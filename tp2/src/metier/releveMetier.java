package metier;

import dao.Idao;
import dao.daoVolatile.releveDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modele.releve;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class releveMetier {
    Idao<releve, Long> releveDao;
    private releveDao dao;


    public releve calculer_Mensualite(long idreleve) throws Exception {
        var releve = releveDao.trouverParId(idreleve);

        if (releve == null) {
            throw new Exception("L'id du releve est incorrecte::[Releve non trouvé]");
        } else {

            double releve_note = (releve.getNote() * releve.getCoef())+(releve.getNote() * releve.getCoef());
            double mensualite = releve.getNote() / releve.getDuree();
            releve.setMensualite(mensualite);

            return releve;
        }
        }

    public void setReleveIdao() {

    }

    public void setDao(dao.daoVolatile.releveDao dao) {
        this.dao = dao;
    }
}

