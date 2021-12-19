/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import Zoo.*;
import Animaux.Animaux;
import Enclos.Enclos;
import Game.initGame;

public class menuZoo {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Employe employe = initGame.getEmploye();
	private static Zoo zoo = initGame.getZoo();

	/**
	 * Affichage du menu des actions pour le zoo
	 */
	public static void affichageMenu() {
		System.out.println("\nMenu d'informations du Zoo :\n" + "1 - Liste des enclos\n"
				+ "2 - Nombre d'animaux dans le Zoo\n" + "3 - Animaux par enclos\n" + "4 - Informations du Zoo\n"
				+ "5 - Informations de l'employé\n" + "6 - Retour");
	}

	/**
	 * Affichage de la liste des enclos
	 */
	public static void listEnclos(List<String> enclos) {
		System.out.println("Liste des enclos du Zoo :\n" + enclos);
	}
	
	/**
	 * Affichage texte du nombre maximal d'animaux dans le zoo
	 */
	public static void numberAnimal(int number) {
		System.out.println("Nombre d'animaux présent dans les cages :\n" + number);
	}
	
	/**
	 * Affichage des enclos et animaux triés par nom
	 */
	public static void animalsByEnclos(String sortedMisOfThings) {
		System.out.println("Enclos et leurs animaux triés par nom :\n" + sortedMisOfThings);
	}
	
	/**
	 * Affichage des informations du zoo
	 */
	public static void affichageInformationsZoo(String zoo) {
		System.out.println("Informations du zoo :\n" + zoo);
	}

	/**
	 * Affichage des informations de l'employé(e)
	 */
	public static void affichageInformationsEmploye(String employe) {
		System.out.println("Informations de l'employé :\n" + employe);
	}
	
	/**
	 * Traite les choix fait sur le menu Zoo
	 */
	public static void menu() {
		affichageMenu();
		int selected = scanner.nextInt();
		switch (selected) {
			case 1:
				listEnclos();
				break;
			case 2:
				numberAnimalZoo();
				break;
			case 3:
				animalsByEnclos();
				break;
			case 4:
				informationsZoo();
				break;
			case 5:
				informationsEmploye();
				break;
			case 6:
				initGame.menu();
				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
	}

	
	/**
	 * Retourne la liste de tous les enclos
	 */
	public static void listEnclos() {
		List<Enclos> enclos = zoo.getAllEnclos();
		listEnclos(enclos.stream().map(Enclos::toString).collect(Collectors.toList()));
	}

	/**
	 * Retourne le nombre d'animaux dans le zoo
	 */
	public static void numberAnimalZoo() {
		int number = zoo.numberAnimalsZoo();
		numberAnimal(number);
	}

	/**
	 * Trie les animaux par type d'enclos
	 */
	public static void animalsByEnclos() {
		SortedSet<Enclos> enclosByName = new TreeSet<>(zoo.getAllEnclos());
		StringBuilder sortedOutput = new StringBuilder();
		for (Enclos enclos : enclosByName) {
			sortedOutput.append(enclos.getName()).append(":\n");
			SortedSet<Animaux> animals = new TreeSet<>(enclos.getActualAnimals());
			for (Animaux animal : animals) {
				sortedOutput.append("\t").append(animal.toString()).append("\n");
			}
		}
		animalsByEnclos(sortedOutput.toString());
	}

	/**
	 * Affichage des caractéristiques du zoo avec son toString()
	 */
	public static void informationsZoo() {
		affichageInformationsZoo(zoo.toString());
	}

	/**
	 * Affichage des caractéristiques de l'employé(e) avec son toString()
	 */
	public static void informationsEmploye() {
		affichageInformationsZoo(employe.toString());
	}
}
