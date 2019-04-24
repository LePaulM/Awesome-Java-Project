package animaux;

import java.awt.Color;
import java.util.ArrayList;
import java.util.stream.IntStream;

import Gestion.Gestionnaire;
import ecosysteme.Case;
import ecosysteme.Grille;



public abstract class Animal {
	int id;
	private int dateNaissance;
	private int dateDeces;
	protected boolean accesForet;
	protected int esperanceVie;
	private Case emplacement;
	protected int vitesse;
	private boolean estVivant;
	private int tpDecomposition;
	private String espece;
	public Color couleur;
	protected int tailleEstomac;
	private int remplissageEstomac;
	protected int viande;
	private int maturite;
	private boolean aProcree;
	private int meurtFaim;

	/**
	/**
	 * Constructeur	
	 * @param id : identifiant de l'individu, cet identifiant permet au gestionnaire de faire "jouer" les individus
	 * @param dateNaissance : int numéro du tour où l'animal est né
	 * @param dateDeces : int numéro du tour où l'animal décède (change chaque tour jusqu'à sa mort)
	 * @param emplacement : objet de type Case sur laquelle se trouve l'animal
	 * @param tpDecomposition : int temps que l'animal met à disparaitre après sa mort. Laisse du temps aux charognards pour manger le cadavre
	 * @param couleur : Color couleur de l'animal sur la carte
	 * @param remplissageEstomac : int définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 * @param maturite : définit l'age auquel l'animal est assez grand pour se reproduire
	 * @param aProcree : si l'animal a procréé récemment 
	 * @param meurtFaim : Indique le nombre de tours restants lorsque l'animal est en état de famine
	 */


	// il faut changer famine() de place dans les diagrammes de sequence
	//ca ne sert à rien de faire des tests sur des animaux mort - Paul

