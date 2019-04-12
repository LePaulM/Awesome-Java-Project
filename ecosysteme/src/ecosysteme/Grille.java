package ecosysteme;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;


public class Grille {
	/**
	 * attributs qui gerent la taille de notre grille carree, et la grille elle meme
	 */
	private int taille;
	private int[][] grille;



	public int getTaille() {
		return taille;
	}

	/**
	 * constructeur de la grille
	 * @param taille
	 */
	public Grille(int taille) {
		this.taille=taille;
		grille = new int[this.taille][this.taille];

		for(int i=0;i<this.taille;i++) {
			for ( int j=0;j<this.taille;j++) {
				grille[i][j]=0;
			}
		}
	}



	/**
	 * modifier case
	 */
	public void modifier(int x, int y, int z){
		this.grille[x][y]=z;
	}


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


	public void creationRiviere() {
		int y=(int)this.taille/3;
		for(int x=(int)this.taille/9;x<this.taille;x++) {
			if(this.grille[x][y-1]==7||this.grille[x][y-1]==5) {
				this.grille[x][y]=2;
			}
			else {
				this.grille[x][y-1]=2;
				this.grille[x][y]=2;
				this.grille[x][y+1]=2;
			}
		}
	}
	

	public void creationForet(int foret) {
		int i=0;
		while(i<foret) {
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
			this.grille[x][y]==5)  {
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

	
	
	public void creationMontagne() {
		for(int x=0;x<=(int)(this.taille/2)*0.6;x++) {
			for(int y=0;y<=(int)(1.7*Math.sqrt(Math.pow(this.taille/2,2)-Math.pow(x/0.6,2)));y++){
				this.grille[x][y]=7;
			}
		}
	}

	
	
	public void creationNeige(int neige) {
		for(int x=0;x<=(int)(this.taille/4)*0.6;x++) {
			for(int y=0;y<=(int)(1.7*Math.sqrt(Math.pow(this.taille/4,2)-Math.pow(x/0.6,2)));y++){
				this.grille[x][y]=5;
			}
		}
		
		int i=0;
		while(i<neige) {
			double a=Math.random()*this.taille;
			double b=Math.random()*this.taille;
			int x=(int)a;
			int y=(int)b;
			if(this.grille[x][y]==5) {
				continue;
			}
			if (this.grille[x][y]==7) {
				this.grille[x][y]=5;
			}
			i=i+1;
		}
	}

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
	/*
	 *c'est la creation de riviere aleatoire
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

	public int getCase(int x, int y) {
		return this.grille[x][y];
	}
	
	
	

	/**
	 * méthode afficher la grille
	 */
	public void afficher() {
		for(int i=0;i<this.taille;i++) {
			for ( int j=0;j<this.taille;j++) {
				System.out.print(grille[i][j]);
			}
			System.out.println(" ");
		}
	}





}
