package dao.daoMySql;

import dao.Idao;
import modele.Etudiant;
import modele.Nom_Demandeur;

import java.util.List;

public abstract class Nom_DemandeurDao implements Idao<Nom_Demandeur, String> {
    public Nom_Demandeur findById (long id ){return null;}

    public List<Nom_Demandeur> findAll(){return null;}
    public Nom_Demandeur save (Nom_Demandeur nom_demandeur){return null;}
    public Nom_Demandeur update (Nom_Demandeur nom_demandeur){return null;}
    public boolean delete (Nom_Demandeur nom_demandeur){return false;}
    public boolean deleteById (long id){return false;}
}
