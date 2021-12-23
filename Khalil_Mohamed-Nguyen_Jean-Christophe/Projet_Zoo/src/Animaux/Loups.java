/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import java.util.concurrent.ThreadLocalRandom;

import Animaux.Especes.Mammiferes;
import Animaux.SimulationLoups.LoupsSpec;
import Animaux.SimulationLoups.MeuteLoups;

public class Loups extends Animaux implements Mammiferes {
	// 1 = jeune, 2 = adulte, 3 = vieux
	private int age;
	// 1 = faible, 2 = moyen, 3 = fort
	private int force;
	// le facteur de domination
	private int domination;
	// representer par les lettres de l'alaphabet grec
	private char rangDomination;
	// critère de qualité male/femelle
	private int niveaux;
	// facteur d'impétuosité
	private int violence;
	// meute a laquelle le loup appartient
	private MeuteLoups meuteLoups;

	/**
	 * Constructeur Loups
	 *
	 * @param name
	 * @param charSex
	 * @param poids
	 * @param taille
	 * @param rangDomination
	 */

	public Loups(String name, char charSex, double poids, double taille, char rangDomination) {
		super(LoupsSpec.toTitle(name));

		// si le loup est un alpha, la force est affecter à 3
		if (rangDomination == 'α') {
			this.force = 3;
		} else {
			this.force = 1;
		}
		this.age = 1;
		this.niveaux = 1;
		this.domination = 0;
		// Le facteur d'impetuosité est généré aléatoirement (entre 1 et 5)
		this.violence = ThreadLocalRandom.current().nextInt(1, 5 + 1);
		if (LoupsSpec.isInListRang(rangDomination)) {
			this.rangDomination = rangDomination;
		}
	}

	/**
	 * Hurlement du loups
	 */
	public void hurlement(String hurlement) {
		System.out.println(super.getName() + " hurle \"" + hurlement + "\"");
	}

	/**
	 * Type d'hurlement du loup
	 */
	public void hurlement() {
		if (this.meuteLoups != null) {
			this.hurlement(meuteLoups.getHurlement());
		} else {
			this.hurlement("Aoouuuuuuuuuuuuuuh");
		}
	}

	/**
	 * Ecoute de tout les hurlement des loups
	 */
	public void ecoute() {
		if (!super.isSleepIndicator() && super.isHealthIndicator()) {
			System.out.println(super.getName() + " entend des hurlements");
		}
	}

	
	/**
	 * Supprimer l'objet loup si il est vieux
	 */
	public void vieilli() {
		if (this.age == 3) {
			System.out.println(super.getName() + " est mort");
		} else {
			++this.age;
			String ageStr = "";
			switch (this.age) {
			case 2:
				ageStr = "adulte";
				break;
			case 3:
				ageStr = "vieux";
				break;
			}
			System.out.println(super.getName() + " a prit de l'age et est maintenant un " + ageStr);
		}
	}

	
	/**
	 * Augmente le rang de domination
	 */
	private void upDomination() {
		++this.domination;
	}
	
	/**
	 * Diminue le rang de domination
	 */
	private void downDomination() {
		if (this.domination != 0) {
			--this.domination;
		}
	}
	
	/**
	 * Augmente le niveau
	 */
	private void upNiveaux() {
		++this.niveaux;
	}
	/**
	 * Diminue le niveau
	 */
	private void downNiveaux() {
		if (this.niveaux != 0) {
			--this.niveaux;
		}
	}

	/**
	 * Changement du Rand du loup si l'agresseur a un rang superieur
	 *
	 * @param loup dont le rang va changer
	 */
	private void changementRangDomination(Loups loup) {
		if (LoupsSpec.isDominant(this.rangDomination, loup.getRangDomination())) {
			char rankDominationTemp = this.rangDomination;
			this.rangDomination = loup.getRangDomination();
			loup.setRangDomination(rankDominationTemp);
		}
	}

	/**
	 * Réequilibrage des caractéristiques des loups apres affrontement dans le cas d'une réussite
	 *
	 * @param loup dans la domination va changer lors d'un success
	 */
	private void succesDomination(Loups loup) {
		// On réequilibre le facteur de domination
		this.upDomination();
		loup.downDomination();
		// On intervertit le rang de domination
		this.changementRangDomination(loup);
		// On réequilibre le level
		this.upNiveaux();
		loup.downNiveaux();
		System.out.println(super.getName() + " domine le loup " + loup.getName());
	}

	/**
	 * Réequilibrage des caractéristiques des loups apres affrontement dans le cas d'une échec
	 *
	 * @param loup dans la domination va changer lors d'un echec
	 */
	private void failedDomination(Loups loup) {
		// On réequilibre le facteur de domination
		this.upDomination();
		loup.downDomination();
		// On intervertit le rang de domination
		loup.changementRangDomination(this);
		// On réequilibre le level
		this.upNiveaux();
		loup.downNiveaux();
		System.out.println(super.getName() + " a etait dominé  par " + loup.getName());
	}

	/**
	 * Changement du couple si le loup alpha perd un loup perd naturellemnt si son
	 * rang est en dessous d'un certains seuil si il est le dernier de son rang.
	 *
	 * @param loup 
	 */
	public void dominate(Loups loup) {
		if (this.violence >= loup.getViolence() && loup.getRangDomination() != 'α') {
			if (this.niveaux > loup.getNiveaux() || loup.getRangDomination() == 'ω') {
				this.succesDomination(loup);
			} else if (this.niveaux == loup.getNiveaux()) {
				System.out.println(super.getName() + " et " + loup.getName() + " sont à égalité, le combat est donc "
						+ "aléatoire !");
				// Retourne 0 ou 1
				long aleat = Math.round(Math.random());
				// 1 = this gagne, 0 = this perd
				if (0 < aleat) {
					this.succesDomination(loup);
				} else {
					this.succesDomination(loup);
				}
			} else {
				this.failedDomination(loup);
			}
		} else {
			this.failedDomination(loup);
		}
	}

