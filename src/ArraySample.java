import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class ArraySample extends ConsoleProgram {
	private static final int STUDENTS_N = 30;

	public void run() {
		matrixSample();
		arrayListSample();
	}

	private void matrixSample() {	
		int[][] myMatrix = new int[10][5];
		
//		check 3 different prints
		println(myMatrix);
		println(Arrays.toString(myMatrix));
		for (int i = 0; i < myMatrix.length; i++) {
			println(Arrays.toString(myMatrix[i]));
		}
		
		// assign value to each cell
		for (int i = 0; i < myMatrix.length; i++) {
			for(int j = 0; j < myMatrix[0].length; j++) {
				myMatrix[i][j] = i + j;
			}
		}
		
		// custom print
		for (int i = 0; i < myMatrix.length; i++) {
			for (int j = 0; j < myMatrix[i].length; j++) {
				myMatrix[i][j] = i + j;
				print(myMatrix[i][j] + " ");
			}
			println();
		}
	}

	private void arrayListSample() {
		ArrayList<Integer> studentsList = new ArrayList<Integer>();
		println(studentsList.isEmpty());
		println(studentsList);

		for (int i = 0; i < STUDENTS_N; i++) {
			studentsList.add(i);
		}
		println(studentsList);
		studentsList.add(1, -1);
		println(studentsList);

		studentsList.remove(studentsList.indexOf(-1));
		println(studentsList);
		// next line error, indexOf(50) == -1
		// studentsList.remove(studentsList.indexOf(50));

		ArrayList<String> studentsL = new ArrayList<String>();
		studentsL.add("mari");
		println(studentsL);
		studentsL.remove("mar");
		println(studentsL);

		println(studentsL.get(0));

		// loop for going through each element of the ArrayList
		// for(int i = 0; i < studentsList.size(); i++)

//		studentsL.remove(STUDENTS_N)ხ„
	}

	private void arraysSample() {
		int[] myArr = new int[10];

		int[] myArr2 = { 0, 5, 6, 7, 8, 9 };
		int[] myArr3 = { 0, 5, 100, 7, 8, 9 };

		println(myArr[2]);
		println(myArr2[2]);

		myArr2[2] = 100;
		println(myArr2[2]);

		println("print with for loop: i, arr[i]");
		for (int i = 0; i < myArr2.length; i++) {
			println("index: " + i + ",value: " + myArr2[i]);
		}

		println("print with foreach loop: each element, no index)");
		for (int value : myArr2) {
			println("value: " + value);
		}

//		array -> wrapper class Arrays
		println("println(myArr2); // does not work");
		println(myArr2); // does not work
		println("println(Arrays.toString(myArr2)); // works");
		println(Arrays.toString(myArr2)); // works

		println("== does not work for arrays Arrays.equal does");
		if (myArr2 == myArr3) {
			println("==");
		}

		if (Arrays.equals(myArr2, myArr3)) {
			println("Equals");
		}

		Arrays.fill(myArr3, 7);
		println(Arrays.toString(myArr3));

		int[] toSort = { 10, 5, 61, 7, 10, -2, 8, 9 };

		Arrays.sort(toSort);
		println(Arrays.toString(toSort));

	}
}
