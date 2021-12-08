/**
 * @author Nguyen, Khalil
 *
 */
package Zoo;

import Enclos.Enclos;

public class Employe {
	
	private String name;
	private String sexe;
	private int age;
	/**
	 * 
	 */
	public Employe(String name, String sexe, int age) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom de l'employé ne peut pas être vide.");
		}
		if (age <= 18) {
			throw new IllegalArgumentException("L'employé doit être majeur. L'âge doit être supérieur ou équal à 18.");
		}
		this.name = name;
		this.sexe = sexe;
		this.age = age;
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

	public void analyseEnclos(Enclos enclos) {
		System.out.println(enclos);
		System.out.println(enclos.getActualAnimals());
	}
	public void cleanEnclos(Enclos enclos) {
		//enclos.maintenance(null);
		
	}
	@Override
	public String toString() {
		return "Employe {name=" + name + ", sexe=" + sexe + ", age=" + age + "}";
	}
	public void feedAnimalsEnclos(Enclos enclos1) {
		enclos1.feedAnimals();
	}
	public void transferAnimals(Enclos enclos1) {
		//enclos1.transferer();
	}
}
