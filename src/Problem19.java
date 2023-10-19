//19. კონსოლიდან წაიკითხეთ მთელი რიცხვი n და შემდეგ n ჯერ დაბეჭდეთ “hello ” + i, სადაც i
//იცვლება 0 დან n-1 მდე.

import acm.program.ConsoleProgram;

public class Problem19 extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		for (int i = 0; i < n; i++) {
			println("hello " + i);
		}
	}
	
	private void ippVsPpi() {
		int i = 0;	
		println(i++);
		
		int j = 0;
		println(++j);
	}
	
	private void differentLoops() {
		
		for (int i = 0; isBlue(i); ++i) {
			print(i);
			print("/mari/");
			println("hello " + i);
			
			
//			every line works the same
//			i++;
//			i = i + 1;
//			i += 1;
		}
		print("loop ended");
	}

	private boolean isBlue(int n) {
		return n % 2 == 0;
	}
}
