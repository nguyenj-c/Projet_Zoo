package Animaux;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public class CoupleLoups {
	private Loups loupMale;
	private Loups loupFemelle;
	Random rd = new Random();
	
	public CoupleLoups(Loups loupMale, Loups loupFemelle) {
    	this.loupMale = loupMale;
    	this.loupFemelle = loupFemelle;
    	System.out.println(loupMale.getName() + " et " + loupFemelle.getName() + " forment un nouveau couple de loups !");
    }
	
	public void setloupMale(Loups loupMale) {
        if('α' == loupMale.getRangDomination()) {
        	if('m' == loupMale.getSexe()) {
        		this.loupMale = loupMale;
        	} else {
        	 System.out.println("Le loup mâle doit être un mâle");	
        	}            
        } else {
            System.out.println("Le loup mâle doit être Alpha");
        }

    }

    public void setloupFemelle(Loups loupFemelle) {
        if('α' == loupFemelle.getRangDomination()) {
        	if('f' == loupFemelle.getSexe()) {
        		this.loupFemelle = loupFemelle;
        	} else {
        	 System.out.println("Le loup femelle doit être un femelle");	
        	} 
        } else {
            System.out.println("Le loup femelle doit être Alpha");
        }
    }
    
    public void setMeuteLoups(MeuteLoups meute) {
		this.loupMale.setMeuteLoups(meute);
		this.loupFemelle.setMeuteLoups(meute);
	}

	public void affichageCouple() {
        System.out.println("Loup mâle : " + loupMale + "\nLoup femelle : " + loupFemelle);
    }

    public ArrayList<Loups> reproduire() {
    	
    	// On estime qu'un loup doit avoir 2 en âge pour procréer
    	if (this.loupMale.getAge() > 1 && this.loupFemelle.getAge() > 1) {
	        // Le nombre de loups-nés est généré aléatoirement (compris entre 1 et 7)
	        int nbLoups = ThreadLocalRandom.current().nextInt(1,7+1);
	        System.out.println("Félicitations ! Vous avez " + nbLoups + " loups nouveaux-nés :");
	        System.out.println("Comment souhaitez-vous les nommer ?");
	        ArrayList<Loups> loupNee = new ArrayList<Loups>();
	        for(int i = 0; i < nbLoups; ++i) {
	        	boolean sex = rd.nextBoolean();
	        	char charSex = 'm';
	        	if(sex == true ) {
	        			charSex = 'm';
	        	}
	        	else {
	        		charSex = 'f';
	        	}
	        	
	        	Scanner sc = new Scanner(System.in);
	        	System.out.println("Veuillez saisir un nom pour le loup " + (i+1) + " : ");
	        	String str = sc.nextLine();
	            Loups loup = new Loups(str, charSex, 2, 7, 'β');
	            loupNee.add(loup);
	            System.out.println("Bébé " + loup.getName() + " est arrivé ! Félicitations !");
	        }
	        return loupNee;
    	}
    	else {
    		System.out.println("Le couple n'est pas assez âgé pour procréer !");
    		return null;
    	}
    }

	public Loups getloupMale() {
		return loupMale;
	}

	public Loups getloupFemelle() {
		return loupFemelle;
	}
    
    public boolean vide() {
    	if (this.loupMale == null && this.loupFemelle == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}


