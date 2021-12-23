package Game.Menu;

/**
 * @author Nguyen, Khalil
 *
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Animaux.SimulationLoups.*;
import Animaux.Loups;

public class menuLoups {

	private static final Scanner sc = new Scanner(System.in);
	private static ColonieLoups colonieLoups = new ColonieLoups();

	/**
	 * méthode affichant le texte de bienvenu du jeu Loup simulation
	 */
	public static void bienvenu() {
		System.out.println("Bienvenue chez les Loups !!!\n"
				+ "Cinq types d'actions vont être lancées aléatoirement au fil du temps.\n"
				+ "Nous vous laissons les découvrir au fur et à mesure de la simulation.\n" + "Good Game !");
	}

	/**
	 * methode de création des couples et des meutes
	 * 
	 * @param actionUn une action
	 */
	public static void initLoup(int actionUn) {

		int randomeMeute = ThreadLocalRandom.current().nextInt(1, actionUn + 1);
		if (randomeMeute == 1) {

			System.out.println("\n//////// CREATION D'UNE NOUVELLE MEUTE DE LOUPS ////////\n"
					+ "Un nouveau couple de loups va être crée.");

			/**
			 * Création du male et de la femelle du couple
			 */
			System.out.println("Nom du mâle du couple :");
			String strMale = sc.nextLine();
			Loups male = new Loups(strMale, 'm', 36, 37, 'α');
			System.out.println("Nom de la femelle du couple :");
			String strFemelle = sc.nextLine();
			Loups femelle = new Loups(strFemelle, 'f', 36, 38, 'α');

			/**
			 * Création du couple
			 */
			CoupleLoups coupleLoupsApp = new CoupleLoups(male, femelle);

			/**
			 * Création de la meute
			 */
			System.out.println("Une nouvelle meute de loups va être créee.\n"
					+ "Quel cri de meute souhaitez-vous ? (exemple : \"Aouuuuuuuuuuuh\") ");
			String hurlement = sc.nextLine();
			MeuteLoups meuteLoupsApp = new MeuteLoups(colonieLoups, coupleLoupsApp, hurlement);
		} else {
			System.out.println("Rien a signaler...");
		}
	}

	/**
	 * méthode des hurlement de la meute de loups
	 * 
	 * @param actionQuatre une action
	 * @param randHurlementGeneral de la meute
	 * @param randHurlementDominant de la meute
	 */
	public static void meuteHurlement(int actionQuatre, int randHurlementGeneral, int randHurlementDominant) {
		// Si des meutes existent alors les loups peuvent hurler
		for (MeuteLoups meuteLoups : colonieLoups.getMeuteLoups()) {

			/**
			 * On verifie si des loups sont présent
			 */
			if (!meuteLoups.getLoups().isEmpty()) {
				/**
				 * On parcourt les loups de la meute
				 */
				for (Loups loup : meuteLoups.getLoups()) {

					randHurlementGeneral = ThreadLocalRandom.current().nextInt(1, actionQuatre + 1);
					/**
					 * On décide si le loup doit hurler pour montrer son appartenance à une meute (
					 * 1 chance sur 5)
					 */
					if (randHurlementGeneral == 1) {
						loup.hurlementMeute(false);
					}

					randHurlementDominant = ThreadLocalRandom.current().nextInt(1, actionQuatre + 1);
					/**
					 * On décide si le loup doit hurler pour essayer de dominer un autre loup (1
					 * chance sur 5)
					 */
					if (randHurlementDominant == 1) {
						/**
						 * On choisit au hasard le loup que l'on va essayer de dominer
						 */
						Loups loupsDominer = loup;
						int randLoupsDominer;
						/**
						 * On choisit un loup dans la meute ( différent de celui qui lance la domination
						 * )
						 */
						while (loupsDominer == loup) {
							randLoupsDominer = ThreadLocalRandom.current().nextInt(1, meuteLoups.getLoups().size() + 1);
							loupsDominer = meuteLoups.getLoups().get(randLoupsDominer - 1);
						}

						loup.hurlementDomination(loupsDominer);
					}
				}
			} else {
				System.out.println("La meute n'a pas de loups !");
			}
		}
	}
	/**
	 * Méthode d'évolution de la meute de loups
	 * 
	 * @param randDomination de la meute
	 * @param randReductionRang de la meute
	 */
	public static void meuteEvolution(int randDomination, int randReductionRang) {
		/**
		 * Si des meutes existent alors les hiérarchies peuvent évoluer
		 */
		for (MeuteLoups meuteLoups : colonieLoups.getMeuteLoups()) {

			/**
			 * Affichage de la hiérarchie
			 */
			meuteLoups.hierarchie();
			/**
			 * On verifie si la meute commprend des Loups
			 */
			if (!meuteLoups.getLoups().isEmpty()) {
				// On parcourt les loups de la meute
				for (Loups loup : meuteLoups.getLoups()) {

					randDomination = ThreadLocalRandom.current().nextInt(1, 5 + 1);

					/**
					 * On décide si on doit lancer une domination pour chaque loup (1 chance sur 5)
					 */
					if (randDomination == 1) {

						/**
						 * On choisit le loup que l'on va essayer de dominer aléatoirement
						 */
						Loups loupsDominer = loup;
						int randLoupsDominer;

						/**
						 * On choisit un loup dans la meute (différent de celui qui lance la domination)
						 */
						while (loupsDominer == loup) {
							randLoupsDominer = ThreadLocalRandom.current().nextInt(1, meuteLoups.getLoups().size() + 1);
							loupsDominer = meuteLoups.getLoups().get(randLoupsDominer - 1);
						}

						loup.dominate(loupsDominer);
					}

					randReductionRang = ThreadLocalRandom.current().nextInt(1, 3 + 1);

					/**
					 * On décide si on baisse le rang de domination du loup (1 chance sur 3)
					 */
					if (randReductionRang == 1) {
						meuteLoups.baisseRang(loup);
					}
				}

				/**
				 * Affichage la nouvelle hiérarchie
				 */
				meuteLoups.affichageLoups();
				System.out.print("Nouvelle ");
				meuteLoups.hierarchie();
			} else {
				System.out.println("La meute n'a pas de loups !");
			}
		}
	}
	
	/**
	 * Méthode de veillissement de la meute de loups
	 */
	public static void meuteVeillissement() {
		/**
		 * Si des meutes existent alors les loups peuvent vieillir
		 */
		for (MeuteLoups meuteLoups : colonieLoups.getMeuteLoups()) {

			/**
			 * On verifie si la meute comprend des loups
			 */
			if (meuteLoups.getLoups() != null) {

				/**
				 * On affiche les loups présent de la meute
				 */
				System.out.println("Loups actuels de la meute :");
				meuteLoups.affichageLoups();

				/**
				 * On parcourt les loups de la meute
				 */
				for (Loups loup : meuteLoups.getLoups()) {

					/**
					 * On fait vieillir tout les loups
					 */
					loup.vieilli();
				}
				System.out.println("Les loups de la meute ont tous vieilli !");

				/**
				 * On affiche les loups présent de la meute
				 */
				System.out.println("Loups de la meute après vieillissement :");
				meuteLoups.affichageLoups();
			} else {
				System.out.println("La meute n'a pas de loups !");
			}
		}

	}

	/**
	 * Méthode deroulant le menu de notre simulation
	 */
	public static void menu() {
		/**
		 * affichage du texte d'introduction a la simulation
		 */
		bienvenu();
		/**
		 * définit l'évènement à produire
		 */
		int compteur = 0;
		/**
		 * variables permettant d'executer chaque actions
		 */
		int actionUn = 1;
		int actionDeux = 1;
		int actionTrois = 1;
		int actionQuatre = 1;

		while (true) {
			/**
			 * Définit les tâches à faire grâce au compteur
			 */
			switch (compteur) {

				/**
				 * CREATION D'UNE NOUVELLE MEUTE
				 */
				case 0:
					/**
					 * pause dans l'execution
					 */
					LoupsSpec.pause();
					initLoup(actionUn);
					/**
					 * On décide si on crée une nouvelle meute (généré aléatoirement, 1 chance sur 2
					 * )
					 */

					actionUn = 5;
					compteur += 1;

					/**
					 * SAISON DES AMOURS, REPRODUCTION
					 */
				case 1:

					/**
					 * pause dans l'execution
					 */
					LoupsSpec.pause();

					/**
					 * On décide si c'est la saison des amours (généré aléatoirement, 1 chance sur
					 * 4)
					 */
					int randSaison = ThreadLocalRandom.current().nextInt(1, actionDeux + 1);
					if (randSaison == 1) {

						System.out.println("\n//////// SAISON DES AMOURS ////////\n"
								+ "C'est la saison des amours, nous avons peut-être des loups nouveaux-nés !");
						/**
						 * On vérifie si un couples existent
						 */
						if (colonieLoups.getMeuteLoups().isEmpty()) {
							System.out.println("Aucun couple n'existe, aucune reproduction n'est possible.");
							break;
						} else {
							/**
							 * Si des couples existent alors ils peuvent se reproduire
							 */
							int indexMeute = 0;
							for (MeuteLoups meuteLoups : colonieLoups.getMeuteLoups()) {

								if (meuteLoups.getCoupleLoups() != null) {
									System.out.println("Meute numéro " + (indexMeute + 1));
									++indexMeute;
									meuteLoups.reproduire();
								} else {
									System.out.println("La meute n'as pas de couple !");
								}
							}
						}
					} else {
						System.out.println("Rien a signaler...");
					}

					actionDeux = 4;
					compteur += 1;
					/**
					 * EVOLUTION HIERARCHIE DES MEUTES
					 */
				case 2:

					/**
					 * pause dans l'execution
					 */
					LoupsSpec.pause();
					/**
					 * On décide si on doit faire évoluer naturellement la hierarchie (généré
					 * aléatoirement, 1 chance sur 4)
					 */
					int randHierarchie = ThreadLocalRandom.current().nextInt(1, actionTrois + 1);
					int randDomination = 0;
					int randReductionRang = 0;
					if (randHierarchie == 1) {

						System.out.println("\n//////// EVOLUTION NATURELLE DE LA HIERARCHIE ////////\n"
								+ "Les meutes évoluent et les hiérarchies vont peut-être changer !");
						/**
						 * On vérifie si une meute existent
						 */
						if (colonieLoups.getMeuteLoups().isEmpty()) {
							System.out.println("Aucune meute n'existe, les hierarchies n'ont donc pas évoluer !");
							break;
						} else {
							meuteEvolution(randDomination, randReductionRang);
						}
					} else {
						System.out.println("Rien a signaler...");
					}

					actionTrois = 4;
					compteur += 1;
					/**
					 * VIEILLISSEMENT DES LOUPS
					 */
				case 3:

					/**
					 * pause dans l'execution
					 */
					LoupsSpec.pause();

					System.out.println("\n//////// VIEILLISSEMENT DES LOUPS ////////\n"
							+ "Le temps passe et les loups prennent de l'age !");
					/**
					 * On vérifie si une meute existent
					 */
					if (colonieLoups.getMeuteLoups().isEmpty()) {
						System.out.println("Aucune meute n'existe, aucun loup ne peut vieillir !");
						break;
					} else {
						meuteVeillissement();
					}

					compteur += 1;
					/**
					 * HURLEMENTS ENTRE LOUPS
					 */
				case 4:

					/**
					 * pause dans l'execution
					 */
					LoupsSpec.pause();

					System.out.println("\n//////// HURLEMENT DES LOUPS ////////\n"
							+ "Certains loups peuvent hurler pour montrer leur appartenance à une meute !");
					/**
					 * Variables pour faire hurler les loups (générées aléatoirement)
					 */
					int randHurlementGeneral = 0;
					int randHurlementDominant = 0;
					/**
					 * On vérifie si une meute existent
					 */
					if (colonieLoups.getMeuteLoups().isEmpty()) {
						System.out.println("Aucune meute n'existe, les loups ne peuvent donc pas hurler !");
						break;
					} else {
						meuteHurlement(actionQuatre, randHurlementGeneral, randHurlementDominant);
					}

					actionQuatre = 5;
					compteur = 0;
				}
		}
	}

}
