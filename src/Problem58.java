import java.util.Arrays;

import acm.program.ConsoleProgram;

//58. (2018 წლის გამოცდის ამოცანა)

//მატრიცას ეწოდება მაგიური თუკი ის კვადრატულია(n x n-ზე) და მასში არის ყველა
//რიცხვი 1-დან n^2-ის ჩათვლით. თქვენი მიზანია დაწეროთ magicMatrix მეთოდი
//რომელიც შეამოწმებს არის თუ არა მატრიცა მაგიური და თუკი მაგიურია მაშინ
//დააბრუნებს true-ს თუ არა მაშინ false-ს. 

public class Problem58 extends ConsoleProgram {
	public void run() {
		// int[][] m1 = new int[2][3];
		int[][] m1 = { { 1, 2, 3 },{ 1, 2, 3 },  { 4, 5, 6 } };
		int[][] m2 = { { 1, 2, 3 },{ 7, 8, 9 },  { 4, 5, 6 } };
		printMatrix(m1);
		println(isMagical(m1));
		println(isMagical2(m1));
		
		printMatrix(m1);
		println(isMagical(m2));
		println(isMagical2(m2));
	}

	private boolean isMagical(int[][] m1) {
		int nSq = m1.length * m1.length;
		for(int i = 1; i < nSq + 1; i++){
			if(! contains(m1, i)){
				return false;
			}
		}
		return true;
	}

	private boolean contains(int[][] m1, int n) {
		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m1[0].length; j++){
				if(m1[i][j] == n){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isMagical2(int[][] m1) {
		
		int nSq = m1.length * m1.length;
		
		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m1[0].length; j++){
				if(m1[i][j] <= 0 || m1[i][j] > nSq){
					return false;
				}
				if(notFirstOccurence(m1, i, j)){
					return false;
				}
			}
		}
		return true;
		
	}

	private boolean notFirstOccurence(int[][] m1, int i, int j) {
		for(int a = 0; a < i + 1; a++){
			for(int b = 0; b < m1[0].length; b++){
				if(a == i && b == j){
					break;
				}
				if(m1[a][b] == m1[i][j]){
					return true;
				}
			}
		}
		return false;
	}
	private void printMatrix(int[][] matrix){
		for(int[] row : matrix){
			println(Arrays.toString(row));
		}
	}
}
