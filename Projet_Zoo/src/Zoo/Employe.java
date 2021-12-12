/**
 * @author Nguyen, Khalil
 *
 */
package Zoo;

import Animaux.Animaux;
import Enclos.Enclos;
import Enclos.Enclos.degreProprete;

public class Employe {
	
	private String name;
	private boolean sexe;
	private int age;
	
	/**
	 * Constructeur de l'employé(e)
	 * @param name
	 * @param sexe
	 * @param age
	 */
	public Employe(String name, boolean sexe, int age) {
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
	 * Retourne le nom de l'employé(e)
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Change le nom de l'employé(e)
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Retourne le sexe de l'employé(e)
	 * @return the sexe
	 */
	public boolean getSexe() {
		return sexe;
	}
	/**
	 * Change le sexe de l'employé(e)
	 * @param sexe the sexe to set
	 */
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	/**
	 * Retourne l'age de l'employé(e)
	 * @return the age
	 */
	public int getAge() {
		if (age <= 18) {
			throw new IllegalArgumentException("L'employé doit être majeur. L'âge doit être supérieur ou équal à 18.");
		}
		return age;
	}
	/**
	 * Change l'age de l'employé(e)
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Permet à l'employé(e) d'examiner un enclos
	 * @param enclos
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
	 * @param enclos
	 */
	public void cleanEnclos(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut être null.");
		}
		enclos.maintenance();
		
	}
		
	/**
	 * Permet à l'employé(e) de nourrir les animaux d'un enclos
	 * @param enclos
	 */
	public void feedAnimalsEnclos(Enclos enclos) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		enclos.feedAnimals();
	}

	/**
	 * Permet de transférer un animal d'un enclos à un autre enclos
	 * @param enclos
	 * @param enclosDestination
	 * @param animal
	 */
	public void transferAnimals(Enclos enclos, Enclos enclosDestination, Animaux animal) {
		if (enclos == null) {
			throw new IllegalArgumentException("L'enclos ne peut pas être null.");
		}
		if (enclosDestination == null) {
			throw new IllegalArgumentException("L'enclos ciblé ne peut pas être null.");
		}
		if(animal == null) {
			throw new IllegalArgumentException("L'animal ne peut pas être null.");
		}
		enclos.enlever(animal);
		enclosDestination.ajouter(animal);
		System.out.println("L'animal à été transféré dans l'enclos " + enclosDestination.getName() +" .");
	}
	
	@Override
	public String toString() {
		return "Employe { name= " + name + ", sexe= " + sexe + ", age= " + age + " }";
	}
	
        public static void getNameEmploye() {
                System.out.println("Quel est le nom de votre employé ?");
        }

        public static void getSexEmploye() {
                System.out.println("Quel est le sexe de votre employé ? (Homme ou Femme)");
        }

        public static void getAgeEmploye() {
                System.out.println("Quel est l'age de votre employé ?");
        }
        public static void successEmploye() {
                System.out.println("L'employé à été créé !\n" +
                                   "Nous allons maintenant créer le Zoo.");
        }
}

