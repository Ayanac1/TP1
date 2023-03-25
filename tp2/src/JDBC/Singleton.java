package JDBC;

import java.sql.*;


public class Singleton {
    private static Connection connection;
    private String driver;

    private Singleton() {

        String url = "jdbc:mysql://localhost:3306/bankati";
        var User = "";
        var Password = "";
        driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, User, Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new Singleton();
        } else System.out.println("connection deja etablie");
        return connection;
    }

    public static void main(String[] args) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from client where cin=?");
            Statement stmnt = getConnection().createStatement();
            getConnection().setAutoCommit(false);
            DatabaseMetaData meta = getConnection().getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




