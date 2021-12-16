/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Animaux.*;
import Enclos.Enclos;
import Enclos.EnclosAquarium;
import Enclos.EnclosVolieres;
import Game.initGame;
import Zoo.Employe;
import Zoo.Zoo;

public class menuEnclos {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Employe employe = initGame.getEmploye();
    private static Animaux animal;
    private static Zoo zoo = initGame.getZoo();
    private static Enclos enclos;
    
	public static void affichageMenu() {
		System.out.println("\nMenu de gestion des enclos :\n" + "1 - Créer un nouvel enclos\n"
				+ "2 - Examiner un enclos\n" + "3 - Ajouter un animal à un enclos\n"
				+ "4 - Supprimer un animal d'un enclos\n" + "5 - Transférer les animaux d'un enclos à un autre\n"
				+ "6 - Nettoyer un enclos\n" + "7 - Nourrir les animaux d'un enclos\n"
				+ "8 - Consulter les informations d'un enclos\n" + "9 - Retour");
	}

	public static void affichageMenuCreateEnclos() {
		System.out.println("Création d'un nouvel enclos.\n" + "Quel type d'enclos voulez vous ajouter au Zoo ?\n"
				+ "1 - Un enclos normal\n" + "2 - Une volière\n" + "3 - Un aquarium");
	}

	public static void getNameEnclos() {
		System.out.println("Quel nom voulez vous donner à l'enclos ?");
	}

	public static void getAreaEnclos() {
		System.out.println("Quel est la superficie de l'enclos ?");
	}

	public static void getMaxAnimalsEnclos() {
		System.out.println("Quel est le nombre maximal d'animaux pouvant être mit dans l'enclos ?");
	}
	
    public static void getTypeEnclos() {
        System.out.println("Quel est le type de l'enclos ?\n" +
                "1 - Enclos normal\n" +
                "2 - Volière\n" +
                "3 - Aquarium");
    }
	
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
                //menuFeedAnimals();
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

	public static void menuExamineEnclos() {
        if (zoo.getAllEnclos().isEmpty()) {
        	System.out.println("Il n'y a pas d'enclos dans le Zoo.");
            return;
        }
        Enclos enclos = selectEnclos();
		employe.analyseEnclos(enclos);
    }
	
	 private static Animaux selectAnimal() {
	        if (zoo.getAllEnclos().isEmpty()) {
	        	System.out.println("\nIl n'y a pas d'enclos contenant des animaux dans le Zoo.");
	            return null;
	        }
	        menuAnimaux.getTypeAnimal();
	        int selected = scanner.nextInt();
	        Class<? extends Animaux> clazz = null;
	        switch (selected) {
	            case 1:
	                clazz = Aigles.class;
	                break;
	            case 2:
	                clazz = Baleines.class;
	                break;
	            case 3:
	                clazz = Loups.class;
	                break;
	            case 4:
	                clazz = Ours.class;
	                break;
	            case 5:
	                clazz = Pingouins.class;
	                break;
	            case 6:
	                clazz = Poissons_Rouges.class;
	                break;
	            case 7:
	                clazz = Requins.class;
	                break;
	            case 8:
	                clazz = Tigres.class;
	                break;
	            default:
	                throw new IllegalArgumentException("Sélection en dehors du menu.");
	        }
	        List<Animaux> animalsOfSelectedType = AnimalRegistry.getRegisteredAnimalsByClass(clazz);
	        List<String> animalsOfSelectedTypeStr = animalsOfSelectedType.stream()
	                .map(Animaux::getName)
	                .collect(Collectors.toList());
	        menuAnimaux.displayAnimalList(animalsOfSelectedTypeStr);
	        String animalSelected = "";
	        while(!animalsOfSelectedTypeStr.contains(animalSelected)) {
	            menuAnimaux.getAnimal();
	            animalSelected = scanner.next();
	        }
	        String finalAnimalSelected = animalSelected;
	        return animalsOfSelectedType.stream()
	                .filter(animal1 -> animal1.getName().equals(finalAnimalSelected))
	                .findAny().orElseThrow();
	    }
	
	public static void menuAddAnimal() {
        Animaux targetAnimal = selectAnimal();
        enclos = selectEnclos();
        enclos.ajouter(targetAnimal);
        System.out.println("L'animal à été correctement ajouté à l'enclos.");
    }

    public static void menuRemoveAnimal() {
    	Animaux targetAnimal = selectAnimal();
        enclos = selectEnclos();
        enclos.enlever(targetAnimal);
        System.out.println("L'animal à été correctement ajouté à l'enclos.");
    }


    public static void menuInformationsEnclos() {
        if (zoo.getAllEnclos().isEmpty()) {
        	System.out.println("Il n'y a pas d'enclos dans le Zoo.");
            return;
        }
        Enclos enclos =  selectEnclos();
        System.out.println("Informations de l'enclos :\n" +
                enclos.toString());
    }

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

        selected = -1;
        List<? extends Enclos> enclos2 = zoo.getEnclosByType(selectedType);
        List<String> names = enclos2.stream().map(Enclos::getName).collect(Collectors.toList());
        while (selected < 0 || selected >= enclos2.size()) {
            getEnclos(names);
            selected = scanner.nextInt() - 1;
        }
        return enclos = enclos2.get(selected);
    }
	
    public static void getEnclos(List<String> enclosureNames) {
        System.out.println("Quel enclos voulez vous sélectionner ?");
        for (int i = 0; i < enclosureNames.size(); i++) {
            System.out.println((i+1) + " - " + enclosureNames.get(i));
        }
    }
    public static void menuTransfertAnimal() {
        Animaux targetAnimal = selectAnimal();

        enclos= selectEnclos();
        Enclos fromEnclosure = zoo.getEnclosOf(targetAnimal);
        if(fromEnclosure != null)
            fromEnclosure.enlever(targetAnimal);
        enclos.ajouter(targetAnimal);

    }

    public static void menuCleanEnclos() {
        if (zoo.getAllEnclos().isEmpty()) {
        	System.out.println("Il n'y a pas d'enclos dans le Zoo.");
            return;
        }
        Enclos enclos = selectEnclos();
        employe.cleanEnclos(enclos);
        employe.analyseEnclos(enclos);
    }


}