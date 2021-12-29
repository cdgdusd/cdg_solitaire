package soliTaire_GameBoard;

import soliTaire_SquareBoard.StrutDirection;

public class Strut {
	private int fromField;
	private int toField;
	private int enablerField;
	private StrutDirection direction;

	public Strut(int _f, int _t, int _e, StrutDirection _d) {
		this.fromField = _f;
		this.toField = _t;
		this.enablerField = _e;
		this.direction = _d;
	} // constructor

	public int getFromField() {
		return this.fromField;
	} // getFromField

	public int getToField() {
		return this.toField;
	} // getToField

	public int getEnablerField() {
		return this.enablerField;
	} // getEnablerField
	
	public StrutDirection getDirection() {
		return this.direction;
	} // getDirection

	public String toString() {
		return this.fromField + " -> " + this.toField + "\t[" + this.enablerField + "]\t" + this.direction + "\n";
	} // toString
	
} // Strut
