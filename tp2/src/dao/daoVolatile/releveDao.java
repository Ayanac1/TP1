package dao.daoVolatile;

import dao.Idao;
import lombok.Data;
import lombok.NoArgsConstructor;
import metier.releveMetier;
import modele.releve;
import org.springframework.stereotype.Component;
import java.sql.Array;
import java.util.*;
import java.util.function.DoubleToIntFunction;
@Data
@NoArgsConstructor
@Component

public class releveDao  implements Idao<releve, Long> {
    private releveMetier metier;

    public static Set<releve> BDreleve(){
    return new HashSet<releve>(
             Arrays.asList(
                     new releve(1, "Aya", 18,1, 16.3, "Assia", 0),
                     new releve(2, "Arij", 19,1, 17, "Kaoutar", 0),

                     new releve(13, "Soufiane", 17,1, 16, "Said", 0),

                     new releve(7, "Safouane", 20,1, 14, "Aicha", 0)

             ));


    }




    public releve trouverParId(Long id) {
        System.out.println("[DAO-DS volatile] trouver le releve n°:"+id);
        return BDreleve()
                .stream()
                .filter(releve -> releve.getId()== id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public releve findById(Long aLong) {
        return null;
    }

    @Override
    public List<releve> findAll() {
        return null;
    }

    @Override
    public releve save(releve releve) {
        return null;
    }

    @Override
    public releve update(releve releve) {
        return null;
    }

    @Override
    public boolean delete(releve releve) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    public void setMetier(releveMetier metier) {
        this.metier = metier;
    }
}
