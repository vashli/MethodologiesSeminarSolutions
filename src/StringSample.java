import acm.program.ConsoleProgram;

public class StringSample extends ConsoleProgram{
	public void run() {
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
