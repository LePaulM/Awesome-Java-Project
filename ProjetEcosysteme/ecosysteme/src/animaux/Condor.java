package animaux;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * @author formation
 *
 */
public class Condor extends Charognard{
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
	public Condor(int dateNaissance, int dateDeces, Case emplacement,
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces, emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Grille.animaux.size() + 1;

		//	donne une espérance de vie d'au moins 40 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 40;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// le condor a acces à la forêt
		accesForet = true;

		//	le condor a une vitesse de 2
		vitesse = 4;
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
			setViande(4);
		}
	}

}
