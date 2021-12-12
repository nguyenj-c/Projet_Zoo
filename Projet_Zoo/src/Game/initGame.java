package Game;

import java.util.Scanner;

import Zoo.Employe;
import Zoo.Zoo;

public class initGame {
	
    public initGame() {}
    
    public void accueil() {
        System.out.println("Bienvenue dans la simulation de Zoo !\n\n" +
        		"Voici les r�gles du jeu :\n" +
                "- Vous �tes l'employ� du Zoo et vous devez vous occuper des animaux et des enclos qui le constitue,\n" +
                "- Lorsque vous faite 5 actions, certains �l�ments du Zoo sont susceptible de changer (un animal devient malade, une cage devient sale, etc),\n" +
                "- C'est alors a vous d'analyser les animaux et les cages pour voir si tout vas bien.\n" +
                "Amusez vous bien !\n" +
                "Pour commencer, nous allons cr�er un employ� qui sera charg� de g�rer et de s'occuper du Zoo.");
    }
    public void start() {
		accueil();
		Scanner scanner = new Scanner(System.in);
		Employe.getNameEmploye();
		String nameEmploye = scanner.next();
		Employe.getSexEmploye();
		String sexe = scanner.next();
		boolean sexe1;
		if (sexe.equals("Homme")) {
            sexe1 = true;
        } else if (sexe.equals("Femme")) {
            sexe1 = false;
        } else {
            throw new IllegalArgumentException("Le sexe de l'employ� n'a pas �t� correctement renseign�.");
        }
		Employe.getAgeEmploye();
        int ageEmploye = scanner.nextInt();
		Employe employe = new Employe(nameEmploye, sexe1, ageEmploye);
	    Employe.successEmploye();
	    System.out.print(employe + "\n");
        Zoo.getNameZoo();
        String nameZoo = scanner.next();
        Zoo.getMaxEnclosure();
        int maxEnclosure = scanner.nextInt();
        Zoo zoo = new Zoo(nameZoo, employe, maxEnclosure);
       
        System.out.print(zoo);
        

    }
    
    
}
