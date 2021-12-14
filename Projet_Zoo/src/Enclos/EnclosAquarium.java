/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Animaux;
import Animaux.Especes.Marins;

public class EnclosAquarium extends Enclos{
	private int profondeur;
	private double saliniteEau;
	
	
	/**
	 * Retourne la profondeur de l'aquarium
	 * @return the profondeur
	 */
	public int getProfondeur() {
		return profondeur;
	}


	/**
	 * Change la profondeur de l'aquarium
	 * @param profondeur the profondeur to set
	 */
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}


	/**
	 * Retourne la salinité de l'eau
	 * @return the saliniteEau
	 */
	public double getSaliniteEau() {
		return saliniteEau;
	}


	/**
	 * Change la salinité de l'eau
	 * @param saliniteEau the saliniteEau to set
	 */
	public void setSaliniteEau(double saliniteEau) {
		this.saliniteEau = saliniteEau;
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
        return animal instanceof Marins;
    }

	/**
	 * Constructeur d'aquarium
	 * @param name
	 * @param supercifie
	 * @param maxAnimals
	 * @param profondeur
	 * @param saliniteEau
	 */
	public EnclosAquarium(String name, double superficie, int maxAnimals, int profondeur, double saliniteEau) {
		super(name, superficie, maxAnimals);
		this.profondeur = profondeur;
		this.saliniteEau = saliniteEau;
	}
	
}
