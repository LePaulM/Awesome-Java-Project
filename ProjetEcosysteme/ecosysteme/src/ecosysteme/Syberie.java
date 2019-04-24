package ecosysteme;


public class Syberie extends Grille{

	public Syberie(int taille) {
		super(taille);
	}
 
	@Override
	public void creationNeige() {
		int neige=(int)(getTaille()*100/70);
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
	
	@Override
	public void creationMontagne() {
		for(int x=0;x<=(int)(getTaille()/2)*0.6;x++) {
			for(int y=0;y<=(int)(1.7*Math.sqrt(Math.pow(getTaille()/2,2)-Math.pow(x/0.6,2)));y++){
				getGrille()[x][y]=7;
			}
		}
	}
	
	
	/**
	 * ok ca c'est bon
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
	
	int foret = (int)Math.pow(getTaille(),2)*50/(21*100);
	int buisson = (int)getTaille()*0/100;
	
	@Override
	public void creationGrille() {
		Syberie syberie = new Syberie(getTaille());
		
		syberie.creationMontagne();	
		syberie.creationForet(foret);
		syberie.creationNeige();
		syberie.creationEau();
		syberie.afficher();
	}
	
	
}
