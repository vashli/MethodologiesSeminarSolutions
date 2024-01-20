import acm.program.ConsoleProgram;

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2CarTst extends ConsoleProgram {
	public void run() {
		print(testCar());
	}

	private int testCar() {
		Final2021Session2Car myCar = new Final2021Session2Car(10, 0);
		while (!myCar.isBrokenDown()) {
			boolean drove = myCar.turnOnAndDrive(10);
			if (!drove && !myCar.isBrokenDown()) {
				myCar.fillGas(10);
				println("Gas needed, kms: " + myCar.getMileage());
			}
		}

		return myCar.getMileage();
	}
}
