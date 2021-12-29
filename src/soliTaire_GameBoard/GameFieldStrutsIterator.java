package soliTaire_GameBoard;

public class GameFieldStrutsIterator {
	private int currentField;
	private int maxFieldIndex;
	private GameBoard board;
	
	public GameFieldStrutsIterator(GameBoard _board) {
		this.currentField = -1;
		this.maxFieldIndex = _board.getNumberOfStruts() - 1;
		this.board = _board;
	} // constructor
	
	public boolean hasNext() {
		return (this.currentField < this.maxFieldIndex);
	} // hasNext
	
	public Strut next() {
		this.currentField++;
		return this.board.getStrut(this.currentField);
	} // next

} // ST_GameFieldIterator

/*
package soliTaire_GameBoard;

public class ST_GameFieldIterator {
	private int currentField;
	private int currentDirection;
	private ST_GameBoard board;
		this.currentDirection = 0;
		this.board = _board;
		this.finalField = this.board.getNumberOfFields() - 1;
		this.numberOfDirectionsForFinalField = this.board.getNumberOfDirectionsForField(this.finalField) - 1;
	} // constructor

	public boolean hasNext() {
		// condition for not having next: currentField and currentDirection are on the last field and direction
		return !((this.currentField == this.finalField) && (this.currentDirection == this.numberOfDirectionsForFinalField));
	} // hasNext

	public ST_Strut next() {
		// check for overflow of directions
		if ((this.currentDirection + 1) == this.board.getNumberOfDirectionsForField(this.currentField)) {
			this.currentField++;
			this.currentDirection = 0;
		} else {
			this.currentDirection++;
		}
		return new ST_Strut(this.currentField, this.board.getToField(this.currentField), this.board.getEnablerField(this.currentField));
	} // next

} // ST_GameFieldIterator
*/
