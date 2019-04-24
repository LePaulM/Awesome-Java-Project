package AffichageGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Personnalise extends JDialog {
	private boolean sendData;
	private JLabel nomLabel, tplateauLabel, ecostmeLabel, tpsLabel,tpsLabel2, nbreAnimauxLabel, nbreAnimauxLabel2, icon;
	private JRadioButton tranche1, tranche2, tranche3, tranche4;
	private JComboBox tplateau, ecostme;
	private JTextField nom, nbreAnimaux,tps;
	private String environnementChoisi;
	boolean okclique = false;

	//private String nom;


	public Personnalise(){

	}
	public Personnalise(String nom){
		JPanel container = new JPanel();
		JLabel buisson = new JLabel("Buisson");
		JLabel eau = new JLabel("Eau");
		JLabel foret = new JLabel	("Foret"); 
		JLabel montagne = new JLabel	("Montagne");
		JLabel neige = new JLabel ("Neige");
		JLabel sable = new JLabel ("Sable");
		JLabel terrainNu = new JLabel ("Terrain nu");
		JLabel herbe = new JLabel ("Herbe");
		JFormattedTextField amountBuisson = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountEau = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountForet = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountMontagne = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountNeige = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountSable = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountTerrainNu = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField amountHerbe = new JFormattedTextField(NumberFormat.getIntegerInstance());
		
		JButton okBouton = new JButton("OK");

		//this.nom.setText(nom);
		JFrame perso = new JFrame();
		//Définit un titre pour notre fenêtre
		perso.setTitle("Personalisé");
		//Définit sa taille : 400 pixels de large et 100 pixels de haut
		perso.setSize(1400, 250);
		//Nous demandons maintenant à notre objet de se positionner au centre
		perso.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		perso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		//SpringLayout layout = new SpringLayout();
		container.setBackground(Color.BLUE);
		container.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		//top.setLayout(layout);
		JPanel grid = new JPanel();
		//On définit le layout à utiliser sur le content pane
	    //Trois lignes sur deux colonnes
		GridLayout gl = new GridLayout(2, 4);		// cette gridlayout sert à la mise en page des différents éléments de la Frame
		grid.setLayout(gl);
		gl.setHgap(10); //Dix pixels d'espace entre les colonnes (H comme Horizontal)
		gl.setVgap(10); //Dix pixels d'espace entre les lignes (V comme Vertical) 
		top.setLayout(new FlowLayout());
		
		
		Font police = new Font("Arial", Font.BOLD, 14);
		grid.add(buisson, BorderLayout.WEST);
		amountBuisson.setFont(police);
		amountBuisson.setPreferredSize(new Dimension(150, 30));
		amountBuisson.setForeground(Color.BLACK);
		grid.add(amountBuisson);
		grid.add(eau, BorderLayout.CENTER);
		amountBuisson.setFont(police);
		amountBuisson.setPreferredSize(new Dimension(150, 30));
		amountBuisson.setForeground(Color.BLACK);
		grid.add(amountEau);
		grid.add(foret, BorderLayout.WEST);
		amountForet.setFont(police);
		amountForet.setPreferredSize(new Dimension(150, 30));
		amountForet.setForeground(Color.BLACK);
		grid.add(amountForet);
		grid.add(montagne, BorderLayout.EAST);
		amountMontagne.setFont(police);
		amountMontagne.setPreferredSize(new Dimension(150, 30));
		amountMontagne.setForeground(Color.BLACK);
		grid.add(amountMontagne);
		grid.add(neige, BorderLayout.CENTER);
		amountNeige.setFont(police);
		amountNeige.setPreferredSize(new Dimension(150, 30));
		amountNeige.setForeground(Color.BLACK);
		grid.add(amountNeige);
		grid.add(sable, BorderLayout.WEST);
		amountSable.setFont(police);
		amountSable.setPreferredSize(new Dimension(150, 30));
		amountSable.setForeground(Color.BLACK);
		grid.add(amountSable);
		grid.add(terrainNu, BorderLayout.EAST);
		amountTerrainNu.setFont(police);
		amountTerrainNu.setPreferredSize(new Dimension(150, 30));
		amountTerrainNu.setForeground(Color.BLACK);
		grid.add(amountTerrainNu);
		grid.add(herbe, BorderLayout.CENTER);
		amountHerbe.setFont(police);
		amountHerbe.setPreferredSize(new Dimension(150, 30));
		amountHerbe.setForeground(Color.BLACK);
		grid.add(amountHerbe);
		top.add(grid);
		container.add(top);

		okBouton.setSize(100, 30);
		top.add(okBouton);
		perso.setContentPane(container);
		perso.setVisible(true); 

		
		okBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}


	/**
	 * Rédéfinition de la méthode toString. 
	 */
	@Override
	public String toString(){
		return "çaaaa fonctioooooooonnne !!!!!!!";
	}

	public boolean getSendData() {
		return sendData;
	}

	public void setSendData(boolean sendData) {
		this.sendData = sendData;
	}

}
