package animaux;
import java.awt.Color;
import java.util.ArrayList;

import ecosysteme.Case;
import ecosysteme.Grille;
/**
 * 
 * @author formation
 *
 */

public abstract class Charognard extends Animal {
	/**
	 * Constructeur
	 * @param id
	 * @param dateNaissance
	 * @param dateDeces
	 * @param accesForet
	 * @param esperanceVie
	 * @param vitesse
	 * @param vivant
	 * @param tpDecomposition
	 * @param espece
	 * @param tailleEstomac
	 * @param remplissageEstomac
	 * @param viande
	 * @param maturite
	 * @param aProcree
	 * @param meurtFaim
	 */
	public Charognard(int dateNaissance, Case emplacement,  
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement,tpDecomposition,couleur, 
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}


	public void seNourrir(){
		// si l'animal est vivant
		if (getEstVivant() == true) {
			// si l'animal n'est pas rassasi� 
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				// si la case contient un cadavre, le charognard peut manger
				if(this.getEmplacement().aCadavre() == true) {
					if (this.getEmplacement().getAnimal().getViande() > 0) {			// si le cadavre a de la viande
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si la case contient plus de nourriture que l'animal ne peut en manger, 
							// alors il mange juste à sa faim
							if (this.getEmplacement().getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
								this.getEmplacement().getAnimal().setViande(this.getEmplacement().getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
								this.setRemplissageEstomac(this.getTailleEstomac());
								this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande());
							} 
							// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0 et la case ne contient plus de cadavre
							else if (getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande() <= getTailleEstomac()){
								this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande());
								this.getEmplacement().getAnimal().setViande(this.getTailleEstomac() - this.getRemplissageEstomac());
								this.getEmplacement().getAnimal().setViande(0);
								this.getEmplacement().setACadavre(false); 
							}
						}
					}
				}
			}
		}
	}
}
