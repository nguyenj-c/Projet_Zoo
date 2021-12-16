package Animaux.SimulationLoups;

import java.util.ArrayList;
import Animaux.Loups;

public class ColonieLoups {
	
	private ArrayList<MeuteLoups> meute;

    public ColonieLoups() {
       this.meute = new ArrayList<MeuteLoups>();
    }

    public void showWolfs() {
        System.out.println("Voici les loups de la colonie :");
        for (MeuteLoups meute : meute) {
            for(Loups loup : meute.getLoups()) {
                System.out.println(loup);
            }
        }
    }

    public void ajoutMeute(MeuteLoups meute) {
        if(!this.meute.contains(meute)) {
            this.meute.add(meute);
        }
    }
    
    public ArrayList<MeuteLoups> getMeuteLoups() {
    	return this.meute;
    }

}
