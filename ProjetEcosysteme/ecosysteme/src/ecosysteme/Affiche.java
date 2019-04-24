package ecosysteme;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import src.Visualisation.Grille;
import src.Visualisation.HashMap;
import src.Visualisation.ImageIcon;
import src.Visualisation.String;

public class Affiche extends JFrame{
	ImageIcon X,O;
	private static final long serialVersionUID = 1L;

	private Grille grille;
	
	private int tailleCote;

	private HashMap<String, ImageIcon> icones;

	private int hauteur;

	private int largeur;
	
	public Affiche(Grille grille, int largeur ,int hauteur) {
		super();
		this.icones = new HashMap<String,ImageIcon>();
		this.tailleCote = grille.getTaille();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.grille  = grille;
		
		//creation et stockage des icones necessaires a l'affichage
		icones.put("X", this.creerIcone("X.PNG"));
		icones.put("O", this.creerIcone("O.PNG"));
	
	}
}