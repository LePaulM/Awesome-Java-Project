package animaux;

import java.awt.Color;

//import java.awt.Color;
/**
 * 
 * @author formation
 *
 */

public class Carnivore extends Animal{
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
	public Carnivore(int dateNaissance, int dateDeces, boolean accesForet, Case emplacement, int vitesse, boolean vivant,
			int tpDecomposition, String espece, Color couleur, int tailleEstomac,int remplissageEstomac, int viande, int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces,accesForet, emplacement, vitesse,vivant,tpDecomposition,espece,couleur,tailleEstomac, 
				remplissageEstomac,viande, maturite,aProcree,meurtFaim);
	}

	@Override
	public void seReproduire() {
		// TODO Auto-generated method stub
		//		Définition des cases adjacentes
		Case c1=new Case(emplacement.getX(),emplacement.getY()+1);
		Case c2=new Case(emplacement.getX()-1,emplacement.getY());
		Case c3=new Case(emplacement.getX()+1,emplacement.getY());
		Case c4=new Case(emplacement.getX(),emplacement.getY()-1);
		//		Création de la liste des cases adjacentes
		ArrayList<Case> cases=new ArrayList<Case>(c1,c2,c3,c4);
		for (int c = 0; c < 8; c++){ 
			if (cases.get(c).estVide == true) {
				//			Si une des cases adjacentes n'est pas vide, l'animal se reproduit et arrête de vérifier les autres cases adjacentes
				continue;
			} else if (cases.get(c).getAnimal().espece.equals(espece)) {
				Carnivore animal = new Carnivore(dateNaissance, dateDeces, accesForet, vitesse, estVivant,
						tpDecomposition, espece, couleur, tailleEstomac,getRemplissageEstomac(), viande, maturite,
						true , 3);
					
			}
		}
		this.setRemplissageEstomac(this.getRemplissageEstomac() - 1);
		
	}
}
