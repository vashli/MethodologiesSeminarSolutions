import acm.util.RandomGenerator;
//ამოცანა 5. (35 ქულა) მანქანა
//ა) (25 ქულა)
//თქვენი ამოცანაა დაწეროთ Car კლასი, რომელიც აკონტროლებს რამდენი კილომეტრი გაიარა მანქანამ, რამდენი ბენზინი აქვს ავზში და არის თუ არა გაფუჭებული. Car ტიპის ობიექტის შექმნა შეგიძლიათ თუკი გადასცემთ ბენზინის რაოდენობას ავზში და მანქანის საწყის კილომეტრაჟს. მაგალითად:
//Car myCar = new Car(10, 1000);  // 10 ლიტრი, 1000 კილომეტრი გავლილი
//მთავარი მეთოდი, რომელიც Car კლასს აქვს არის turnOnAndDrive, რომელსაც გადაეცემა თუ რამდენი კილომეტრი უნდა გაიაროს მანქანამ და რომელიც დაქოქავს მანქანას, გაივლის კილომეტრებს და გამორთავს. ამ მეთოდმა შემდეგი რამ უნდა გააკეთოს.
//⦁	ყოველი მანქანის დაქოქვისას შანსია, რომ მანქანა გაფუჭდეს. თუკი მანქანას გავლილი აქვს 0-დან 10000 კილომეტრამდე, მაშინ გაფუჭების შანსია 10%. თუკი გავლილი აქვს 10000-დან 20000 კილომეტრამდე მაშინ გაფუჭების შანსია 20% და ა.შ. თუკი მანქანა გაფუჭდა მაშინ ის ვერ გაივლის.
//⦁	თუკი მანქანა წარმატებით დაიქოქა, მაშინ მან უნდა გაიაროს იმდენი კილომეტრი დამდენიც გადაეცა პარამეტრად. სიარულის დროს მანქანა ბენზინს ხარჯავს და შესაბამისი რაოდენობის ბენზინი უნდა მოაკლდეს(მოცემული გაქვთ KILOMETERS_PER_LITER კონსტანტა - ერთი ლიტრი ბენზინით რამდენი კილომეტრის გავლა შეუძლია მანქანას).
//⦁	თუკი მანქანას სიარული შეუძლია მაგრამ მას არ აქვს საკმარისი ბენზინი, მანქანა ივლის მანამ სანამ ბენზინი არ გამოელევა.
//⦁	მეთოდმა უნდა დააბრუნოს true თუკი მანქანამ წარმატებით გაიარა გადაცემული კილომეტრები, წინააღმდეგ შემთხვევაში უნდა დააბრუნოს false(თუკი გაფუჭდა ან ბენზინი არ ეყო).
//თქვენ უნდა დააიმპლემენტიროთ შემდეგი მეთოდები
//public boolean turnOnAndDrive(int kmsToDrive) //ცდილობს დაიქოქოს და გაიაროს
//public int getMileage() // აბრუნებს რამდენი კილომეტრი აქვს გავლილი მანქანას
//public boolean isBrokenDown() // აბრუნებს true-ს თუ მანქანა გაფუჭებულია, თუ არა false-ს
//public void repair() // შეაკეთებს მანქანას, ანუ მანქანა აღარ იქნება გაფუჭებული და შეეძლება გადაადგილება
//public void fillGas(double numberOfLiters) // დაამატებს შესაბამისი რაოდენობის ბენზინს მანქანის ავზს.
//
//ბ) (10 ქულა)
//მას შემდეგ რაც Car კლასის იმპლემენტაცია დაწერეთ თქვენი ამოცანაა გატესტოთ რამდენად გამძლეა ეს მანქანა. ამისათვის უნდა დაწეროთ testCar მეთოდი, რომელიც შექმნის ახალ მანქანას, შეამოწმებს და დააბრუნებს რამდენი კილომეტრის გავლა შეძლო მანქანამ სანამ პირველად არ გაფუჭდა.
//მანქანამ უნდა დაიწყოს 10 ლიტრი ბენზინით და 0 საწყისი კილომეტრაჟით. ის უნდა გადაადგილდეს 10-10 კილომეტრით ყოველ ჯერზე. ყოველი ბენზინის გამოლევაზე მასში უნდა ჩაასხათ 10 ლიტრი. როგორც კი მანქანა გაფუჭდება დააბრუნეთ რამდენი კილომეტრის გავლა შეძლო მან.
//ამოხსნა დაწერეთ car.java ფაილში

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2Car {
	private static final double KILOMETERS_PER_LITER = 2.3;

	private double gas;
	private double kms;
	private boolean isBroken;
	private RandomGenerator rgen;

	// კონსტრუქტორი
	public Final2021Session2Car(int gas, int kms) {
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
