package Animaux;

import java.util.ArrayList;

import Zoo.assets;


public class MeuteLoups {
	
	private ColonieLoups meute;
	private CoupleLoups couple;
	private ArrayList<Loups> loups;
	private String hurlement;
	
	public MeuteLoups(ColonieLoups meute, CoupleLoups couple, String hurlement) {
		super();
		this.meute = meute;
		this.meute.ajoutMeute(this);
		this.couple = couple;
		couple.setMeuteLoups(this);
		this.loups = new ArrayList<Loups>();
		this.hurlement = hurlement;
		System.out.println("Une nouvelle meute a été crée ! (Couple de la meute : " + this.couple.getloupMale().getName() +
						   " & " + this.couple.getloupFemelle().getName() + ", cri : \"" + this.hurlement + "\")");
	}

	public void affichageMeute() {
		if (!couple.vide()) {
			System.out.println("La meute de loups est constitué du couple :");
			this.couple.affichageCouple();
		}
		if (!loups.isEmpty()) {
			System.out.println("et des loups : ");
			for(Loups loup : loups) {
				System.out.println(loup.getName() + " : " + loup);
			}
		}
		else {
			System.out.println();
		}
	}
	
	public void affichageLoups() {
		System.out.println("Caractéristiques des loups "
				+ "de la meute :");
		System.out.println(this.couple.getloupMale().toString());
		System.out.println(this.couple.getloupFemelle().toString());
		for(Loups loup : loups) {
			System.out.println(loup.toString());
		}
	}
	
	// Afficher la hiérarchie des loups de la meute
	public void hierarchie() {
		System.out.println("Hiérarchie de la meute :");
		ArrayList hierarchie = new ArrayList();
		
		// On parcourt tout les rangs de domination
		for (Object c : assets.getListRangDomination()) {
			for (Loups loup : this.getLoups()) {
				if ((char) c == loup.getRangDomination()) {
					hierarchie.add(c);
					break;
				}
			}
		}
		System.out.println(hierarchie);
	}
	
	// Constituer un nouveau couple
	public void constitutionCouple(Loups maleAlphaloup) {
		this.couple.setloupFemelle(maleAlphaloup);
		maleAlphaloup.setMeuteLoups(this);
	}
	
	public void ajoutLoup(Loups loup) {
		// On n'ajoute pas un loupn déjà présent dans le couple
		if (!this.getLoups().contains(loup)) {
			loups.add(loup);
			loup.setMeuteLoups(this);
			System.out.println(loup.getName() + " a été ajouté à la meute");
		}
	}
	
	public void enleverLoup(Loups loup) {
		if(loups.contains(loup)) {
			loups.remove(loup);
			loup.setMeuteLoups(null);
			System.out.println(loup.getName() + " a été retiré de la meute");
		}
	}
	
	public void setOmegaLoup(Loups loup) {
		if(loups.contains(loup)) {
			loup.setRangDomination('ω');
			System.out.println(loup.getName() + " est maintenant un loup Oméga");
		}
	}
	
	public String getHurlement() {
		return hurlement;
	}

	public void reproduire() {
		ArrayList<Loups> loupNee = this.couple.reproduire();
		if (loupNee != null) { 
			for (Loups loup: loupNee) {
				this.ajoutLoup(loup);
			}
		}
	}
	
	// TODO: Permet de décroitre les rangs de domination d'un loup naturellement
	public void baisseRang(Loups loup) {
		if(this.getLoups().contains(loup)) {
			char vieuxRang = loup.getRangDomination();
			loup.setRangDomination(assets.decreaseRank(loup.getRangDomination()));
			System.out.println(loup.getName() + " a vu son rang diminué (" + 
					vieuxRang + " -> " + loup.getRangDomination() + ")");
		}
		else {
			System.out.println("On ne peut baisser le rang d'un loup qui n'est pas la meute");
		}
	}

	public ArrayList<Loups> getLoups() {
		ArrayList<Loups> allLoups = new ArrayList();
		allLoups.addAll(this.loups);
		allLoups.add(this.couple.getloupMale());
		allLoups.add(this.couple.getloupFemelle());
		return allLoups;
	}

	public CoupleLoups getCoupleLoups() {
		return couple;
	}

}
