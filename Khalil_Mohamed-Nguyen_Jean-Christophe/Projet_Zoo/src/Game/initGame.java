/**
 * @author Nguyen, Khalil
 *
 */
package Game;

import java.util.Scanner;

import Game.Menu.*;
import Zoo.*;

public class initGame {

	/**
	 * Boolean game qui permet le fonctionnement du jeu. (True, le jeu tourne. False, le jeu s'arrète)
	 */
	private static boolean game = true;
	/**
	 * Création objet Scanner
	 */
	private static final Scanner scanner = new Scanner(System.in);
	/**
	 * Instance static employé(e) crée
	 */
	private static Employe employe;
	/**
	 * Instance static zoo crée
	 */
	private static Zoo zoo;
	
	private static int actions = 0;

	/**
	 * Constructeur de la classe initGame
	 */
	public initGame() {
	}

	/**
	 * Affichage du texte de bienvenu du jeu
	 *
	 */
	public static void startGame() {
		System.out.println("Bienvenue dans la simulation de Zoo !\n\n" + "Voici les règles du jeu :\n"
				+ "- Vous êtes l'employé du Zoo et vous devez vous occuper des animaux et des enclos qui le constitue,\n"
				+ "- Lorsque vous faite 5 actions, certains éléments du Zoo sont susceptible de changer (un animal devient malade, une cage devient sale, etc),\n"
				+ "- C'est alors a vous d'analyser les animaux et les cages pour voir si tout vas bien.\n"
				+ "Amusez vous bien !\n");
	}

	/**
	 * Affichage du texte de sortie du jeu
	 *
	 */
	public static void endGame() {
		System.out.println("Voulez-vous vraiment quitter la partie ? (Oui ou Non)");
		String selected = scanner.next();
		if (selected.equals("Oui") || selected.equals("oui")) {
			game = false;
			System.out.println("Fin de la partie ! Merci d'avoir joué.");
		}
	}

	/**
	 * Retourne l'état du jeu. True jeu tourne, False le jeu s'arrête.
	 *
	 * @return boolean the boolean of the game if true the game start else the game stop
	 */
	public boolean isGame() {
		return game;
	}

	/**
	 * Retourne le zoo
	 *
	 * @return Zoo the zoo of the game
	 */
	public static Zoo getZoo() {
		return zoo;
	}

	/**
	 * Retourne l'employé(e)
	 *
	 * @return Employe the employee of the zoo
	 */
	public static Employe getEmploye() {
		return employe;
	}

	/**
	 * Affichage du menu principale du jeu
	 */
	public static void mainMenu() {
		System.out.println("\nMenu principal :\n" + "1 - Gestion des animaux\n" + "2 - Gestion des enclos\n"
				+ "3 - Informations du Zoo\n" + "4 - Simulation Loups\n" + "5 - Règles du jeu\n"
				+ "6 - Quitter la partie\n");
	}

	/**
	 * Traite les choix fait sur le menu principale
	 */
	public static void menu() {
		if (actions == 5) {
    		   System.out.println("Vous avez fait 5 actions. Modifications aléatoires des valeurs en cours...");
    	   	   Zoo.randomActions();
    	   	   System.out.println("Modifications terminées.");
               	   actions = 0;
        	}
		mainMenu();
		int selected = scanner.nextInt();
		switch (selected) {
		case 1:
			menuAnimaux.menu();
			break;
		case 2:
			menuEnclos.menu();
			break;
		case 3:
			menuZoo.menu();
			break;
		case 4:
			menuLoups.menu();
			break;
		case 5:
			startGame();
			break;
		case 6:
			endGame();
			break;
		default:
			throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
		actions++;
	}

	/**
	 * Initialise le jeu avec la création de l'employé(e) et du zoo
	 */
	public void start() {
		startGame();
		System.out.print(
				"Pour commencer, nous allons créer un employé qui sera chargé de gérer et de s'occuper du Zoo.\n");
		menuEmploye.getNameEmploye();
		String nameEmploye = scanner.next();
		menuEmploye.getSexEmploye();
		String sexe = scanner.next();
		boolean sexe1;
		if (sexe.equals("Homme") || sexe.equals("homme") || sexe.equals("H") || sexe.equals("h")) {
			sexe1 = true;
		} else if (sexe.equals("Femme") || sexe.equals("femme") || sexe.equals("F") || sexe.equals("f")) {
			sexe1 = false;
		} else {
			throw new IllegalArgumentException("Le sexe de l'employé n'a pas été correctement renseigné.");
		}
		menuEmploye.getAgeEmploye();
		int ageEmploye = scanner.nextInt();
		employe = new Employe(nameEmploye, sexe1, ageEmploye);
		menuEmploye.successEmploye();
		System.out.print(employe + "\n");
		Zoo.getNameZoo();
		String nameZoo = scanner.next();
		Zoo.getMaxEnclosZoo();
		int maxEnclosure = scanner.nextInt();
		zoo = new Zoo(nameZoo, employe, maxEnclosure);
		System.out.print(zoo);
	}

}
