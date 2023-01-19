import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების მატრიცა და ამ მატრიცას უკეთებს ტრანსპონირებას
//Transpose of a matrix is a matrix which is formed by turning all the rows of the source matrix into columns and vice-versa.
//[[1, 2, 3, 4],	   [[1, 5, 9, 3],
//[5, 6, 7, 8],			[2, 6, 0, 4],
//[9, 0, 1, 2],-------->[3, 7, 1, 5],
//[3, 4, 5, 0]]			[4, 8, 2, 0]]
//Tags: Matrix, Rearrange elements

public class Final12 extends ConsoleProgram {

	public void run() {
		int[][] matrix = new int[][] { 
			{ 12, 11, 10 }, 
			{ 4, 2, 3 }, 
			{ 7, 8, 9 }, 
			{ 1, 5, 6 } };

		printMatrix(matrix);
		printMatrix(createTransposeMatrix(matrix));
		
		println("2");
		int[][] matrix2 = new int[][] { 
			{ 1, 2, 3, 4}, 
			{ 5, 6, 7, 8}, 
			{ 9, 0, 1, 2}, 
			{ 3, 4, 5, 0 } };
		
			printMatrix(matrix2);
			printMatrix(createTransposeMatrix(matrix2));
			transposeMatrixForSquare(matrix2);
			printMatrix(matrix2);
			
		println("3");
		int[][] matrix3 = new int[][] { 
			{ 1, 2, 3,}, 
			{ 4, 5, 6}, 
			{ 7, 8, 9} };
		
			printMatrix(matrix3);
			printMatrix(createTransposeMatrix(matrix3));
			transposeMatrixForSquare(matrix3);
			printMatrix(matrix3);
	}

	// works for every matrix, returns new object
	private int[][] createTransposeMatrix(int[][] matrix){
		int[][] transpose = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < transpose.length; i++){
			for(int j = 0; j < transpose[0].length; j++){
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
	}
	
	// works for squares, changes in place
	private void transposeMatrixForSquare(int[][] matrix) {
		if(matrix.length != matrix[0].length) return;
		for (int i = 0; i < matrix.length; i++) {
			// we start from j = i, or else we would swap each pair twice
			for (int j = i; j < matrix[0].length; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	// swaps elems in matrix at coords [i][j] and [k][l]
	private void swap(int[][] matrix, int i, int j, int k, int l) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = tmp;
	}

	private void printMatrix(int[][] matrix) {
		println("matrix");
		for (int[] arr : matrix) {
			println(Arrays.toString(arr));
		}
	}
}