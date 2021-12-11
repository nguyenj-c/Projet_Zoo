/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import Animaux.Especes.Marins;

public class Requins extends Animaux implements Marins {

	/**
	 * Constructeur de requins
	 * @param name
	 * @param age
	 */
	public Requins(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Surcharge/ R��criture de la m�thode reproduire
	 */
	@Override
	public void reproduire() {
		if(this.isSexe() == false) {
			System.out.println("Je ponds un oeuf");
		}else {
			System.out.println("Je peux pas pondre car je suis un male.");
		}		
	}

	/**
	 * Surcharge/ R��criture de la m�thode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux nager");
	}
}
