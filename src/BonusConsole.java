import java.util.Iterator;

import acm.program.ConsoleProgram;

public class BonusConsole extends ConsoleProgram{
	public void run(){
		MidtermBonus myBonus = new MidtermBonus();
		
		myBonus.addGuess(0, "mberi15");
		myBonus.addGuess(10, "dsamk21");
		myBonus.addGuess(2, "lkhar21");
		myBonus.addGuess(2, "lkhar22");
		
		
		println("winning number: " + myBonus.getWinningNumber());
		
		println("winners: ");
		
		Iterator<String> it = myBonus.getWinners();
		while(it.hasNext()){
			println(it.next());
		}
	}
}