	/**
	 * Hurle son appartenance a un rang
	 *
	 * @param isAnswer cri de réponse de la meute
	 */
	public void hurlementMeute(boolean isAnswer) {
		if (this.getMeuteLoups() != null) {
			hurlement();
			System.out.println("*Je suis le loup " + this.getName() + " et j'appartiens à la meute des plus forts!*");
			this.caracteristique();
			if (!isAnswer) {
				rapatriment(true);
			}
		} else {
			System.out.println("Aouuuuh ! *Je suis le loup " + this.getName() + " et je suis un loup solitaire*");
			this.caracteristique();
		}
	}

	/**
	 * Réponse des loups
	 *
	 * @param isAnswer cri de réponse des loup
	 */
	public void rapatriment(boolean isAnswer) {
		if (isAnswer) {
			if (this.meuteLoups != null) {
				for (Loups loup : meuteLoups.getLoups()) {
					if (loup != this) {
						loup.hurlementMeute(isAnswer);
					}
				}
			}
		}
	}

	/**
	 * Hurlement de domination
	 *
	 * @param loupMenacer loup qui se fera menacer
	 */
	public void hurlementDomination(Loups loupMenacer) {
		hurlement();
		System.out.println(
				"*Je suis le loup " + this.getName() + " et je veux te dominer " + loupMenacer.getName() + "*");
		this.caracteristique();
	}

	/**
	 * Hurlment de soumission
	 *
	 * @param loupAttaquant loup qui attaquera
	 */
	public void hurlementSoumission(Loups loupAttaquant) {
		hurlement();
		System.out.println(
				"*Je suis le loup " + this.getName() + " et je me soumer toi " + loupAttaquant.getName() + "*");
		this.caracteristique();
	}

	/**
	 * Hurlement d'agression envers le dominant
	 *
	 * @param loupAttaquant loup qui attaquera
	 */
	public void hurlementAgression(Loups loupAttaquant) {
		hurlement();
		System.out.println("*Je suis le loup " + this.getName() + " et je te domine " + loupAttaquant.getName() + "*");
		this.caracteristique();
	}

	/**
	 * Surcharge/ Réécriture de la méthode reproduire
	 */
	@Override
	public void reproduire() {
		if (!this.isSexe()) {
			System.out.println("Je me reproduis et va donner naissance");
		} else {
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

	@Override
	public String getSpecies() {
		return "Loup";
	}

	/**
	 * Retourne l'age du loup
	 *
	 * @return int
	 */
	@Override
	public int getAge() {
		return age;
	}

	/**
	 * Change l'age du loup
	 *
	 * @param age du loup
	 */
	@Override
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retourne la force du loup
	 *
	 * @return int
	 */
	public int getForce() {
		return force;
	}

	/**
	 * Change la force du loup
	 *
	 * @param force du loup
	 */
	public void setForce(int force) {
		this.force = force;
	}

	/**
	 * Retourne le facteur de domination du loup
	 *
	 * @return int
	 */
	public int getDomination() {
		return domination;
	}

	/**
	 * Change le facteur de domination du loup
	 *
	 * @param domination du loup
	 */
	public void setDomination(int domination) {
		this.domination = domination;
	}

	/**
	 * Retourne le rang de domination du loup
	 *
	 * @return char
	 */
	public char getRangDomination() {
		return rangDomination;
	}

	/**
	 * Change le rang de domination du loup
	 *
	 * @param rangDomination du loup
	 */
	public void setRangDomination(char rangDomination) {
		this.rangDomination = rangDomination;
	}

	/**
	 * Retourne le niveau du loup
	 *
	 * @return int
	 */
	public int getNiveaux() {
		return niveaux;
	}

	/**
	 * Change le niveau du loup
	 *
	 * @param niveaux du loup
	 */
	public void setNiveaux(int niveaux) {
		this.niveaux = niveaux;
	}

	/**
	 * Retourne la violence du loup
	 *
	 * @return int
	 */
	public int getViolence() {
		return violence;
	}

	/**
	 * Change la violence du loup
	 *
	 * @param violence du loup
	 */
	public void setViolence(int violence) {
		this.violence = violence;
	}

	/**
	 * Retourne la meute du loup
	 *
	 * @return MeuteLoups
	 */
	public MeuteLoups getMeuteLoups() {
		return meuteLoups;
	}

	/**
	 * Change la meute du loup
	 *
	 * @param meuteLoups du loup
	 */
	public void setMeuteLoups(MeuteLoups meuteLoups) {
		this.meuteLoups = meuteLoups;
	}

	/**
	 * EChangement de l'affichage des loups
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return "Loup {" + "Nom=" + this.getName() + ", age=" + age + ", force=" + force + ", domination=" + domination
				+ ", rangDomination=" + rangDomination + ", niveau=" + niveaux + ", violence=" + violence + ", meute="
				+ (this.meuteLoups != null ? "oui" : "non") + "}";
	}
	
	/**
	 * Retourne les propriétés du loup
	 */
	public void caracteristique() {
		System.out.println("Voici mes propriété : " + this.toString());
	}
}
