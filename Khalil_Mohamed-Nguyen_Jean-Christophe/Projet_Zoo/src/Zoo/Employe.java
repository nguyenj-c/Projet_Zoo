/**
 * @author Nguyen, Khalil
 *
 */
package Zoo;

import Animaux.Animaux;
import Enclos.Enclos;
import Enclos.Enclos.degreProprete;

public class Employe {

	/**
	 * Nom de l'employé(e)
	 */
	private String name;
	/**
	 * Sexe de l'employé(e). Si le sexe est true c'est donc un homme sinon c'est une femme
	 */
	private boolean sexe;
	/**
	 * Age de l'employé(e)
	 */
	private int age;

	/**
	 * Constructeur de l'employé(e)
	 *
	 * @param name de l'employé(e)
	 * @param sexe de l'employé(e)
	 * @param age de l'employé(e)
	 */
	public Employe(String name, boolean sexe, int age) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Le nom de l'employé ne peut pas être vide.");
		}
		if (age < 18) {
			throw new IllegalArgumentException("L'employé doit être majeur. L'âge doit être supérieur ou équal à 18.");
		}
		if (age > 100) {
			throw new IllegalArgumentException("L'employé n'as plus la force de travailler à cette âge.");
		}
		this.name = name;
		this.sexe = sexe;
		this.age = age;
	}

	/**
	 * Retourne le nom de l'employé(e)
	 *
	 * @return the name of employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change le nom de l'employé(e)
	 *
	 * @param name the name of employee
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne le sexe de l'employé(e)
	 *
	 * @return the sexe of employee
	 */
	public boolean getSexe() {
		return sexe;
	}

	/**
	 * Change le sexe de l'employé(e)
	 *
	 * @param sexe the sexe of employee
	 */
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}

	/**
	 * Retourne l'age de l'employé(e)
	 *
	 * @return the age of employee
	 */
	public int getAge() {
		if (age <= 18) {
			throw new IllegalArgumentException("L'employé doit être majeur. L'âge doit être supérieur ou équal à 18.");
		}
		return age;
	}

	/**
	 * Change l'age de l'employé(e)
	 *
	 * @param age the age of employee
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Permet à l'employé(e) d'examiner un enclos
	 *
	 * @param enclos enclos selectionné
	 */
	public void analyseEnclos(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		if (enclos.getActualProprete() == degreProprete.bon) {
			System.out.println("L'enclos est propre.");
		} else if (enclos.getActualProprete() == degreProprete.bon) {
			System.out.println("La propreté de l'enclos est correcte.");
		} else {
			System.out.println("L'enclos est sale et doit être lavé.");
		}
		System.out.println(enclos);
		System.out.println(enclos.getActualAnimals());
	}

	/**
	 * Permet à l'employé(e) de nettoyer un enclos
	 *
	 * @param enclos enclos selectionné
	 */
	public void cleanEnclos(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut être null.");
		}
		enclos.maintenance();

	}

	/**
	 * Permet à l'employé(e) de nourrir les animaux d'un enclos
	 *
	 * @param enclos enclos selectionné
	 */
	public void feedAnimalsEnclos(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		enclos.feedAnimals();
	}

	/**
	 * Permet de transférer un animal d'un enclos à un autre enclos
	 *
	 * @param enclos enclos d'origine
	 * @param enclosDestination enclos de destination
	 * @param animal animal à transférer
	 */
	public void transferAnimals(Enclos enclos, Enclos enclosDestination, Animaux animal) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		if (enclosDestination == null) {
			throw new IllegalArgumentException("L'enclos ciblé ne peut pas être null.");
		}
		if (animal == null) {
			throw new IllegalArgumentException("L'animal ne peut pas être null.");
		}
		enclos.removeAnimaux(animal);
		enclosDestination.addAnimaux(animal);
		System.out.println("L'animal à été transféré dans l'enclos " + enclosDestination.getName() + " .");
	}

	/**
	 * Changement de l'affichage de l'employé(e)
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		if (getSexe()) {
			return "Employe { name= " + name + ", sexe= homme , age= " + age + " }";
		} else {
			return "Employe { name= " + name + ", sexe= femme, age= " + age + " }";
		}
	}
}
