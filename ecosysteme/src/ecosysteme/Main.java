package ecosysteme;

public class Main {

	public static void main(String[] args) {
		
		
		Grille gr=new Grille(60);	
		
		gr.creationMontagne();
		gr.creationNeige(160);
		gr.creationForet(30);
		gr.creationBuisson(70);
		gr.creationSable();
		gr.creationRiviere();
		
		//gr.afficher();
		
		
		
/*
		JPanelGrille gl = new JPanelGrille(gr, 600 ,600);
*/
		
		System.out.println(gr.getCase(3,0));
		
	}

}
