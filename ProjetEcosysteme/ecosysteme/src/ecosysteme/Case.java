package ecosysteme;

public class Case {
	
	private int typeOccupation;
	private boolean estvide;
	private boolean cadavre;
	private int position[];
	
	public Case() {};
	
	public int getTypeOccupation() {
		return typeOccupation;
	}

	public boolean estVide() {
		return estvide;
	}

	public boolean isCadavre() {
		return cadavre;
	}

	public int[] getPosition() {
		return this.position;
	}
	
	public int getX() {
		return this.position[0];
	}
	
	public int getY() {
		return this.position[1];
	}

	public void setX(int x) {
		this.position[0] = x;
	}
	
	public void setY(int y) {
		this.position[1] = y;
	}

	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estvide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}

	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estvide = b;
	}
	
}
