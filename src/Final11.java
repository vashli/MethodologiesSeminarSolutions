import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების მატრიცა და ამ მატრიცას სორტავს.
//Tags: Matrix, Sort
import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების მატრიცა და ამ მატრიცას ატრიალებს სიმეტრიულად x ღერძის მიმართ 
//1, 2 -> 3,4
//3, 4     1,2
//Tags: Matrix, Rearrange elements

public class Final11 extends ConsoleProgram {

	public void run() {
		int[][] matrix = new int[][] { 
			{ 12, 11, 10 }, 
			{ 4, 2, 3 }, 
			{ 7, 8, 9 }, 
			{ 1, 5, 6 } };

		printMatrix(matrix);
		rotateTowardsX(matrix);
		printMatrix(matrix);
		
		
		int[][] matrix2 = new int[][] { 
			{ 12, 11, 10 }, 
			{ 7, 8, 9 }, 
			{ 1, 5, 6 } };
			
			printMatrix(matrix2);
			rotateTowardsX(matrix2);
			printMatrix(matrix2);
	}

	private void rotateTowardsX(int[][] matrix) {
		for(int i = 0; i < matrix.length / 2; i++){
			swapRows(matrix, i, matrix.length - 1 - i);
		}
	}

	private void swapRows(int[][] matrix, int i, int j) {
		int[] tmp = matrix[i];
		matrix[i] = matrix[j];
		matrix[j] = tmp;
	}

	private void printMatrix(int[][] matrix) {
		println("matrix");
		for (int[] arr : matrix) {
			println(Arrays.toString(arr));
		}
	}
}
