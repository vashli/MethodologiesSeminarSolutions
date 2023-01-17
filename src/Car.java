import acm.util.RandomGenerator;

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Car {
	private static final double KILOMETERS_PER_LITER = 2.3;

	private double gas;
	private double kms;
	private boolean isBroken;
	private RandomGenerator rgen;

	// კონსტრუქტორი
	public Car(int gas, int kms) {
		this.gas = gas;
		this.kms = kms;
		this.isBroken = false;
		this.rgen = RandomGenerator.getInstance();
	}

	// ცდილობს დაიქოქოს და გაიაროს
	public boolean turnOnAndDrive(int kmsToDrive) {
		if (!started()) {
			this.isBroken = true;
			return false;
		}

		double gasNeeded = kmsToDrive / KILOMETERS_PER_LITER;
		if (gasNeeded <= this.gas) {
			this.gas -= gasNeeded;
			this.kms += kmsToDrive;
			return true;
		}

		double currKms = this.gas * KILOMETERS_PER_LITER;
		this.kms += currKms;
		this.gas = 0;

		return false;
	}

	private boolean started() {
		if (this.kms < 10000) {
			return this.rgen.nextBoolean(0.9);
		} else if (this.kms < 20000) {
			return this.rgen.nextBoolean(0.8);
		} else if (this.kms < 30000) {
			return this.rgen.nextBoolean(0.7);
		} else if (this.kms < 40000) {
			return this.rgen.nextBoolean(0.6);
		} else if (this.kms < 50000) {
			return this.rgen.nextBoolean(0.5);
		} else if (this.kms < 60000) {
			return this.rgen.nextBoolean(0.4);
		} else if (this.kms < 70000) {
			return this.rgen.nextBoolean(0.3);
		} else if (this.kms < 80000) {
			return this.rgen.nextBoolean(0.2);
		} else if (this.kms < 90000) {
			return this.rgen.nextBoolean(0.1);
		}
		return false;
	}

	// აბრუნებს რამდენი კილომეტრი აქვს გავლილი მანქანას
	public int getMileage() {
		return (int) this.kms;
	}

	// აბრუნებს true-ს თუ მანქანა გაფუჭებულია, თუ არა false-ს
	public boolean isBrokenDown() {
		return this.isBroken;
	}

	// შეაკეთებს მანქანას, ანუ მანქანა აღარ იქნება გაფუჭებული და შეეძლება
	// გადაადგილება
	public void repair() {
		this.isBroken = false;
	}

	// დაამატებს შესაბამისი რაოდენობის ბენზინს მანქანის ავზს.
	public void fillGas(double numberOfLiters) {
		this.gas += numberOfLiters;
	}
}

// private int testCar(){
//
// }
