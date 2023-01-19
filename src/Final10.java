import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების მატრიცა და ამ მატრიცას ატრიალებს სიმეტრიულად y ღერძის მიმართ 
//1, 2 -> 2,1
//3, 4     4,3
//Tags: Matrix, Rearrange elements

public class Final10 extends ConsoleProgram {

	public void run() {
		int[][] matrix = new int[][] { 
			{ 12, 11, 10 }, 
			{ 4, 2, 3 }, 
			{ 7, 8, 9 }, 
			{ 1, 5, 6 } };

		printMatrix(matrix);
		rotateTowardsY(matrix);
		printMatrix(matrix);
		
		int[][] matrix2 = new int[][] { 
			{ 12, 11, 10, 10}, 
			{ 4, 2, 3, 3}, 
			{ 7, 8, 9, 9}, 
			{ 1, 5, 6, 6} };

			printMatrix(matrix2);
			rotateTowardsY(matrix2);
			printMatrix(matrix2);
	}

	private void rotateTowardsY(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length / 2; j++){
				swap(matrix[i], j, matrix[0].length - 1 - j);
			}			
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private void printMatrix(int[][] matrix) {
		println("matrix");
		for (int[] arr : matrix) {
			println(Arrays.toString(arr));
		}
	}
}
