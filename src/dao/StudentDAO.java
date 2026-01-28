package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;
import model.Student;

public class StudentDAO {
    public boolean addStudents(Student student) {
        String sql = "insert into students (name, marks) values (?, ?)";

        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getMarks());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void viewAllStudents() {

        String sql = "select id, name, marks from students";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

                System.out.println("\n--- Student List ---");

                while(rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int marks = rs.getInt("marks");

                    System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


