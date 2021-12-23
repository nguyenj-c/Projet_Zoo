/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Animaux.*;
import Enclos.*;
import Zoo.*;
import Game.initGame;

public class menuEnclos {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Employe employe = initGame.getEmploye();
	private static Zoo zoo = initGame.getZoo();
	private static Enclos enclos;


	/**
	 * Affichage du menu des actions pour les enclos
	 */
	public static void affichageMenu() {
		System.out.println("\nMenu de gestion des enclos :\n" + "1 - Créer un nouvel enclos\n"
				+ "2 - Examiner un enclos\n" + "3 - Ajouter un animal à un enclos\n"
				+ "4 - Supprimer un animal d'un enclos\n" + "5 - Transférer les animaux d'un enclos à un autre\n"
				+ "6 - Nettoyer un enclos\n" + "7 - Nourrir les animaux d'un enclos\n"
				+ "8 - Consulter les informations d'un enclos\n" + "9 - Retour");
	}


	/**
	 * Affichage du menu des actions pour la création des enclos
	 */
	public static void affichageMenuCreateEnclos() {
		System.out.println("Création d'un nouvel enclos.\n" + "Quel type d'enclos voulez vous ajouter au Zoo ?\n"
				+ "1 - Un enclos normal\n" + "2 - Une volière\n" + "3 - Un aquarium");
	}

	/**
	 * Affichage texte de demande du nom de l'enclos
	 */
	public static void getNameEnclos() {
		System.out.println("Quel nom voulez vous donner à l'enclos ?");
	}

	/**
	 * Affichage texte de demande de la superficie de l'enclos
	 */
	public static void getAreaEnclos() {
		System.out.println("Quel est la superficie de l'enclos ?");
	}
	
	/**
	 * Affichage texte de demande du nombre maximale d'animaux dans l'enclos
	 */
	public static void getMaxAnimalsEnclos() {
		System.out.println("Quel est le nombre maximal d'animaux pouvant être mit dans l'enclos ?");
	}

	/**
	 * Affichage texte de demande du type de l'enclos
	 */
	public static void getTypeEnclos() {
		System.out.println("Quel est le type de l'enclos ?\n" + "1 - Enclos normal\n" + "2 - Volière\n" + "3 - Aquarium");
	}

