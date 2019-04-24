package ecosysteme;

public class Steppe extends Grille{

	public Steppe(int taille) {
		super(taille);
	}
	
	@Override
	/**
	 * ok ca c'est bon
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
			if((x-1)<0 || (x+1)>(getTaille()-1) || (y-1)<0 || (y+1)>(getTaille()-1)) {
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
	
	public void creationNeige(int neige) {
		
	}
	
	public void creationMontagne() {
		
	}
	
	public void creationForet() {
		
	}
	

	int buisson = (int)Math.pow(getTaille(),2)*10/100;
	@Override
	public void creationGrille() {
		Steppe  steppe= new Steppe(getTaille());
		
		steppe.creationBuisson(buisson);
		steppe.creationEau();
		steppe.afficher();
	}
	
}
