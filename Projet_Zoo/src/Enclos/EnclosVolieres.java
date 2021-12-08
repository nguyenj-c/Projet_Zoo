/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Volants;

public class EnclosVolieres <T extends Volants> extends Enclos <T>{
	private int taille;

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}

	/**
	 * @param taille
	 */
	public EnclosVolieres(int taille) {
		super();
		this.taille = taille;
	}	
	
}
