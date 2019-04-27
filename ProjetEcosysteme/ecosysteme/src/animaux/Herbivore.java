package animaux;

import java.awt.Color;
import java.util.ArrayList;

import ecosysteme.Case;

//import java.awt.Color;
/**
 * 
 * @author formation
 *
 */

public class Herbivore extends Animal{
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

	public Herbivore(int dateNaissance,  Case emplacement, 
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement,tpDecomposition,couleur, 
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}

	public void seNourrir(){
		if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
			// si la case est de type "Herbe", "Buisson" ou Foret, l'herbivore peut manger
			if(this.getEmplacement().getTypeOccupation().equals("Herbe")||this.getEmplacement().getTypeOccupation().equals("Buisson")
					||this.getEmplacement().getTypeOccupation().equals("Foret")) {
				if (getRemplissageEstomac() < getTailleEstomac()) {
					// si la case contient plus de nourriture que l'animal ne peut en manger, 
					// alors il mange juste à sa faim
					if (this.getEmplacement().getNourriture() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
						this.getEmplacement().setNourriture(this.getEmplacement().getNourriture() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
						this.setRemplissageEstomac(this.getTailleEstomac());
					} 
					// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
					// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
					// le stock de nourriture tombe donc à 0
					// la case lance alors son processus de recuperation
					else if (getRemplissageEstomac() + this.getEmplacement().getNourriture() <= getTailleEstomac()){
						this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getNourriture());
						this.getEmplacement().setNourriture(this.getTailleEstomac() - this.getRemplissageEstomac());
						this.getEmplacement().setNourriture(0);
						this.getEmplacement().recuperation();
					}
				}
			}
		}

	}
}
