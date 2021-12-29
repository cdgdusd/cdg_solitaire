package soliTaire_2020_02_01_1200;

import java.text.DecimalFormat;
import soliTaire_GameBoard.GameBoard;
import soliTaire_GameBoard.GameFieldStrutsIterator;
import soliTaire_GameBoard.Strut;
import soliTaire_GameState.GameState;
import soliTaire_SquareBoard.SquareBoard;

public class SoliTairePlayer {
	private SquareBoard squareBoard;
	private GameBoard board;
	private GameState state;
	private Strut[] actualJumps;
	//
	private SoliTaireTimeStamp startTime, finishTime;
	private SoliTaireStatistics statistik;

	public SoliTairePlayer() {
		this.squareBoard = new SquareBoard();
		this.board = new GameBoard(this.squareBoard);
		this.state = new GameState(this.squareBoard);
		//
		this.actualJumps = new Strut[this.state.getNumPegs() - 1];
		for (int i = 0; i < this.actualJumps.length; i++) {
			this.actualJumps[i] = null;
		}
		//
		this.statistik = new SoliTaireStatistics(this.state.getNumPegs());
		// System.out.print(this.board);
		// System.out.print(this.state);
		// System.out.println("SoliTairePlayer - leaving constructor");
	} // constructor

	public void run() {
		// Timestamp aufzeichnen
		startTime = new SoliTaireTimeStamp();
		this.findNextJump(0);
		return;
	} // run

	private void findNextJump(int _count) {
		int actualJumpCount = _count;
		if (this.state.terminationCondition()) {
			finishTime = new SoliTaireTimeStamp();
			this.statistik.update(actualJumpCount);
			this.printResultAndExit(startTime, finishTime);
			/***
			if (Math.floorMod(this.statistik.getCount(31), 5000) == 0) {
				System.out.println(this.statistik.getCount(31));
				for (int i = 0; i < this.actualJumps.length; i++) {
					if (this.actualJumps[i] != null) {
						System.out.print(this.actualJumps[i]);
					}
				}
			}
			***/
		}
		GameFieldStrutsIterator strutsIterator = new GameFieldStrutsIterator(this.board);
		Strut currentStrut;
		while (strutsIterator.hasNext()) {
			currentStrut = strutsIterator.next();
			if (this.state.canJump(currentStrut)) {
				this.state.jump(currentStrut);
				this.actualJumps[actualJumpCount] = currentStrut;
				this.findNextJump(actualJumpCount + 1);
			}
		}
		actualJumpCount--;
		Strut jumpToUndo = this.actualJumps[actualJumpCount];
		this.state.undoJump(jumpToUndo);
		this.actualJumps[actualJumpCount] = null;
		this.statistik.update(actualJumpCount);
		return;
	} // findNextJump
		
	private void printResultAndExit(SoliTaireTimeStamp _start, SoliTaireTimeStamp _finish) {
		// Timestamp drucken
		DecimalFormat df = new DecimalFormat("###,##0.000");
		System.out.println("Execution time [seconds elapsed]:\t" + df.format(0.001 * (_finish.getTimeStamp() - _start.getTimeStamp())));
		for (int i = 0; i < this.actualJumps.length; i++) {
			if (this.actualJumps[i] != null) {
				System.out.print(this.actualJumps[i]);
			}
		}
		System.out.print(this.statistik);
		System.exit(0);
		return;
	} // printResultAndExit

} // SoliTairePlayer
