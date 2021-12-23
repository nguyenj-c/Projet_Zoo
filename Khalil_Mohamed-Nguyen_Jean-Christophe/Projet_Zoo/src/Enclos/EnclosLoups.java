/**
 * @author khalil nguyen
 *
 */
package Enclos;

import Animaux.Animaux;
import Animaux.Loups;
import Animaux.SimulationLoups.MeuteLoups;


public class EnclosLoups<T extends Animaux> extends Enclos {
	private MeuteLoups meute;

	/**
	 * Constructeur EnclosLoups
	 *
	 * @param name of the wolf enclosure
	 * @param superficie of the wolf enclosure
	 * @param maxAnimals of the wolf enclosure
	 * @param meute of the wolf enclosure
	 */
	public EnclosLoups(String name, double superficie, int maxAnimals, MeuteLoups meute) {
		super(name, superficie, maxAnimals);
		this.meute = meute;
	}
	
	/**
	 * affichage des animaux
	 */
	public void affichageAnimaux() {
		System.out.println("L'enclos " + this.getName() + " contient les loups :");
		this.meute.affichageMeute();
	}
	
	/**
	 * Réécriture de la méthode pour ajouter le loup directement dans la meute
	 * @param loup of the wolf enclosure
	 */
	public boolean ajoutAnimaux(T loup) {
		meute.ajoutLoup((Loups) loup);
		return true;
	}

	/**
	 * Réécriture de la méthode pour retirer le loup directement de la meute
	 * @param loup of the wolf enclosure
	 */	
	public boolean retirerAnimaux(T loup) {
		meute.enleverLoup((Loups) loup);
		return true;
	}
}
