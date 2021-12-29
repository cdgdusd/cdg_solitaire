package soliTaire_GameBoard;

import soliTaire_SquareBoard.StrutDirection;

public class GameBoardFieldListEntry {
	private int count;
	private StrutDirection[] directions;

	public GameBoardFieldListEntry() {
		this.count = 0;
		this.directions = new StrutDirection[StrutDirection.values().length];
	} // constructor

	public void add(StrutDirection _dir) {
		this.directions[this.count] = _dir;
		this.count++;
		return;
	} // add

	public int getNumberOfJumpsPossible() {
		return this.count;
	} // getNumberOfJumpsPossible

	public StrutDirection getJumpDirection(int _jumpNum) {
		return this.directions[_jumpNum];
	} // getJumpDirection
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.count; i++) {
			result += this.count + "\t" + this.directions[this.count] + "\n";
		}
		return result;
	} // toString
	
} // GameBoardFieldListEntry
