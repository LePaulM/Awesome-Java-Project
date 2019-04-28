package ecosysteme;

public enum Ecosysteme {
SAVANE(50,10,5,5,30,0,0),
JUNGLE(0,10,20,70,0,0,0),
SIBERIE(0,0,10,20,0,0,70),
MONTAGNE(0,0,10,0,0,60,30),
STEPPE(80,0,20,0,0,0,0),
STANDART(20,10,5,20,15,20,10);
	
	private int herbe;
	private int buisson;
	private int riviere;
	private int foret;
	private int sable;
	private int montagne;
	private int neige;
	
	private Ecosysteme(int herbe, int buisson, int riviere, int foret, int sable, int montagne, int neige) {
		this.herbe = herbe;
		this.buisson = buisson;
		this.riviere = riviere;
		this.foret = foret;
		this.sable = sable;
		this.montagne = montagne;
		this.neige = neige;
	}

	public int getHerbe() {
		return herbe;
	}

	public int getBuisson() {
		return buisson;
	}

	public int getRiviere() {
		return riviere;
	}

	public int getForet() {
		return foret;
	}

	public int getSable() {
		return sable;
	}

	public int getMontagne() {
		return montagne;
	}

	public int getNeige() {
		return neige;
	}
		
}