	public Animal(int dateNaissance,  Case emplacement,
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {

		this.id = Gestionnaire.getAnimaux().size() + 1;
		this.dateNaissance = dateNaissance;
		this.emplacement = emplacement;
		this.estVivant = true;
		this.tpDecomposition = tpDecomposition;
		this.couleur = couleur;
		this.remplissageEstomac = tailleEstomac/2 % 1;
		this.maturite = maturite;
		this.aProcree = aProcree;
		this.meurtFaim = meurtFaim;
	}

	/**
	 * getters et setters
	 */
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public void setEmplacement(Case emplacement){
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
		this.remplissageEstomac = this.remplissageEstomac + remplissageEstomac;
		if (remplissageEstomac >= this.tailleEstomac) {
			this.remplissageEstomac = this.tailleEstomac;
		}
		else if(remplissageEstomac < 0) {
			this.remplissageEstomac = 0;
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

	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. 
	 * La case sur laquelle il est diminue également en quantité de nourriture.
	 * Elle est définie dans les classes Carnivore, Charognard et Herbivore
	 */
	public abstract void seNourrir() ;

	/**
	 * Cette méthode déplace l'animal sur une case, à l'aide d'un Random pour la direction (et en fonction de l'occupation  
	 * des cases alentours) et de sa vitesse
	 */
	public void seDeplacer() {
		int direction=(int)(Math.random() * 9);					// 		on choisit un nombre entre 1 et 9 qui determinera quelle direction suivra l'animal
		if (direction==1) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX() - this.vitesse,this.getEmplacement().getY() + this.vitesse);		//		on définit ce qui sera la prochaine case
			if (caseSuivante.estVide() == true) {				//		si la case est vide
				this.setEmplacement(caseSuivante);				// 		on y va
				caseSuivante.setEstVide(false);					//		la case n'est plus vide
			}													//		si la case n'est pas vide l'animal ne bouge pas?
		}
		if(direction==2) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX(),this.getEmplacement().getY()+this.vitesse);
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
			}
		}
		if(direction==3) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY()+this.vitesse);
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);

				caseSuivante.setEstVide(false);
			}
		}
		if(direction==4) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX()-this.vitesse,this.getEmplacement().getY());
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
			}
		}
		if(direction==5) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY());
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
			}
		}
		if (direction==6) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX()-this.vitesse,this.getEmplacement().getY()-this.vitesse);
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
			}
		}
		if(direction==7) {
			Case caseSuivante = Grille.getCase1(this.getEmplacement().getX(),this.getEmplacement().getY()-this.vitesse);
			if (caseSuivante.estVide() == true) {
				this.setEmplacement(caseSuivante);
				caseSuivante.setEstVide(false);
			}
		}
		Case caseSuivante = Grille.getCase1(this.getEmplacement().getX()+this.vitesse,this.getEmplacement().getY()-this.vitesse);
		if (caseSuivante.estVide() == true) {
			this.setEmplacement(caseSuivante);
			caseSuivante.setEstVide(false);
		}
	}				

	/**
	 * 	Cette méthode permet à 2 animaux de la même espèce de se reproduire s'ils sont sur des cases adjacentes et de produire ainsi 
	 *  un nouvel animal de la même espèce.
	 */
	public void seReproduire() {
		if (this.estVivant == false) {
			break;
			if (this.aProcree == true) {
				break;
			} else {
				//		Définition des cases adjacentes
				Case case1 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()-1);
				Case case2 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()-1);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()-1);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY());
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY());
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()+1);
				Case case7 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()+1);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()+1);
				//		Création de la liste des cases adjacentes
				ArrayList<Case> cases=new ArrayList<Case>(case1,case2,case3,case4,case5,case6,case7, case8);
				for (Case c : cases){ 
					if (cases(c).estVide == false) {									//			Si une des cases adjacentes n'est pas vide, 
						if (cases(c).getAnimal().getEspece().equals(this.espece))		//			et si l'animal présent sur la case adjacente est de la même espèce, 
							this.aProcree = true;										// 			la variable permettant de savoir si l'animal a procree devient true
						for (Case cbis : cases){										// 			on cherche ensuite  
							if (cases(cbis).estVide == true) {							//			une case vide 
								Animal animal = new Animal(Gestionnaire.getTour(),cbis,
										this.tpDecomposition,  this.couleur, this.tailleEstomac/2,  this.maturite,	// pour créer un nouvel individu
										this.aProcree,this.meurtFaim);
								Gestionnaire.addAnimal(animal);								// on ajoute l'animal au gestionnaire
								break;														//			l'animal se reproduit et arrête de vérifier 
							}
						}
					}
				}
			}
		}
	}
	/**
	 * Cette méthode s'active si l'estomac de l'animal est vide. Elle lui compte un certain nombre de tours avant qu'il 
	 * ne meure de faim.
	 */
	public boolean famine() {
		if (estVivant == false) {					// si l'animal est decedé 
			break;									// on passe à la suite du tour
		} else if (remplissageEstomac == 0) {		// sinon si l'estomac est vide
			meurtFaim = meurtFaim - 1;				// le compteur qui dit combien de temps l'animal peut vivre sans manger prend - 1
			if (meurtFaim == 0) {					// si ce compteur atteint zéro
				return true;						// cette fonction renvoie true et il mourra au prochain tour
			}					
			else return false;						// sinon on passe à la suite du tour

		}
	}


	/**
	 * cette méthode s'active lorsque l'animal décède
	 * elle gère le décès de l'animal
	 */
	public void decede() {

		this.setEstVivant(false);					// on dit que l'animal n'est plus vivant
		this.setDateDeces(Gestionnaire.tour);		// on enregistre la date du deces
		this.emplacement.setEstVide(true);			// la case devient vide (il n'y a plus d'animal dessus)
		this.emplacement.setACadavre(true);			// la case a un cadavre maintenant
	}

	/**
	 * 	Une fois qu'un animal est décédé, il a un certain nombre de tours pour se décomposer, qui est réduit si un charognard le mange.
	 * 	Cette méthode gère la décomposition et fait disparaitre l'animal de la case et donc de la grille.
	 * Cette fonction est lancée dans le getionnaire à chaque début de tour
	 */
	public void seDecomposer(){
		if (this.getEmplacement().getACadavre() == true) {		// on vérifie que l'animal ne s'est pas encore décomposé

			//		une fois que la viande arrive à 0 l'animal disparait de la case
			// 		on met le test avant l'action de faire perdre de la viande à l'animal
			//		pour ne pas que le gestionnaire fasse perdre de la viande à un animal déjà décomposé
			// si la viande est déjà à 0 alors on ne décompose pas l'animal et on ne met plus le aCadavre de la case sur false

			if (viande == 0 || viande < 0) {
				this.viande = 0;
				break;
			}
			//		l'animal perd jusqu'à 2 de viande par tour
			// on met un deucième test ici pour éviter que si il y a 2 animaux morts sur la même case 
			// l'un d'eux ne se décompose pas si aCadavre prend faux à chaque tour
			this.viande = this.viande - (Gestionnaire.getTour() - this.dateDeces)%2;
			if (viande == 0 || viande < 0) {
				this.viande = 0;
				this.getEmplacement().setACadavre(false);
				break;
			}
		}
	}
}