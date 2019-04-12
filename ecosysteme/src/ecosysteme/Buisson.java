package ecosysteme;

public class Buisson extends Case{

	/**
	 * stock de nourriture que contient le buisson
	 */
	private int nourriture;
	
	/**
	 * Constructeur
	 */
	public Buisson(){
		this.nourriture=10;
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

			int tourDeRecup = Gestionnaire.tour;
			
			int recuperation=0;
			
			while(recuperation <= 3) {
				recuperation = Gestionnaire.tour - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=10;
				}
			}
		}
	}
}
