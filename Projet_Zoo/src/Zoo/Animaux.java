/**
 * 
 */
package Zoo;

/**
 * @author n19004502
 *
 */
public class Animaux implements Runnable {

	private String name;
	private boolean sexe;
	private double poids;
	private double taille;
	private int age;
	private boolean hungryIndicator;
	private boolean sleepIndicator;
	private boolean healthIndicator;

	
	public Animaux(String name, boolean sexe, double poids, double taille, int age, boolean hungryIndicator,
			boolean sleepIndicator, boolean healthIndicator) {
		super();
		this.name = name;
		this.sexe = sexe;
		this.poids = poids;
		this.taille = taille;
		this.age = age;
		this.hungryIndicator = hungryIndicator;
		this.sleepIndicator = sleepIndicator;
		this.healthIndicator = healthIndicator;
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
		this.sexe = sexe;
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
		this.hungryIndicator = hungryIndicator;
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
	public boolean eat() {
		if (sleepIndicator == false) {
			setHungryIndicator(false);
		} else {
			setHungryIndicator(true);
		}
		return sleepIndicator;

	}

	public void sound(boolean hungryIndicator, boolean sleepIndicator, boolean healthIndicator) {
		if (hungryIndicator == true) {
			System.out.println("faim" + name);
		}
		if (sleepIndicator == true) {
			System.out.println("dormir" + name);
		}
		if (healthIndicator == true) {
			System.out.println("guérisson" + name);
		}
		if (healthIndicator == false || sleepIndicator == false || hungryIndicator == false) {
			System.out.println(name);
		}
	}

	public void beHealed() {
		if (healthIndicator == false) {
			setHealthIndicator(true);
		}
	}

	public void sleepState() {
		try {
			if (sleepIndicator == true) {
				System.out.println(" dodo : " + name);
				Thread.sleep(200);
				setSleepIndicator(false);
			} else {
				System.out.println(" reveiller : " + name);
				Thread.sleep(200);
				setSleepIndicator(true);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sleepState();
	}

	@Override
	public String toString() {
		return "Animaux [name=" + name + ", sexe=" + sexe + ", poids=" + poids + ", taille=" + taille + ", age=" + age
				+ ", hungryIndicator=" + hungryIndicator + ", sleepIndicator=" + sleepIndicator + ", healthIndicator="
				+ healthIndicator + "]";
	}

}
