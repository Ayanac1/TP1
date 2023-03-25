import dao.daoVolatile.releveDao;
import metier.IreleveMetier;
import metier.releveMetier;
import presentation.releveControleur;

import java.util.Scanner;


public class CalculDeReleveDeNote_App {

    static releveControleur releveControleur;
    static Scanner clavier = new Scanner(System.in);

    private static boolean estUnNombre(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void test1() {
        //instanciation des différents composants de l'application
        var dao = new releveDao();
        var metier = new releveMetier();
        var controleur = new releveControleur();

        //injection des dépendances
        dao.setMetier(metier);
        metier.setDao(dao);
        controleur.setMetier(metier);


        //tester

        String rep = "";
        do {
            System.out.print("=>[Test1] Calcule de Mensualité de releve <=\n");
            try {
                String inpuut = "";
                while (true) {
                    System.out.print("=>Entrez l'id du releve:");
                    inpuut = clavier.nextLine();
                    if (estUnNombre(inpuut)) break;
                    System.err.println("Entrée non valide!!!");
                }
                long id = Long.parseLong(inpuut);
                controleur.afficher_Mensualite(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.print("Voulez vous quittez(oui/non)?");
            rep = clavier.nextLine();
        } while (!rep.equalsIgnoreCase("oui"));
        System.out.println("Au revoir ^_^");
    }

    public static void main(String[] args) {
        test1();
    }
}