	/**
	 * Traite les choix fait sur le menu de création d'enclos
	 */
	public static void menuCreateEnclos() {
		affichageMenuCreateEnclos();
		int selected = scanner.nextInt();
		getNameEnclos();
		String nameEnclos = scanner.next();
		getAreaEnclos();
		double areaEnclos = scanner.nextDouble();
		getMaxAnimalsEnclos();
		int maxAnimalsEnclos = scanner.nextInt();
		switch (selected) {
			case 1:
				enclos = new Enclos(nameEnclos, areaEnclos, maxAnimalsEnclos);
				initGame.getZoo().addEnclos(enclos);
				break;
			case 2:
				System.out.println("Quel est la hauteur de la volière ?");
				double hauteur = scanner.nextDouble();
				enclos = new EnclosVolieres(nameEnclos, areaEnclos, maxAnimalsEnclos, hauteur);
				initGame.getZoo().addEnclos(enclos);
				System.out.print(enclos);
				break;
			case 3:
				System.out.println("Quel est la profondeur de l'aquarium ?");
				double profondeur = scanner.nextFloat();
				enclos = new EnclosAquarium(nameEnclos, areaEnclos, maxAnimalsEnclos, profondeur);
				initGame.getZoo().addEnclos(enclos);

				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
		System.out.println("L'enclos a été correctement créé.");
	}

	/**
	 * Traite les choix fait sur le menu Enclos
	 */
	public static void menu() {
		affichageMenu();
		int selected = scanner.nextInt();
		switch (selected) {
			case 1:
				menuCreateEnclos();
				break;
			case 2:
				menuExamineEnclos();
				break;
			case 3:
				menuAddAnimal();
				break;
			case 4:
				menuRemoveAnimal();
				break;
			case 5:
				menuTransfertAnimal();
				break;
			case 6:
				menuCleanEnclos();
				break;
			case 7:
				menuFeedAnimals();
				break;
			case 8:
				menuInformationsEnclos();
				break;
			case 9:
				initGame.menu();
				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
	}


	/**
	 * Examine un enclos selectionné
	 */
	public static void menuExamineEnclos() {
		if (zoo.getAllEnclos().isEmpty()) {
			System.out.println("Il n'y a pas d'enclos dans le Zoo.");
			return;
		}
		Enclos enclos = selectEnclos();
		if (enclos == null) {
			System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
		} else {
			employe.analyseEnclos(enclos);
		}
	}

	/**
	 * Traite les choix fait sur le menu de sélection d'animaux
	 */
	private static Animaux selectAnimal() {
		if (zoo.getAllEnclos().isEmpty()) {
			System.out.println("\nIl n'y a pas d'enclos contenant des animaux dans le Zoo.");
			return null;
		}
		menuAnimaux.getTypeAnimal();
		int selected = scanner.nextInt();
		Class<? extends Animaux> especes = null;
		switch (selected) {
			case 1:
				especes = Aigles.class;
				break;
			case 2:
				especes = Baleines.class;
				break;
			case 3:
				especes = Loups.class;
				break;
			case 4:
				especes = Ours.class;
				break;
			case 5:
				especes = Pingouins.class;
				break;
			case 6:
				especes = Poissons_Rouges.class;
				break;
			case 7:
				especes = Requins.class;
				break;
			case 8:
				especes = Tigres.class;
				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
		List<Animaux> animalsOfSelectedType = AnimalRegistry.getRegisteredAnimalsByClass(especes);
		if (animalsOfSelectedType == null) {
			return null;
		} else {
			List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream().map(Animaux::getName)
					.collect(Collectors.toList());
			menuAnimaux.displayAnimalList(animalsOfSelectedTypeStr);
			String animalSelected = "";
			while (!animalsOfSelectedTypeStr.contains(animalSelected)) {
				menuAnimaux.getAnimal();
				animalSelected = scanner.next();
			}
			String finalAnimalSelected = animalSelected;
			return animalsOfSelectedType.stream().filter(animal1 -> animal1.getName().equals(finalAnimalSelected))
					.findAny().orElseThrow();
		}
	}

	/**
	 * Ajoute un animal selectionné à un enclos selectioné
	 */
	public static void menuAddAnimal() {
		Animaux targetAnimal = selectAnimal();
		if (targetAnimal == null) {
			System.out.print("Pas d'animaux de ce type se trouve dans le zoo\n");
		} else {
			enclos = selectEnclos();
			if (enclos == null) {
				System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
			} else {
				if (enclos.isCompatible(targetAnimal)) {
					enclos.addAnimaux(targetAnimal);
					System.out.println("L'animal à été correctement ajouté à l'enclos.");
				} else {
					System.out.print("L'animal " + targetAnimal + " n'est pas compatible avec cette enclos\n");
				}
			}
		}
	}
	/**
	 * Enlève un animal selectionné à un enclos selectioné
	 */
	public static void menuRemoveAnimal() {
		Animaux targetAnimal = selectAnimal();
		if (targetAnimal == null) {
			System.out.print("Pas d'animaux de ce type se trouve dans le zoo\n");
		} else {
			enclos = selectEnclos();
			if (enclos == null) {
				System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
			} else {
				if (enclos.isCompatible(targetAnimal)) {
					enclos.removeAnimaux(targetAnimal);
					System.out.println("L'animal à été correctement enlevé à l'enclos.");
				} else {
					System.out.print("L'animal " + targetAnimal + " n'est pas compatible avec cette enclos\n");
				}
			}
		}
	}
	
	/**
	 * Nourrit un animal selectionné dans un enclos selectioné
	 */
	public static void menuFeedAnimals() {
		if (zoo.getAllEnclos().isEmpty()) {
			System.out.println("Il n'y a pas d'enclos dans le Zoo.");
			return;
		}
		enclos = selectEnclos();
		if (enclos == null) {
			System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
		} else {
			employe.feedAnimalsEnclos(enclos);
			System.out.println("Les animaux de l'enclos ont été nourrit.");
		}
	}

	/**
	 * Retourne les informations d'un enclos selectioné
	 */
	public static void menuInformationsEnclos() {
		if (zoo.getAllEnclos().isEmpty()) {
			System.out.println("Il n'y a pas d'enclos dans le Zoo.");
			return;
		}
		Enclos enclos = selectEnclos();
		if (enclos == null) {
			System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
		} else {
			System.out.println("Informations de l'enclos :\n" + enclos.toString());
		}
	}
	
	/**
	 * Affichage de la liste des enclos
	 */
	public static void displayEnclosList(List<String> list) {
		System.out.println("Voici la liste des enclos : ");
		list.forEach(System.out::println);
	}
	
	/**
	 * Traite les choix fait sur le menu de sélection des enclos
	 */
	public static Enclos selectEnclos() {
		getTypeEnclos();
		int selected = scanner.nextInt();

		Class<? extends Enclos> selectedType = null;
		switch (selected) {
			case 1:
				selectedType = Enclos.class;
				break;
			case 2:
				selectedType = EnclosVolieres.class;
				break;
			case 3:
				selectedType = EnclosAquarium.class;
				break;
		}

		List<Enclos> enclosOfSelectedType = EnclosRegistry.getRegisteredEnclosByType(selectedType);
		if (enclosOfSelectedType == null) {
			return null;
		} else {
			List<String> enclosOfSelectedTypeStr = enclosOfSelectedType.stream().map(Enclos::getName)
					.collect(Collectors.toList());
			displayEnclosList(enclosOfSelectedTypeStr);
			String enclosSelected = "";
			while (!enclosOfSelectedTypeStr.contains(enclosSelected)) {
				getEnclos(enclosOfSelectedTypeStr);
				enclosSelected = scanner.next();
			}
			String finalEnclosSelected = enclosSelected;
			Enclos targetEnclos = enclosOfSelectedType.stream()
					.filter(enclos1 -> enclos1.getName().equals(finalEnclosSelected)).findAny().orElseThrow();
			return targetEnclos;
		}
	}

	/**
	 * Prends et retourne les enclos demandés
	 */
	public static void getEnclos(List<String> enclosNames) {
		System.out.println("Quel enclos voulez vous sélectionner ?");
		for (int i = 0; i < enclosNames.size(); i++) {
			System.out.println((i + 1) + " - " + enclosNames.get(i));
		}
	}

	/**
	 * Transfère un animal selectionné à un enclos selectioné
	 */
	public static void menuTransfertAnimal() {
		Animaux targetAnimal = selectAnimal();
		enclos = selectEnclos();
		if (enclos == null) {
			System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
		} else {
			if (enclos.isCompatible(targetAnimal)) {
				Enclos enclosOrigine = zoo.getEnclosOf(targetAnimal);
				if (enclosOrigine != null)
					enclosOrigine.removeAnimaux(targetAnimal);
				enclos.addAnimaux(targetAnimal);
			} else {
				System.out.print("L'animal " + targetAnimal.getSpecies() + " : " + targetAnimal.getName()
						+ " n'est pas compatible avec cette enclos\n");
			}
		}
	}

	/**
	 * Nettoie un enclos selectioné
	 */
	public static void menuCleanEnclos() {
		if (zoo.getAllEnclos().isEmpty()) {
			System.out.println("Il n'y a pas d'enclos dans le Zoo.");
			return;
		}
		Enclos enclos = selectEnclos();
		if (enclos == null) {
			System.out.print("Pas d'enclos de ce type se trouve dans le zoo\n");
		} else {
			employe.cleanEnclos(enclos);
			employe.analyseEnclos(enclos);
		}
	}
}
