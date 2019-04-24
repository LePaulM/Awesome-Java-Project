package animaux;

import java.util.Random;

import ecosysteme.Case;
import ecosysteme.Grille;

import java.awt.Color;
/**
 * 
 * @author formation
 *
 */

public class Bouquetin extends Herbivore {
	/**
	 * Constructeur
	 * @param dateNaissance
	 * @param dateDeces
	 * @param accesForet
	 * @param esperanceVie
	 * @param tpDecomposition
	 * @param espece
	 * @param tailleEstomac
	 * @param remplissageEstomac
	 * @param viande
	 * @param maturite
	 * @param aProcree
	 * @param meurtFaim
	 */
	public Bouquetin(int dateNaissance, Case emplacement,
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {

		super(dateNaissance, emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);
		
		// on ajoute un id à l'animal
		this.id = Grille.animaux.size() + 1;

		//	donne une espérance de vie d'au moins 20 tours et pouvant aller jusqu'à 1/5 de plus
		this.esperanceVie=20;
		esperanceVie=esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// le bouquetin a acces à la forêt
		accesForet=true;

		// le bouquetin a une vitesse de 4
		vitesse=4;

		// la bouquetin contient 1 viande à la naissance
		viande = 1;
	}
	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */

		if ((Gestion.tour-getDateNaissance())<=(esperanceVie/4)) {
			setViande(2);
			setTailleEstomac(1);
		}
		else if((Gestion.tour-getDateNaissance())<=(esperanceVie/2)) {
			setViande(3);
			setTailleEstomac(3);
		}
		else {
			setTailleEstomac(6);
			setViande(6);
		}

	}

}
