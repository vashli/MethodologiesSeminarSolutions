import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class StringSample extends ConsoleProgram{
	public void run() {
		String initial = "mariamii";
		println(initial.replace("ari", "T"));
		
		
		characterClassSample();
		substringSample();
		
	}
	private void charManipulationSample() {

//		char <-> int manipulations 
		println((int)'7');
		println((int)'7' - (int) '0');
		println('7' - '0');
		
		println((char)('7' - '0'));
		
		
		for(int i = 0; i < 26; i ++) {
			println((char)('a' + i));
		}
//		char <-> int manipulations 
		println((int)'7');
		println((int)'7' - (int) '0');
		println('7' - '0');
		
		println((char)('7' - '0'));
		
		
		for(int i = 0; i < 26; i ++) {
			println((char)('a' + i));
		}
	}
	
	private void tokenizerSample() {

		// String Tokenizer sample
		
		// \n -character for new line
		// \t -character for tab
		String text = "mari. 2, \n .  \t\t 3 4";
		
		StringTokenizer tokenizer = new StringTokenizer(text);
		
//		StringTokenizer tokenizer = new StringTokenizer(text,
//				" ,.");

//		StringTokenizer tokenizer = new StringTokenizer(text,
//				" ,.", true);
		
//		StringTokenizer tokenizer = new StringTokenizer(text,
//				" ,.", false);
		
		while(tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			println(currToken);
		}

	}
	private void characterClassSample() {
//		wrapper classes for primitive types
//		int - > Integer
//		double -> Double
//		char -> Character
		
//		static  vs non static method
		
//		obj.nonStaticMethod();
//		ClassName.staticMethod(obj);
		
		
		char ch = 'a';
		println(Character.isDigit(ch));
		println(Character.isDigit('9'));
		
//		ch.isDigit()
	}
	private void substringSample() {
		
		String text = "mari";
		String substr = text.substring(2); //ri
		String halfDelI = text.substring(0, 2) + 
				delIsInStr(text.substring(2));
		
		text = "mari";
		int index = text.indexOf("ari");
		String mariWithoutAri  = "mari".substring(0, index);
		
	}
	
	private String delIsInStr(String text) {
		text = text.replace("i", "");
		return text;
	}

	private void basicStringSample() {
		String str1 = "mari";
		String str2 = "mari";
		String str3 = new String("mari");
		String str4 = readLine("enter str4: ");
		
		println("1, 2 " + (str1 == str2) + " " + str1.equals(str2));
		println("1, 3 " + (str1 == str3) + " " + str1.equals(str3));
		println("1, 4 " + (str1 == str4) + " " + str1.equals(str4));
	
		
		// modification of the string
		// existing object does not change, new object is created
		// and saved in the same variable
		str1 = str1.substring(0, str1.length() - 1) + 'a';
		
		println("changed String variable: " + str1);
				
		println("length of the text(str1): " + str1.length());
		char firstChar = str1.charAt(0);
		println("first char of the text(str1): " + firstChar);
	
	}
}
