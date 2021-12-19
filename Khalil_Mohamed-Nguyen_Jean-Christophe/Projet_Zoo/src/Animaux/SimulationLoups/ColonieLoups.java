/**
 * @author Nguyen, Khalil
 *
 */
package Animaux.SimulationLoups;

import java.util.ArrayList;

import Animaux.Loups;

public class ColonieLoups {

	private ArrayList<MeuteLoups> meute;

	/**
	 * Constructeur ColonieLoups
	 */

	public ColonieLoups() {
		this.meute = new ArrayList<>();
	}

	/**
	 * Affichage des loups dans la colonie
	 */
	public void affichageLoups() {
		System.out.println("loups de la colonie :");
		for (MeuteLoups meute : meute) {
			for (Loups loup : meute.getLoups()) {
				System.out.println(loup);
			}
		}
	}

	/**
	 * Permet d'ajouter une meute
	 *
	 * @param meute
	 */
	public void ajoutMeute(MeuteLoups meute) {
		if (!this.meute.contains(meute)) {
			this.meute.add(meute);
		}
	}

	/**
	 * Retourne la liste de la meute
	 *
	 * @return meute
	 */
	public ArrayList<MeuteLoups> getMeuteLoups() {
		return this.meute;
	}

}
