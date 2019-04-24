package Gestion;

import java.util.ArrayList;
import java.util.Timer;

import animaux.Animal;

public class Gestionnaire {
	protected static int tour;
	private static int cadence;
	private static ArrayList<Animal> animaux = new ArrayList<Animal>();

	/**
	 * getter et setter
	 * 
	 */

	public static int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		Gestionnaire.tour = tour;
	}

	public int getCadence() {
		return cadence;
	}

	public void setCadence(int newCadence) {
		Gestionnaire.cadence = newCadence;
	}

	public Animal getAnimal(int id) {
		return animaux.get(id);
	}

	public static ArrayList<Animal> getAnimaux(){
		return animaux;
	}

	public static void addAnimal(Animal animal) {
		animaux.add(animal);
	}


	public void nouveauTour() {
		tour = tour++;
		Timer timer = new Timer();
		for (Animal e : animaux) {								// pour chaque animal présent dans la simulation
			if (e.getEstVivant() == false){						// si l'animal est decedé,
				e.seDecomposer();								// on applique la fonction seDecomposer()
				continue;										// et on termine le tour de l'animal
			}
			else {												// sinon,
				if (e.getEsperanceVie() <= tour - e.getDateNaissance() || e.famine() == true ) {	//si l'animal a atteint son esperance de vie, ou si il est en famine avancée
					e.decede();												// il décede
					continue;												// et on termine le tour de l'animal
				}else {														//sinon,
					e.seDeplacer();											// l'animal se déplace,
					e.seNourrir();											// se nourrit si il le peut
					e.seReproduire();										// et se reproduit si il le peut
				}
			}

		}
	}
}
