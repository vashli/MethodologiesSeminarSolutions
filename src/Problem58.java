//58. (2018 წლის გამოცდის ამოცანა)
//მატრიცას ეწოდება მაგიური თუკი ის კვადრატულია(n x n-ზე) და მასში 
//არის ყველა რიცხვი 1-დან n^2-ის ჩათვლით. თქვენი მიზანია დაწეროთ 
//magicMatrix მეთოდი რომელიც შეამოწმებს არის თუ არა მატრიცა მაგიური 
//და თუკი მაგიურია მაშინ
//დააბრუნებს true-ს თუ არა მაშინ false-ს. 

import acm.program.ConsoleProgram;

public class Problem58 extends ConsoleProgram{
	public void run() {
		
	}
	
//	three versions
	
//	for everyone check that sizes are n x n,
	
//	1 - loop from 1 to n**2 
//	and for each number check that it is in the matrix

//	2 -  create array of counts for each int from 1 to n**2
//	go through the matrix, check value of each element and increase
//	the value of the corresponding cell in counts array
//	every value from 1 to n**2 should be 1
	
//	3 
//	check that every num >= 1 and  <= n**2
//	check that every value is unique (for each value find
//	if other cell has same value)
	
	
	private boolean isMagicMatrix(int [][] matrix) {
//		matrix.length; // height
//		matrix[0].length; // width
		
		return false;
	}

}
