/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import Animaux.Especes.Volants;

public class Aigles extends Animaux implements Volants {

	/**
	 * Constructeur d'aigles
	 * @param name
	 */
	public Aigles(String name) {
		super(name);
	}

	/**
	 * Surcharge/ Réécriture de la méthode reproduire
	 */
	@Override
	public void reproduire() {
		if(this.isSexe() == false) {
			System.out.println("Je ponds un oeuf");
		}else {
			System.out.println("Je peux pas pondre car je suis un male");
		}
	}

	/**
	 * Surcharge/ Réécriture de la méthode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux voler");
	}

	/**
	 * Espèce de l'animal
	 * @return string
	 */
	@Override
	public String getSpecies() {return "Aigle";}

}
