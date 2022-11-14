package test;

public class PrimeRunner {
	public static void main(String[] args) {
		
		Prime prime=new Prime(6);
		//System.out.print(prime.isPrime());
		int sumOfAdd =prime.sum();
		System.out.println(sumOfAdd);
		int sumDivisor =prime.divisor();
		System.out.println(sumDivisor);
		prime.printTriangle();
		

	}
}
