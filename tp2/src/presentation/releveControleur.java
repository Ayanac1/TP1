package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import metier.IreleveMetier;
import metier.releveMetier;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class releveControleur implements IreleveControleur  {
    IreleveMetier releveMetier;
    private releveMetier metier;


    public void afficher_Mensualite(Long idreleve) throws Exception {

        var releveAvecMensualite = releveMetier.calculer_Mensualite(idreleve);
        System.out.printf("releveAvecMensualite");

    }

    public void setReleveMetier(metier.releveMetier metier) {
    }

    public void setMetier(metier.releveMetier metier) {
        this.metier = metier;
    }
}
