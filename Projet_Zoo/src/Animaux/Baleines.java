/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;


public class Baleines extends Animaux implements Marins{

	/**
	 * Constructeur de baleines
	 * @param name, sexe, poids, taille, age
	 */
	public Baleines(String name, boolean sexe, double poids, double taille, int age) {
		super(name, sexe, poids, taille, age);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Surcharge/ Réécriture de la méthode reproduire
	 */
	@Override
	public void reproduire() {
		if(this.isSexe() == false) {
			System.out.println("Je ponds un oeuf");
		}else {
			System.out.println("Je peux pas pondre");
		}		
	}

	/**
	 * Surcharge/ Réécriture de la méthode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux nager");
	}
	
}
