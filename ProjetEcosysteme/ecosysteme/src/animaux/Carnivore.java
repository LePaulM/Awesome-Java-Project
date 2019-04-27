package animaux;
import java.awt.Color;
/**
 * 
 * @author formation
 *
 */
import java.util.ArrayList;

import ecosysteme.Case;
import ecosysteme.Grille;

public class Carnivore extends Animal{
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
	public Carnivore(int dateNaissance, Case emplacement, 
			int tpDecomposition, Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement, tpDecomposition,couleur,
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}

	public void seNourrir(){
		if (getEstVivant() == false) {
			break;
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				//			Définition des cases adjacentes
				int case1 = Grille.getGrille()[this.getEmplacement().getX()-1][this.getEmplacement().getY()-1];	// marche avec les coordonn�es de la case
				Case case2 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()-1);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()-1);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY());
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY());
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()+1);
				Case case7 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()+1);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()+1);
				//		Création de la liste des cases adjacentes
				ArrayList<Case> cases = new ArrayList<Case>(case1,case2,case3,case4,case5,case6,case7, case8);
				for (Case c : cases) {
					// si la case contient un animal, et que l'animal n'est pas un autre carnivore, 
					// le carnivore le tue
					if(c.estVide() == true || c.getAnimal().getEspece() != this.getEspece()) {
						c.getAnimal().decede();
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si l'animal tué contient plus de nourriture que l'animal n'a de place dans son estomac, 
							// alors il mange juste à sa faim
							if (c.getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
								c.getAnimal().setViande(c.getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
								this.setRemplissageEstomac(this.getTailleEstomac());
								this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
							} 
							// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0
							else if (getRemplissageEstomac() + c.getAnimal().getViande() <= getTailleEstomac()){
								this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
								c.getAnimal().setViande(this.getTailleEstomac() - this.getRemplissageEstomac());
								c.getAnimal().setViande(0);
								c.setACadavre(false); 
							}
						}
					}			
					break;			//une fois que l'animal s'est nourri on arrête la boucle (un animal ne se nourrit qu'une seule fois par tour
				}

			}
		}
	}
}
