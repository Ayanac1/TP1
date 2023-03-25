package dao;

import dao.daoMySql.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface Idao <T, Id>{
    T trouverParId(Id id);

    T findById (Id id);
    List<T> findAll() throws DAOException;
    T save (T t) throws SQLException, DAOException;
    T update(T t) throws DAOException, SQLException;
    boolean delete (T t) throws DAOException, SQLException;
    boolean deleteById (Id id);

}
