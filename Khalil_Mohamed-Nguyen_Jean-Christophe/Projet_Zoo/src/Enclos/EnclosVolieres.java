/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Animaux;
import Animaux.Especes.Volants;

public class EnclosVolieres extends Enclos {
	
	/**
	 * Taille de la volière
	 */
	private double taille;

	/**
	 * Retourne la taille de la volieres
	 *
	 * @return the taille of the aviary
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * Change la taille de la volieres
	 *
	 * @param taille the taille of the aviary
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**
	 * Permet de savoir si un animal est compatible avec l'enclos
	 *
	 * @param animal animal qui est vérifier s'il est compatible
	 * @return boolean si true alors il est compatible, false non compatible
	 */
	@Override
	public boolean isCompatible(Animaux animal) {
		if (animal == null) {
			throw new IllegalArgumentException("L'animal ne peut pas être vide.");
		}
		return animal instanceof Volants;
	}

	/**
	 * Constructeur de volieres
	 *
	 * @param name de la volière
	 * @param superficie de la volière
	 * @param maxAnimals de la volière
	 * @param taille de la volière
	 */
	public EnclosVolieres(String name, double superficie, int maxAnimals, double taille) {
		super(name, superficie, maxAnimals);
		this.taille = taille;
	}

}
