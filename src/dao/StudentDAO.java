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
            System.out.println("Failed to add student.");
            return false;
        }
    }

    public void viewAllStudents() {

        String sql = "select id, name, marks from students";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

                System.out.println("\n--- Student List ---");

                boolean found = false;

                while(rs.next()) {
                    found = true;
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int marks = rs.getInt("marks");

                    System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
                }

                if(!found) {
                    System.out.println("No students found.");
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateStudentMarks(int id, int marks) {

        String sql = "update students set marks = ? where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, marks);
                ps.setInt(2, id);

                int rows = ps.executeUpdate();
                
                if(rows > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch(Exception e) {
                System.out.println("Database update failed.");
                return false;
            }
    }

    public boolean deleteStudent(int id) {

        String sql = "delete from students where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);

                int rows = ps.executeUpdate();
                
                if(rows > 0) {
                    return true;
                } else {
                    return false;
                }

            } catch(Exception e) {
                System.out.println("Database delete failed.");
                return false;
            }
    }

    public Student getStudentById(int id) {

        String sql = "select id, name, marks from students where id = ?";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("marks")
                    );
                } 
        } catch(Exception e) {
                e.printStackTrace();
        }

        return null; //Student not found
    }
    
}


