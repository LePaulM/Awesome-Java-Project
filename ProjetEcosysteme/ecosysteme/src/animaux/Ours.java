package animaux;

import java.awt.Color;
import java.util.Random;

import Gestion.Gestionnaire;
import ecosysteme.Case;

/**
 * 
 * @author formation
 *
 */

public class Ours extends Carnivore{
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
	public Ours(int dateNaissance, Case emplacement, 
			int tpDecomposition, Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance, emplacement, tpDecomposition, couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Gestionnaire.getAnimaux().size() + 1;

		//	donne une espérance de vie d'au moins 30 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 30;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// l'ours a accès aux cases de foret
		accesForet = true;

		// l'ours a une vitesse de 4
		vitesse = 2;

		// l'ours contient 1 viande à la naissance
		viande = 1;
	}

	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */
		if ((Gestionnaire.getTour() - this.getDateNaissance())<=(esperanceVie/4)) {
			setViande(3);
			setTailleEstomac(2);
		}
		else if((Gestionnaire.getTour() - this.getDateNaissance())<=(esperanceVie/2)) {
			setViande(6);
			setTailleEstomac(4);
		}
		else {
			setTailleEstomac(8);
			setViande(12);
		}
	}

}
