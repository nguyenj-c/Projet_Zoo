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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
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

	public void sound(boolean hungryIndicator, boolean sleepIndicator, boolean healthIndicator) {
		if (hungryIndicator == true) {
			System.out.println("faim " + name);
		}
		if (sleepIndicator == true) {
			System.out.println("dormir " + name);
		}
		if (healthIndicator == true) {
			System.out.println("gu�risson " + name);
		}
		if (healthIndicator == false && sleepIndicator == false && hungryIndicator == false) {
			System.out.println(name);
		}
	}

	public void beHealed(boolean healthIndicator) {
		if (this.healthIndicator == false) {
			this.healthIndicator = true;
			System.out.println("Je suis gu�rri :" + this.healthIndicator);
		}
	}

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
	public void run() {
		// TODO Auto-generated method stub
		//sleepState();
	}

	@Override
	public String toString() {
		return "Animaux [name=" + name + ", sexe=" + sexe + ", poids=" + poids + ", taille=" + taille + ", age=" + age
				+ ", hungryIndicator=" + hungryIndicator + ", sleepIndicator=" + sleepIndicator + ", healthIndicator="
				+ healthIndicator + "]";
	}

}
