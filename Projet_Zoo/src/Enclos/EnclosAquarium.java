/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Marins;

public class EnclosAquarium <T extends Marins> extends Enclos <T>{
	private int profondeur;
	private double saliniteEau;
	
	
	/**
	 * @return the profondeur
	 */
	public int getProfondeur() {
		return profondeur;
	}


	/**
	 * @param profondeur the profondeur to set
	 */
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}


	/**
	 * @return the saliniteEau
	 */
	public double getSaliniteEau() {
		return saliniteEau;
	}


	/**
	 * @param saliniteEau the saliniteEau to set
	 */
	public void setSaliniteEau(double saliniteEau) {
		this.saliniteEau = saliniteEau;
	}


	/**
	 * @param profondeur
	 * @param saliniteEau
	 */
	public EnclosAquarium(int profondeur, double saliniteEau) {
		super();
		this.profondeur = profondeur;
		this.saliniteEau = saliniteEau;
	}
	
}