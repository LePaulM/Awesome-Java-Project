package animaux;

import java.util.Random;

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
	public Chacal(int dateNaissance, int dateDeces, boolean accesForet,/*Case emplacement,*/ int vitesse, boolean vivant,
			int tpDecomposition, String espece, /*Color couleur,*/ int tailleEstomac,int remplissageEstomac, int viande, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces,accesForet, vitesse,vivant,tpDecomposition,espece,/*couleur,*/tailleEstomac, 
				remplissageEstomac,viande, maturite,aProcree,meurtFaim);
		this.esperanceVie=12;
		Random r = new Random();
		int plusoumoins = r.nextInt(1);
		if (plusoumoins==1) {
			esperanceVie=esperanceVie+(int)(Math.random() * this.esperanceVie/5);}
		else {
			esperanceVie=esperanceVie-(int)(Math.random() * this.esperanceVie/5);
		}
		
	}

}
