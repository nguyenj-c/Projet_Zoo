/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

import java.util.Scanner;

import Animaux.Aigles;
import Animaux.Animaux;
import Animaux.Baleines;
import Animaux.Loups;
import Animaux.Ours;
import Animaux.Pingouins;
import Animaux.Poissons_Rouges;
import Animaux.Requins;
import Animaux.Tigres;
import Game.initGame;
import Zoo.Employe;
import Zoo.Zoo;

public class menuAnimaux {

	
    private static final Scanner scanner = new Scanner(System.in);
    private static final Employe employe = initGame.getEmploye();
    private static Animaux animal;
    private static Zoo zoo = initGame.getZoo();
    
	public static void affichageMenu() {
		System.out.println(
				"\nMenu de gestion des animaux :\n" + "1 - Créer un nouvel animal\n" + "2 - Soigner un animal\n"
						+ "3 - Nourrir un animal\n" + "4 - Consulter les informations d'un animal\n" + "5 - Retour");
	}

	public static void affichageMenuCreateAnimal() {
		System.out.println("Création d'un nouvel animal.\n" + "Quel type d'animal voulez vous ajouter au Zoo ?\n"
				+ "1 - Un Aigle\n" + "2 - Une Baleine\n" + "3 - Un Loup\n" + "4 - Un Ours\n" + "5 - Un Pingouin\n"
				+ "6 - Un Poisson rouge\n" + "7 - Un Requin\n" + "8 - Un Tigre\n");
	}

	public static void getNameAnimal() {
		System.out.println("Quel nom voulez vous donner à  l'animal ?");
	}

	public static void successCreate() {
		System.out.println("L'animal a Ã©tÃ© correctement créé.");
	}

	public static void getTypeAnimal() {
		System.out.println("Quel type d'animal voulez vous sélectionner ?\n" + "1 - Un Aigle\n" + "2 - Une Baleine\n"
				+ "3 - Un Loup\n" + "4 - Un Ours\n" + "5 - Un Pingouin\n" + "6 - Un Poisson rouge\n" + "7 - Un Requin\n"
				+ "8 - Un Tigre\n");
	}

	public static void getAnimal() {
		System.out.println("Quel animal voulez vous sélectionner ?");
	}

	public static void menu() {
		affichageMenu();
		int selected = scanner.nextInt();
		switch (selected) {
		case 1:
			menuCreateAnimal();
			break;
        case 2:
            //menuHealAnimal();
            break;
        case 3:
            //menuFeedAnimal();
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
			new Loups(nameAnimal);
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
				especes =  Tigres.class;
				break;
            default:
                throw new IllegalArgumentException("Sélection en dehors du menu.");
        }
        System.out.println("Informations de l'animal :\n" +
        		especes.toString());
    }
	    public static void displayAnimalList(List<String> list) {
        System.out.println("Voici la liste des animaux : ");
        list.forEach(System.out::println);
    }
	/*public void menuFeedAnimal() {
        if (zoo.numberAnimalsZoo() == 0) {
            animalsView.errorNumberAnimal();
            return;
        }
        animalsView.getTypeAnimal();
        int selected = scanner.nextInt();
        Class<? extends Animal> clazz = null;
        switch (selected) {
            case 1:
                clazz = Bear.class;
                break;
            case 2:
                clazz = Eagle.class;
                break;
            case 3:
                clazz = Goldfish.class;
                break;
            case 4:
                clazz = Penguin.class;
                break;
            case 5:
                clazz = Shark.class;
                break;
            case 6:
                clazz = Tiger.class;
                break;
            case 7:
                clazz = Whale.class;
                break;
            case 8:
                clazz = Wolf.class;
                break;
            default:
                throw new IllegalArgumentException("Sélection en dehors du menu.");
        }
        List<Animal> animalsOfSelectedType = AnimalRegistry.getRegisteredAnimalsByClass(clazz);
        List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream()
                .map(Animal::getName)
                .collect(Collectors.toList());
        animalsView.displayAnimalList(animalsOfSelectedTypeStr);
        String animalSelected = "";
        while(!animalsOfSelectedTypeStr.contains(animalSelected)) {
            animalsView.getAnimal();
            animalSelected = scanner.next();
        }
        String finalAnimalSelected = animalSelected;
        Animal targetAnimal = animalsOfSelectedType.stream()
                .filter(animal1 -> animal1.getName().equals(finalAnimalSelected))
                .findAny().orElseThrow();
        if (targetAnimal.feed()) {
            animalsView.feedAnimal();
        } else {
            animalsView.errorFeedAnimal();
        }
    }

    public void menuHealAnimal() {
        if (zoo.numberAnimalsZoo() == 0) {
            animalsView.errorNumberAnimal();
            return;
        }
        animalsView.getTypeAnimal();
        int selected = scanner.nextInt();
        Class<? extends Animal> clazz = null;
        switch (selected) {
            case 1:
                clazz = Bear.class;
                break;
            case 2:
                clazz = Eagle.class;
                break;
            case 3:
                clazz = Goldfish.class;
                break;
            case 4:
                clazz = Penguin.class;
                break;
            case 5:
                clazz = Shark.class;
                break;
            case 6:
                clazz = Tiger.class;
                break;
            case 7:
                clazz = Whale.class;
                break;
            case 8:
                clazz = Wolf.class;
                break;
            default:
                throw new IllegalArgumentException("Sélection en dehors du menu.");
        }
        List<Animal> animalsOfSelectedType = AnimalRegistry.getRegisteredAnimalsByClass(clazz);
        List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream()
                .map(Animal::getName)
                .collect(Collectors.toList());
        animalsView.displayAnimalList(animalsOfSelectedTypeStr);
        String animalSelected = "";
        while(!animalsOfSelectedTypeStr.contains(animalSelected)) {
            animalsView.getAnimal();
            animalSelected = scanner.next();
        }
        String finalAnimalSelected = animalSelected;
        Animal targetAnimal = animalsOfSelectedType.stream()
                .filter(animal1 -> animal1.getName().equals(finalAnimalSelected))
                .findAny().orElseThrow();
        targetAnimal.heal();
        animalsView.healAnimal();
    }*/
}

