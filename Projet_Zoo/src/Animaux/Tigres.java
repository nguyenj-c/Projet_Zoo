/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import Animaux.Especes.Mammiferes;

public class Tigres extends Animaux implements Mammiferes {

	/**
	 * Constructeur de tigres
	 * @param name
	 * @param age
	 */
	public Tigres(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Surcharge/ Réécriture de la méthode reproduire
	 */
	@Override
	public void reproduire() {
		if(this.isSexe() == false) {
			System.out.println("Je me reproduis et va donner naissance � un b�b�");
		}else {
			System.out.println("Je peux pas mettre bas car je suis un male.");
		}		
	}

	/**
	 * Surcharge/ Réécriture de la méthode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux vagabonder");
	}

}

