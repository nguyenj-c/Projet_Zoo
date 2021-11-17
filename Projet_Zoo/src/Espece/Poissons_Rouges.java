/**
 * 
 */
package Espece;
import Zoo.Animaux;
import Zoo.Marins;

/**
 * @author n19004502
 *
 */
public class Poissons_Rouges extends Animaux implements Marins{

	public Poissons_Rouges(String name, boolean sexe, double poids, double taille, int age, boolean hungryIndicator,
			boolean sleepIndicator, boolean healthIndicator) {
		super(name, sexe, poids, taille, age, hungryIndicator, sleepIndicator, healthIndicator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reproduire() {
		System.out.println("Je peux pas pondre");		
	}

	@Override
	public void deplacement() {
		System.out.println("Je peux nager");
	}
	
}