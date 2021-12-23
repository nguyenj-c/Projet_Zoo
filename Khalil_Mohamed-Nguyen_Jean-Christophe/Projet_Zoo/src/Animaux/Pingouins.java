/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import Animaux.Especes.Marins;
import Animaux.Especes.Volants;

public class Pingouins extends Animaux implements Volants, Marins {

	/**
	 * Constructeur de pingouins
	 *
	 * @param name du pingouin
	 */
	public Pingouins(String name) {
		super(name);
	}

	/**
	 * Surcharge/ Réécriture de la méthode reproduire
	 */
	@Override
	public void reproduire() {
		if (!this.isSexe()) {
			System.out.println("Je ponds un oeuf");
		} else {
			System.out.println("Je peux pas pondre car je suis un male.");
		}
	}

	/**
	 * Surcharge/ Réécriture de la méthode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux voler et nager");
	}

	/**
	 * Espèce de l'animal
	 *
	 * @return String
	 */
	@Override
	public String getSpecies() {
		return "Pingouin";
	}
}
