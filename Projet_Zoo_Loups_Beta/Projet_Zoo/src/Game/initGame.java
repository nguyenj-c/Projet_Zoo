package Game;

import java.util.Scanner;

import Animaux.Animaux;
import Game.Menu.*;
import Zoo.Employe;
import Zoo.Zoo;

public class initGame {

	private static boolean game = true;
    private static final Scanner scanner = new Scanner(System.in);
    private static Animaux animal;
    private static Employe employe;
    private static Zoo zoo;
    public initGame() {}
    
	public static void startGame() {
		System.out.println("Bienvenue dans la simulation de Zoo !\n\n" + "Voici les règles du jeu :\n"
				+ "- Vous êtes l'employé du Zoo et vous devez vous occuper des animaux et des enclos qui le constitue,\n"
				+ "- Lorsque vous faite 5 actions, certains éléments du Zoo sont susceptible de changer (un animal devient malade, une cage devient sale, etc),\n"
				+ "- C'est alors a vous d'analyser les animaux et les cages pour voir si tout vas bien.\n"
				+ "Amusez vous bien !\n");
	}

	public static void endGame() {
		System.out.println("Voulez-vous vraiment quitter la partie ? (Oui ou Non)");
		Scanner scanner = new Scanner(System.in);
		String selected = scanner.next();
		if (selected.equals("Oui") || selected.equals("oui")) {
			game = false;
			System.out.println("Fin de la partie ! Merci d'avoir joué.");
		}
	}
    public boolean isGame() {return game;}
	
	public static Zoo getZoo() {return zoo;}

    public static Employe getEmploye() {return employe;}
	
	public static void mainMenu() {
		System.out.println("\nMenu principal :\n" + "1 - Gestion des animaux\n" + "2 - Gestion des enclos\n"
				+ "3 - Informations du Zoo\n" +"4 - Simulation Loups\n"+ "5 - Règles du jeu\n" + "6 - Quitter la partie\n");
	}

	public static void menu() {
		mainMenu();
		Scanner scanner = new Scanner(System.in);
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
	}

	public void start() {
		startGame();
		System.out.print("Pour commencer, nous allons créer un employé qui sera chargé de gérer et de s'occuper du Zoo.\n");
		Scanner scanner = new Scanner(System.in);
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
		Zoo.getMaxEnclos();
		int maxEnclosure = scanner.nextInt();
		zoo = new Zoo(nameZoo, employe, maxEnclosure);

		System.out.print(zoo);
	}

}
