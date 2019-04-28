package ecosysteme;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;


public abstract class Grille {
	
	/**
	 * attribut qui gere la taille de notre grille carree
	 */
	private int taille;
	
	/**
	 * attribut qui gere la grille, sous forme de matrice
	 */
	private int[][] grille;

    
	/**
	 * Les getter
	 * @return taille, grille
	 */
    
	public int getTaille() {
		return taille;
	}

	public int[][] getGrille() {
		return grille;
	}

	/**
	 * constructeur de la grille sous forme de matrice
	 * @param taille
	 */
	public Grille(int taille) {
		this.taille=taille;
		grille = new int[this.taille][this.taille];

		for(int i=0;i<this.taille;i++) {
			for ( int j=0;j<this.taille;j++) {
				grille[i][j]=0 ;
			}
		}
	}

	
	/**
	 * une methode qui permet de modifier une case de la grille
	 */
	public void modifier(int x, int y, int z){
		this.grille[x][y]=z;
	}

	
	/**
	 * Une methode qui cree les buissons, applicable a toutes les classes filles, c'est une génération dans l'espace aléatoirement d'une quantitee de buisson definie en parametre. Lors de la creation de la grille un buisson ne peut etre place ni sur un autre buisson, ni sur aucun autre sol excepte l'herbe et le sable.
	 * @param buisson
	 */
	public void creationBuisson(int buisson) {

		int i=0;
		while(i<buisson) {
			double a=Math.random()*this.taille;
			double b=Math.random()*this.taille;
			int x=(int)a;
			int y=(int)b;
			if(this.grille[x][y]==1 || this.grille[x][y]==2 || this.grille[x][y]==7 || this.grille[x][y]==5
					|| this.grille[x][y]==3) {
				continue;
			}
			this.grille[x][y]=1;
			i=i+1;
		}
	}

	/**
	 * Une methode qui cree les arbres, applicable a toutes les classes filles, c'est une génération dans l'espace aléatoirement d'une quantitee d'arbre definie en parametre. Un arbres est grand et donc occupe plusieurs cases. Lors de la creation de la grille un arbre ne peut etre place sur aucun autre sol excepte l'herbe, le sable et les buissons, il ne peut superposer que legerment un autre arbre.
	 * @param arbre
	 */
	public void creationArbre(int arbre) {
		int i=0;
		while(i<arbre) {
			double a=Math.random()*this.taille;
			double b=Math.random()*this.taille;
			int x=(int)a;
			int y=(int)b;
			if((x-2)<0 || (x+2)>(this.taille-1) || (y-2)<0 || (y+2)>(this.taille-1)) {
				continue;
			}
			
			if(this.grille[x][y]==3 ||
			this.grille[x-1][y-1]==3 ||
			this.grille[x-1][y]==3 ||
			this.grille[x-1][y+1]==3 ||
			this.grille[x][y-1]==3 ||
			this.grille[x][y+1]==3 ||
			this.grille[x+1][y-1]==3 ||
			this.grille[x+1][y]==3 ||
			this.grille[x+1][y+1]==3 ||
			this.grille[x][y]==7 || 
			this.grille[x][y]==5 ||
			this.grille[x][y]==2
			)  {
				continue;
			}
			
			this.grille[x][y]=3;
			this.grille[x-1][y-1]=3;
			this.grille[x-1][y]=3;
			this.grille[x-1][y+1]=3;
			this.grille[x][y-1]=3;
			this.grille[x][y+1]=3;
			this.grille[x+1][y-1]=3;
			this.grille[x+1][y]=3;
			this.grille[x+1][y+1]=3;
			this.grille[x-2][y-1]=3;
			this.grille[x-2][y]=3;
			this.grille[x-2][y+1]=3;
			this.grille[x-1][y-2]=3;
			this.grille[x][y-2]=3;
			this.grille[x+1][y-2]=3;
			this.grille[x+2][y-1]=3;
			this.grille[x+2][y]=3;
			this.grille[x+2][y+1]=3;
			this.grille[x-1][y+2]=3;
			this.grille[x][y+2]=3;
			this.grille[x+1][y+2]=3;
			i=i+1;
		}
	}

	/**
	 * Une methode qui permet de cree du sable selon deux regles, l'ajout de sable ne peut se faire que sur de l'herbe et doit etre distant
	 * de cases d'un arbre
	 */ 
	public void creationSable(){
		for(int x=2;x<=this.taille-3;x++) {
		for(int y=2;y<=this.taille-3;y++) {
		if( this.grille[x][y]==0 &&
				this.grille[x+2][y]!=3 &&
				this.grille[x+2][y+2]!=3 &&
				this.grille[x][y+2]!=3 &&
				this.grille[x-2][y+2]!=3 &&
				this.grille[x-2][y]!=3 &&
				this.grille[x-2][y-2]!=3 &&
				this.grille[x][y-2]!=3 &&
				this.grille[x+2][y-2]!=3) {
			this.grille[x][y]=4;
		}
		}
		}
	}
	
	//ouai ca tu laisse je le degagerai plus tard
	
	/*c'est la creation de riviere aleatoire
	public void creationGrille() {


		int y = (int) Math.random()*(this.taille-1);
		int x = 0;
		this.grille[x][y]=2;


		while (x<this.taille) {

		int[] t1 = {x,y-1};
		int[] t2 = {x+1,y};
		int[] t3 = {x,y+1};

		List<int[]> liste = new ArrayList<int[]>();
		liste.add(t1);
		liste.add(t2);
		liste.add(t3);

		int indiceAuHasard = (int) (Math.random() * (liste.size()));

		if(y<=0) {
			continue;
		}

		else if(y>=this.taille) {
			continue;
		}

		this.grille[liste.get(indiceAuHasard)[0]][liste.get(indiceAuHasard)[1]]=2;
		x=liste.get(indiceAuHasard)[0];

		}
	}
	 */
	
	/**
	 * methodes abstraite redefinie dans les classes filles
	 */
	public abstract void creationNeige();
	public abstract void creationEau();
	public abstract void creationMontagne();
	
	
	/**
	 * Une methode (ou getter ??) qui recupere le contenu de la grille a une position (x,y)
	 * @param x
	 * @param y
	 * @return
	 */
	public int getCase(int x, int y) {
		return this.grille[x][y];
	}
	
	/**
	 * Une Methode permettant de creer la grille a partir des methodes precedentes, un ordre particulier de ces methode sera choisi (......)
	 */
	public  abstract void creationGrille();

	/**
	 * Une methode qui afficher la grille dans la console, ce n'est pas l'interface graphique.
	 */
	public void afficher() {
		for(int i=0;i<this.taille;i++) {
			for ( int j=0;j<this.taille;j++) {
				System.out.print(grille[i][j]+"");
			}
			System.out.println(" ");
		}
	}

}
