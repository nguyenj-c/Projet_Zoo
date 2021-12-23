/**
 * @author Nguyen, Khalil
 *
 */
package Animaux.SimulationLoups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoupsSpec {
	
	/**
	 * Liste des différents rang de domination
	 */
	private static ArrayList listRangDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ',
			'ι', 'κ', 'λ', 'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));

	/**
	 * Retourne la liste des différents rang de domination
	 */
	public static ArrayList getListRangDomination() {
		return listRangDomination;
	}
	
	/**
	 * Verifie si un rang est dans la liste
	 */
	public static boolean isInListRang(char c) {
		if (listRangDomination.contains(c)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifie la superiorité du rang ente les loups
	 */
	public static boolean isDominant(char c1, char c2) {
		if (isInListRang(c1) && isInListRang(c2)) {
			if (listRangDomination.indexOf(c1) > listRangDomination.indexOf(c2)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Baisse le rang de domination
	 */
	public static char reductionRang(char c) {
		if (isInListRang(c)) {
			int rank = listRangDomination.indexOf(c);
			++rank;
			return (char) listRangDomination.get(rank);
		}
		return (Character) null;
	}
	
	/**
	 * Mets la première lettre d'une String en majuscule
	 */
	public static String toTitle(String s) {
		String s1 = s.substring(0, 1).toUpperCase();
		String sTitle = s1 + s.substring(1);
		return sTitle;
	}
	
	/**
	 * Permet de faire une pause dans l'execution du code en demandant à l'utilisateur de confirmer par Entrée (ou autre touche)
	 */
	public static void pause() {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Appuyez sur Entrée pour continuer.");
		String responsePause = sc.nextLine();
	}
}
