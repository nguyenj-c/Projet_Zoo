/**
 * @author Nguyen, Khalil
 *
 */
package Animaux.SimulationLoups;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Animaux.Loups;

public class CoupleLoups {
	private Loups loupMale;
	private Loups loupFemelle;
	Random rd = new Random();

	/**
	 * Constructeur CoupleLoups
	 *
	 * @param loupMale
	 * @param loupFemelle
	 */

	public CoupleLoups(Loups loupMale, Loups loupFemelle) {
		this.loupMale = loupMale;
		this.loupFemelle = loupFemelle;
		System.out.println(loupMale.getName() + " et " + loupFemelle.getName() + " forment un nouveau couple de loups !");
	}

	/**
	 * Attribution du sexe au loups
	 *
	 * @param loupMale to set
	 */
	public void setloupMale(Loups loupMale) {
		if ('α' == loupMale.getRangDomination()) {
			if (loupMale.isSexe()) {
				this.loupMale = loupMale;
			} else {
				System.out.println("Le loup mâle doit être un mâle");
			}
		} else {
			System.out.println("Le loup mâle doit être Alpha");
		}

	}

	/**
	 * Attribution du sexe au loups
	 *
	 * @param loupFemelle to set
	 */

	public void setloupFemelle(Loups loupFemelle) {
		if ('α' == loupFemelle.getRangDomination()) {
			if (!loupFemelle.isSexe()) {
				this.loupFemelle = loupFemelle;
			} else {
				System.out.println("Le loup femelle doit être un femelle");
			}
		} else {
			System.out.println("Le loup femelle doit être Alpha");
		}
	}

	/**
	 * Affectation des loups dans la meute
	 *
	 * @param meute to set
	 */
	public void setMeuteLoups(MeuteLoups meute) {
		this.loupMale.setMeuteLoups(meute);
		this.loupFemelle.setMeuteLoups(meute);
	}

	/**
	 * Affichage du couple
	 */

	public void affichageCouple() {
		System.out.println("Loup mâle : " + loupMale + "\nLoup femelle : " + loupFemelle);
	}

	/**
	 * Permet la reproduction du couple
	 * @return loupNee
	 */
	public ArrayList<Loups> reproduire() {

		// On estime qu'un loup doit avoir 2 en âge pour procréer
		if (this.loupMale.getAge() > 1 && this.loupFemelle.getAge() > 1) {
			// Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
			int nbLoups = ThreadLocalRandom.current().nextInt(1, 7 + 1);
			System.out.println("Bravo ! Vous avez " + nbLoups + " loups nouveaux-nés :");
			System.out.println("Comment souhaitez-vous les nommer ?");
			// affectation des loupNee dans la liste
			ArrayList<Loups> loupNee = new ArrayList<>();
			// affectation aléatoire du sexe des loupNee
			for (int i = 0; i < nbLoups; ++i) {
				boolean sex = rd.nextBoolean();
				char charSex = 'm';
				if (sex) {
					charSex = 'm';
				} else {
					charSex = 'f';
				}

				Scanner sc = new Scanner(System.in);
				System.out.println("Veuillez saisir un nom pour le loup " + (i + 1) + " : ");
				String str = sc.nextLine();
				Loups loup = new Loups(str, charSex, 2, 7, 'β');
				loupNee.add(loup);
				System.out.println("Bébé " + loup.getName() + " est arrivé ! Félicitations !");
			}
			return loupNee;
		} else {
			System.out.println("Le couple n'est pas assez âgé pour procréer !");
			return null;
		}
	}

	/**
	 * Retourne le loup male
	 *
	 * @return Loups
	 */
	public Loups getloupMale() {
		return loupMale;
	}

	/**
	 * Retourne le loup femelle
	 *
	 * @return Loups
	 */
	public Loups getloupFemelle() {
		return loupFemelle;
	}

	/**
	 * Retourne true si il n'y a pas de couple et false si il y a un couple
	 *
	 * @return boolean
	 */
	public boolean vide() {
		if (this.loupMale == null && this.loupFemelle == null) {
			return true;
		} else {
			return false;
		}
	}

}
