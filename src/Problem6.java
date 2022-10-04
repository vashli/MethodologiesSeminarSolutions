import stanford.karel.SuperKarel;

public class Problem6 extends SuperKarel{
	
	/*
	 * Karel moves n beepers from 2x1 to 4x1 and makes backup 
	 * pile of n beepers at 2x2, same for m beepers.
	 * After that karel moves n beepers back from 2x2 to 2x1
	 * and m beepers from 3x2 to 3x1
	 */
	public void run(){
		moveBeepersFromNPileAndBackup();
		moveBeepersFromMPileAndBackup();
		returnBeepersToNPile();
		returnBeepersToMPile();
	}

	/* Karel moves n beepers from 2x1 to 4x1 and makes backup 
	 * pile of n beepers at 2x2
	 * pre: karel is at 1x1, facing east, n beepers at 2x1
	 * post: karel is at 2x1, facing east, 
	 * n beepers at 4x1, 2x2, 0 beepers at 2x1
	 */
	private void moveBeepersFromNPileAndBackup() {
		move();
		while(beepersPresent()){
			pickBeeper();
			putOneBeeperToDestinationFromNPile();
			putOneBeeperToBackupCellFromNPile();
		}	
	}
	
	/*
	 * karel  moves from starting position to the 
	 * destination position of the sum and puts 1 beeper down
	 * start: karel at pos: 2x1, facing east, y beepers at 4x1
	 * end: karel at pos: 2x1 , facing east, y+1 beepers at 4x1
	 */
	private void putOneBeeperToDestinationFromNPile() {
		move();
		move();
		putBeeper();
		turnAround();
		move();
		move();
		turnAround();
	}

	/*
	 * karel  moves from starting position to the 
	 * backup position and puts 1 beeper down
	 * start: karel at pos: 2x1, facing east, y beepers at 4x1
	 * end: karel at pos: 2x1 , facing east, y+1 beepers at 4x1
	 */
	private void putOneBeeperToBackupCellFromNPile() {
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();
	}

	/* Karel moves m beepers from 3x1 to 4x1 and makes backup 
	 * pile of m beepers at 3x2
	 * pre: karel is at 1x1, facing east, m beepers at 3x1
	 * post: karel is at 3x1, facing east, 
	 * m beepers at 4x1, 3x2, 0 beepers at 3x1
	 */
	private void moveBeepersFromMPileAndBackup() {
		move();
		while(beepersPresent()){
			pickBeeper();
			putOneBeeperToDestinationFromMPile();
			putOneBeeperToBackupCellFromMPile();
		}
		
	}
	
	/*
	 * karel moves from starting position to the 
	 * backup position and puts 1 beeper down
	 * start: karel at pos: 3x1, facing east, y beepers at 4x1
	 * end: karel at pos: 3x1 , facing east, y+1 beepers at 4x1
	 */
	private void putOneBeeperToDestinationFromMPile() {
		move();
		putBeeper();
		turnAround();
		move();
		turnAround();
	}
	
	/*
	 * karel  moves from starting position to the 
	 * backup position and puts 1 beeper down
	 * start: karel at pos: 3x1, facing east, y beepers at 3x2
	 * end: karel at pos: 3x1 , facing east, y+1 beepers at 3x2
	 */
	private void putOneBeeperToBackupCellFromMPile() {
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();
	}
	
	/*
	 * pre: karel is standing at 3x1, facing east
	 * n beepers are at pos 2x2, 0 beepers at 2x1
	 * post: karel is standing at 2x2, facing south
	 * n beepers are at pos 2x1, 0 beepers at 2x2
	 */
	private void returnBeepersToNPile() {
		goToNewNPile();
		returnPile();
	}
	
	/*
	 * pre: karel is standing at 3x1, facing east
	 * post: karel is standing at 2x2, facing south
	 */
	private void goToNewNPile() {
		turnAround();
		move();
		turnRight();
		move();
		turnAround();
	}
	
	/*
	 * pre: karel is standing on a backup pile of beepers, facing south
	 * k beepers are at pos Ax2, 0 beepers at Ax1
	 * post: karel is standing at the initial position of pile of beepers, 
	 * facing south, k beepers are at pos Ax1, 0 beepers at Ax2
	 */
	private void returnPile() {
		while(beepersPresent()){
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
	}
	
	/*
	 * pre: karel is standing at 2x2, facing south
	 * m beepers are at pos 3x2, 0 beepers at 3x1
	 * post: karel is standing at 3x2, facing south
	 * m beepers are at pos 3x1, 0 beepers at 3x2
	 */
	private void returnBeepersToMPile() {
		goToNewMPile();
		returnPile();
	}

	/*
	 * pre: karel is standing at 2x2, facing south
	 * post: karel is standing at 3x2, facing south
	 */
	private void goToNewMPile() {
		turnLeft();
		move();
		turnRight();
	}
}
