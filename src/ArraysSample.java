import java.util.ArrayList;
import java.util.Arrays;
import acm.program.ConsoleProgram;

public class ArraysSample extends ConsoleProgram {
	private static final int STUDENTS_N = 30;

	public void run() {
		basics();
		testSwaps();
	}

	private void basics() {
		int[] students = new int[STUDENTS_N];
		for (int i = 0; i < students.length; i++) {
			students[i] = students.length - i;
		}

		Arrays.sort(students);

		println(Arrays.toString(students));

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
	}

	private void testSwaps() {
		// array
		int[] students = new int[STUDENTS_N];
		Arrays.fill(students, 0);
		students[2] = 20;
		students[3] = 30;
		println(Arrays.toString(students));
		swap(students, 2, 3);
		println(Arrays.toString(students));
		// ArrayList
		ArrayList<Integer> studentsList = new ArrayList<Integer>();
		studentsList.add(3);
		studentsList.add(4);
		println(studentsList);
		swapList(studentsList, 0, 1);
		println(studentsList);
	}
	
	// swap the elements at index positions i and j (in array)
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// swap the elements at index positions i and j (in ArrayList)
	private void swapList(ArrayList<Integer> studentsList, int i, int j) {
		int tmp = studentsList.get(i);
		studentsList.set(i, studentsList.get(j));
		studentsList.set(j, tmp);
	}
}
