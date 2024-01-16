import acm.program.ConsoleProgram;

public class Final2022Session2UndoConsole extends ConsoleProgram{
	public void run() {
		Final2022Session2Undo a = new Final2022Session2Undo();
		a.save("1");
		a.save("2");
		a.save("3");
		a.undo();
		a.undo();
		println(a.get()); //- დააბრუნებს “1”
		a.redo();
		println(a.get()); //- დააბრუნებს “2”
		a.save("4");
		println(a.get()); //- დააბრუნებს “4”
		a.undo();
		println(a.get()); //- დააბრუნებს “2”
		a.clear();
		println(a.get()); //- დააბრუნებს “”
	}

}
