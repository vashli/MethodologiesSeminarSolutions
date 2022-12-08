import java.util.Arrays;

import acm.program.ConsoleProgram;

// მატრიცული ნამრავლი

public class DotProduct extends ConsoleProgram {
	public void run(){
		
		int[][] m1 =  {{1,2, 3}, {4, 5, 6}};
		int[][] m2 =  {{7,8}, {9,10}, {11,12}};
		
		int[][] dotProduct  = dotProduct(m1, m2);
	
		for(int[] arr : dotProduct){
			println(Arrays.toString(arr));
		}

	}

	private int[][] dotProduct(int[][] m1, int[][] m2){
		int[][] result = new int[m1.length][m2[0].length];
		
		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m2[0].length; j++ ){
				int currDot = multiplyOnePair(m1, m2, i, j);
				result[i][j] = currDot;
			}
		}
		
		return result;
	}

	private int multiplyOnePair(int[][] m1, int[][] m2, int i, int j) {
		int res = 0;
		for(int k = 0; k < m1[0].length; k++){
			int a = m1[i][k];
			int b = m2[k][j];
			int c = a * b;
			res += c; 
		}
		return res;
	}

}
