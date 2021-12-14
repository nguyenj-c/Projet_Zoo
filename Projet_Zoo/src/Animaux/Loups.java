/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import java.util.concurrent.ThreadLocalRandom;

import Animaux.Especes.Mammiferes;
import Zoo.assets;
import java.util.concurrent.ThreadLocalRandom;




public class Loups extends Animaux implements Mammiferes {
	
	private int age; // 1 = jeune / 2 = adulte / 3 = vieux
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getDomination() {
		return domination;
	}

	public void setDomination(int domination) {
		this.domination = domination;
	}

	public char getRangDomination() {
		return rangDomination;
	}

	public void setRangDomination(char rangDomination) {
		this.rangDomination = rangDomination;
	}

	public int getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(int niveaux) {
		this.niveaux = niveaux;
	}

	public int getViolence() {
		return violence;
	}

	public void setViolence(int violence) {
		this.violence = violence;
	}

	private int force; // 1 = pas fort / 2 = moyen fort / 3 = tres fort
    private int domination; // facteur de domination TODO: correspondant aÂ  la difference entre les dominations exercees et celles subies)
    private char rangDomination; // TODO: lettre de l'alphabet grec qui represente le niveau de domination dans la meute du loup
    private int niveaux; // TODO: correspondant au critere de qualite subjectif d'un loup, male comme femelle
    // calculÃ© en fonction de la catÃ©gorie d'Ã¢ge, de la force, du facteur de domination et du rang
    private int violence; // TODO: facteur de violence (impÃ©tuositÃ©)
    // TODO: Trouver autre chose que donnÃ©e membre
    private MeuteLoups meuteLoups;
    
    public MeuteLoups getMeuteLoups() {
		return meuteLoups;
	}

	public void setMeuteLoups(MeuteLoups meuteLoups) {
		this.meuteLoups = meuteLoups;
	}

	public Loups(String name, char charSex, double poids, double taille, char rangDomination) {
        super(assets.toTitle(name));
        
        // On détermine la force à 3 si le loup est un alphal
        if (rangDomination == 'α') {
        	this.force = 3;
        }
        else {
        	this.force = 1;
        }
        this.age = 1;
        this.niveaux = 1;
        this.domination = 0;
        // Le facteur de violence est généré aléatoirement (compris entre 1 et 5)
        this.violence = ThreadLocalRandom.current().nextInt(1,5+1);
        if(assets.isInListRank(rangDomination)) {
            this.rangDomination = rangDomination;
        }
    }
    
    public void hurlement(String hurlement)  { // howl = hurlement
        System.out.println(super.getName() + " hurle \"" + hurlement + "\"");
    }
    public void hurlement() {
    	if (this.meuteLoups != null) {
    		this.hurlement(meuteLoups.getHurlement());
    	} else {
    		this.hurlement("Aoouuuuuh");
    	}
    }
    public void ecoute() {
        if(!super.isSleepIndicator() && super.isHealthIndicator()) {
            System.out.println(super.getName() + " entend des hurlements (peut-Ãªtre)");
            // TODO: entend TOUS les loups de LA meute émettent un son
        }
    }
    
    public void vieilli() {
        if(this.age == 3) {
            //this.leavePack();
            System.out.println(super.getName() + " meurt"); // TODO: détruire l'objet this
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
            System.out.println(super.getName() + " a grandit et est maintenant " + ageStr);
        }
    }
    
    private void upDomination() {
        ++this.domination;
    }

    private void downDomination() {
        if (this.domination != 0) {
            --this.domination;
        }
    }
    
    private void upNiveaux() {
        ++this.niveaux;
    }

    private void downNiveaux() {
        if (this.niveaux != 0) {
            --this.niveaux;
        }
    }
    
    private void changementRangDomination(Loups loup) {
        // on considére qu'un échange de rang s'effectue si l'agresseur a un rang inférieur à la cible
        if(assets.isDominant(this.rangDomination, loup.getRangDomination())) {
            char rankDominationTemp = this.rangDomination;
            this.rangDomination = loup.getRangDomination();
            loup.setRangDomination(rankDominationTemp);
        }
    }
    
    private void succesDomination(Loups loup) {
        // On réequilibre le facteur de domination
        this.upDomination();
        loup.downDomination();
        // On intervertit le rang de domination
        this.changementRangDomination(loup);
        // On réequilibre le level
        this.upNiveaux();
        loup.downNiveaux();
        System.out.println(super.getName() + " a dominé le loup " + loup.getName());
    }
    
