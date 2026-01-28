package main;

import java.util.Scanner;

public class MainApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Exit");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Add Student selected");
                break;
            case 2:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
