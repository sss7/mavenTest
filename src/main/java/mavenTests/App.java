package mavenTests;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        Connection connection = null;
        String url = "jdbc:oracle:thin:@89.108.84.144:1521/BPM8";
        String name = "test01";
        String password = "test01";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("Драйвер подключен");

            connection = DriverManager.getConnection(url, name, password);
//            System.out.println("Соединение установлено");

            Statement statement = null;
            statement = connection.createStatement();

            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test01.department");

//            System.out.println("Выводим statement");
            while (result1.next()) {
//                System.out.println(result1.getRow() + "\t"  );
                System.out.print(result1.getInt(1) + "\t");
//                System.out.println(result1.getString(1));
                System.out.print(result1.getString(2) + "\t\t");
//                System.out.println(result1.getString(3));
                System.out.println(result1.getInt(3));
            }



        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException...");
        } catch (SQLException e) {
            System.out.println("SQLException...");
        }

    }
}
