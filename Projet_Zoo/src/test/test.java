/**
 * @author Nguyen, Khalil
 *
 */
package test;


import java.util.Random;

import Animaux.*;
import Animaux.Especes.Mammiferes;
import Animaux.Especes.Marins;
import Animaux.Especes.Volants;
import Enclos.Enclos;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tigres tigre1 = new Tigres("tigre");
		if(tigre1 instanceof Mammiferes) {
			System.out.print("cest un mammiferes\n");
		}else {
			System.out.print("cest autre chose");
		}
		Pingouins pingouin1 = new Pingouins("pingouin");
		if(pingouin1 instanceof Marins) {
			System.out.print("cest un marins\n");
		}else {
			System.out.print("cest autre chose");
		}
		if(pingouin1 instanceof Volants) {
			System.out.print("cest un volants");
		}else {
			System.out.print("cest autre chose");
		}
		/*Ours our1 = new Ours("ours");
		tigre1.eat();
		tigre1.beHealed();
		tigre1.deplacement();
		tigre1.reproduire();
		Enclos enclos1 = new Enclos ("test",100,10);
		Enclos enclos2 = new Enclos ("test2",100,10);
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
		enclos1.maintenance();*/
		Random r = new Random();
		double result = r.nextDouble();
		System.out.println(result);
	}

}
