/**
 * @author Nguyen, Khalil
 *
 */
package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Animaux.Animaux;
import Enclos.Enclos;
import Enclos.Enclos.degreProprete;

public class Zoo {

	/**
	 * Nom du zoo
	 */
	private String name;
	/**
	 * Employé(e) du zoo
	 */
	private Employe employe;
	/**
	 * Nombre d'enclos du zoo
	 */
	private int nbEnclos;
	/**
	 * Nombre d'enclos max du zoo
	 */
	private int maxEnclos;
	/**
	 * Liste enclos dans le zoo
	 */
	private static ArrayList<Enclos> list_enclos;

	/**
	 * Constructeur de Zoo
	 *
	 * @param name of the zoo
	 * @param employe of the zoo
	 * @param maxEnclos of the zoo
	 */
	public Zoo(String name, Employe employe, int maxEnclos) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom du Zoo ne peut pas être vide.");
		}
		if (employe == null) {
			throw new IllegalArgumentException("L'employé ne peut pas Ãªtre null.");
		}
		if (maxEnclos <= 0d) {
			throw new IllegalArgumentException("Le nombre maximal d'enclos doit Ãªtre supérieur à  zéro.");
		}
		this.name = name;
		this.employe = employe;
		this.nbEnclos = 0;
		this.maxEnclos = maxEnclos;
		Zoo.list_enclos = new ArrayList<>();
	}

	/**
	 * Retourne le nom du zoo
	 *
	 * @return the name of the zoo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom du zoo
	 *
	 * @param name the name of the zoo
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne l'employe
	 *
	 * @return the employe of the zoo
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * Change l'employe
	 *
	 * @param employe the employe of the zoo
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	/**
	 * Retourne le nombre d'enclos dans le zoo
	 *
	 * @return the nbEnclos of the zoo
	 */
	public int getNbEnclos() {
		return nbEnclos;
	}

	/**
	 * Change le nombre d'enclos dans le zoo
	 *
	 * @param nbEnclos the nbEnclos of the zoo
	 */
	public void setNbEnclos(int nbEnclos) {
		this.nbEnclos = nbEnclos;
	}

	/**
	 * Retourne le max d'enclos dans le zoo
	 *
	 * @return the maxEnclos of the zoo
	 */
	public int getMaxEnclos() {
		return maxEnclos;
	}

	/**
	 * Change le nombre max d'enclos dans le zoo
	 *
	 * @param maxEnclos the maxEnclos of the zoo
	 */

	public void setMaxEnclos(int maxEnclos) {
		this.maxEnclos = maxEnclos;
	}

	/**
	 * Retourne la liste des enclos
	 *
	 * @return the list_enclos of the zoo
	 */
	public ArrayList<Enclos> getList_enclos() {
		return list_enclos;
	}

	/**
	 * Change la liste des enclos
	 *
	 * @param list_enclos the list_enclos of the zoo
	 */
	public void setList_enclos(ArrayList<Enclos> list_enclos) {
		Zoo.list_enclos = list_enclos;
	}

	/**
	 * Ajoute un enclos au Zoo
	 *
	 * @param enclos of the zoo
	 */
	public void addEnclos(Enclos enclos) {
		if (enclos == null) {
			System.out.println("L'enclos ne peut pas être null.");
		}
		if (getNbEnclos() == getMaxEnclos()) {
			System.out.println("Zoo déja plein, impossible de rajouter " + enclos.getName() + " ( " + getNbEnclos()
					+ "/" + getMaxEnclos() + " )");
		} else {
			this.nbEnclos += 1;
			Zoo.list_enclos.add(enclos);
		}
	}

	/**
	 * Supprime un enclos du zoo
	 *
	 * @param enclos of the zoo
	 */
	public void removeEnclos(Enclos enclos) {
		if (enclos == null) {
			System.out.println("L'enclos ne peut pas être null.");
		}
		if (!Zoo.list_enclos.contains(enclos)) {
			System.out.println("L'enclos n'existe pas.");
		}
		if (!(enclos.getNbAnimals() == 0)) {
			System.out.println("L'enclos n'est pas vide.");
		}
		if (getNbEnclos() == 0) {
			System.out.println("Pas d'enclos existant dans le zoo.");
		} else {
			this.nbEnclos -= 1;
			Zoo.list_enclos.remove(enclos);
		}
	}

	/**
	 * Renvoie la liste de tous les enclos du Zoo
	 *
	 * @return List_Enclos 
	 */
	public List<Enclos> getAllEnclos() {
		return list_enclos;
	}

	/**
	 * Renvoie la liste des enclos par type d'enclos
	 *
	 * @param type of the enclos
	 * @param <T> enclos
	 * @return List
	 */
	public <T extends Enclos> List<T> getEnclosByType(Class<T> type) {
		List<T> typeList = new ArrayList<>();
		for (Enclos allEnclos : getAllEnclos()) {
			if (allEnclos.getClass().equals(type)) {
				typeList.add((T) allEnclos);
			}
		}
		return typeList;
	}

	/**
	 * Renvoie l'enclos ou se situe l'animal
	 *
	 * @param targetAnimal animal of a enclos
	 * @return Enclos
	 */
	public Enclos getEnclosOf(Animaux targetAnimal) {
		for (Enclos enclos : list_enclos) {
			if (enclos.getActualAnimals().contains(targetAnimal)) {
				return enclos;
			}
		}
		return null;
	}

	/**
	 * Renvoie le nombre d'animaux présents dans les enclos du Zoo
	 *
	 * @return int
	 */
	public int numberAnimalsZoo() {
		return list_enclos.stream().mapToInt(Enclos::getActualAnimalsSize).sum();
	}

	/**
	 * Changement de l'affichage du zoo
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Zoo { " + "name = " + this.name + ", employe = " + this.employe + ", maxEnclos = " + this.maxEnclos
				+ ", enclos = " + Zoo.list_enclos + " }";
	}

	/**
	 * Affichage de la demande du nom de zoo
	 */
	public static void getNameZoo() {
		System.out.println("Quel est le nom de votre Zoo ?");
	}

	/**
	 * Affichage de la demande du nombre max d'enclos
	 */
	public static void getMaxEnclosZoo() {
		System.out.println("Combien d'enclos au maximum autorisez vous dans votre Zoo ?");
	}

	/**
	 * Affichage du success de la création du zoo
	 */
	public static void successZoo() {
		System.out.println("Le Zoo à  correctement été crée !\n");
	}
	/**
	 * Permet de changer aléatoirement des attributs pour les animaux comme les enclos
	 */
	public static void randomActions() {
		Random r = new Random();
		for (Enclos enclos : list_enclos) {
			int random = r.nextInt(100);
			if (random < 15) {
				Enclos.setActualProprete(degreProprete.mauvais);
			}
			for (Animaux animals : enclos.getActualAnimals()) {
				int random2 = r.nextInt(100);

				if (random2 > 50) {
					animals.sound();
					animals.setHealthIndicator(false);
				}
				if (random2 < 50) {
					animals.sound();
					animals.setHungryIndicator(true);
				}
				if (random2 < 30) {
					animals.sound();
					animals.setSleepIndicator(true);
				}
			}
		}
	}
}