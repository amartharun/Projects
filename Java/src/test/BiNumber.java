package test;

public class BiNumber {

	private int i = 10;
	private int j = 20;

	public BiNumber(int i, int j) {
		this.i = i;
		this.j = j;
	}

	// TODO Auto-generated constructor stub }

	public int add() {
		// TODO Auto-generated method stub
		return i + j;
	}

	public int mul() {
		return i * j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;

	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void doubleValue() {
		// TODO Auto-generated method stub
		this.i *= 2;
		this.j *= 2;

	}

}
