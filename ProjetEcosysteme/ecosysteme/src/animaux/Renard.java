package animaux;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * @author formation
 *
 */

public class Renard extends Carnivore{
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
	public Renard(int dateNaissance, Case emplacement, 
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance, emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Grille.animaux.size() + 1;
		
		//	donne une espérance de vie d'au moins 4 tours et pouvant aller jusqu'à 1/4 de plus
		esperanceVie = 4;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/4);

		// le renard a accès aux cases de foret
		accesForet = true;

		// le renard a une vitesse de 4
		vitesse = 4;
		
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
			setTailleEstomac(2);
		}
		else {
			setTailleEstomac(4);
			setViande(5);
		}
	}
}
