/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Especes.Volants;

public class EnclosVolieres <T extends Volants> extends Enclos <T>{
	private int taille;

	/**
	 * Retourne la taille de la volieres
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Change la taille de la volieres
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * Constructeur de volieres
	 * @param name
	 * @param supercifie
	 * @param maxAnimals
	 * @param taille
	 */
	public EnclosVolieres(String name, double superficie, int maxAnimals, int taille) {
		super(name, superficie, maxAnimals);
		this.taille = taille;
	}	
	
}
