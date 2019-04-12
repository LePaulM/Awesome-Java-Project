package ecosysteme;

public class Case {
	
	private int typeOccupation;
	private boolean estvide;
	private boolean cadavre;
	private int position[][];
	
	
	
	public int getTypeOccupation() {
		return typeOccupation;
	}

	public boolean isEstvide() {
		return estvide;
	}

	public boolean isCadavre() {
		return cadavre;
	}

	public int[][] getPosition() {
		return position;
	}

	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[][] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estvide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}
	
}
