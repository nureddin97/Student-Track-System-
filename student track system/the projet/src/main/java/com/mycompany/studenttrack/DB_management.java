/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studenttrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class DB_management {

    static final String connectionString = "jdbc:mysql://127.0.0.1:3306/"
            + "new_student?user=root&password=nureddin";

    static Connection connection = null;

    public static boolean InsertNewTeacher(teacher_register teache) {

        try {
            connection = DriverManager.getConnection(connectionString);

            Statement stmt = connection.createStatement();
            String query = "INSERT INTO newteacher "
                    + "(name_surname, email, password )"
                    + "VALUES('" + teache.name_surname
                    + "','" + teache.email + "','" + teache.password + "')";
            stmt.executeUpdate(query);

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static teacher_register teacherLogin(String email, String password) {
        teacher_register teacher = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            String quary = "SELECT * FROM newteacher WHERE email='" + email + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(quary);
            if (rs.next()) {
                teacher = new teacher_register();
                teacher.name_surname = rs.getString("name_surname");
                teacher.email = rs.getString("email");
                teacher.password = rs.getString("password");
            }
            connection.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        }

        return teacher;

    }

    public static boolean InsertNewStudent(student_register student) {

        try {
            connection = DriverManager.getConnection(connectionString);

            Statement stmt = connection.createStatement();
            String query = "INSERT INTO newstudent "
                    + "(id,name_surname,phone, email, password ,cours  )"
                    + "VALUES('" + student.id + "','" + student.name_surname
                    + "','" + student.phone + "','" + student.email + "','" + student.password + "','" + student.cours + "')";
            stmt.executeUpdate(query);

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static student_register studentLogin(String email, String password) {
        student_register student = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            String quary = "SELECT * FROM newstudent WHERE email='" + email + "' AND password='" + password + "'";
            ResultSet rs = stmt.executeQuery(quary);
            if (rs.next()) {
                student = new student_register();
                student.id = rs.getInt("id");
                student.name_surname = rs.getString("name_surname");
                student.phone = rs.getString("phone");
                student.email = rs.getString("email");
                student.password = rs.getString("password");
                student.cours = rs.getInt("cours");
            }
            connection.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        }

        return student;

    }

    public static student_register getInf(String id) {

        student_register student = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            String quary = "SELECT * FROM newstudent WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(quary);
            if (rs.next()) {
                student = new student_register();
                student.id = rs.getInt("id");
                student.name_surname = rs.getString("name_surname");
                student.phone = rs.getString("phone");
                student.email = rs.getString("email");
                student.password = rs.getString("password");
                student.cours = rs.getInt("cours");
            }
            connection.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        }

        return student;

    }

    public static boolean removeStudent(int id) {

        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stat = connection.createStatement();
            String quary = "DELETE FROM newstudent WHERE id ='" + id + "'";
            stat.executeUpdate(quary);
            connection.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DB_management.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public static boolean InsertHW(studentHW HW) {

        try {
            connection = DriverManager.getConnection(connectionString);

            Statement stmt = connection.createStatement();
            String query = "INSERT INTO homework "
                    + "(id,HW  )"
                    + "VALUES('" + HW.id + "','" + HW.HW + "')";
            stmt.executeUpdate(query);

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static studentHW showHW(String id) {
        studentHW homework = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            String quary = "SELECT * FROM homework WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(quary);
            if (rs.next()) {
                homework = new studentHW();
                homework.id = rs.getString("id");
                homework.HW = rs.getString("HW");
            }
            connection.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        }

        return homework;

    }

    public static boolean saveFB(feAndMark feedback) {

        try {
            connection = DriverManager.getConnection(connectionString);

            Statement stmt = connection.createStatement();
            String query = "INSERT INTO feedback "
                    + "(id,mark,feedback)"
                    + "VALUES('" + feedback.id + "','" + feedback.mark + "','" + feedback.feedback + "')";
            stmt.executeUpdate(query);

            connection.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static feAndMark result(int id) {
        feAndMark result = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            Statement stmt = connection.createStatement();
            String quary = "SELECT * FROM feedback WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(quary);
            if (rs.next()) {
                result = new feAndMark();
                result.id = rs.getInt("id");
                result.mark = rs.getInt("mark");
                result.feedback = rs.getString("feedback");
            }
            connection.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        }

        return result;

    }

}
