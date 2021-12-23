/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Animaux.*;
import Zoo.*;
import Game.initGame;

public class menuAnimaux {

	private static final Scanner scanner = new Scanner(System.in);
	private static Zoo zoo = initGame.getZoo();

	/**
	 * Affichage du menu des actions pour les animaux
	 */
	public static void affichageMenu() {
		System.out.println(
				"\nMenu de gestion des animaux :\n" + "1 - Créer un nouvel animal\n" + "2 - Soigner un animal\n"
						+ "3 - Nourrir un animal\n" + "4 - Consulter les informations d'un animal\n" + "5 - Retour");
	}


	/**
	 * Affichage du menu crée un animal
	 */
	public static void affichageMenuCreateAnimal() {
		System.out.println("Création d'un nouvel animal.\n" + "Quel type d'animal voulez vous ajouter au Zoo ?\n"
				+ "1 - Un Aigle\n" + "2 - Une Baleine\n" + "3 - Un Loup\n" + "4 - Un Ours\n" + "5 - Un Pingouin\n"
				+ "6 - Un Poisson rouge\n" + "7 - Un Requin\n" + "8 - Un Tigre\n");
	}

	
	/**
	 * Affichage texte de demande du nom de l'animal
	 */
	public static void getNameAnimal() {
		System.out.println("Quel nom voulez vous donner à  l'animal ?");
	}


	/**
	 * Affichage texte du success de création de l'animal
	 */
	public static void successCreate() {
		System.out.println("L'animal a été correctement créé.");
	}

	
	/**
	 * Affichage texte de demande du type de l'animal
	 */
	public static void getTypeAnimal() {
		System.out.println("Quel type d'animal voulez vous sélectionner ?\n" + "1 - Un Aigle\n" + "2 - Une Baleine\n"
				+ "3 - Un Loup\n" + "4 - Un Ours\n" + "5 - Un Pingouin\n" + "6 - Un Poisson rouge\n" + "7 - Un Requin\n"
				+ "8 - Un Tigre\n");
	}
	/**
	 * Affichage texte de demande saisie de l'animal
	 */
	public static void getAnimal() {
		System.out.println("Quel animal voulez vous sélectionner ?");
	}
	
	/**
	 * Traite les choix fait sur le menu Animaux
	 */
	public static void menu() {
		affichageMenu();
		int selected = scanner.nextInt();
		switch (selected) {
			case 1:
				menuCreateAnimal();
				break;
			case 2:
				menuHealAnimal();
				break;
			case 3:
				menuFeedAnimal();
				break;
			case 4:
				menuInformationsAnimal();
				break;
			case 5:
				initGame.menu();
				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
	}

	/**
	 * Traite les choix fait sur le menu crée un animal
	 */
	public static void menuCreateAnimal() {
		affichageMenuCreateAnimal();
		int selected = scanner.nextInt();
		getNameAnimal();
		String nameAnimal = scanner.next();
		switch (selected) {
			case 1:
				new Aigles(nameAnimal);
				break;
			case 2:
				new Baleines(nameAnimal);
				break;
			case 3:
				new Loups(nameAnimal, 'm', 57, 60, 'α');
				break;
			case 4:
				new Ours(nameAnimal);
				break;
			case 5:
				new Pingouins(nameAnimal);
				break;
			case 6:
				new Poissons_Rouges(nameAnimal);
				break;
			case 7:
				new Requins(nameAnimal);
				break;
			case 8:
				new Tigres(nameAnimal);
				break;
			default:
				throw new IllegalArgumentException("Sélection en dehors du menu.");
		}
		successCreate();
	}

	/**
	 * Traite les choix fait sur le choix de l'animal pour avoir ses informations
	 */
	public static void menuInformationsAnimal() {
		getTypeAnimal();
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
			System.out.print("Pas d'animaux de ce type ce trouve dans le zoo\n");
		} else {
			List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream().map(Animaux::getName)
					.collect(Collectors.toList());
			displayAnimalList(animalsOfSelectedTypeStr);
			String animalSelected = "";
			while (!animalsOfSelectedTypeStr.contains(animalSelected)) {
				getAnimal();
				animalSelected = scanner.next();
			}
			String finalAnimalSelected = animalSelected;
			Animaux targetAnimal = animalsOfSelectedType.stream()
					.filter(animal1 -> animal1.getName().equals(finalAnimalSelected)).findAny().orElseThrow();
			System.out.println("Informations de l'animal :\n" + targetAnimal.toString());
		}
	}

	/**
	 * Affichage de la liste des animaux
	 */
	public static void displayAnimalList(List<String> list) {
		System.out.println("Voici la liste des animaux : ");
		list.forEach(System.out::println);
	}

	/**
	 * Traite les choix fait sur le choix de l'animal pour les nourir
	 */
	public static void menuFeedAnimal() {
		if (zoo.numberAnimalsZoo() == 0) {
			System.out.println("\nIl n'y a pas d'enclos contenant des animaux dans le Zoo.");
			return;
		}
		getTypeAnimal();
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
			System.out.print("Pas d'animaux de ce type ce trouve dans le zoo\n");
		} else {
			List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream().map(Animaux::getName)
					.collect(Collectors.toList());
			displayAnimalList(animalsOfSelectedTypeStr);
			String animalSelected = "";
			while (!animalsOfSelectedTypeStr.contains(animalSelected)) {
				getAnimal();
				animalSelected = scanner.next();
			}
			String finalAnimalSelected = animalSelected;
			Animaux targetAnimal = animalsOfSelectedType.stream()
					.filter(animal1 -> animal1.getName().equals(finalAnimalSelected)).findAny().orElseThrow();
			targetAnimal.eat();
		}
	}

	/**
	 * Traite les choix fait sur le choix de l'animal pour le soigner
	 */
	public static void menuHealAnimal() {
		if (zoo.numberAnimalsZoo() == 0) {
			System.out.println("\nIl n'y a pas d'enclos contenant des animaux dans le Zoo.");
			return;
		}
		getTypeAnimal();
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
			System.out.print("Pas d'animaux de ce type ce trouve dans le zoo\n");
		} else {
			List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream().map(Animaux::getName)
					.collect(Collectors.toList());
			displayAnimalList(animalsOfSelectedTypeStr);
			String animalSelected = "";
			while (!animalsOfSelectedTypeStr.contains(animalSelected)) {
				getAnimal();
				animalSelected = scanner.next();
			}
			String finalAnimalSelected = animalSelected;
			Animaux targetAnimal = animalsOfSelectedType.stream()
					.filter(animal1 -> animal1.getName().equals(finalAnimalSelected)).findAny().orElseThrow();
			targetAnimal.beHealed();
		}
	}
}
