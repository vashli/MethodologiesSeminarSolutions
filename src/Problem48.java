import acm.program.ConsoleProgram;

//48. კონსოლიდან შეგყვავს ტექსტი პროგრამამ უნდა დაბეჭდოს სტატისტიკა რომელი სიმბოლო
//რამდენჯერ გვხვდება

public class Problem48 extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter String: ");
		for(int i = 0; i < str.length(); i++){
			if(isFirstOccurence(str, i)){
				int count = countCharInStr(str, str.charAt(i));
				println(str.charAt(i) + ": " + count);
			}
		}
		
	}

	private boolean isFirstOccurence(String str, int index){
		char currChar = str.charAt(index);

		for(int i = 0; i < index; i++){
			if(str.charAt(i) == currChar){  
				return false;
			}
		}
		return true;
	}
	
	private int countCharInStr(String str, char ch) {
		int cnt = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(ch == str.charAt(i)){
				cnt++;
			}
		}
		
		return cnt;
	}
}
