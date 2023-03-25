package modele;

import java.util.Objects;

public class Etudiant {
    long Nom;
    String Prenom;
    String Email;
    String Cin;
    int Tel;
    String Sexe;

    public static long getId() {
    return 0;
    }

    public void setNom(long nom) {
    }

    public void setPrenom(String prenom) {
    }

    public void setEmail(String email) {
    }

    public void setCin(String cin) {
    }

    public void setTel(int tel) {
    }

    public void setSexe(String sexe) {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "Nom=" + Nom +
                ", Prenom='" + Prenom + '\'' +
                ", Email='" + Email + '\'' +
                ", Cin='" + Cin + '\'' +
                ", Tel=" + Tel +
                ", Sexe='" + Sexe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Nom == etudiant.Nom && Tel == etudiant.Tel && Objects.equals(Prenom, etudiant.Prenom) && Objects.equals(Email, etudiant.Email) && Objects.equals(Cin, etudiant.Cin) && Objects.equals(Sexe, etudiant.Sexe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nom, Prenom, Email, Cin, Tel, Sexe);
    }


    public void setId(long aLong) {
    }

    public long getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public String getCin() {
        return Cin;
    }

    public int getTel() {
        return Tel;
    }

    public String getSexe() {
        return Sexe;
    }
}


