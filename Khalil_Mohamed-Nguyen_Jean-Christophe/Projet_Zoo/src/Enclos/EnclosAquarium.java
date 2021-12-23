/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import java.util.Random;

import Animaux.Animaux;
import Animaux.Especes.Marins;

public class EnclosAquarium extends Enclos {
	/**
	 * Profondeur de l'aquarium
	 */
	private double profondeur;
	/**
	 * Salinité de l'eau de l'aquarium
	 */
	private double saliniteEau;

	/**
	 * Retourne la profondeur de l'aquarium
	 *
	 * @return the profondeur of the aquarium
	 */
	public double getProfondeur() {
		return profondeur;
	}

	/**
	 * Change la profondeur de l'aquarium
	 *
	 * @param profondeur the profondeur of the aquarium
	 */
	public void setProfondeur(double profondeur) {
		this.profondeur = profondeur;
	}

	/**
	 * Retourne la salinité de l'eau
	 *
	 * @return the saliniteEau of the aquarium
	 */
	public double getSaliniteEau() {
		return saliniteEau;
	}

	/**
	 * Change la salinité de l'eau
	 *
	 * @param saliniteEau the saliniteEau of the aquarium
	 */
	public void setSaliniteEau(double saliniteEau) {
		this.saliniteEau = saliniteEau;
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
		return animal instanceof Marins;
	}

	/**
	 * Constructeur d'aquarium
	 *
	 * @param name de l'aquarium
	 * @param superficie de l'aquarium
	 * @param maxAnimals de l'aquarium
	 * @param profondeur de l'aquarium
	 */
	public EnclosAquarium(String name, double superficie, int maxAnimals, double profondeur) {
		super(name, superficie, maxAnimals);
		Random r = new Random();
		this.profondeur = profondeur;
		this.saliniteEau = r.nextDouble();
	}

}
