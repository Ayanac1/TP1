package JDBC;

import java.sql.*;


import static java.lang.System.out;

public class TestJDBC {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        var url = "jdbc:mysql://localhost:3306/bankati";
        var User = "root";
        var Password = "";
        Connection connexion = null;
        Statement stmnt = null;
        ResultSet rs = null;
        ResultSetMetaData rsMetaData = null;
        PreparedStatement ps = null;
        ps = connexion.prepareStatement("select u.nom, u.prenom"    + "from utilisateur u"    + "where u.user = ?AND u.password = ?");
        rs = ps.executeQuery();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("le driver a ete charge avec succes");
            connexion = DriverManager.getConnection(url, User, Password);
            out.println("driver acess ");
            stmnt = connexion.createStatement();
            rs = stmnt.executeQuery("SELECT * FROM client");
            rsMetaData = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    out.println("" + rsMetaData.getColumnName(i).toUpperCase() + " : " + rs.getObject(i).toString() + "\t");
                    out.println("\n----------------------------------------");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                if (connexion != null) {
                    try {
                        connexion.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    out.println("connexion ferme");
                }
                if (stmnt != null) {
                    try {
                        stmnt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    out.println("statement ferme");
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    out.println("resultset ferme");
                }
            }
        }
    }


