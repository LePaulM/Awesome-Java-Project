package ecosysteme;

public class MassifMontagneux extends Grille{

	public MassifMontagneux(int taille) {
		super(taille);
	}
	
	
	@Override
	public void creationMontagne() {
		double premiere=2*getTaille()/3; //premiere sequence, grand axe
		for(int x=0;x<=premiere;x++) {
			double a=(x*x);
			double b=(Math.pow(premiere,2));
			for(int y=0;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b));y++) { 
				getGrille()[x][y]=7;
			}
			}
		
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=(int)(-(getTaille()/4)*Math.sqrt(1-(a/b))+2*(getTaille()/4)); y<=(getTaille()/2);y++) {
				getGrille()[x][y]=7;
			}
			}
		
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=getTaille()/2;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b))+getTaille()/2;y++) {
				getGrille()[x][y]=7;
			}
			}
		
		for(int x=0;x<=4*getTaille()/5;x++) {
			double a=(x*x);
			double b=(Math.pow(4*getTaille()/5,2));
			for(int y=(int)((getTaille()/4)-(getTaille()/4)*Math.sqrt(1-(a/b))+3*getTaille()/4); y<getTaille();y++) {
				getGrille()[x][y]=7;
			}
			}
	}
	
	@Override
	public void creationEau() {
		int y=(int)this.getTaille()/4;
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
		int v=(int)3*this.getTaille()/4;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille()[x][v-1]==7||getGrille()[x][v-1]==5) {
				getGrille()[x][v]=2;
			}
			else {
				getGrille()[x][v-1]=2;
				getGrille()[x][v]=2;
				getGrille()[x][v+1]=2;
			}
		}
	}
	
	
	public void creationNeige() {
		int neige=(int)(getTaille()*100/30);
		for(int x=0;x<=(int)(this.getTaille()/4)*0.6;x++) {
			for(int y=0;y<(int)(this.getTaille());y++){
				getGrille()[x][y]=5;
			}
		}
		
		int i=0;
		while(i<neige) {
			double a=Math.random()*this.getTaille();
			double b=Math.random()*this.getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille()[x][y]==5) {
				continue;
			}
			if (getGrille()[x][y]==7) {
				getGrille()[x][y]=5;
			}
			i=i+1;
		}
	}
	
	
	int foret = (int)Math.pow(getTaille(),2)*50/(21*100);
	int buisson=(int)70*getTaille()/100;
	
	@Override
	public void creationGrille() {
		MassifMontagneux massif = new MassifMontagneux(getTaille());
		
		massif.creationMontagne();	
		massif.creationNeige();
		massif.creationForet(foret);
		massif.creationBuisson(buisson);
		massif.creationEau();
		massif.afficher();
	}
	
	

	
	
	
}
