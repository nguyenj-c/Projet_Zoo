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

import Animaux.Animaux;
import Enclos.Enclos;
import Game.initGame;
import Zoo.Employe;
import Zoo.Zoo;


public class menuZoo {

	
    private static final Scanner scanner = new Scanner(System.in);
    private static final Employe employe = initGame.getEmploye();
    private static Animaux animal;
    private static Zoo zoo = initGame.getZoo();

    public static void affichageMenu() {
        System.out.println("\nMenu d'informations du Zoo :\n" +
                "1 - Liste des enclos\n" +
                "2 - Nombre d'animaux dans le Zoo\n" +
                "3 - Animaux par enclos\n" +
                "4 - Informations du Zoo\n" +
                "5 - Informations de l'employé\n" +
                "6 - Retour");
    }

    public static void listEnclos(List<String> enclosures) {
        System.out.println("Liste des enclos du Zoo :\n" +
                enclosures);
    }

    public static void numberAnimal(int number) {
        System.out.println("Nombre d'animaux présent dans les cages :\n" +
                number);
    }

    public static void animalsByEnclos(String sortedMisOfThings) {
        System.out.println("Enclos et leurs animaux triés par nom :\n" +
                sortedMisOfThings);
    }

    public static void informationsZoo(String zoo) {
        System.out.println("Informations du zoo :\n" +
                zoo);
    }

    public static void informationsEmployee(String employee) {
        System.out.println("Informations de l'employé :\n" +
                employee);
    }

    
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

    public static void listEnclos() {
        List<Enclos> enclos = zoo.getAllEnclos();
        listEnclos(enclos.stream().map(Enclos::toString).collect(Collectors.toList()));
    }

    public static void numberAnimalZoo() {
        int number = zoo.numberAnimalsZoo();
        numberAnimal(number);
    }

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

    public static void informationsZoo() {
    	informationsZoo(zoo.toString());
    }

    public static void informationsEmploye() {
        informationsEmployee(employe.toString());
    }
}
