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
public class Chacal extends Charognard {
	/**
	 * Constructeur
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
	public Chacal(int dateNaissance, Case emplacement,
			int tpDecomposition, Color couleur, int remplissageEstomac, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance, emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Gestionnaire.getAnimaux().size() + 1;

		//	donne une espérance de vie d'au moins 12 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 12;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// le chacal a acces à la forêt
		accesForet = true;

		//	le chacal a une vitesse de 2
		vitesse = 2;
	}
	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */
		if ((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/4)) {
			setViande(1);
			setTailleEstomac(1);
		}
		else if((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/2)) {
			setViande(2);
			setTailleEstomac(2);
		}
		else {
			setViande(5);
			setTailleEstomac(4);
		}
	}

}
