package dao.daoMySql;

import java.sql.SQLException;

public class DAOException extends Throwable {
    public DAOException(String s, SQLException e) {
    }

    public DAOException(String s) {
    }
}
