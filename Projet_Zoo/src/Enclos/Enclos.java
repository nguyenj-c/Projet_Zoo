/**
 * 
 */
package Enclos;

import java.util.*;

import Animaux.Animaux;

/**
 * @author n19004502
 *
 */
public abstract class Enclos<T> {
	private String name;
	private double supercifie;
	private int maxAnimals;
	private int nbAnimals;
	// private Animaux[] actualAnimals= new Animaux[maxAnimals];
	private ArrayList<T> actualAnimals;

	private enum degreProprete {
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

	public Enclos(String name, double supercifie, int maxAnimals) {
		super();
		this.name = name;
		this.supercifie = supercifie;
		this.maxAnimals = maxAnimals;
		this.nbAnimals = 0;
		this.actualAnimals = new ArrayList<T>();
		actualProprete = degreProprete.bon;
	}

	/**
	 * @return the actualProprete
	 */
	public degreProprete getActualProprete() {
		return actualProprete;
	}

	/**
	 * @param actualProprete the actualProprete to set
	 */
	public void setActualProprete(degreProprete actualProprete) {
		this.actualProprete = actualProprete;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the supercifie
	 */
	public double getSupercifie() {
		return supercifie;
	}

	/**
	 * @param supercifie the supercifie to set
	 */
	public void setSupercifie(double supercifie) {
		this.supercifie = supercifie;
	}

	/**
	 * @return the maxAnimals
	 */
	public int getMaxAnimals() {
		return maxAnimals;
	}

	/**
	 * @param maxAnimals the maxAnimals to set
	 */
	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}

	/**
	 * @return the nbAnimals
	 */
	public int getNbAnimals() {
		return nbAnimals;
	}

	/**
	 * @param nbAnimals the nbAnimals to set
	 */
	public void setNbAnimals(int nbAnimals) {
		this.nbAnimals = nbAnimals;
	}

	/**
	 * @return the actualAnimals
	 */
	public List<T> getActualAnimals() {
		return actualAnimals;
	}

	/**
	 * @param actualAnimals the actualAnimals to set
	 */
	public void setActualAnimals(ArrayList<T> actualAnimals) {
		this.actualAnimals = actualAnimals;
	}

	@Override
	public String toString() {
		return "Enclos { name=" + name + ", supercifie=" + supercifie + ", maxAnimals=" + maxAnimals + ", nbAnimals="
				+ nbAnimals + ", actualAnimals=" + actualAnimals + " }";
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
	 * @param espece
	 */
	public void ajouter(T espece) {
		if (getNbAnimals() == getMaxAnimals()) {
			System.out.println("Enclos déja plein, on ne peu plus rajouter " + ((Animaux) espece).getName() + " ("
					+ getNbAnimals() + "/" + getMaxAnimals() + ")");
		} else {
			actualAnimals.add(espece);
			this.nbAnimals += 1;
			System.out.println(((Animaux) espece).getName() + " est ajouter à l'enclos " + "(" + getNbAnimals() + "/"
					+ getMaxAnimals() + ")");
		}
	}

	/**
	 * Permet d'enlever les animaux de l'enclos
	 * 
	 * @param espece
	 */
	public void enlever(T espece) {
		if (getNbAnimals() == 0) {
			System.out.println("Enclos vide donc pad d'animaux à enlever");
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
		for (T animals : actualAnimals) {
			if (((Animaux) animals).isHungryIndicator() == true) {
				((Animaux) animals).eat(true);
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
		if (getNbAnimals() == 0 && this.actualProprete == degreProprete.mauvais) {
			setActualProprete(degreProprete.bon);
			System.out.println("Nettoyage enclos fini. Etat enclos : " + this.actualProprete);
		} else if (getNbAnimals() != 0) {
			System.out.println("L'enclos n'est pas vide donc nettoyage impossible");
		} else {
			System.out.println("Etat enclos : " + this.actualProprete + ", Nb animals : " + this.nbAnimals);
		}
	}
}
