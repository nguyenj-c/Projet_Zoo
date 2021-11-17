/**
 * 
 */
package Zoo;

/**
 * @author n19004502
 *
 */
public class Employe {
	
	private String name;
	private String sexe;
	private int age;
	/**
	 * 
	 */
	public Employe() {
		// TODO Auto-generated constructor stub
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
	public String getSexe() {
		return sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	
	public void analyseEnclos() {
		Enclos enclos = new Enclos();
		System.out.println(enclos);
		System.out.println(enclos.getActualAnimals());
	}
	public void cleanEnclos() {
		Enclos enclos = new Enclos();
		enclos.maintenance(null);
		
	}
	@Override
	public String toString() {
		return "Employe [name=" + name + ", sexe=" + sexe + ", age=" + age + "]";
	}
	public void feedAnimalsEnclos() {
		Enclos enclos = new Enclos();
		enclos.feedAnimals();
	}
	public void transferAnimals(Animaux espece) {
		Enclos enclos = new Enclos();
		Enclos enclos2 = new Enclos();
		enclos.getActualAnimals();
		
		enclos.enlever(espece);
		enclos2.ajouter(espece);

	}
}
