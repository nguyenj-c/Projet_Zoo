package Enclos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EnclosRegistry {

	private static final Map<Class<? extends Enclos>, List<Enclos>> ENCLOS_REGISTRY = new HashMap<>();

	/**
	 * Ajoute l'enclos au registre
	 *
	 * @param enclos à enregistrer
	 */
	public static void registerEnclos(Enclos enclos) {
		if (enclos == null)
			return;

		assertClassExists(enclos.getClass());
		ENCLOS_REGISTRY.get(enclos.getClass()).add(enclos);
	}

	/**
	 * Enlève l'enclos du registre
	 *
	 * @param enclos à supprimer du registre
	 */
	public static void unregisterEnclos(Enclos enclos) {
		if (enclos != null && ENCLOS_REGISTRY.containsKey(enclos.getClass())) {
			ENCLOS_REGISTRY.get(enclos.getClass()).remove(enclos);
		}
	}

	private static void assertClassExists(Class<? extends Enclos> type) {
		ENCLOS_REGISTRY.putIfAbsent(type, new ArrayList<>());
	}

	/**
	 * Renvoie la liste d'enclos par type
	 * @param type
	 * @return
	 */
	public static List<Enclos> getRegisteredEnclosByType(Class<? extends Enclos> type) {
		if (type != null && ENCLOS_REGISTRY.containsKey(type)) {
			return ENCLOS_REGISTRY.get(type);
		}
		return null;
	}
}
