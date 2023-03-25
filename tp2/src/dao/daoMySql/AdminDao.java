package dao.daoMySql;

import dao.Idao;
import modele.Admin;

import java.util.List;

public abstract class AdminDao  implements Idao <Admin, Long> {

    public Admin findById (long along ){return null;}

    public List<Admin> findAll(){return null;}
    public Admin save (Admin admin){return null;}
    public Admin update (Admin admin){return null;}
    public boolean delete (Admin admin){return false;}
    public boolean deleteById (long along){return false;}


}
