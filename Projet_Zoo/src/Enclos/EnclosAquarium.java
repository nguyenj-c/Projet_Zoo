/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Especes.Marins;

public class EnclosAquarium <T extends Marins> extends Enclos <T>{
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
	 * Permet de modifier la profondeur de l'aquarium
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
	 * Permet de modifier la salinité de l'eau
	 * @param saliniteEau the saliniteEau to set
	 */
	public void setSaliniteEau(double saliniteEau) {
		this.saliniteEau = saliniteEau;
	}


	/**
	 * Constructeur d'aquarium
	 * @param profondeur
	 * @param saliniteEau
	 */
	public EnclosAquarium(int profondeur, double saliniteEau) {
		super();
		this.profondeur = profondeur;
		this.saliniteEau = saliniteEau;
	}
	
}