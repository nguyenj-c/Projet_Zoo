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
	 * @param age
	 */
	public Aigles(String name, int age) {
		super(name, age);
	}

	/**
	 * Surcharge/ R��criture de la m�thode reproduire
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
	 * Surcharge/ R��criture de la m�thode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux voler");
	}

}
