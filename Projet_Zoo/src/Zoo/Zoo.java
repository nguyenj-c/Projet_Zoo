/**
 * @author Nguyen, Khalil
 *
 */
package Zoo;

import java.util.ArrayList;
import java.util.List;

import Enclos.Enclos;

public class Zoo {

	private String name;
	private Employe employe;
	private int maxEnclos;
	private ArrayList<Enclos> list_enclos;


	/**
	 * Constructeur de Zoo
	 * @param name
	 * @param employee
	 * @param maxEnclos
	 */
	public Zoo(String name, Employe employe, int maxEnclos) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom du Zoo ne peut pas Ãªtre vide.");
		}
		if (employe == null) {
			throw new IllegalArgumentException("L'employÃ© ne peut pas Ãªtre null.");
		}
		if (maxEnclos <= 0d) {
			throw new IllegalArgumentException("Le nombre maximal d'enclos doit Ãªtre supÃ©rieur Ã  zÃ©ro.");
		}
		this.name = name;
		this.employe = employe;
		this.maxEnclos = maxEnclos;
		this.list_enclos = new ArrayList<Enclos>();
	}

	/**
	 * Ajoute un enclos au Zoo
	 * @param enclos
	 */
	public void addEnclosure(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		if (this.list_enclos.contains(enclos)) {
			throw new IllegalArgumentException("L'enclos existe déjà .");
		}
		this.list_enclos.add(enclos);
	}
		/**
	 * Supprime un enclos du zoo
	 * @param enclos
	 */
	public void removeEnclosure(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas Ãªtre null.");
		}
		if (!this.list_enclos.contains(enclos)) {
			throw new IllegalArgumentException("L'enclos n'existe pas.");
		}
		if (!(enclos.getNbAnimals() == 0)) {
			throw new IllegalArgumentException("L'enclos n'est pas vide.");
		}
		this.list_enclos.remove(enclos);
	}
	/**
	 * Renvoie la liste de tous les enclos du Zoo
	 * @return
	 */
	public List<Enclos> getAllEnclosures() {
		return list_enclos;
	}

	/**
	 * Renvoie la liste des enclos par type d'enclos
	 * @param type
	 * @param <T>
	 * @return List
	 */
	public <T extends Enclos> List<T> getEnclosuresByType(Class<T> type) {
		List<T> tList = new ArrayList<>();
		for (Enclos allEnclos : getAllEnclosures()) {
			if(allEnclos.getClass().equals(type)) {
				tList.add((T) allEnclos);
			}
		}
		return tList;
	}

	/**
	 * Renvoie l'enclos ou se situe l'animal
	 * @param targetAnimal
	 * @return
	 */
	public Enclos getEnclosureOf(Animaux targetAnimal) {
		for (Enclos enclos : list_enclos) {
			if(enclos.getActualAnimals().contains(targetAnimal)){
				return enclos;
			}
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return "Zoo { " + "name = " + this.name + ", employe = " + this.employe + 
				", maxEnclos = " + this.maxEnclos + ", enclos = " + this.list_enclos + " }";
	}
	public static void getNameZoo() {
		System.out.println("Quel est le nom de votre Zoo ?");
	}

	public static void getMaxEnclosure() {
		System.out.println("Combien d'enclos au maximum autorisez vous dans votre Zoo ?");
	}

	public static void successZoo() {
		System.out.println("Le Zoo à  correctement été crée !\n");
	}
}

