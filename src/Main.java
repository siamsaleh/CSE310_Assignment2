import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Connection connection;
    static Student loginStudent;
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/course_database";
        String username = "root";
        String password = "";

        ArrayList<Student> studentArrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                Student student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                studentArrayList.add(student);
//                System.out.println(student.getName() + student.getEmail());
            }
            //connection.close();

            // create student
//            Student student = new Student("SiamSaleh", "1234567", "s@gmail.com", "123");
//            createStudent(student);

            //connection.close();

        }catch (Exception e){}


        //First Page
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you have any account input 'Y' otherwise input 'N'");
        String input = scanner.next();
        if (input.equalsIgnoreCase("y")){
            //login
            System.out.print("Email : ");
            String email = scanner.next();
            System.out.print("Password : ");
            String pass = scanner.next();


            for (int i = 0; i < studentArrayList.size(); i++) {
                if (studentArrayList.get(i).getEmail().equals(email) && studentArrayList.get(i).getPassword().equals(pass)){
                    loginStudent = studentArrayList.get(i);
                }
            }

            if (loginStudent!=null){
                System.out.println("Logged in successfully!");
                showCourses();
            }else {
                System.out.println("No student found");
            }

        }else {
            //register
            // take student name, sid, email, password
            System.out.print("Name : ");
            String name = scanner.next();
            System.out.print("SID : ");
            String sid = scanner.next();
            System.out.print("Email : ");
            String email = scanner.next();
            System.out.print("Password : ");
            String pass = scanner.next();

            Student student = new Student(name, sid, email, pass);
            createStudent(student);
        }
    }

    private static void showCourses(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");

            int i = 1;
            while (resultSet.next()){
                System.out.println( i +" Section-0" + resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) +
                        " Seats Remaining");
                i++;
            }

        }catch (Exception e){}
    }
    
    static void createStudent(Student student){
        try {
//            String sql = "INSERT INTO `student` (`name`, `sid`, `email`, `password`) " +
//                    "VALUES (" + student.getName() +   ", " + student.getSid() + ", " + student.getEmail() + ", " + student.getPassword() + ");";
            String sql = " insert into student (name, sid, email, password)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSid());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.execute();

            connection.close();

        } catch (SQLException e) {
            System.err.println("Got an exception!");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }
}