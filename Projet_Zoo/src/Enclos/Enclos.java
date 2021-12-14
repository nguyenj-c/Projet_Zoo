/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import java.util.*;

import Animaux.Animaux;
import Animaux.Especes.Mammiferes;
import Game.initGame;

public class Enclos {
	private String name;
	private double superficie;
	private int maxAnimals;
	private int nbAnimals;
	private ArrayList<Animaux> actualAnimals;

	/**
	 * Etat de propreté de l'enclos
	 */
	public enum degreProprete {
		mauvais, correct, bon
	}

	private degreProprete actualProprete;

	/**
	 * @param name
	 * @param supercifie
	 * @param maxAnimals
	 * @param nbAnimals
	 * @param actualAnimals
	 */
	public Enclos() {
		// TODO Auto-generated constructor stub
	}

	public Enclos(String name, double superficie, int maxAnimals) {
		super();
		this.name = name;
		this.superficie = superficie;
		this.maxAnimals = maxAnimals;
		this.nbAnimals = 0;
		this.actualAnimals = new ArrayList<Animaux>();
		actualProprete = degreProprete.bon;
	}

	/**
	 * Retourne l'état actuel de l'enclos
	 * @return the actualProprete
	 */
	public degreProprete getActualProprete() {
		return actualProprete;
	}

	/**
	 * Change l'état actuel de l'enclos
	 * @param actualProprete the actualProprete to set
	 */
	public void setActualProprete(degreProprete actualProprete) {
		this.actualProprete = actualProprete;
	}

	/**
	 * Retourne le nom de l'enclos
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom de l'enclos
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne la superficie de l'enclos
	 * @return the supercifie
	 */
	public double getSuperficie() {
		return superficie;
	}

	/** Permet de modifier la superficie de l'enclos
	 * @param supercifie the supercifie to set
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * Retourne le nombre maximales d'animaux que l'enclos peut stocker
	 * @return the maxAnimals
	 */
	public int getMaxAnimals() {
		return maxAnimals;
	}

	/**
	 * Change le nombre maximales d'animaux que l'enclos peut stocker
	 * @param maxAnimals the maxAnimals to set
	 */
	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}

	/**
	 * Retourne le nombre actuel des animaux dans l'enclos
	 * @return the nbAnimals
	 */
	public int getNbAnimals() {
		return nbAnimals;
	}

	/**
	 * Change le nombre d'animaux de l'enclos
	 * @param nbAnimals the nbAnimals to set
	 */
	public void setNbAnimals(int nbAnimals) {
		this.nbAnimals = nbAnimals;
	}

	/**
	 * Retourne une liste des animaux actuelles dans l'enclos
	 * @return the actualAnimals
	 */
	public List<Animaux> getActualAnimals() {
		return actualAnimals;
	}

	/**
	 * Change la liste des animaux actuelles dans l'enclos
	 * @param actualAnimals the actualAnimals to set
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
	 * @param espece
	 */
	public void ajouter(Animaux espece) {
		if (getNbAnimals() == getMaxAnimals()) {
			System.out.println("Enclos dÃ©ja plein, on ne peu plus rajouter " + ((Animaux) espece).getName() + " ("
					+ getNbAnimals() + "/" + getMaxAnimals() + ")");
		} else {
			actualAnimals.add(espece);
			this.nbAnimals += 1;
			System.out.println(((Animaux) espece).getName() + " est ajouter Ã  l'enclos " + "(" + getNbAnimals() + "/"
					+ getMaxAnimals() + ")");
		}
	}

	/**
	 * Permet d'enlever les animaux de l'enclos
	 * @param espece
	 */
	public void enlever(Animaux espece) {
		if (getNbAnimals() == 0) {
			System.out.println("Enclos vide donc pad d'animaux à  enlever");
		} else {
			for (int i = 0; i <= actualAnimals.size() - 1; i++) {
				if (actualAnimals.get(i) == espece) {
					actualAnimals.remove(i);
				}
			}
			System.out.println(((Animaux) espece).getName() + " est retirer de l'enclos ");
			this.nbAnimals -= 1;
		}
	}

	/**
	 * Permet de nourrir les animaux de l'enclos
	 */
	public void feedAnimals() {
		for (Animaux animals : actualAnimals) {
			if (((Animaux) animals).isHungryIndicator() == true) {
				((Animaux) animals).eat();
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
	
	@Override
	public String toString() {
		return "Enclos { name=" + name + ", supercifie=" + superficie + ", maxAnimals=" + maxAnimals + ", nbAnimals="
				+ nbAnimals + ", actualAnimals=" + actualAnimals + " }";
	}
	
	/**
     * Permet de savoir si un animal est compatible avec l'enclos
     * @param animal
     * @return true s'il est compatible, false sinon
     */
    public boolean isCompatible(Animaux animal) {
        if(animal == null) {
            throw new IllegalArgumentException("L'animal ne peut pas être vide.");
        }
        return animal instanceof Mammiferes;
    }
}
