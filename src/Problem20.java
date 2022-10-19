import acm.program.ConsoleProgram;
//20. კონსოლიდან წაიკითხეთ n, შემდეგ წაიკითხეთ n ცალი მთელი რიცხვი და დაბეჭდეთ ჯამი
public class Problem20 extends ConsoleProgram{
	public void run(){
		int n = readInt("Enter number of addends: ");
		int sum = 0;
		for (int i = 0; i < n; i++){
			int a = readInt("Enter new addend: ");
			sum += a; // same as sum = sum + a; 
			// println(sum);
		}
		println("Sum: " + sum);
	}
}
