package animaux;

import java.awt.Color;
import java.util.Random;

/**
 * 
 * @author formation
 *
 */


public class Cheval extends Herbivore{
	/**
	 * Constructeur
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
	public Cheval(int dateNaissance, int dateDeces,  Case emplacement,
			int tpDecomposition,  Color couleur, int remplissageEstomac, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces, emplacement, tpDecomposition,couleur,
				remplissageEstomac,maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Grille.animaux.size() + 1;

		//	donne une espérance de vie d'au moins 20 tours et pouvant aller jusqu'à 1/5 de plus
		esperanceVie = 25;
		esperanceVie = esperanceVie +(int)(Math.random() * this.esperanceVie/5);

		// le chacal a acces à la forêt
		accesForet = false;

		//	le chacal a une vitesse de 2
		vitesse = 6;
	}

	public void croissance() {
		/*
		 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
		 * son espèce.
		 * cette fonction est activée par le Gestionnaire en début de tour
		 */
		if ((Gestionnaire.tour-getDateNaissance())<=(esperanceVie/4)) {
			setViande(2);
			setTailleEstomac(1);
		}
		else if((Gestionnaire.tour-getDateNaissance())<=(esperanceVie/2)) {
			setViande(4);
			setTailleEstomac(3);
		}
		else {
			setViande(6);
			setTailleEstomac(8);
		}
	}
