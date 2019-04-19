package animaux;

import java.awt.Color;

/**
 * 
 * @author Louise
 *
 */


public abstract class Animal {
	private int dateNaissance;
	private int dateDeces;
	private boolean accesForet;
	private int esperanceVie;
	private Case emplacement;
	private int vitesse;
	private boolean estVivant;
	private int tpDecomposition;
	private String espece;
	public Color couleur;
	private int tailleEstomac;
	private int remplissageEstomac;
	private int viande;
	private int maturite;
	private boolean aProcree;
	private int meurtFaim;

	/**
	 * Constructeur	
	 * @param dateNaissance : int numéro du tour où l'animal est né
	 * @param dateDeces : int numéro du tour où l'animal décède (change chaque tour jusqu'à sa mort)
	 * @param accesForet : boolean disant si l'animal a accès ou non à la foret 
	 * @param esperanceVie : int donnant l'espérance de vie de cet animal (en nombre de tours)
	 * @param emplacement : objet de type Case sur laquelle se trouve l'animal
	 * @param vitesse : int donnant le nombre de cases dont se déplace l'animal par tour
	 * @param vivant : boolean : True si l'animal est vivant, False s'il est mort
	 * @param tpDecomposition : int temps que l'animal met à disparaitre après sa mort. Laisse du temps aux charognards pour manger le cadavre
	 * @param espece : String espece de l'animal. Seuls deux animaux de la même espece peuvent se reproduire
	 * @param couleur : Color couleur de l'animal sur la carte
	 * @param tailleEstomac : int si remplissageEstomac est au niveau de tailleEstomac l'animal est à  satiété (max de nourriture que l'animal peut ingurgiter
	 * @param remplissageEstomac : int définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 * @param viande : quantité de viande disponible à la mort de l'animal
	 * @param maturite : définit l'age auquel l'animal est assez grand pour se reproduire
	 * @param aProcree : si l'animal a procréé récemment 
	 */
	
	public int getDateNaissance() {
		return dateNaissance;
	}
	
	public void setDateNaissance(int dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public int getDateDeces() {
		return dateDeces;
	}
	
	public void setDateDeces(int dateDeces) {
		this.dateDeces = dateDeces;
	}
	
	public int getEsperanceVie() {
		return esperanceVie;
	}
	
	public void setEsperanceVie(int esperanceVie) {
		this.esperanceVie = esperanceVie;
	}
	
	public Case getEmplacement() {
		return emplacement;
	}
	
	public void setEmplacement(int emplacement){
		this.emplacement = emplacement;
	}
	
	public int getVistesse() {
		return this.vitesse;
	}
	
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	
	public boolean getEstVivant() {
		return estVivant;
	}
	
	public void setEstVivant(boolean etat) {
		this.estVivant = etat;
	}
	
	public int getTempsDecomposition() {
		return this.tpDecomposition;
	}
	
	public void setTempsDecomposition(int tpDecomposition) {
		this.tpDecomposition = tpDecomposition;
	}
	
	public String getEspece() {
		return this.espece;
	}
	
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	public Color getColor() {
		return this.couleur;
	}
	
	public void setColor(Color couleur) {
		this.couleur = couleur;
	}
	
	public int getTailleEstomac() {
		return this.tailleEstomac;
	}

	public void setTailleEstomac(int tailleEstomac) {
		if(tailleEstomac < 0) {
			this.tailleEstomac = 0;
		} else {
			this.tailleEstomac = tailleEstomac;
		}
	}

	public int getRemplissageEstomac() {
		return this.remplissageEstomac;
	}

	public void setRemplissageEstomac(int remplissageEstomac) {
		if (remplissageEstomac >= tailleEstomac) {
			this.remplissageEstomac = tailleEstomac;
		}
		else if(remplissageEstomac < 0) {
			this.remplissageEstomac = 0;
		} else {
			this.remplissageEstomac = tailleEstomac;
		}
	}
	
	public int getViande() {
		return this.viande;
	}
	
	public void setViande(int viande) {
		this.viande = viande;
	}
	
	public int getMaturite() {
		return this.maturite;
	}
	
	public void setMaturite(int maturite) {
		this.maturite = maturite;
	}
	
	public boolean getAProcree() {
		return this.aProcree;
	}
	
	public void setAProcree(boolean aProcree) {
		this.aProcree = aProcree;
	}
	
	public int getMeurtFaim() {
		return this.meurtFaim;
	}
	
	public void setMeurtFaim(int meurtFaim) {
		this.meurtFaim = meurtFaim;
	}


	public Animal(int dateNaissance, int dateDeces, boolean accesForet, Case emplacement, int vitesse, boolean estVivant,
			int tpDecomposition, String espece, Color couleur, int tailleEstomac,int remplissageEstomac, int viande, int maturite,
			boolean aProcree,int meurtFaim) {
		setDateNaissance(dateNaissance);;
		setDateDeces(dateDeces);;
		this.accesForet = accesForet;
		setEmplacement(emplacement);;
		setVitesse(vitesse);
		setEstVivant(etat);;
		setTempsDecomposition(tpDecomposition);;
		setEspece(espece);;
		setColor(couleur);
		setTailleEstomac(tailleEstomac);
		setRemplissageEstomac(remplissageEstomac);
		setViande(viande);
		setMaturite(maturite);
		setAProcree(aProcree);
		setMeurtFaim(meurtFaim);
	}


	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. 
	 * La case sur laquelle il est diminue également en quantité de nourriture.
	 */
	public void seNourrir() {
		if (this.emplacement.typeOccupation.equals('Herbe') || this.emplacement.typeOccupation.equals('Buisson') || this.emplacement.typeOccupation.equals('Foret') ){
			if (tailleEstomac!=remplissageEstomac) {
				remplissageEstomac = setRemplissageEstomac(remplissageEstomac + this.emplacement.nourriture);
				//				modifier état de la case			
			}
		}
	}



	/**
	 * Cette méthode déplace l'animal sur une case, à l'aide d'un Random pour la direction (et en fonction de l'occupation déjà faite 
	 * des cases alentours) et de sa vitesse
	 */
	//	public void seDeplacer(Case emplacement) {	
	//	
	//	}

	/**
	 * 	Une fois qu'un animal est décédé, il a un certain nombre de tours pour se décomposer, qui est réduit si un charognard le mange.
	 * 	Cette méthode gère la décomposition et fait disparaitre l'animal de la case.
	 */
	public void seDecomposer(){}

	/**
	 * 	Cette méthode permet à 2 animaux de la même espèce de se reproduire s'ils sont sur des cases adjacentes et de produire ainsi 
	 *  un nouvel animal de la même espèce.
	 */
	public abstract void seReproduire();

	/**
	 * Cette méthode s'active à chaque tour pour véréfier que l'animal est en bonne santé. 
	 * Si l'estomac de l'animal est vide, elle lui compte un certain nombre de tours avant qu'il ne meure.
	 */
	public void famine() {
		if(this.remplissageEstomac == 0) {

		}
	}

	/**
	 * 	
	 */

	//	public Case getEmplacement {	}


}
