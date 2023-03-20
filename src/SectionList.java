import model.SectionStudentList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SectionList {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/course_database";
        String username = "root";
        String password = "";

        ArrayList<SectionStudentList> studentArrayList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from section_list");
            while (resultSet.next()){
                SectionStudentList sectionStudentList = new SectionStudentList(resultSet.getString(1),
                        resultSet.getString(2), resultSet.getInt(3));
                studentArrayList.add(sectionStudentList);
            }
        }catch (Exception e){}

        System.out.print("Select Section : ");
        Scanner scanner = new Scanner(System.in);
        int section = scanner.nextInt();

        for (int i = 0; i < studentArrayList.size(); i++) {

            if (section == 1) {
                if (studentArrayList.get(i).getSection() == 1) {
                    System.out.println("Name : " + studentArrayList.get(i).getName() + " SID : " + studentArrayList.get(i).getSid());
                }
            }
            else if (section == 2){
                if (studentArrayList.get(i).getSection() == 2) {
                    System.out.println("Name : " + studentArrayList.get(i).getName() + " SID : " + studentArrayList.get(i).getSid());
                }
            }else {
                System.out.println("This section is not available");
            }
        }



    }

}
