package dao.daoMySql;

import java.sql.*;

public class utilitaire {
    public static PreparedStatement initPs(Connection CNX, String sql, boolean generateKey, Object... Columns) throws SQLException {
        PreparedStatement ps = null;
        ps = CNX.prepareStatement(sql, generateKey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        for (int i = 0; i < Columns.length; i++) {
            ps.setObject(i + 1, Columns[i]);
        }
        return ps;
    }

    public static void CloseDaoObject(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
        }
    }

    public static void CloseDaoObject(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture du PreparedStatement : " + e.getMessage());

        }

    }
    public static void CloseDaoObject(Connection CNX) {
       try {
                if (CNX != null) {
                    CNX.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }

    }
    public static void CloseDaoObject(ResultSet rs, PreparedStatement ps, Connection CNX) {
        CloseDaoObject(rs);
        CloseDaoObject(ps);
        CloseDaoObject(CNX);
    }
    public static void CloseDaoObject(ResultSet rs ,PreparedStatement ps) {
        CloseDaoObject(ps);
        CloseDaoObject(rs);
    }
}
