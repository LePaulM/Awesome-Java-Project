package animaux;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * @author formation
 *
 */

public class Hyene extends Charognard{
	/**
	 * Constructeur
	 * 
	 * @param dateNaissance
	 * @param dateDeces
	 * @param accesForet
	 * @param esperanceVie
	 * @param vitesse
	 * @param estVivant
	 * @param tpDecomposition
	 * @param espece
	 * @param tailleEstomac
	 * @param remplissageEstomac
	 * @param viande
	 * @param maturite
	 * @param aProcree
	 * @param meurtFaim
	 */
	public Hyene(int dateNaissance, int dateDeces,  Case emplacement, 
			int tpDecomposition, Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance, dateDeces, emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite, aProcree, meurtFaim);

		// on donne un id à l'animal
		this.id = Grille.animaux.size() + 1;

		// donne une espérance de vie d'au moins 12 tours et pouvant aller jusqu'à 1/5 de plus
		this.esperanceVie = 12;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// la hyene a accès a la forêt
		this.accesForet = true;

		//la hyene a une vitesse de 3
		this.vitesse = 3;
	}
	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */
		if ((Gestion.tour-getDateNaissance())<=(esperanceVie/4)) {
			setViande(1);
			setTailleEstomac(1);
		}
		else if((Gestion.tour-getDateNaissance())<=(esperanceVie/2)) {
			setViande(2);
			setTailleEstomac(2);
		}
		else {
			setTailleEstomac(4);
			setViande(5);
		}
	}
}
