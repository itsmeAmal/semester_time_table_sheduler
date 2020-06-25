/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttms.daoimpl;

import com.ttms.dao.studentDao;
import com.ttms.databaseConnection.DatabaseConnection;
import com.ttms.model.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class studentDaoImpl implements studentDao {

    private String selectQuery = "select student_id, student_name, student_email_1, student_email_2, student_reg_no,"
            + " student_contact_no, student_detail, student_status, student_batch_id, student_group_id, student_special_id from student";

    private String selectQuery2 = "select student_id, student_name, student_email_1, student_email_2, student_reg_no, "
            + "student_contact_no, student_detail, student_status, student_batch_id, student_group_id, "
            + "student_special_id, group_name, group_batch_id, group_type, group_detail, "
            + "(select group_name from group_info where group_id=student_special_id) as specil_group_name "
            + "from student left join group_info on group_id=student_group_id";

    @Override
    public boolean addStudent(student student) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into student (student_name, student_email_1, student_email_2, "
                + " student_reg_no, student_contact_no, student_detail, student_status, student_batch_id, student_group_id,"
                + " student_special_id) values (?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail1());
        ps.setString(3, student.getEmail2());
        ps.setString(4, student.getRegNo());
        ps.setString(5, student.getContactNo());
        ps.setString(6, student.getDetail());
        ps.setInt(7, student.getStatus());
        ps.setInt(8, student.getBatchId());
        ps.setInt(9, student.getGroupId());
        ps.setInt(10, student.getSpecialId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllStudents() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getStudentByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    @Override
    public boolean updateStudent(student student) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteStudent(int studentId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from student where student_id=?");
        ps.setInt(1, studentId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public ResultSet getAllStudentsWithOtherJoinDetails() throws SQLException {
        return new commonDaoImpl().getAllRecords(selectQuery2);
    }

}
