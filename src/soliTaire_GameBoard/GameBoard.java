package soliTaire_GameBoard;

import java.util.ArrayList;

import soliTaire_SquareBoard.SquareBoard;

public class GameBoard {

	private ArrayList<Strut> board;

	public GameBoard(SquareBoard _sqBoard) {
		// fill board with help of square field data structure
		// GameBoard consists of all possible struts (filled by field ID)
		this.board = new ArrayList<Strut>();
		for (int id = 0; id < _sqBoard.getNumberOfFieldsOnGameBoard(); id++) {
			for (int dir = 0; dir < _sqBoard.getNumberOfJumpFields(id); dir++) {
				this.board.add(new Strut(
						id,
						_sqBoard.getJumpField(id, dir),
						_sqBoard.getEnablerField(id, dir),
						_sqBoard.getDirection(id, dir)
						));
			}
		}
	} // constructor

	public int getNumberOfStruts() {
		return this.board.size();
	} // getNumberOfStruts

	public Strut getStrut(int _index) {
		return this.board.get(_index);
	} // getStrut
	
	public String toString() {
		String result = "";
		for (int i = 0; i < this.board.size(); i++) {
			result += this.board.get(i);
		}
		return result;
	} // toString
	
} // GameBoard


/*
public ST_Direction getDirectionForField(int _f, int _d) {
	return this.board[_f].getDirection(_d);
} // getDirectionForField
	public int getNumberOfDirectionsForField(int _id) {
		return this.board.get(_id).getNumDirections();
	} // getNumberOfDirectionsForField

	public int getFromField(int _f) {
		return this.board.get(_f).getFromField();
	} // getFromField
	
	public int getToField(int _f) {
		return this.board.get(_f).getToField();
	} // getToField

	public int getEnablerField(int _f) {
		return this.board.get(_f).getEnablerField();
	} // getEnablerField

*/
