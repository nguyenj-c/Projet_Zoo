/**
 * @author Nguyen, Khalil
 *
 */
package Enclos;

import Animaux.Animaux;

public class EnclosNormal <T extends Animaux> extends Enclos <T>{

	/**
	 * Constructeur de enclos normal
	 * @param name
	 * @param area
	 * @param maxAnimal
	 */
	public EnclosNormal (String name, int area, int maxAnimal) {
		super(name, area, maxAnimal);
	}
}
