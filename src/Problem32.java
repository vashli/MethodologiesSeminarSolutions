import acm.program.ConsoleProgram;

//32. დაწერეთ პროგრამა რომელიც იპოვის და დაბეჭდავს 1000000 მდე ყველა მერტივ რიცხვს
public class Problem32 extends ConsoleProgram{
	public void run(){
		int maxN = 1000000;
		for(int i = 2; i < maxN; i ++){
			boolean  iIsPrime = isPrime(i);
			if(iIsPrime){
				println(i);
			}
		}
		
	}
	
	public boolean isPrime(int num){
		boolean result = true; //version 2 - we can remove this line
		for (int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				result = false;
				break;
//				return false; //version 2 - instead of lines 20,21
			}
		}
		return result;
//		return true; //version 2 - instead of line 25
	}

}
