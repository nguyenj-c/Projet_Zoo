/**
 * 
 */
package test;
import Animaux.*;
import Enclos.Enclos;
import Enclos.EnclosNormal;

/**
 * @author n19004502
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tigres tigre1 = new Tigres("tigre",false,60,160,10);
		Pingouins pingouin1 = new Pingouins("pingouin",true,80,60,80);
		Ours our1 = new Ours("ours",false,180,180,20);
		tigre1.eat(true);
		tigre1.beHealed(true);
		tigre1.deplacement();
		tigre1.reproduire();
		Enclos<Animaux> enclos1 = new EnclosNormal <Animaux>("test",100,10);
		Enclos<Animaux> enclos2 = new EnclosNormal <Animaux>("test2",100,10);
		enclos1.ajouter(tigre1);
		enclos1.ajouter(pingouin1);
		enclos1.ajouter(our1);
		pingouin1.reproduire();
		pingouin1.deplacement();
		System.out.println(enclos1);
		tigre1.setHungryIndicator(true);
		enclos1.feedAnimals();
		enclos1.enlever(tigre1);
		System.out.println(enclos1);
		pingouin1.setHungryIndicator(true);
		enclos1.feedAnimals();
		System.out.println(enclos2);
		//enclos1.transferer(our1, enclos2);
		System.out.println(enclos2);
		enclos1.enlever(pingouin1);
		enclos1.maintenance();
	}

}
