import java.util.Arrays;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;
//ამოცანა 1. (15 ქულა) ცუდსორტი
//თქვენი ამოცანაა ზრდადობით დაალაგოთ მთელი რიცხვების მასივი შემდეგი ალგორითმით:
//მანამ სანამ მასივი არ დალაგდება შემთხვევით აირჩიეთ მასივის ორი ელემენტი და თუკი მარცხნივ მდგომი ელემენტი მეტია მარჯვნივ მდგომ ელემენტზე მაშინ მათ ადგილები გაუცვალეთ.
//ამისათვის დაწერეთ badsort მეთოდი რომელსაც გადაეცემა მასივი და რომელიც ასორტირებს ამ მასივს(ყურადღება მიაქციეთ, რომ მეთოდი არაფერს არ აბრუნებს).
//ამოხსნა დაწერეთ badsort.java ფაილში

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2BadSort extends ConsoleProgram {

	public void run() {
		int[] arr = { 5, 4, 3, 2, 2 };
		badsort(arr);
		print(Arrays.toString(arr));
	}

	private void badsort(int[] arr) {
		RandomGenerator rgen = RandomGenerator.getInstance();
		while (!sorted(arr)) {
			int a = rgen.nextInt(0, arr.length - 1);
			int b = rgen.nextInt(0, arr.length - 1);

			int min = Math.min(a, b);
			int max = Math.max(a, b);
			if (arr[min] > arr[max]) {
				swap(arr, min, max);
			}
		}
	}

	private void swap(int[] arr, int min, int max) {
		int tmp = arr[min];
		arr[min] = arr[max];
		arr[max] = tmp;
	}

	private boolean sorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

}
