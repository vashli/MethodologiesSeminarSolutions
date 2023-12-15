
//59. (2018 წლის გამოცდის ამოცანა - 30 ქულა)
//გადმოგეცემათ nxm-ზე მატრიცა რომელშიც მხოლოდ 0-ები და 1-ები წერია. მეთოდმა
//უნდა დააბრუნოს ამ მატრიცის ყველაზე დიდი ქვემართკუთხედის
//ზომა(ელემენტების რაოდენობა) რომელიც მხოლოდ 1-ებისგან შედგება.
//მაგალითად:
//01100100
//01111100
//00111100
//00111100
//ამ მატრიცაში ყველაზე დიდი შიდა მართკუთხედი, რომელიც სულ ერთიანებისგან
//შედგება არის 12 ზომის:
//01100100
//01111100
//00111100
//00111100
//შესაბამისად ამ მატრიცაზე მეთოდმა უნდა დააბრუნოს 12. ჩათვალეთ რომ
//გადმოცემულ მატრიცაში ერთი უჯრა მაინც იქნება რომელშიც წერია 1.

import java.util.Arrays;
import java.util.Stack;

import acm.program.ConsoleProgram;

public class Problem59 extends ConsoleProgram {

	public void run() {
		int[][] matrix1 = new int[][] {
			{0,1,1,0,0,1,0,0}, 
			{0,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0}, 
			{0,0,1,1,1,1,0,0},
		};
		int[][] matrix2 = new int[][] {
			{0,1,1,1,1,1,1,1,1,1,1,1,0}, 
			{0,0,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,0,1,1,1,1,1,1,1,0,0,0}, 
			{0,0,0,0,1,1,1,1,1,0,0,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,0,0},
		};
		
		// Test all three methods on the first matrix
		println("Matrix 1:");
		printMatrix(matrix1);
		println("getMaxRectArea1: " + getMaxRectArea1(matrix1));
		println("getMaxRectArea2: " + getMaxRectArea2(matrix1));
		println("getMaxRectAreaOptimal: " + getMaxRectAreaOptimal(matrix1));

		// Test all three methods on the second matrix
		println("\nMatrix 2:");
		printMatrix(matrix2);
		println("getMaxRectArea1: " + getMaxRectArea1(matrix2));
		println("getMaxRectArea2: " + getMaxRectArea2(matrix2));
		println("getMaxRectAreaOptimal: " + getMaxRectAreaOptimal(matrix2));
	}

	// helper method
	private void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			println(Arrays.toString(row));
		}
	}

	// code for algorithm 1
	// less optimal, easiest to write

	private int getMaxRectArea1(int[][] matrix) {
		int maxArea = 0;
		int nRows = matrix.length;
		int nCols = matrix[0].length;
		for (int i1 = 0; i1 < nRows; i1++) {
			for (int j1 = 0; j1 < nCols; j1++) {
				// i1, j1 - coords of the first cell of the rect 
				// i2, j2 - coords of the last cell of the rect
				for (int i2 = i1; i2 < nRows; i2++) {
					for (int j2 = j1; j2 < nCols; j2++) {
						if (hasOnlyOnes(matrix, i1, j1, i2, j2)) {
							int currArea = (i2 - i1 + 1) * (j2 - j1 + 1);
							maxArea = Math.max(maxArea, currArea);
						}
					}
				}
			}
		}

		return maxArea;
	}

	private boolean hasOnlyOnes(int[][] matrix, int i1, int j1, int i2, int j2) {
		for (int i = i1; i <= i2; i++) {
			for (int j = j1; j <= j2; j++) {
				if (matrix[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	// code for algorithm 2
	// more optimal than first
	private int getMaxRectArea2(int[][] matrix) {
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int currMaxArea = getMaxAreaStartingWith(matrix, i, j);
				maxArea = Math.max(maxArea, currMaxArea);
			}
		}
		return maxArea;
	}

	// returns max area of the rect starting from cell with coords i, j
	private int getMaxAreaStartingWith(int[][] matrix, int i, int j) {
		int maxArea = 0;
		int currLength = matrix[i].length;
		for (int i2 = i; i2 < matrix.length; i2++) {
			int currHeight = i2 - i + 1;
			currLength = Math.min(currLength, getOnesLengthInRow(matrix[i2], j));
			if (currLength == 0) {
				break;
			}
			int currArea = currHeight * currLength;
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

	private int getOnesLengthInRow(int[] row, int startJ) {
		int length = 0;
		for (int i = startJ; i < row.length; i++) {
			if (row[i] == 0) {
				break;
			}
			length++;
		}
		return length;
	}

	// code for algorithm 3
	// hard!!! uses Largest Rectangle in Histogram algorithm and data structure
	// stack
	private int getMaxRectAreaOptimal(int[][] matrix) {
		int maxArea = 0;
		int[] heights = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				heights[j] = (matrix[i][j] == 0) ? 0 : heights[j] + 1; // ternary operator syntax:
																		// https://www.w3schools.com/java/java_conditions_shorthand.asp
			}
			maxArea = Math.max(maxArea, getMaxRectAreaHistogram(heights));
		}

		return maxArea;
	}

	private int getMaxRectAreaHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;

		for (int i = 0; i <= heights.length; i++) {
			while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1; // ternary operator syntax:
																		// https://www.w3schools.com/java/java_conditions_shorthand.asp
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(i);
		}

		return maxArea;
	}
}
