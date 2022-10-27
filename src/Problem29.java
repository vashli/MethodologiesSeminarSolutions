import acm.program.ConsoleProgram;
//29. მოხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს ფიბონაჩის მიმდევრობის
//მე n წევრი. 
// sequence: 0 1 1 2 3 5 8 13
public class Problem29 extends ConsoleProgram{
	public void run(){
		println("fib sequence: 0 1 1 2 3 5 8 13 21 ...");
		int n = readInt("enter n: ");
		
		int prev2 = 0;
		int prev1 = 1;
		int curr;
		
		if(n == 1){
			curr = 0;
		}else{ // used when n == 2
			curr = 1;
		}
		
		for(int i = 3; i <= n; i++){
			curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		
		println("member # " + n + " is: " +curr);
	}
}
