package ecosysteme;

public class Savane extends Grille{

	public Savane(int taille) {
		super(taille);
	}
	

	/**
	 * creation des zones d'eau, dans ce monde ce sera un lac
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
		
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				getGrille()[x][y]=2;
			}
			}
		
		
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325-Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.2*getTaille());y<=(int)(0.325*getTaille());y++) {
				getGrille()[x][y]=2;
			}
			}
		
		for(int x=(int)(0.325*getTaille());x>=(int)(0.2*getTaille());x--){
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				getGrille()[x][y]=2;
			}
			}
		
		for(int x=(int)(0.325*getTaille());x<=(int)(0.45*getTaille());x++) {
			for(int y=(int)(0.325*getTaille());y<=(int)(Math.sqrt(Math.pow(0.125*getTaille(),2)-Math.pow(x-0.325*getTaille(),2))+0.325*getTaille());y++) { 
				getGrille()[x][y]=2;
			}
			}
			
	}
	
	@Override
	public void creationNeige() {
		
	};
	
	@Override
	public void creationMontagne() {
		
	};
	
	
	int foret = (int)Math.pow(getTaille(),2)*50/(21*100);
	int buisson=(int)70*getTaille()/100;
	
	@Override
	public void creationGrille() {
		Savane savane = new Savane(getTaille());
		
		//savane.creationForet(foret);
		//savane.creationBuisson(buisson);
		//savane.creationSable();
		savane.creationEau();
		savane.afficher();
	}
	
	
	
}
