import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem59 extends ConsoleProgram {

	public void run() {
		int[][] matrix1 = new int[][] {
			{0,1,1,0,0,1,0,0}, 
			{0,1,1,1,1,1,0,0},
			{0,0,1,1,1,1,0,0}, 
			{0,0,1,1,1,1,0,0},
		};
		int[][] matrix = new int[][] {
			{0,1,1,1,1,1,1,1,1,1,1,1,0}, 
			{0,0,1,1,1,1,1,1,1,1,1,0,0},
			{0,0,0,1,1,1,1,1,1,1,0,0,0}, 
			{0,0,0,0,1,1,1,1,1,0,0,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,0,0},
		};
		printMatrix(matrix);
		println(getMaxRectArea(matrix));
		println(getMaxRectArea2(matrix));
		printMatrix(matrix1);
		println(getMaxRectArea(matrix1));
		println(getMaxRectArea2(matrix1));
	}

	private int getMaxRectArea(int[][] matrix) {
		int maxArea = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j ++){
				int currMaxArea = getCurrMaxArea(matrix, i, j);
				maxArea = Math.max(maxArea, currMaxArea);
			}
		}
		return maxArea;
	}

	
	private int getCurrMaxArea(int[][] matrix, int i, int j) {
		int maxArea = 0;
		
		int currLength = matrix[i].length; // initial value, will be updated
		for(int i2 = i; i2 < matrix.length; i2 ++){
			int currHeight = i2 - i + 1;
			//currLength იქნება ახალ როუში მიყოლებული ერთიანების რაოდენობასა და currLength-ის  წინა მნიშვნელობას შორის მინიმალური
			currLength = Math.min(currLength, getCurrLength(matrix[i2] , j));
			if(currLength == 0) {
				break;
			}
			int currArea = currHeight * currLength;
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

	//number of consecutive 1's in current row starting from index startJ
	private int getCurrLength(int[] row, int startJ) {
		int length = 0; 
		for (int i = startJ; i < row.length; i++){
			if(row[i] == 0){
				break;
			}
			length ++;
		}
		return length;
	}

	// second version
	private int getMaxRectArea2(int[][] matrix) {
		int maxArea = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j ++){
				int currMaxArea = getCurrMaxArea2(matrix, i, j);
				maxArea = Math.max(maxArea, currMaxArea);
			}
		}
		return maxArea;
	}
	
	// განვიხილავთ მართკუთხედის ყველა შესაძლო დაბოლოებას და ვამოწმებთ 
	// თუ ერთიანებისგან შემდგარი მართკუთხედია, 
	// ვთვლით მის ზომას და მაქსიმალურ ფართობს ვააფდეითებთ თუ საჭიროა
	private int getCurrMaxArea2(int[][] matrix, int i, int j) {
		int maxArea = 0;
		for(int i2 = i; i2 < matrix.length; i2 ++){
			for(int j2 = j; j2 < matrix[0].length; j2++){
				if(isRect(matrix, i, j, i2, j2)){
					int currArea = (i2 - i + 1) * (j2 - j + 1);
					maxArea = Math.max(maxArea, currArea);
				}
			}
		}
		return maxArea;
	}

	private boolean isRect(int[][] matrix, int i, int j, int i2, int j2) {
		for(int a = i; a <= i2; a++){
			for(int b = j; b <= j2; b++){
				if(matrix[a][b] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	private void printMatrix(int[][] matrix){
		for(int[] row : matrix){
			println(Arrays.toString(row));
		}
	}
}
