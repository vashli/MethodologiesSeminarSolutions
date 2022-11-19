import acm.program.ConsoleProgram;

//13. დაწერეთ მეთოდი, რომელსაც გადაეცემა ნატურალური რიცხვი და აბრუნებს შეიძლება თუ არა 
//ეს რიცხვი წარმოვადგინოთ რომელიმე ორი სხვა ნატურალური  რიცხვის კვადრატების ჯამის სახით.
//მაგ: 26 - > true (5^2 + 1^2) 30 -> false
//Tags: Math, 

public class Practice13 extends ConsoleProgram {
	public void run() {
		while (true) {
			int n = readInt("Enter number: ");
			println(isSumOfSquares(n));
		}
	}

	private boolean isSumOfSquares(int n) {
		int sqrt = (int) Math.sqrt(n); // both of the numbers will be less than sqrt
//		println(sqrt);
		for (int i = 1; i <= sqrt; i++){
			int iSquare = i*i;
			for (int j = i; j <= sqrt; j++){ // we only need to check numbers >= i
				int jSquare = j*j;
//				println(i + ", " + j + ": " + iSquare + ", " + jSquare);
				if (iSquare + jSquare == n){
					return true;
				}else if(iSquare + jSquare > n){
					break; // we don't need to check for i and k > j
				}
			}
		}
		
		return false;
	}
}
