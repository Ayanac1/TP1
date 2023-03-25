package metier;

import modele.releve;

public interface IreleveMetier {

    releve calculer_Mensualite(Long idreleve)
            throws Exception;
}
