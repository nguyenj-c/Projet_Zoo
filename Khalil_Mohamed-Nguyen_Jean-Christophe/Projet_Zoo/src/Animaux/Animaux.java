/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

import java.util.Random;

public abstract class Animaux {

	/**
	 * Nom de l'animal
	 */
	private String name;
	/**
	 * Le sexe de l'animal. Si le sexe est true c'est donc un male sinon c'est une femelle
	 */
	private boolean sexe;
	/**
	 * Poids de l'animal
	 */
	private double poids;
	/**
	 * Taille de l'animal
	 */
	private double taille;
	/**
	 * Age de l'animal
	 */
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
	 *
	 * @return String
	 */
	public abstract String getSpecies();
	
	/**
	 * Constructeur de l'animal
	 *
	 * @param name de l'animal
	 */
	public Animaux(String name) {
		Random r = new Random();
		this.name = name;
		this.sexe = r.nextBoolean();
		this.poids = r.nextFloat() * 100;
		this.taille = r.nextFloat() * 100;
		this.age = r.nextInt(100 - 0) + 0;
		this.hungryIndicator = false;
		this.sleepIndicator = false;
		this.healthIndicator = true;
		AnimalRegistry.registerAnimal(this);
	}

	/**
	 * Retourne le nom de l'animal
	 *
	 * @return the name of the animal
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom de l'animal
	 *
	 * @param name the name of the animal
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le sexe de l'animal
	 *
	 * @return the sexe of the animal
	 */
	public boolean isSexe() {
		return sexe;
	}

	/**
	 * Change le sexe de l'animal
	 *
	 * @param sexe the sexe of the animal
	 */
	public void setSexe(boolean sexe) {
		if (isSexe() || !isSexe()) {
			this.sexe = sexe;
		} else {
			System.out.println("Erreur lors de la saisie du sexe : valeur incorrect");
		}
	}

	/**
	 * Retourne le poids de l'animal
	 *
	 * @return the poids of the animal
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Change le poids de l'animal
	 *
	 * @param poids the poids of the animal
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**
	 * Retourne la taille de l'animal
	 *
	 * @return the taille of the animal
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * Change la taille de l'animal
	 *
	 * @param taille the taille of the animal
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**
	 * Retourne l'âge de l'animal
	 *
	 * @return the age of the animal
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Change l'age de l'animal
	 *
	 * @param age the age of the animal
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retourne la faim de l'animal
	 *
	 * @return the hungryIndicator of the animal
	 */
	public boolean isHungryIndicator() {
		return hungryIndicator;
	}

	/**
	 * Change la faim de l'animal
	 *
	 * @param hungryIndicator the hungryIndicator of the animal
	 */
	public void setHungryIndicator(boolean hungryIndicator) {
		if (isHungryIndicator() || !isHungryIndicator()) {
			this.hungryIndicator = hungryIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
	}

	/**
	 * Retourne l'état de sommeil de l'animal
	 *
	 * @return the sleepIndicator of the animal
	 */
	public boolean isSleepIndicator() {
		return sleepIndicator;
	}

	/**
	 * Change l'etat de sommeil de l'animal
	 *
	 * @param sleepIndicator the sleepIndicator of the animal
	 */
	public void setSleepIndicator(boolean sleepIndicator) {
		if (isSleepIndicator() || !isSleepIndicator()) {
			this.sleepIndicator = sleepIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
		this.sleepIndicator = sleepIndicator;
	}

	/**
	 * Retourne la santé de l'animal
	 *
	 * @return the healthIndicator of the animal
	 */
	public boolean isHealthIndicator() {
		return healthIndicator;
	}

	/**
	 * Change la santé de l'animal
	 *
	 * @param healthIndicator the healthIndicator of the animal
	 */
	public void setHealthIndicator(boolean healthIndicator) {
		this.healthIndicator = healthIndicator;
	}

	/**
	 * Voit si l'animal a faim ou pas et ainsi l'animal mange
	 */
	public boolean eat() {
		if (!isSleepIndicator() && isHungryIndicator()) {
			setHungryIndicator(false);
			System.out.println("Je mange " + name);
		} else {
			setHungryIndicator(true);
			System.out.println("J'ai pas faim " + name);
		}
		return sleepIndicator;
	}

	/**
	 * Cri de l'animal en fonction de ces besoin
	 */
	public void sound() {
		if (isHungryIndicator()) {
			System.out.println("J'ai faim " + name);
		}
		if (isSleepIndicator()) {
			System.out.println("J'ai sommeil " + name);
		}
		if (isHealthIndicator()) {
			System.out.println("Je suis soigné " + name);
		}
		if (!isHealthIndicator() && !isSleepIndicator() && !isHungryIndicator()) {
			System.out.println(name);
		}
	}

	/**
	 * Soigner les animaux
	 */
	public void beHealed() {
		if (!isHealthIndicator()) {
			setHealthIndicator(true);
			System.out.println("Je suis guérri : " + this.getName());
		}
		System.out.println("Je suis en bonne santé");
	}

	/**
	 * Etat de sommeil des animaux
	 */
	public void sleepState() {
		if (isSleepIndicator()) {
			setSleepIndicator(false);
			System.out.println(this.getName() + " va s'endormir.");
		} else {
			setHealthIndicator(true);
			System.out.println(this.getName() + " est en train de se reveiller. ");
		}

	}
	
	/**
	 * Changement de l'affichage des animaux
	 * @return String
	 */
	@Override
	public String toString() {
		if (isSexe()) {
			return "Animaux { species = " + this.getSpecies() + " name= " + name + ", sexe= male , poids= " + poids
					+ ", taille= " + taille + ", age= " + age + ", hungryIndicator= " + hungryIndicator
					+ ", sleepIndicator= " + sleepIndicator + ", healthIndicator= " + healthIndicator + " }";
		} else {
			return "Animaux { species = " + this.getSpecies() + " name= " + name + ", sexe= femelle , poids= " + poids
					+ ", taille= " + taille + ", age= " + age + ", hungryIndicator= " + hungryIndicator
					+ ", sleepIndicator= " + sleepIndicator + ", healthIndicator= " + healthIndicator + " }";
		}
	}
}
