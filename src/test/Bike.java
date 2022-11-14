package test;

public class Bike {

	private int speed;

	void setSpeed(int speed) {
		if (speed > 0) {
			this.speed = speed;
		} else {
			System.out.println("Negative");
		}

	}

	public void increaseSpeed(int howMuch) {
		setSpeed(this.speed + howMuch);
	}

	int getSpeed() {
		// System.out.println(speed);
		return speed;
	}

	void start() {
		System.out.println("Started");
	}

}
