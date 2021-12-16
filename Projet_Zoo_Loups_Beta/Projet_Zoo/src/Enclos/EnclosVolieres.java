/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Animaux;
import Animaux.Especes.Volants;

public class EnclosVolieres extends Enclos{
	private double taille;

	/**
	 * Retourne la taille de la volieres
	 * @return the taille
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * Change la taille de la volieres
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
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
        return animal instanceof Volants;
    }

	/**
	 * Constructeur de volieres
	 * @param name
	 * @param supercifie
	 * @param maxAnimals
	 * @param taille
	 */
	public EnclosVolieres(String name, double superficie, int maxAnimals, double taille) {
		super(name, superficie, maxAnimals);
		this.taille = taille;
	}	
	
}
