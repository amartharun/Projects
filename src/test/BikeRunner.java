package test;

public class BikeRunner {

	public static void main(String[] args) {

		Bike ktm = new Bike();
		Bike bullet = new Bike();

		ktm.start();
		bullet.start();

		ktm.setSpeed(100);

		ktm.increaseSpeed(100);

		System.out.println(ktm.getSpeed());
		// bullet.setSpeed(120);

	}

}
