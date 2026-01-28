package main;

import java.util.Scanner;
import dao.StudentDAO;
import model.Student;

public class Menu {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = sc.nextLine();

                    System.out.println("Enter student marks:");
                    int marks = sc.nextInt();

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
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        

        

        
    }
}
