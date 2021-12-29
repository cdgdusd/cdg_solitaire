package soliTaire_SquareBoard;

import soliTaire_GameBoard.GameBoardFieldListEntry;

public class SquareBoard {
	// fill board with help of temporary structure
	// temporary structure is auxiliary board with square dimensions (7 x 7)
	// arrays give the indices for fields in game board expressed as row indices
	private final int[] lowerIndexForColDelimiter = { 2, 2, 0, 0, 0, 2, 2 };
	private final int[] upperIndexForColDelimiter = { 4, 4, 6, 6, 6, 4, 4 };
	private final boolean FIELD_EXISTS = true;
	//
	private boolean[][] fieldExistsOnGameBoard;
	private GameBoardFieldListEntry[][] fieldList;
	private int[][] iDList;
	//
	private int[] row4ID;
	private int[] col4ID;
	private int numFieldsOnGameBoard;
	
	public SquareBoard() {
		this.fieldExistsOnGameBoard = new boolean[this.lowerIndexForColDelimiter.length][this.lowerIndexForColDelimiter.length];
		this.fieldList = new GameBoardFieldListEntry[this.lowerIndexForColDelimiter.length][this.lowerIndexForColDelimiter.length];
		this.iDList = new int[this.lowerIndexForColDelimiter.length][this.lowerIndexForColDelimiter.length];
		// initial fill
		for (int row = 0; row < this.lowerIndexForColDelimiter.length; row++) {
			for (int col = 0; col < this.lowerIndexForColDelimiter.length; col++) {
				this.fieldExistsOnGameBoard[row][col] = !FIELD_EXISTS;
				this.iDList[row][col] = -1;
			}
		}
		// mark fields existing on game board and create IDs for easy access
		int counter = 0;
		for (int row = 0; row < lowerIndexForColDelimiter.length; row++) {
			for (int col = lowerIndexForColDelimiter[row]; col <= upperIndexForColDelimiter[row]; col++) {
				this.fieldExistsOnGameBoard[row][col] = FIELD_EXISTS;
				this.iDList[row][col] = counter;
				counter++;
			}
		}
		this.numFieldsOnGameBoard = counter;
		this.row4ID = new int[this.numFieldsOnGameBoard];
		this.col4ID = new int[this.numFieldsOnGameBoard];
		for (int i = 0; i < this.row4ID.length; i++) {
			this.row4ID[i] = -1;
			this.col4ID[i] = -1;
		}
		counter = 0;
		for (int row = 0; row < lowerIndexForColDelimiter.length; row++) {
			for (int col = lowerIndexForColDelimiter[row]; col <= upperIndexForColDelimiter[row]; col++) {
				this.row4ID[counter] = row;
				this.col4ID[counter] = col;
				counter++;
			}
		}
		// find fields to jump to and enabler fields
		for (int row = 0; row < this.lowerIndexForColDelimiter.length; row++) {
			for (int col = 0; col < this.lowerIndexForColDelimiter.length; col++) {
				this.fieldList[row][col] = null;
			}
		}
		for (int row = 0; row < lowerIndexForColDelimiter.length; row++) {
			for (int col = 0; col < lowerIndexForColDelimiter.length; col++) {
				if (this.fieldExistsOnGameBoard[row][col]) {
					// check jump in four directions
					GameBoardFieldListEntry currentFieldList = new GameBoardFieldListEntry();
					for (StrutDirection direction : StrutDirection.values()) {
						if (field4JumpExistsOnGameBoard(row, col, direction)) {
							currentFieldList.add(direction);
						}
					}
					this.fieldList[row][col] = currentFieldList;
				} // if fieldExistsOnSquareBoard
			} // inner loop
		} // outer loop

	} // constructor

	private boolean field4JumpExistsOnGameBoard(int _r, int _c, StrutDirection _dir) {
		boolean result = false;
		int row = StrutDirection.getRow4Jump(_r, _dir);
		int col = StrutDirection.getCol4Jump(_c, _dir);
		if ((row > -1) && (col > -1) && (row < this.lowerIndexForColDelimiter.length) && (col < this.lowerIndexForColDelimiter.length)) {
			result = this.fieldExistsOnGameBoard[row][col];
		}
		return result;
	} // field4JumpExistsOnGameBoard

	public int getNumberOfJumpFields(int _id) {
		return this.fieldList[row4ID[_id]][col4ID[_id]].getNumberOfJumpsPossible();
	} // getNumberOfJumpFields

	public StrutDirection getDirection(int _id, int _jumpNum) {
		return this.fieldList[row4ID[_id]][col4ID[_id]].getJumpDirection(_jumpNum);
	} // getDirection

	public int getJumpField(int _id, int _jumpNum) {
		int row = row4ID[_id];
		int col = col4ID[_id];
		StrutDirection direction = this.getDirection(_id, _jumpNum);
		return this.iDList[StrutDirection.getRow4Jump(row, direction)][StrutDirection.getCol4Jump(col, direction)];
	} // getJumpField

	public int getEnablerField(int _id, int _jumpNum) {
		int row = row4ID[_id];
		int col = col4ID[_id];
		StrutDirection direction = this.getDirection(_id, _jumpNum);
		return this.iDList[StrutDirection.getRow4Enable(row, direction)][StrutDirection.getCol4Enable(col, direction)];
	} // getEnablerField

	public int getNumberOfFieldsOnGameBoard() {
		return this.numFieldsOnGameBoard;
	} // getNumberOfFieldsOnGameBoard
	
} // SquareBoard


