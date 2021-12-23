/**
 * @author Nguyen, Khalil
 *
 */
package Game;

public class main {

	/**
	 * Creation de la classe initGame
	 */
	private static final initGame initGame = new initGame();

	/**
	 * Application main permettant de lancer le jeu
	 *
	 * @param args pour l'input de l'user
	 */
	public static void main(String[] args) {
		initGame.start();
		while (initGame.isGame()) {
			Game.initGame.menu();
		}
	}

}
