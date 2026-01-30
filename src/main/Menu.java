package main;

import java.util.Scanner;
import dao.StudentDAO;
import model.Student;

public class Menu {
    
    public void start() {
        
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch(Exception e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }
            
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter student name:");
                    String name = sc.nextLine();

                    if(name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.println("Enter student marks:");
                    int marks = sc.nextInt();

                    if(marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    Student student = new Student(name, marks);

                    boolean result = dao.addStudents(student);

                    if(result) {
                        System.out.println("Student added successfully!");
                    }
                    else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    dao.viewAllStudents();
                    break;

                case 3:
                    System.out.println("Enter student id: ");
                    int id = sc.nextInt();

                    if(id <= 0) {
                        System.out.println("Invalid ID.");
                    }
                    
                    System.out.println("Enter new marks: ");
                    marks = sc.nextInt();

                    if(marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    if(dao.updateStudentMarks(id, marks)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter student id to delete: ");
                    int deleteId = sc.nextInt();

                    if(deleteId <= 0) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    if(dao.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
            
                case 5:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
