package ecosysteme;

public class Steppe extends Grille{

	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public Steppe(int taille) {
		super(taille);
	}

	@Override
	/**
	 * methode qui creer des petits lacs. Le nombre de lacs dependant directement de la taille de la grille donc pas de parametres en entree.
	 * Ces lacs sont de taille 3*3, repartits aleatoirement dans l'espace, ce lac ne peuvent pas entierement se superposer.
	 */
	public void creationEau() {
		int i=0;
		while(i<(int)getTaille()/10) {
			double a=Math.random()*getTaille();
			double b=Math.random()*getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille()[x][y]==2) {
				continue;
			}
			if((x-1)<0 || (x+1)>(getTaille()-1) || (y-1)<0 || (y+1)>(getTaille()-1)) { //gestion des bordures
				continue;
			}
			getGrille()[x-1][y-1]=2;
			getGrille()[x-1][y]=2;
			getGrille()[x-1][y+1]=2;
			getGrille()[x][y-1]=2;
			getGrille()[x][y]=2;
			getGrille()[x][y+1]=2;
			getGrille()[x+1][y-1]=2;
			getGrille()[x+1][y]=2;
			getGrille()[x+1][y+1]=2;
			i=i+1;
		}
	}

	/**
	 * Quantitee de buissons l'ecosysteme Steppe ---> a mettre absolument dans une methode ??
	 */
	int buisson = (int)Math.pow(getTaille(),2)*5/100;

	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		Steppe  steppe= new Steppe(getTaille());

		steppe.creationBuisson(buisson);
		steppe.creationEau();
		steppe.afficher();
	}

}
