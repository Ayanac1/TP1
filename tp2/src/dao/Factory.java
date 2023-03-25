package dao;

import java.sql.SQLException;

public abstract class Factory {
    public static  final int MySql_DAO_FACTORY =0;
    public static final int File_DAO_FACTORY=1;

    public abstract Idao getEtudiantDao();

    public abstract Idao getProfesseurDao();

    public abstract Idao getAdminDao();

    public abstract Idao getCompteDao();

    public abstract Idao getDepartementDao();

    public abstract Idao getFiliereDao();

    public abstract Idao getMatiereDao();

    public abstract Idao getNoteDao();

    public abstract Idao getSeanceDao();

    public abstract Idao getSemestreDao();


public static Factory getFactory(int type) throws SQLException, DAOConfigException {
    switch (type) {
        case MySql_DAO_FACTORY:
            return FactoryMySql.getInstance();
        case File_DAO_FACTORY:
            return new FactoryId();
        default:
            return null;
    }


}}