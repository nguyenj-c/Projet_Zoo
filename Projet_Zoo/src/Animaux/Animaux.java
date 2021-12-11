/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import java.util.Random;

public abstract class Animaux{

	private String name;
	/**
	 * Si le sexe est true c'est donc un male sinon c'est une femelle
	 */
	private boolean sexe; 
	private double poids;
	private double taille;
	private int age;
	/**
	 * Si hungryIndicator est true alors l'animal a faim sinon non
	 */
	private boolean hungryIndicator;
	/**
	 * Si sleepIndicator est true alors il a sommeil sinon non
	 */
	private boolean sleepIndicator;
	/**
	 * Si healthIndicator est true, il est en bonne santé sinon non
	 */
	private boolean healthIndicator;
	/**
	 * Espèce de l'animal
	 * @return string
	 */
	public abstract String getSpecies();

	public Animaux(String name, int age) {
		Random r = new Random();
		this.name = name;
		this.sexe = r.nextBoolean();
		this.poids = r.nextFloat() * 100;
		this.taille = r.nextFloat() * 100;
		this.age = age;
		this.hungryIndicator = false;
		this.sleepIndicator = false;
		this.healthIndicator = true;
	}

	/**
	 * Retourne le nom de l'animal
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom de l'animal
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le sexe de l'animal
	 * @return the sexe
	 */
	public boolean isSexe() {
		return sexe;
	}

	/**
	 * Change le sexe de l'animal
	 * @param sexe the sexe to set
	 */
	public void setSexe(boolean sexe) {
		if (isSexe() == true || isSexe() == false) {
			this.sexe = sexe;
		} else {
			System.out.println("Erreur lors de la saisie du sexe : valeur incorrect");
		}
	}

	/**
	 * Retourne le poids de l'animal
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Change le poids de l'animal
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**
	 * Retourne la taille de l'animal
	 * @return the taille
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * Change la taille de l'animal
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**
	 * Retourne l'âge de l'animal
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Change l'age de l'animal
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retourne la faim de l'animal
	 * @return the hungryIndicator
	 */
	public boolean isHungryIndicator() {
		return hungryIndicator;
	}

	/**
	 * Change la faim de l'animal
	 * @param hungryIndicator the hungryIndicator to set
	 */
	public void setHungryIndicator(boolean hungryIndicator) {
		if (isHungryIndicator() == true || isHungryIndicator() == false) {
			this.hungryIndicator = hungryIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
	}

	/**
	 * Retourne l'état de sommeil de l'animal
	 * @return the sleepIndicator
	 */
	public boolean isSleepIndicator() {
		return sleepIndicator;
	}

	/**
	 * Change l'etat de sommeil de l'animal
	 * @param sleepIndicator the sleepIndicator to set
	 */
	public void setSleepIndicator(boolean sleepIndicator) {
		if (isSleepIndicator() == true || isSleepIndicator() == false) {
			this.sleepIndicator = sleepIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
		this.sleepIndicator = sleepIndicator;
	}

	/**
	 * Retourne la santé de l'animal
	 * @return the healthIndicator
	 */
	public boolean isHealthIndicator() {
		return healthIndicator;
	}

	/**
	 * Change la santé de l'animal
	 * @param healthIndicator the healthIndicator to set
	 */
	public void setHealthIndicator(boolean healthIndicator) {
		this.healthIndicator = healthIndicator;
	}

	/**
	 * Voit si l'animal a faim ou pas et ainsi l'animal mange
	 * @param healthIndicator the healthIndicator to set
	 */
	public boolean eat() {
		if (isSleepIndicator() == false && isHungryIndicator() == true) {
			setHungryIndicator(false);
			System.out.println("Je mange" + name);
		} else {
			setHungryIndicator(true);
		}
		return sleepIndicator;

	}

	/**
	 * Cri de l'animal en fonction de ces besoin
	 */
	public void sound() {
		if (isHungryIndicator() == true) {
			System.out.println("J'ai faim " + name);
		}
		if (isSleepIndicator() == true) {
			System.out.println("J'ai sommeil " + name);
		}
		if (isHealthIndicator() == true) {
			System.out.println("Je suis soigné " + name);
		}
		if (isHealthIndicator() == false && isSleepIndicator() == false && isHungryIndicator() == false) {
			System.out.println(name);
		}
	}

	/**
	 * Soigner les animaux
	 */
	public void beHealed() {
		if (isHealthIndicator() == false) {
			setHealthIndicator(true);
			System.out.println("Je suis guérri :" + isHealthIndicator());
		}
	}

	/**
	 * Etat de sommeil des animaux
	 */
	public void sleepState() {
		if (isSleepIndicator() == true) {
			setSleepIndicator(false);
			System.out.println( name + "va s'endormir : " + isSleepIndicator());
		} else {
			setHealthIndicator(true);
			System.out.println( name + "est en train de se reveiller : " + isSleepIndicator());
		}

	}

	@Override
	public String toString() {
		return "Animaux { species = " + this.getSpecies() + " name= " + name +
				", sexe= " + sexe + ", poids= " + poids + ", taille= " + taille + ", age= " + age
				+ ", hungryIndicator= " + hungryIndicator + ", sleepIndicator= " + sleepIndicator + ", healthIndicator= "
				+ healthIndicator + " }";
	}

}
