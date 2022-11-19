import acm.program.ConsoleProgram;

//2. კონსოლიდან შემოდის ტექსტი. დაბეჭდეთ True თუ ტექსტში არსებული ყველა lowercase 
//ინგლისური ასო ზრდადობით არის დალაგებული, False თუ არაა. ტექსტში სხვა სიმბოლოებიც შეიძლება 
//შეგხვდეთ და იმათ ყურადღება არ მიაქციოთ.  მაგ: “a bcAAA!” -> true, “” -> true 
//“ABCDz,a” -> false
//Tags: String, char, charOperations, isLowerCase   

public class Practice02 extends ConsoleProgram{
	public void run(){
		while(true){
			String s = readLine("Enter text: ");
			println(isProperString(s));
		}
		
	}

	private boolean isProperString(String s) {
		char prevChar = 'a' - 1; // auto cast between char and int
		for(int i = 0; i < s.length(); i++){
			char currChar = s.charAt(i);
			if(Character.isLowerCase(currChar)){
				if(currChar <= prevChar){ // მკაცრად ზრდადია ტექსტი 
					return false;
				}
				prevChar = currChar;
			}
		}
		return true;
	}
}
