package animaux;

import java.awt.Color;

//import java.awt.Color;
/**
 * 
 * @author formation
 *
 */

public abstract class Charognard extends Animal {
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
	public Charognard(int dateNaissance, int dateDeces, boolean accesForet, /*Case emplacement,*/ int vitesse, boolean vivant,
			int tpDecomposition, String espece, Color couleur, int tailleEstomac,int remplissageEstomac, int viande, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces,accesForet,vitesse,vivant,tpDecomposition,espece, couleur,tailleEstomac, 
				remplissageEstomac,viande, maturite,aProcree,meurtFaim);
	}
}
