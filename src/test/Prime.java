package test;

public class Prime {

	private int number;
	boolean total;

	public Prime(int number) {
		// TODO Auto-generated constructor stub
		this.number=number;
	}

	public boolean isPrime() {

		return false;
	}

	public int sum() {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<=number;i++) {
			sum=sum+i;

		}
		return sum;
	}

	public int divisor() {
		int sum=0;
		for(int i=2;i<number-1;i++) {
			if(number%i==0) {
				sum=sum+i;
			}
		}
		return sum;
	}

	public void printTriangle() {
		// TODO Auto-generated method stub
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"");
			}
			System.out.println();
		}
		


	}
}


