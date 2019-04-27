package ecosysteme;

import Gestion.Gestionnaire;
import animaux.Animal;

public class Case {

	private String typeOccupation;
	private boolean estvide;
	private boolean cadavre;
	private int position[];
	private int nourriture;
	private int nourritureMax;

	public Case() {};

	public String getTypeOccupation() {
		return typeOccupation;
	}

	public boolean estVide() {
		return estvide;
	}

	public boolean aCadavre() {
		return cadavre;
	}

	public int[] getPosition() {
		return this.position;
	}

	public int getX() {
		return this.position[0];
	}

	public int getY() {
		return this.position[1];
	}

	public void setX(int x) {
		this.position[0] = x;
	}

	public void setY(int y) {
		this.position[1] = y;
	}

	public Case(String typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estvide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}

	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estvide = b;
	}

	public Animal getAnimal() {
		if (this.estVide() == false) {

			return null;
		}
		else {
			return null;
		}
	}

	public boolean getACadavre() {
		// TODO Auto-generated method stub
		return aCadavre();
	}

	public void setACadavre(boolean b) {
		// TODO Auto-generated method stub
		this.cadavre = b;
	}

	/**
	 * Getter
	 * @return
	 */
	public int getNourriture() {
		return this.nourriture;
	}

	/**
	 * Setter
	 * @param nourriture
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=10;
				}
			}
		}
	}

}
