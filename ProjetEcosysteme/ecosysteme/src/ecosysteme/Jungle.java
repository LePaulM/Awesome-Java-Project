package ecosysteme;

public class Jungle extends Grille{

	public Jungle(int taille) {
		super(taille);
	}


	@Override
	public void creationMontagne() {
		
	}
	
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
	
	@Override
	public void creationNeige() {
		
	};
	
	
	int foret = (int)Math.pow(getTaille(),2)*80/(21*100);
	int buisson = (int)getTaille()*50/100;
	@Override
	public void creationGrille() {
		Jungle  jungle = new Jungle(getTaille());
		
		jungle.creationMontagne();	
		jungle.creationNeige();
		jungle.creationForet(foret);
		jungle.creationBuisson(buisson);
		jungle.creationEau();
		jungle.afficher();
	}
	
	
}
