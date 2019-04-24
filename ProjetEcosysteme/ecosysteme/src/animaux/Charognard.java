package animaux;
import java.awt.Color;
import java.util.ArrayList;
/**
 * 
 * @author formation
 *
 */

public abstract class Charognard extends Animal {
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
	public Charognard(int dateNaissance, int dateDeces, Case emplacement,  
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,dateDeces,emplacement,tpDecomposition,couleur, 
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}


	public void seNourrir(){
		if (getEstVivant() == false) {
			break;
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				//			Définition des cases adjacentes
				Case case1 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()-1);
				Case case2 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()-1);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()-1);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY());
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY());
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()+1);
				Case case7 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()+1);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()+1);
				//		Création de la liste des cases adjacentes
				ArrayList<Case> cases=new ArrayList<Case>(case1,case2,case3,case4,case5,case6,case7, case8);
				for (Case c : cases) {
					// si la case contient un cadavre, le charognard peut manger
					if(c.aCadavre == true) {
						if (c.getAnimal().getViande() > 0) {			// si le cadavre a de la viande
							if (getRemplissageEstomac() < getTailleEstomac()) {
								// si la case contient plus de nourriture que l'animal ne peut en manger, 
								// alors il mange juste à sa faim
								if (c.getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
									c.getAnimal().getViande(case8.getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
									this.setRemplissageEstomac(this.getTailleEstomac());
									this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
								} 
								// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
								// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
								// le stock de nourriture tombe donc à 0
								else if (getRemplissageEstomac() + c.nourriture <= getTailleEstomac()){
									this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
									c.getAnimal().getViande(this.getTailleEstomac() - this.getRemplissageEstomac());
									c.getAnimal().getViande(0);
									c.setACadavre(false); 
								}
							}
						}
						break;		//une fois que l'animal s'est nourri on arrête la boucle (un animal ne se nourrit qu'une seule fois par tour
					}
				}
			}
		}
	}
}