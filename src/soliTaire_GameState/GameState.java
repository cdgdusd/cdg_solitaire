package soliTaire_GameState;

import soliTaire_GameBoard.Strut;
import soliTaire_SquareBoard.SquareBoard;

public class GameState {
	private final static boolean FIELD_OCCUPIED = true;
	private final static boolean FIELD_EMPTY = !GameState.FIELD_OCCUPIED;
	
	private final static int[] finalFieldArray = { 9 };
	
	private boolean[] state;
	private int numPegsCurrentlyOnGameBoard;
	
	public GameState(SquareBoard _sqBoard) {
		this.state = new boolean[_sqBoard.getNumberOfFieldsOnGameBoard()];
		this.numPegsCurrentlyOnGameBoard = 0;
		for (int i = 0; i < this.state.length; i++) {
			this.state[i] = GameState.FIELD_OCCUPIED;
			this.numPegsCurrentlyOnGameBoard++;
		}
		for (int i = 0; i < getNumFinalFields(); i++) {
			this.state[getFinalField(i)] = GameState.FIELD_EMPTY;
			this.numPegsCurrentlyOnGameBoard--;
		}
	} // constructor

	public boolean terminationCondition() {
		return ((this.numPegsCurrentlyOnGameBoard == getNumFinalFields()) && this.isFinalFieldsEmpty());
	} // terminationCondition
	
	private boolean isFinalFieldsEmpty() {
		boolean result = true;
		for (int i = 0; i < getNumFinalFields(); i++) {
			result = result && (this.state[getFinalField(i)] == GameState.FIELD_OCCUPIED);
		}
		return result;
	} // isFinalFieldsEmpty

	public int getNumPegs() {
		return this.numPegsCurrentlyOnGameBoard;
	} // getNumPegs

	public boolean canJump(Strut _j) {
		return ((state[_j.getFromField()] == FIELD_OCCUPIED) && (state[_j.getToField()] == FIELD_EMPTY) && (state[_j.getEnablerField()] == FIELD_OCCUPIED));
	} // canJump

	public void jump(Strut _j) {
		this.toggleFieldState(_j.getFromField());
		this.toggleFieldState(_j.getToField());
		this.toggleFieldState(_j.getEnablerField());
		this.numPegsCurrentlyOnGameBoard--;
		return;
	} // jump
	
	private void toggleFieldState(int _id) {
		this.state[_id] = !this.state[_id];
		return;
	} // toggleFieldState

	public void undoJump(Strut _j) {
		this.toggleFieldState(_j.getFromField());
		this.toggleFieldState(_j.getToField());
		this.toggleFieldState(_j.getEnablerField());
		this.numPegsCurrentlyOnGameBoard++;
		return;
	} // undoJump

	private static int getFinalField(int _i) {
		return finalFieldArray[_i];
	} // getFinalField

	private static int getNumFinalFields() {
		return finalFieldArray.length;
	} // getNumFinalFields
	
	public String toString() {
		String result = this.numPegsCurrentlyOnGameBoard + "\n";
		for (int i = 0; i < this.state.length; i++) {
			result += "[" + i + ", " + this.state[i] + "]\n";
		}
		return result;
	} // toString
	
} // GameState

