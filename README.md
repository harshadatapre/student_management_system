# Student Management System (Core Java + JDBC)

## Description
A console-based Student Management System developed using Core Java and JDBC.
The application performs CRUD operations on a MySQL databasa using a menu-driven interface.

## Features
- Add Student
- View All Students
- Update Student Marks
- Delete Student
- Search Student by ID
- Exit Application

## Technologies Used
- Core Java
- JDBC
- MySQL
- VS Code

## Concepts Implemented
- DAO Design Pattern
- PreparedStatement (to prevent SQL Injection)
- auto_increment primary key
- Exception Handling
- Input Validation
- Menu-driven console application

## Project Structure
src/
- main -> MainApp, Menu, TestConnection
- dao -> StudentDAO
- model -> Student
- util -> DBConnection
lib/
- mysql-connector-j

## How to Run
1. Add MySQL Connector/J JAR to 'lib' folder
2. Compile the project using:
```bash
javac -d out src/util/DBConnection.java src/model/Student.java src/dao/StudentDAO.java src/main/Menu.java src/main/MainApp.java
```
3. Run the application
```bash
java -cp "out;lib/*" main.MainApp
```

##Author
Harshada Tapre
