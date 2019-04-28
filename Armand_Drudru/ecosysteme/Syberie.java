package ecosysteme;


public class Syberie extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Syberie(int taille) {
		super(taille);
	}

	/**
	 * Methode qui cree une repartition aleatoire de neige dans la grille, la neige va remplir 70% de la grille. Seule regle : lors de la generation de case neige, la neige ne peut pas aller sur de la neige deja presente
	 */
	@Override
	public void creationNeige() {
		int neige=(int)(Math.pow(getTaille(), 2)*70/100);
		int i=0;
		while(i<neige) {
			double a=Math.random()*getTaille();
			double b=Math.random()*getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille()[x][y]==5) {
				continue;
			}
			if (getGrille()[x][y]==2) {
				continue;
			}
			getGrille()[x][y]=5;
			i=i+1;
		}
	}
	
	/**
	 * Methode qui cree une petite zone de montagne dans le coin en haut a gauche
	 */
	@Override
	public void creationMontagne() {
		double a = getTaille()*0.2;//axe des x
		double b = getTaille()*0.8;//axe des y
		for(int x=0;x<=(int)(a);x++) {
			for(int y=0;y<=(int)(b*Math.sqrt(1-((x*x)/(a*a))));y++){
				getGrille()[x][y]=7;
			}
		}
	}
	
	
	/**
	 * methode qui creer un cours d'eau avec plusieurs ramifications, crees independemments sous forme de troncons
	 */
	@Override
	public void creationEau() {
	/**
	* troncon 1
	*/
	for(int x=(int)getTaille()/7;x<=(int)3*getTaille()/7;x++) {
			int y=(int)getTaille()/4;
			getGrille()[x][y-1]=2;
			getGrille()[x][y]=2;
			getGrille()[x][y+1]=2;
		}
	/**
	 * troncon 2
	*/
	for(int x=(int)3*getTaille()/7-2;x<=(int)5*getTaille()/7;x++) {
		int y=(int)getTaille()/4+3;
		getGrille()[x][y-1]=2;
		getGrille()[x][y]=2;
		getGrille()[x][y+1]=2;
	}
	/**
	 * troncon 3
	 */
	for(int y=(int)getTaille()/4+5;y<=(int)2*getTaille()/4;y++) {
		int x=(int)5*getTaille()/7-1;
		getGrille()[x-1][y]=2;
		getGrille()[x][y]=2;
		getGrille()[x+1][y]=2;
	}
	/**
	 * troncon 4
	 */
	for(int x=(int)5*getTaille()/7-2;x<(int)getTaille();x++) {
		int y=(int)2*getTaille()/4+2;
		getGrille()[x][y-1]=2;
		getGrille()[x][y]=2;
		getGrille()[x][y+1]=2;
	}
	/**
	 * troncon 5
	 */
	for(int y=(int)getTaille()/4+3;y<=(int)3*getTaille()/4;y++) {
		int x=(int)getTaille()/2;
		getGrille()[x-1][y]=2;
		getGrille()[x][y]=2;
		getGrille()[x+1][y]=2;
	}
}
	
	/**
	 * Quantitee de arbres l'ecosysteme Siberie ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)Math.pow(getTaille(),2)*70/(21*100);
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		Syberie syberie = new Syberie(getTaille());
		
		syberie.creationMontagne();	
		syberie.creationArbre(arbre);
		syberie.creationNeige();
		syberie.creationEau();
		syberie.afficher();
	}
	
	
}