    private void failedDomination(Loups loup) {
        // On réequilibre le facteur de domination
        this.upDomination();
        loup.downDomination();
        // On intervertit le rang de domination
        loup.changementRangDomination(this);
        // On réequilibre le level
        this.upNiveaux();
        loup.downNiveaux();
        System.out.println(super.getName() + " se fait dominé par " + loup.getName());
    }
    
 // TODO : if alpha loup gagne alors pas de changement de couple sinon oui
    public void dominate(Loups loup) {
        if(this.violence >= loup.getViolence() && loup.getRangDomination() != 'α') {
            if(this.niveaux > loup.getNiveaux() || loup.getRangDomination() == 'ω') {
                this.succesDomination(loup);
            }
            
            // TODO : Lorsque le facteur de domination est en dessous d’un certain seuil, le loup perd naturellement un
            // rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le
            //		dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
            
            // On considére que lorsqu'il y a égalité dans la domination, le verdict s'effectue aléatoirement
            else if(this.niveaux == loup.getNiveaux()) {
                System.out.println(super.getName() + " et " + loup.getName() + " sont à  égalité, le combat est donc " +
                        "aléatoire !");
                // Retourne 0 ou 1
                long aleat = Math.round(Math.random());
                // 1 = this gagne, 0 = this perd
                if (0 < aleat) {
                    this.succesDomination(loup);
                } else {
                    this.succesDomination(loup);
                }
            }
            else {
                this.failedDomination(loup);
            }
        } else {
            this.failedDomination(loup);
        }
    }
    
    public String toString() {
        return "Loup {" +
        		"Nom=" + this.getName() + 
        		", age=" + age +
                ", force=" + force +
                ", domination=" + domination +
                ", rangDomination=" + rangDomination +
                ", niveau=" + niveaux +
                ", violence=" + violence +
                ", meute=" + (this.meuteLoups != null ? "oui":"non") +
                "}";
    }
    public void caracteristique() {
    	System.out.println("Regardes comment je suis bg : " + this.toString());
    }
    
    // Hurler pour exprimer son appartenance à une meute
    public void hurlementMeute(boolean isAnswer) {
    	if (this.getMeuteLoups() != null) {
    		sound();
    		System.out.println("*Je suis le loup " + this.getName() + " et j'appartiens à la meute des plus forts!*");
    		this.caracteristique();
    		if(!isAnswer) {
    			rapatriment(true);
            }
    	}
    	else {
    		System.out.println("Aouuuuh ! *Je suis le loup " + this.getName() + " et je suis solitaire*");
    		this.caracteristique();
    	}
    }

    // Demande aux autres loups un hurlement réponse et non un hurlement d'appel
    public void rapatriment(boolean isAnswer) {
        if(isAnswer) {
            if(this.meuteLoups != null) {
                for(Loups loup : meuteLoups.getLoups()) {
                    if(loup != this) {
                        loup.hurlementMeute(isAnswer);
                    }
                }
            }
        }
    }
    
    // Hurler pour exprimer sa domination
    public void hurlemntDomination(Loups loupMenacer) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je veux te dominer " + loupMenacer.getName() + "*");
		this.caracteristique();
    }   
    
    // Hurler pour répondre à la domination (soumission)
    public void hurlementSoumission(Loups loupAttaquant) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je suis soumis à toi " + loupAttaquant.getName() + "*");
		this.caracteristique();
    }
    
    // Hurler pour répondre à la domination (domination)
    public void hurlementAgression(Loups loupAttaquant) {
    	sound();
		System.out.println("*Je suis le loup " + this.getName() + " et je TE domine " + loupAttaquant.getName() + "*");
		this.caracteristique();
    }
    
	/**
	 * Constructeur de loups
	 * @param name
	 */
	/*public Loups(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}*/

	/**
	 * Surcharge/ RÃ©Ã©criture de la mÃ©thode reproduire
	 */
	@Override
	public void reproduire() {
		if(this.isSexe() == false) {
			System.out.println("Je me reproduis et va donner naissance ï¿½ un bï¿½bï¿½");
		}else {
			System.out.println("Je peux pas mettre bas car je suis un male.");
		}				
	}

	/**
	 * Surcharge/ RÃ©Ã©criture de la mÃ©thode deplacement
	 */
	@Override
	public void deplacement() {
		System.out.println("Je peux vagabonder");
	}

	/**
	 * EspÃ¨ce de l'animal
	 * @return string
	 */
	@Override
	public String getSpecies() {return "Loup";}
}
