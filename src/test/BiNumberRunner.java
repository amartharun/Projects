package test;

public class BiNumberRunner {

	public static void main(String[] args) {
		BiNumber number = new BiNumber(2, 3);
		System.out.println(number.add());
		System.out.println(number.mul());
		number.doubleValue();
		System.out.println(number.getI());
		System.out.println(number.getJ());
	}

}
