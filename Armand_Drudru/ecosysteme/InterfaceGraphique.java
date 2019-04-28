package ecosysteme;


import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class InterfaceGraphique extends JFrame{
	
	/**
	 * Grille du jeu 
	 */
	public Grille grille;
	
	/**
	 * Largeur de l'interface graphique
	 */
	public int largeur;
	
	/**
	 * hauteur de l'interface graphique
	 */
	public int hauteur;
	
	/**
	 * Map des images des icones associes avec leur nom
	 */
	public HashMap<String,ImageIcon> icones;

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Construteur
	 * @param grille grille sur laquelle se trouve les animaux
	 * @param largeur largeur de l'ecran en pixel 
	 * @param hauteur hauteur de l'ecran en pixel
	 */
	public InterfaceGraphique (Grille grille, int largeur, int hauteur){
		super("Simulation Fourmiliere");
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.grille  = grille;
		setSize(largeur, hauteur);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JPanelGrille(grille, largeur, hauteur));
		setVisible(true);
	}
	
	
	/**
	 * Fonction permettant de rafaichir l'affichage
	 */
	public void rafraichir (){
		//on vide le jpanel
		this.getContentPane().removeAll();
		//on le reconstuit a partir de la grille mise a jour
		((JPanelGrille)this.getContentPane()).construire();
		this.getContentPane().revalidate();
	}
	
}
