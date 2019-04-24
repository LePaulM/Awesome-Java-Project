package ecosysteme;

import java.awt.Color;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.HashMap;

/*
public class GLayout extends JFrame{

    public GLayout(){

        JPanel container = new JPanel();

        this.setTitle("Ecosysteme");

        this.setSize(600,600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new GridLayout(3,3));
        
        container.add(new JPanel());
        container.add(new JFrame());
        container.setBackground(Color.BLUE);
        this.setContentPane(container);

        this.setVisible(true);

    }

    public static void main(String[] args) {

        GLayout gl = new GLayout();

    }

}
*/
public class JPanelGrille extends JPanel{

	
	private static final long serialVersionUID = 1L;

	/**
	 * Grille sur laquelle se deplacer les animaux
	 */
	private Grille grille;
	
	/**
	 * Nombre de case du cote de grille
	 */
	private int tailleCote;

	/**
	 * Dictionnaire des icones 
	 */
	private HashMap<String, ImageIcon> icones;

	/**
	 * Hauteur en pixels
	 */
	private int hauteur;

	/**
	 * Largeur en pixels
	 */
	private int largeur;

	

	/**
	 * Objet de type JPanel permettant de representer une grille et ses occupants  
	 * @param grille objet Grille a representer
	 * @param largeur largeur en pixels
	 * @param hauteur hauteur en pixels
	 */
	public JPanelGrille(Grille grille, int largeur ,int hauteur) {
		super();
		this.icones = new HashMap<String,ImageIcon>();
		this.tailleCote = grille.getTaille();
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.grille  = grille;
		
		//creation et stockage des icones necessaires a l'affichage
		icones.put("Arbre", this.creerIcone("tilleul-arbre.jpg"));
	
		this.construire();		
	}
	
	/**
	 * Fonction permettant de creer l'icone d'une image qui pourra s'afficher sur la grille
	 * @param nom de l'image (entre guillemets)
	 * @return l'image en miniature
	 */
	public ImageIcon creerIcone(String nom) {
		return new ImageIcon(new ImageIcon(this.getClass().getResource(nom)).getImage().getScaledInstance(largeur/tailleCote, hauteur/tailleCote, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Fonction permettant d'ajouter a un JPanel une icone representant la nature de la case
	 * @param Case objet case dont on souhaite creer l'icone 
	 */
	public void ajouterIconeCase(Case Case){
		this.add(new JLabel(icones.get("Arbre")));
	}
	
	/**
	 * Fonction permettant le remplissage duJPanel avec les icones correspondant a la grille
	 */
	public void construire(){
		setLayout(new GridLayout(tailleCote,tailleCote));
		for(int i = 0;i < tailleCote * tailleCote; i++){
			int abscisse = i/tailleCote + 1;
			int ordonnee = i%tailleCote + 1;
			int a=this.grille.getCase(abscisse,ordonnee);
			//ajouterIconeCase(case);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ajouterIconeCase(int occupation){
		this.add(new JLabel(icones.get("Arbre")));
	}
	
	
/*	
	public void construire(){
		setLayout(new GridLayout(tailleCote,tailleCote));
		for(int i = 0;i<=tailleCote; i++){
			for(int j=0;j<=tailleCote;j++) {
				int occupation=this.grille.getCase(i,j);
			}
		}
	}
	*/
}
