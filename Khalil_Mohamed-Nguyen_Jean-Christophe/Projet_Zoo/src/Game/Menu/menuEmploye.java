/**
 * @author Nguyen, Khalil
 *
 */
package Game.Menu;

public class menuEmploye {

	/**
	 * Affichage de la demande du nom de l'employé(e)
	 */
	public static void getNameEmploye() {
		System.out.println("Quel est le nom de votre employé ?");
	}

	/**
	 * Affichage de la demande du sexe de l'employé(e)
	 */
	public static void getSexEmploye() {
		System.out.println("Quel est le sexe de votre employé ? ( h pour Homme ou f pour Femme)");
	}

	/**
	 * Affichage de la demande de l'age de l'employé(e)
	 */
	public static void getAgeEmploye() {
		System.out.println("Quel est l'age de votre employé ? ( Employé(e) doit être majeur. )");
	}

	/**
	 * Affichage du success de création de l'employé(e)
	 */
	public static void successEmploye() {
		System.out.println("L'employé à été créé !\n" + "Nous allons maintenant créer le Zoo.");
	}

}
