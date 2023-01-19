import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების მატრიცა და ამ მატრიცას სორტავს.
//Tags: Matrix, Sort
public class Final09 extends ConsoleProgram {

	public void run() {
		int[][] matrix = new int[][] { 
			{ 12, 11, 10 }, 
			{ 4, 2, 3 }, 
			{ 7, 8, 9 }, 
			{ 1, 5, 6 } };

		printMatrix(matrix);
		sortMatrix(matrix);
		printMatrix(matrix);
	}

	private void sortMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int[] minElemCoord = findMinElemCoord(matrix, i, j);
				swap(matrix, i, j, minElemCoord[0], minElemCoord[1]);
			}
		}
	}

	// swaps elems in matrix at coords [i][j] and [k][l]
	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = tmp;
	}

	// finds min elem in matrix, starting from the cell -[startI][startJ]
	private int[] findMinElemCoord(int[][] matrix, int startI, int startJ) {
		// coordinates of min value so far x = coords[0], y = coords[1]
		int[] coords = { startI, startJ }; // default values - 0's

		for (int i = startI; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == startI && j < startJ) {
					continue; // we don't want to check those cells
				}
				if (matrix[i][j] < matrix[coords[0]][coords[1]]) {
					coords[0] = i;
					coords[1] = j;
				}
			}
		}

		return coords;
	}

	private void printMatrix(int[][] matrix) {
		println("matrix");
		for (int[] arr : matrix) {
			println(Arrays.toString(arr));
		}
	}
}