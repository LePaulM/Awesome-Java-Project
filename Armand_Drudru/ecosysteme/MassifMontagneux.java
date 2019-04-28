package ecosysteme;

public class MassifMontagneux extends Grille{
	
	/**
	 * Le constructeur de la classe, reutilisant le constructeur de la classe mere
	 * @param taille
	 */
	public MassifMontagneux(int taille) {
		super(taille);// appel au constructeur de sa classe mere : ''Grille''
	}
	
	/**
	 * Une methode qui cree la zone montagneuse de notre grille, l'explication de cette methode sera detaillee sur le rapport
	 */
	@Override
	public void creationMontagne() {
		// premier bloc
		double premiere=2*getTaille()/3; //premiere sequence, grand axe
		for(int x=0;x<=premiere;x++) {
			double a=(x*x);
			double b=(Math.pow(premiere,2));
			for(int y=0;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b));y++) { 
				getGrille()[x][y]=7;
			}
			}
		// deuxieme bloc
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=(int)(-(getTaille()/4)*Math.sqrt(1-(a/b))+2*(getTaille()/4)); y<=(getTaille()/2);y++) {
				getGrille()[x][y]=7;
			}
			}
		// troisieme bloc
		for(int x=0;x<=3*getTaille()/4;x++) {
			double a=(x*x);
			double b=(Math.pow(3*getTaille()/4,2));
			for(int y=getTaille()/2;y<=(int)(getTaille()/4)*Math.sqrt(1-(a/b))+getTaille()/2;y++) {
				getGrille()[x][y]=7;
			}
			}
		// quatrieme bloc
		for(int x=0;x<=4*getTaille()/5;x++) {
			double a=(x*x);
			double b=(Math.pow(4*getTaille()/5,2));
			for(int y=(int)((getTaille()/4)-(getTaille()/4)*Math.sqrt(1-(a/b))+3*getTaille()/4); y<getTaille();y++) {
				getGrille()[x][y]=7;
			}
			}
	}
	
	/**
	 * Une methode qui creer les rivieres qui partent de la montagne. Elles seront larges de trois cases sauf quand celles-ci sont sur une zone de montagne ou une zone de neige elles seront larges d'une case
	 */
	@Override
	public void creationEau() {
		//premiere riviere
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
		//seconde riviere
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
	
	/**
	 * Une methode qui cree le glacier au sommet de la montagne et un peu de neige dans les versants.
	 */
	public void creationNeige() {
		//creation du glacier
		for(int x=0;x<=(int)(this.getTaille()/4)*0.6;x++) {
			for(int y=0;y<(int)(this.getTaille());y++){
				getGrille()[x][y]=5;
			}
		}
		//creation de neige de facon aleatoire dans la montagne.
		int neige=(int)(getTaille()*100/30);
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
	
	/**
	 * Quantitee de buissons et d'arbres dans l'ecosysteme MassifMontagneux ---> a mettre absolument dans une methode ??
	 */
	int arbre = (int)(Math.pow(getTaille(),2)*5/(21*100));
	int buisson=(int)70*getTaille()/100;
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		
		MassifMontagneux massif = new MassifMontagneux(getTaille());
		
		massif.creationMontagne();	
		massif.creationNeige();
		massif.creationArbre(arbre);
		massif.creationBuisson(buisson);
		massif.creationEau();
		massif.afficher();
	}
	
	

	
	
	
}
