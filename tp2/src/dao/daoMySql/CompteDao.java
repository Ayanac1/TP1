package dao.daoMySql;

import dao.Idao;
import modele.Admin;
import modele.Compte;

import java.util.List;

public abstract class CompteDao implements Idao<Compte, Long> {
    public Compte findById (long id ){return null;}

    public List<Compte> findAll(){return null;}
    public Compte save (Compte compte){return null;}
    public Compte update (Compte compte){return null;}
    public boolean delete (Compte compte){return false;}
    public boolean deleteById (long id){return false;}
}
