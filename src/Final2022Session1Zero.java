import java.util.Arrays;
import acm.program.ConsoleProgram;
//ამოცანა 2. (20 ქულა) მატრიცის განულება
//დაწერეთ მეთოდი zero რომელსაც გადაეცემა ორგანზომილებიანი ინტების
//მასივი(მატრიცა), რომელიც არაფერს არ აბრუნებს და რომელიც გადაცემულ
//მატრიცას “ანულებს”.
//განულების წესი შემდეგია: თუკი თავდაპირველ მატრიცაში სადმე გვხვდება 0
//მაშინ მატრიცის მთელი ის სვეტი და სტრიქონი უნდა განულდეს. მაგალითად:
//თუკი მეთოდს გადაეცა მატრიცა:
//[[1, 0, 3, 4],
// [5, 6, 7, 8],
// [9, 0, 1, 2]]
//მაშინ მეთოდმა იგი უნდა შეცვალოს შემდეგნაირად:
//[[0, 0, 0, 0],
// [5, 0, 7, 8],
// [0, 0, 0, 0]]
//ამ ამოცანის გადასაჭრელად არ შექმნათ მასივები(მატრიცებიც) და ArrayListები.
//ამოხსნა დაწერეთ zero.java ფაილში
public class Final2022Session1Zero extends ConsoleProgram{
	public void run() {
		int [][] before = { {1, 0, 3, 4},
							{5, 6, 7, 8},
							{9, 0, 1, 2}};
		int [][] after = 	{{0, 0, 0, 0},
							 {5, 0, 7, 8},
							 {0, 0, 0, 0}};
		
		
		printMatrix(before);
		println("Expected: ");
		printMatrix(after);
		println("Actual:");
//		zero(before);
		zeroEasier(before);
		printMatrix(before);
	}
	
	private void printMatrix(int[][] matrix) {
		for(int[] arr : matrix ) {
			println(Arrays.toString(arr));
		}
	}
	
	// zero VERSION 1
	private void zero(int[][] m) {
		boolean zeroFirstCol = colHasZero(0, m);
		boolean zeroFirstRow = rowHasZero(0, m);
		
		for(int i = 0; i < m.length; i++) {
			if(rowHasZero(i, m)) {
				m[i][0] = 0;
			}
		}
		
		for(int j = 1; j < m[0].length; j++) {
			if(colHasZero(j, m)) {
				m[0][j] = 0;
			}
		}
		
		for(int i = 1; i < m.length; i++) {
			if(m[i][0] == 0) {
				zeroRow(i, m);
			}
		}
		for(int j = 1; j < m[0].length; j++) {
			if(m[0][j] == 0) {
				zeroCol(j, m);
			}
		}

		if (zeroFirstCol) {
			zeroCol(0, m);
		}
		if (zeroFirstRow) {
			zeroRow(0, m);
		}
	}
	
	private void zeroCol(int j, int[][] m) {
		for (int i = 0; i < m.length; i++) {
			m[i][j] = 0;
		}
	}


	private void zeroRow(int i, int[][] m) {
		for (int j = 0; j < m[0].length; j++) {
			m[i][j] = 0;
		}
	}


	private boolean colHasZero(int j, int[][] m) {
		for (int i = 0; i < m.length; i++) {
			if(m[i][j] == 0) {
				return true;
			}
		}
		return false;
	}
	private boolean rowHasZero(int i, int[][] m) {
		for (int j = 0; j < m[0].length; j++) {
			if(m[i][j] == 0) {
				return true;
			}
		}
		return false;
	}
	
	// VERSION 2 - easier algo
	

//	find a number which does not exist in matrix, 
//	we change all numbers which have to become 0 to that number first, than to 0
	private void zeroEasier(int[][] m) {
		int  tmpNum = findTmpNum(m);
		int rowNum = m.length;
		int colNum = m[0].length;
		
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				if(m[i][j] == 0) {
					changeRowToTmp(m, i ,tmpNum);
					changeColToTmp(m, j ,tmpNum);
				}
			}
		}
		changeTmpToZero(m, tmpNum);
	}

	private void changeColToTmp(int[][] m, int j, int tmpNum) {
		int rowNum = m.length;
		for(int i = 0; i < rowNum; i++) {
			if(m[i][j] != 0) {
				m[i][j] = tmpNum;
			}
		}
	}

	private void changeRowToTmp(int[][] m, int i, int tmpNum) {
		int colNum = m[0].length;
		for(int j = 0; j < colNum; j++) {
			if(m[i][j] != 0) {
				m[i][j] = tmpNum;
			}
		}
		
	}
	private void changeTmpToZero(int[][] m, int tmpNum) {
		int rowNum = m.length;
		int colNum = m[0].length;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				if(m[i][j] == tmpNum) {
					m[i][j] = 0;
				}
			}
		}
	}

	private int findTmpNum(int[][] m) {
		int rowNum = m.length;
		int colNum = m[0].length;
		
		for(int i = 0; i < rowNum * colNum + 1; i++) {
			if(!contains(m, i)) {
				return i;
			}
		}
		return -1; // wont need, at least 1 num will return from our loop;
	}
	
	private boolean contains(int[][] m, int num) {
		int rowNum = m.length;
		int colNum = m[0].length;
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				if(m[i][j] == num) {
					return true;
				}
			}
		}
		return false;
	}
	
}
