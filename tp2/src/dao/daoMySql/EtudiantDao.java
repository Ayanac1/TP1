package dao.daoMySql;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.Idao;
import modele.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EtudiantDao implements Idao<Etudiant, Long> {
    private Connection connection;

    public EtudiantDao(Connection connection) {
        this.connection = connection;

    }

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM etudiant WHERE id = ?";

    public Etudiant findById(long id) {
        Etudiant etudiant = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        try {
            ps = utilitaire.initPs(connection, SQL_SELECT_BY_ID, false, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                etudiant = map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            utilitaire.CloseDaoObject(resultSet, ps);
        }
        return etudiant;
    }


    private static final String SQL_SELECT_ALL = "SELECT * FROM etudiant";

    public List<Etudiant> findAll() throws DAOException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Etudiant> etudiants = new ArrayList<>();

        try {
            ps = utilitaire.initPs(connection, SQL_SELECT_ALL, false);
            resultSet = ps.executeQuery();
            System.out.println("[SQL]" + SQL_SELECT_ALL);
            while (resultSet.next()) {
                Etudiant etudiant = map(resultSet);
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            utilitaire.CloseDaoObject(resultSet, ps);
        }
        return etudiants;
    }


    ////////////////////////////////////////////save


    public Etudiant save(Etudiant etudiant) throws SQLException, DAOException {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int statut = 0;
        try {
            ps = utilitaire.initPs(connection, "INSERT INTO etudiant (nom, prenom, email, cin, tel, sexe) VALUES (?, ?, ?, ?, ?, ?)", true, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getCin(), etudiant.getTel(), etudiant.getSexe());
            statut = ps.executeUpdate();
            if (statut == 0)
                throw new DAOException("Echec de la création de l'etudiant, aucune ligne ajoutée dans la table.");
            ResultSet AutoGeneratedValues = ps.getGeneratedKeys();
            if (AutoGeneratedValues.next()) {
                etudiant.setId(AutoGeneratedValues.getLong(1));
                System.out.println("insert into etudiant (nom, prenom, email, cin, tel, sexe) VALUES (" + etudiant.getNom() + ", " + etudiant.getPrenom() + ", " + etudiant.getEmail() + ", " + etudiant.getCin() + ", " + etudiant.getTel() + ", " + etudiant.getSexe() + ")");
                System.out.println("enregistrement de l'etudiant avec succes");
            } else
                throw new DAOException("Echec de la création de l'etudiant en base, aucun ID auto-généré retourné.");

            }catch (SQLException e) {throw new DAOException("probleme dans la methode save de etudiantDao" + e.getMessage(), e);
        }finally {
            utilitaire.CloseDaoObject(resultSet, ps);
        }
            return etudiant;
    }

    ////////////////////////////////////////////update
    public static final String UPDATE_Column = "nom = ?, prenom = ?, username = ?, passwors = ?, role = ?";
    public static final String UPDATE = "UPDATE etudiant SET"+ UPDATE_Column+ " WHERE id = ?";
    public Etudiant update(Etudiant etudiant) throws DAOException, SQLException {
        PreparedStatement ps = null;
        int statut = 0;
        try{
            ps = utilitaire.initPs(connection, UPDATE, false, etudiant.getNom(), etudiant.getPrenom(), etudiant.getEmail(), etudiant.getCin(), etudiant.getTel(), etudiant.getSexe(), etudiant.getId());
            statut = ps.executeUpdate();
            if (statut == 0)
                throw new DAOException("Echec de la modification de l'etudiant, aucune ligne ajoutée dans la table.");
           else {
                System.out.println("[Sql] : UPDATE etudiant SET"+
                        "prenom = "+ etudiant.getPrenom()+", "+
                        "nom = "+ etudiant.getNom()+", "+
                        "email = "+ etudiant.getEmail()+", "+
                        "cin = "+ etudiant.getCin()+", "+
                        "tel = "+ etudiant.getTel()+", "+
                        "sexe = "+ etudiant.getSexe()+", "+
                        "WHERE id = "+ etudiant.getId());
                System.out.println("modification de l'etudiant avec succes")
                        ;

        }
    }catch (SQLException e) {
            throw new DAOException("probleme dans la methode update de etudiantDao" + e.getMessage(), e);
        }finally {
            utilitaire.CloseDaoObject(ps);
        }
        return etudiant;
    }





    private static Etudiant map(ResultSet resultSet) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(resultSet.getLong("nom"));
        etudiant.setPrenom(resultSet.getString("prenom"));
        etudiant.setEmail(resultSet.getString("email"));
        etudiant.setCin(resultSet.getString("cin"));
        etudiant.setTel(resultSet.getInt("tel"));
        etudiant.setSexe(resultSet.getString("sexe"));
        return etudiant;
    }
    ////////////////////////////////////////////delete
    public static final String Delete = "DELETE FROM etudiant WHERE id = ?";

    public boolean delete(Etudiant etudiant) throws DAOException, SQLException {
        return deleteById(Etudiant.getId());
    }

    public boolean deleteById(long id) throws SQLException, DAOException {
        PreparedStatement ps = null;
        int statut = 0;
        try {
            ps = utilitaire.initPs(connection, Delete, false, id);
            statut = ps.executeUpdate();
            if (statut == 0)
                throw new DAOException("Echec de la suppression de l'etudiant, aucune ligne supprimée de la table.");
            else{
                System.out.println("[SQL]" + Delete);
                System.out.println("Etudiant supprimé avec succès");

        }
    }
        catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        } finally {
            utilitaire.CloseDaoObject(ps);
        }
        return true;
    }


}
