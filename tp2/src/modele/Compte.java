package modele;

import java.util.Date;

public class Compte {
    long id ;
    Date dateCreation;
    double solde;

    Etudiant etudiant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Compte() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", solde=" + solde +
                ", etudiant=" + etudiant +
                '}';
    }
}
