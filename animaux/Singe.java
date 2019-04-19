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
	public Singe(int dateNaissance, int dateDeces, boolean accesForet,/*Case emplacement,*/ int vitesse, boolean estVivant,
			int tpDecomposition, String espece, /*Color couleur,*/ int tailleEstomac,int remplissageEstomac, int viande, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces,accesForet, vitesse,estVivant,tpDecomposition,espece,/*couleur,*/tailleEstomac, 
				remplissageEstomac,viande, maturite,aProcree,meurtFaim);
//		donne une espérance de vie autour de 20 tours à 4 tours près (soit 1/5)
		esperanceVie=20;
		Random r = new Random();
		int plusoumoins = r.nextInt(1);
		if (plusoumoins==1) {
			esperanceVie=esperanceVie+(int)(Math.random() * this.esperanceVie/5);}
		else {
			esperanceVie=esperanceVie-(int)(Math.random() * this.esperanceVie/5);
		}
	}

	@Override
	public void seReproduire() {
		// TODO Auto-generated method stub
		
	}
}

