/**
 * 
 */
package Espece;
import Zoo.Animaux;
import Zoo.Mammiferes;


/**
 * @author n19004502
 *
 */
public class Loups extends Animaux implements Mammiferes{

	public Loups(String name, boolean sexe, double poids, double taille, int age, boolean hungryIndicator,
			boolean sleepIndicator, boolean healthIndicator) {
		super(name, sexe, poids, taille, age, hungryIndicator, sleepIndicator, healthIndicator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reproduire() {
		if(this.isSexe() == true) {
			System.out.println("Je me reproduis et va donner naissance à  un bébé");
		}else {
			System.out.println("Je peux pas mettre bas");
		}		
	}

	@Override
	public void deplacement() {
		System.out.println("Je peux vagabonder");
	}

}
