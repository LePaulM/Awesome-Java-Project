package ecosysteme;

/**
 * C'est la grille standard, pas touche on verra plus tard cette classe, 
 * @author formation
 *
 */

public class Standard extends Grille {

	
	
	public Standard(int taille) {
		super(taille);
	}
	
	/**
	 * méthode qui crée la neige divisée en deux parties :
	 * la premiere qui remplie le "sommet" de la zone montagneuse entierement de neige
	 * la seconde qui ajoute de la neige aleatoirement sur les autres parties de la zone montagneuse
	 */
	@Override
	public void creationNeige(int neige) {
		for(int x=0;x<=(int)(getTaille()/4)*0.6;x++) {
			for(int y=0;y<=(int)(1.7*Math.sqrt(Math.pow(getTaille()/4,2)-Math.pow(x/0.6,2)));y++){
				getGrille()[x][y]=5;
			}
		}
		
		int i=0;
		while(i<neige) {
			double a=Math.random()*getTaille();
			double b=Math.random()*getTaille();
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
	 * méthode qui crée la zone montagneuse
	 */
	@Override
	public void creationMontagne() {
		for(int x=0;x<=(int)(getTaille()/2)*0.6;x++) {
			for(int y=0;y<=(int)(1.7*Math.sqrt(Math.pow(getTaille()/2,2)-Math.pow(x/0.6,2)));y++){
				getGrille()[x][y]=7;
			}
		}
	}
	
	/**
	 * méthode qui crée la rivière, c'est une simple riviere qui 
	 */
	@Override
	public void creationEau() {
		int y=(int)this.getTaille()/3;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille()[x][y-1]==7||getGrille()[x][y-1]==5) { // si la rivière traverse la montagne ou la neige, elle sera plus petite
				getGrille()[x][y]=2;
			}
			else { // sinon elle possède une taille normale
				getGrille()[x][y-1]=2;
				getGrille()[x][y]=2;
				getGrille()[x][y+1]=2;
			}
		}
	}
	
	
}
