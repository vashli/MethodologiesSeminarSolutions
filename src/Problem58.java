//58. (2018 წლის გამოცდის ამოცანა)
//მატრიცას ეწოდება მაგიური თუკი ის კვადრატულია(n x n-ზე) და მასში 
//არის ყველა რიცხვი 1-დან n^2-ის ჩათვლით. თქვენი მიზანია დაწეროთ 
//magicMatrix მეთოდი რომელიც შეამოწმებს არის თუ არა მატრიცა მაგიური 
//და თუკი მაგიურია მაშინ
//დააბრუნებს true-ს თუ არა მაშინ false-ს. 

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem58 extends ConsoleProgram {
	public void run() {
		int[][] matrix1 = {
				{1, 2, 3},
				{9, 7, 8},
				{4, 5, 6}};
		int[][] matrix2 = {
				{1, 2, 3},
				{9, 7, 8},
				{4, 5, 10}};
		int[][] matrix3 = {
				{1, 2, 3},
				{4, 5, 6}};
		
		printMatrix(matrix1);
		println("isMagicMatrix1 : " + isMagicMatrix1(matrix1));
		println("isMagicMatrix2_3 : " + isMagicMatrix2_3(matrix1));
		printMatrix(matrix2);
		println("isMagicMatrix1 : " + isMagicMatrix1(matrix2));
		println("isMagicMatrix2_3 : " + isMagicMatrix2_3(matrix2));
		printMatrix(matrix3);
		println("isMagicMatrix1 : " + isMagicMatrix1(matrix3));
		println("isMagicMatrix2_3 : " + isMagicMatrix2_3(matrix3));
	}
	
// helper method
	private void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			println(Arrays.toString(row));
		}
	}
	
//	check that sizes are n x n,
//	1 - loop from 1 to n**2 
//	and for each number check that it is in the matrix
	private boolean isMagicMatrix1(int[][] matrix) {
		int n = matrix.length; // height
		int m = matrix[0].length; // width
		if (n != m) {
			return false;
		}

		for (int i = 1; i <= n * n; i++) {
			if (!containsNum(matrix, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean containsNum(int[][] matrix, int num) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}

	
//	check that sizes are n x n,
//	2 -  create array of counts for each int from 1 to n**2
//	go through the matrix, check value of each element and increase
//	the value of the corresponding cell in counts array
//	every value from 1 to n**2 should be 1

//	3 
//	check that every num >= 1 and  <= n**2
//	check that every value is unique (for each value find
//	if other cell has same value)
	private boolean isMagicMatrix2_3(int[][] matrix) {
		int nRows = matrix.length;
		int nCols = matrix[0].length;
		if (nRows != nCols) {
			return false;
		}

		int[] numCounts = new int[nRows * nRows + 1];

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				int num = matrix[i][j];
				if (num > 0 && num <= nRows * nRows && numCounts[num] == 0) {
					numCounts[num]++;
				} else {
					return false;
				}
			}
		}
		return true;

	}

}
