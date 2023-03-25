package dao;

import dao.daoMySql.EtudiantDao;
import modele.Etudiant;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryMySql extends Factory {
    private static final String PropertiesFile = "config.properties";
    private static String url = "SDB.url";
    private static String user = "SDB.user";
    private static String password = "SDB.password";

    private static final String Driver = "SDB.Driver";

    private static FactoryMySql instance = null;
    private static Connection connection ;



    private FactoryMySql(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        connection = DriverManager.getConnection(url, user, password);
    }


    public static FactoryMySql getInstance() throws SQLException, DAOConfigException {
        FactoryMySql instance = null;
        String property_URL, property_DBNAME = null, property_USER, property_PASSWORD, property_DRIVER;
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PropertiesFile);
        if (propertiesFile == null) {
            throw new DAOConfigException("Le fichier properties " + PropertiesFile + " est introuvable.");
        } else {
            try {
                properties.load(propertiesFile);
                property_URL = properties.getProperty(url);
                property_USER = properties.getProperty(user);
                property_PASSWORD = properties.getProperty(password);
                property_DRIVER = properties.getProperty(Driver);
                propertiesFile.close();
                Class.forName(property_DRIVER);
                property_URL = property_URL + property_DBNAME;
                instance = new FactoryMySql(property_URL, property_USER, property_PASSWORD);
                System.out.println("Connexion à la base de données réussie");
            } catch (IOException e) {
                throw new DAOConfigException("Impossible de charger le fichier properties " + PropertiesFile);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigException("Le driver est introuvable dans le classpath.");
            } catch (SQLException e) {
            throw new DAOConfigException("Impossible de se connecter à la base de données.");
        }finally {
                properties.clear();
            }
            }

return instance;
    }

    @Override
    public Idao getEtudiantDao() {
        return new EtudiantDao(getConnection()) {
            @Override
            public Etudiant trouverParId(Long aLong) {
                return null;
            }

            @Override
            public Etudiant findById(Long aLong) {
                return null;
            }

            @Override
            public boolean deleteById(Long aLong) {
                return false;
            }
        };
    }

    @Override
    public Idao getProfesseurDao() {
        return null;
    }

    @Override
    public Idao getAdminDao() {
        return null;
    }

    @Override
    public Idao getCompteDao() {
        return null;
    }

    @Override
    public Idao getDepartementDao() {
        return null;
    }

    @Override
    public Idao getFiliereDao() {
        return null;
    }

    @Override
    public Idao getMatiereDao() {
        return null;
    }

    @Override
    public Idao getNoteDao() {
        return null;
    }

    @Override
    public Idao getSeanceDao() {
        return null;
    }

    @Override
    public Idao getSemestreDao() {
        return null;
    }
    public static Connection getConnection() {
        return connection;
    }
    public static void closeConnection() throws DAOConfigException {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
               throw  new DAOConfigException("Impossible de fermer la connexion à la base de données.");
            }

    }

}



