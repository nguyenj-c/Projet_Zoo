/**
 * @author Nguyen, Khalil
 *
 */
package Animaux;

public abstract class Animaux{

	private String name;
	private boolean sexe; 
	private double poids;
	private double taille;
	private int age;
	private boolean hungryIndicator;
	private boolean sleepIndicator;
	private boolean healthIndicator;

	public Animaux(String name, boolean sexe, double poids, double taille, int age) {
		this.name = name;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.hungryIndicator = false;
		this.sleepIndicator = false;
		this.healthIndicator = true;
	}

	/**
	 * Retourne le nom
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le sexe des animaux
	 * @return the sexe
	 */
	public boolean isSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(boolean sexe) {
		if (this.sexe == true || this.sexe == false) {
			this.sexe = sexe;
		} else {
			System.out.println("Erreur lors de la saisie du sexe : valeur incorrect");
		}
	}

	/**
	 * Retourne le poids des animaux
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**
	 * Retourne l taille des animaux
	 * @return the taille
	 */
	public double getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(double taille) {
		this.taille = taille;
	}

	/**
	 * Retourne l'âge des animaux
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Retourne la faim des animaux
	 * @return the hungryIndicator
	 */
	public boolean isHungryIndicator() {
		return hungryIndicator;
	}

	/**
	 * @param hungryIndicator the hungryIndicator to set
	 */
	public void setHungryIndicator(boolean hungryIndicator) {
		if (this.hungryIndicator == true || this.hungryIndicator == false) {
			this.hungryIndicator = hungryIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
	}

	/**
	 * Retourne l'état de sommeil des animaux
	 * @return the sleepIndicator
	 */
	public boolean isSleepIndicator() {
		return sleepIndicator;
	}

	/**
	 * @param sleepIndicator the sleepIndicator to set
	 */
	public void setSleepIndicator(boolean sleepIndicator) {
		if (this.sleepIndicator == true || this.sleepIndicator == false) {
			this.sleepIndicator = sleepIndicator;
		} else {
			System.out.println("Erreur lors de la saisie des valeur");
		}
		this.sleepIndicator = sleepIndicator;
	}

	/**
	 * Retourne la santé des animaux
	 * @return the healthIndicator
	 */
	public boolean isHealthIndicator() {
		return healthIndicator;
	}

	/**
	 * @param healthIndicator the healthIndicator to set
	 */
	public void setHealthIndicator(boolean healthIndicator) {
		this.healthIndicator = healthIndicator;
	}

	/**
	 *
	 * @param healthIndicator the healthIndicator to set
	 */
	public boolean eat(boolean hungryIndicator) {
		if (this.sleepIndicator == false && this.hungryIndicator == true) {
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
	public void sound(boolean hungryIndicator, boolean sleepIndicator, boolean healthIndicator) {
		if (hungryIndicator == true) {
			System.out.println("J'ai faim " + name);
		}
		if (sleepIndicator == true) {
			System.out.println("J'ai sommeil " + name);
		}
		if (healthIndicator == true) {
			System.out.println("Je suis soigné " + name);
		}
		if (healthIndicator == false && sleepIndicator == false && hungryIndicator == false) {
			System.out.println(name);
		}
	}
	/**
	 * Soigner les animaux
	 */
	public void beHealed(boolean healthIndicator) {
		if (this.healthIndicator == false) {
			this.healthIndicator = true;
			System.out.println("Je suis guérri :" + this.healthIndicator);
		}
	}
	/**
	 * Etat de sommeil des animaux
	 */
	public void sleepState(boolean sleepIndicator) {
		if (this.sleepIndicator == true) {
			this.sleepIndicator = false;
			System.out.println( name + "va s'endormir : " + this.sleepIndicator);
		} else {
			this.sleepIndicator = true;
			System.out.println( name + "est en train de se reveiller : " + this.sleepIndicator);
		}

	}


	@Override
	public String toString() {
		return "Animaux [name=" + name + ", sexe=" + sexe + ", poids=" + poids + ", taille=" + taille + ", age=" + age
				+ ", hungryIndicator=" + hungryIndicator + ", sleepIndicator=" + sleepIndicator + ", healthIndicator="
				+ healthIndicator + "]";
	}

}
