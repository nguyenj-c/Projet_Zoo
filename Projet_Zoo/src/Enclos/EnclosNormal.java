package Enclos;

import Animaux.Animaux;

public class EnclosNormal <T extends Animaux> extends Enclos <T>{

	public EnclosNormal (String name, int area, int maxAnimal) {
		super(name, area, maxAnimal);
	}
}
