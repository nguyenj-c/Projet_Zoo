package Animaux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AnimalRegistry {

    private static final Map<Class<? extends Animaux>, List<Animaux>> ANIMAL_REGISTRY = new HashMap<>();

    /**
     * Ajoute l'animal au registre
     * @param animal
     */
    public static void registerAnimal(Animaux animal) {
        if(animal == null) return;

        assertClassExists(animal.getClass());
        ANIMAL_REGISTRY.get(animal.getClass()).add(animal);
    }

    /**
     * Enlève l'animal du registre
     * @param animal
     */
    public static void unregisterAnimal(Animaux animal) {
        if(animal != null && ANIMAL_REGISTRY.containsKey(animal.getClass())) {
            ANIMAL_REGISTRY.get(animal.getClass()).remove(animal);
        }
    }

    private static void assertClassExists(Class<? extends Animaux> clazz) {
        ANIMAL_REGISTRY.putIfAbsent(clazz, new ArrayList<>());
    }

    /**
     * Renvoie la liste d'animaux par classe
     * @param clazz
     * @return List
     */
    public static List<Animaux> getRegisteredAnimalsByClass(Class<? extends Animaux> clazz) {
        if(clazz != null && ANIMAL_REGISTRY.containsKey(clazz)) {
            return ANIMAL_REGISTRY.get(clazz);
        }
        return null;
    }
}
