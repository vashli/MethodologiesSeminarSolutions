import acm.program.ConsoleProgram;

//ამოცანა 1. ლოგარითმი (15 ქულა)
//თქვენი ამოცანაა დაწეროთ მეთოდი რომელიც ლოგარითმს გამოითვლის. 
//შეგახსენებთ რომ ლოგარითმი n-ის ფუძით m არის რიცხვი რომელ ხარისხშიც უნდა ავიყვანოთ n
//იმისათვის რომ m მივიღოთ. ანუ, თუ
//n^x =m , მაშინ  xის მთელი ნაწილია შედეგი.
//n ^ x  > m
//log(5 ,25)  =2
//5, 26
//დაწერეთ მეთოდი log რომელსაც გადაეცემა 2 მთელი რიცხვი და რომელიც აბრუნებს ამ რიცხვებითვის ლოგარითმის მთელ ნაწილს.
//თქვენ არ გავთ უფლება გამოიყენოთ Math კლასი. შესაბამისად ვერ გამოიყენებთ მეთოდებს log, log10, log1p, pow და ა.შ.
//ჩათვალეთ, რომ m>n>0.

public class Midterm1 extends ConsoleProgram {
	public void run() {
		println(log(2, 8)); // უნდა დაბეჭდოს 3
		println(log(2, 12)); // უნდა დაბეჭდოს 3
		println(log(3, 8)); // უნდა დაბეჭდოს 1

		println("n: " + 2 + " m: " + 8 + ", expected: 3" + ", got: " + log(2, 8));
		println("n: " + 2 + " m: " + 12 + ", expected: 3" + ", got: " + log(2, 12));
		println("n: " + 3 + " m: " + 8 + ", expected: 1" + ", got: " + log(3, 8));
		println("n: " + 3 + " m: " + 3 + ", expected: 1" + ", got: " + log(3, 3));
		println("n: " + 5 + " m: " + 125 + ", expected: 3" + ", got: " + log(5, 125));
		println("n: " + 4 + " m: " + 64 + ", expected: 3" + ", got: " + log(4, 64));
		println("n: " + 2 + " m: " + 16 + ", expected: 4" + ", got: " + log(2, 16));
		println("n: " + 2 + " m: " + 17 + ", expected: 4" + ", got: " + log(2, 17));
		println("n: " + 4 + " m: " + 15 + ", expected: 1" + ", got: " + log(4, 15));
		println("n: " + 2 + " m: " + 64 + ", expected: 6" + ", got: " + log(2, 64));
	}

	private int log(int n, int m) {
		if (n == 1) return -1;

		for (int i = 0; i <= m; i++) {
			if (pow(n, i) == m) {
				return i;
			} else if (pow(n, i) > m) {
				return i - 1;
			}
		}
		
		return -1;
	}

	private int pow(int n, int i) {
		int res = 1;
		for (int j = 0; j < i; j++) {
			res *= n; // res = res * n;
		}
		return res;
	}

	// version 2
//	private int log(int n, int m) {
//		if (n == 1)return -1;
//		
//		int number = n;
//		int power = 0;
//		while (number <= m) {
//			number *= n;
//			power++;
//		}
//		return power;
//	}

}
