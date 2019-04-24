package animaux;

import java.util.Random;

/**
 * 
 * @author formation
 *
 */

public class Singe extends Charognard{
	/**
	 * Constructeur
	 * @param id
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
	public Singe(int dateNaissance, int dateDeces, Case emplacement,
			int tpDecomposition, Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Grille.animaux.size() + 1;
		
		//	donne une espérance de vie d'au moins 20 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 20;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// le renard a accès aux cases de foret
		accesForet = true;

		// le renard a une vitesse de 4
		vitesse = 2;
		
		// la renard contient 1 viande à la naissance
		viande = 1;

	}
	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */
		if ((Gestion.tour - this.getDateNaissance())<=(esperanceVie/4)) {
			setViande(1);
			setTailleEstomac(1);
		}
		else if((Gestion.tour - this.getDateNaissance())<=(esperanceVie/2)) {
			setViande(2);
			setTailleEstomac(3);
		}
		else {
			setTailleEstomac(6);
			setViande(5);
		}
	}
}

