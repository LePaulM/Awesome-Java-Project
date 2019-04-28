package ecosysteme;

public class Savane extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Savane(int taille) {
		super(taille);
	}
	

	/**
	 * creation des zones d'eau, dans ce biome ce sera un lac en forme de cercle. Ce cercle est cree en quatres parties, une meilleure explication dans le rapport
	 */
	@Override
	public void creationEau() {
		/*
		int y=(int)this.getTaille()/3;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille()[x][y-1]==7||getGrille()[x][y-1]==5) {
				getGrille()[x][y]=2;
			}
			else {
				getGrille()[x][y-1]=2;
				getGrille()[x][y]=2;
				getGrille()[x][y+1]=2;
			}
		}
		*/
		//quart en haut a gauche
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				getGrille()[x][y]=2;
			}
			}
		//quart en bas a gauche
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				getGrille()[x][y]=2;
			}
			}
		//quart en haut a droite
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--){
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				getGrille()[x][y]=2;
			}
			}
		//quart en bas a droite
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				getGrille()[x][y]=2;
			}
			}
			
	}
	
	/**
	 * Quantitee de buissons et d'arbres dans l'ecosysteme Savane ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)Math.pow(getTaille(),2)*5/(21*100);
	int buisson=(int)70*getTaille()/100;
	
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		Savane savane = new Savane(getTaille());
		
		savane.creationArbre(arbre);
		savane.creationBuisson(buisson);
		savane.creationSable();
		savane.creationEau();
		savane.afficher();
	}
	
	
	
}
