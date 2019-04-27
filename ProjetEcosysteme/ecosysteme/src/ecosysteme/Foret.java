package ecosysteme;

import Gestion.Gestionnaire;

public class Foret extends Case{
	/**
	 * stock de nourriture que contient la foret
	 */
	private int nourriture;

	/**
	 * Constructeur
	 */
	public Foret(){
		this.nourriture=20;
	}


	/**
	 * Getter
	 * @return
	 */
	public int getNourriture() {
		return nourriture;
	}


	/**
	 * Setter
	 * @param nourriture
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	



	/**
	 * méthode qui recharge le stock de nouriiture que contient le buisson si il est vide
	 */
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=20;
				}
			}
		}
	}
}
