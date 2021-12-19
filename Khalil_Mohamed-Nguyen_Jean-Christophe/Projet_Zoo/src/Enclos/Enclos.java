/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import java.util.ArrayList;
import java.util.List;

import Animaux.Animaux;
import Animaux.Especes.Mammiferes;

public class Enclos {
	/**
	 * Nom de l'enclos
	 */
	private String name;
	/**
	 * Superficie de l'enclos
	 */
	private double superficie;
	/**
	 * Nombre maximal d'animaux dans l'enclos
	 */
	private int maxAnimals;
	/**
	 * Nombre d'animaux dans l'enclos
	 */
	private int nbAnimals;
	/**
	 * Liste des animaux dans l'enclos
	 */
	private ArrayList<Animaux> actualAnimals;

	/**
	 * Etat de propreté de l'enclos
	 */
	public enum degreProprete {
		/**
	 	* Enclos dans un mauvais état
	 	*/
		mauvais,
		/**
	 	* Enclos dans un état correct
	 	*/
		correct, 
		/**
	 	* Enclos dans un bon état
	 	*/
		bon
	}

	private static degreProprete actualProprete;

	/**
	 * Constructeur de l'enclos
	 *
	 * @param name of the enclosure
	 * @param superficie of the enclosure
	 * @param maxAnimals of the enclosure
	 */
	public Enclos(String name, double superficie, int maxAnimals) {
		this.name = name;
		this.superficie = superficie;
		this.maxAnimals = maxAnimals;
		this.nbAnimals = 0;
		this.actualAnimals = new ArrayList<>();
		Enclos.actualProprete = degreProprete.bon;
		EnclosRegistry.registerEnclos(this);
	}

	/**
	 * Retourne l'état actuel de l'enclos
	 *
	 * @return the actualProprete of the enclosure
	 */
	public degreProprete getActualProprete() {
		return actualProprete;
	}

	/**
	 * Change l'état actuel de l'enclos
	 *
	 * @param actualProprete the actualProprete of the enclosure
	 */
	public static void setActualProprete(degreProprete actualProprete) {
		Enclos.actualProprete = actualProprete;
	}

	/**
	 * Retourne le nom de l'enclos
	 *
	 * @return the name of the enclosure
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom de l'enclos
	 *
	 * @param name the name of the enclosure
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne la superficie de l'enclos
	 *
	 * @return the supercifie of the enclosure
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * Permet de modifier la superficie de l'enclos
	 *
	 * @param superficie the supercifie of the enclosure
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * Retourne le nombre maximales d'animaux que l'enclos peut stocker
	 *
	 * @return the maxAnimals of the enclosure
	 */
	public int getMaxAnimals() {
		return maxAnimals;
	}

	/**
	 * Change le nombre maximales d'animaux que l'enclos peut stocker
	 *
	 * @param maxAnimals the maxAnimals of the enclosure
	 */
	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}

	/**
	 * Retourne le nombre actuel des animaux dans l'enclos
	 *
	 * @return the nbAnimals of the enclosure
	 */
	public int getNbAnimals() {
		return nbAnimals;
	}

	/**
	 * Change le nombre d'animaux de l'enclos
	 *
	 * @param nbAnimals the nbAnimals of the enclosure
	 */
	public void setNbAnimals(int nbAnimals) {
		this.nbAnimals = nbAnimals;
	}

	/**
	 * Retourne une liste des animaux actuelles dans l'enclos
	 *
	 * @return the actualAnimals of the enclosure
	 */
	public List<Animaux> getActualAnimals() {
		return actualAnimals;
	}

	/**
	 * Retourne la taille liste des animaux actuelles dans l'enclos
	 *
	 * @return the size of actualAnimals of the enclosure
	 */
	public int getActualAnimalsSize() {
		return actualAnimals.size();
	}

	/**
	 * Change la liste des animaux actuelles dans l'enclos
	 *
	 * @param actualAnimals the actualAnimals of the enclosure
	 */
	public void setActualAnimals(ArrayList<Animaux> actualAnimals) {
		this.actualAnimals = actualAnimals;
	}

	/**
	 * Affiche les caractéristiques des animaux actuels
	 */
	public void printAnimalsAttributs() {
		System.out.println(toString());
		System.out.println(getActualAnimals());
	}

	/**
	 * Permet d'ajouter des animaux de l'enclos
	 *
	 * @param espece animal to add in the enclosure
	 */
	public void addAnimaux(Animaux espece) {
		if (getNbAnimals() == getMaxAnimals()) {
			System.out.println("Enclos dÃ©ja plein, on ne peu plus rajouter " + espece.getName() + " (" + getNbAnimals()
					+ "/" + getMaxAnimals() + ")");
		} else {
			actualAnimals.add(espece);
			this.nbAnimals += 1;
			System.out.println(espece.getName() + " est ajouter Ã  l'enclos "  + this.getName() + " (" + getNbAnimals() + "/"
					+ getMaxAnimals() + ")");
		}
	}

	/**
	 * Permet d'enlever les animaux de l'enclos
	 *
	 * @param espece animal to remove from the enclosure
	 */
	public void removeAnimaux(Animaux espece) {
		if (getNbAnimals() == 0) {
			System.out.println("Enclos vide donc pad d'animaux à  enlever");
		} else {
			for (int i = 0; i <= actualAnimals.size() - 1; i++) {
				if (actualAnimals.get(i) == espece) {
					actualAnimals.remove(i);
				}
			}
			System.out.println(espece.getName() + " est retirer de l'enclos " + this.getName());
			this.nbAnimals -= 1;
		}
	}

	/**
	 * Permet de nourrir les animaux de l'enclos
	 */
	public void feedAnimals() {
		for (Animaux animals : actualAnimals) {
			if (animals.isHungryIndicator()) {
				animals.eat();
				System.out.println("Je nourris les " + animals);
			} else {
				System.out.println("Ils ont pas faim " + animals);
			}
		}
	}

	/**
	 * Permet de dire si l'enclos est vide ou dire l'etat de l'enclos
	 */
	public void maintenance() {
		if (getNbAnimals() == 0 && getActualProprete() == degreProprete.mauvais) {
			setActualProprete(degreProprete.bon);
			System.out.println("Nettoyage enclos fini. Etat enclos : " + getActualProprete());
		} else if (getNbAnimals() != 0) {
			System.out.println("L'enclos n'est pas vide donc nettoyage impossible");
		} else {
			System.out.println("Etat enclos : " + getActualProprete() + ", Nb animals : " + getNbAnimals());
		}
	}
	/**
	 * Changement de l'affichage de l'employé(e)
	 * @return String
	 */
	@Override
	public String toString() {
		return "Enclos { name=" + name + ", supercifie=" + superficie + ", maxAnimals=" + maxAnimals + ", nbAnimals="
				+ nbAnimals + ", actualAnimals=" + this.actualAnimals + " }";
	}

	/**
	 * Permet de savoir si un animal est compatible avec l'enclos
	 *
	 * @param animal animal qui est vérifier s'il est compatible
	 * @return boolean si true alors il est compatible, false non compatible
	 */
	public boolean isCompatible(Animaux animal) {
		if (animal == null) {
			throw new IllegalArgumentException("L'animal ne peut pas être vide.");
		}
		return animal instanceof Mammiferes;
	}
}
