package soliTaire_SquareBoard;

public enum StrutDirection {

	NORTH, EAST, SOUTH, WEST;

	final static int[] rowAdd4Jump   = { -2,  0, +2,  0 };
	final static int[] colAdd4Jump   = {  0, +2,  0, -2 };
	//
	final static int[] rowAdd4Enable = { -1,  0, +1,  0 };
	final static int[] colAdd4Enable = {  0, +1,  0, -1 };
		
	public static int getRow4Jump(int _row, StrutDirection _dir) {
		return _row + rowAdd4Jump[_dir.ordinal()];
	} // getRow4Jump
	
	public static int getCol4Jump(int _col, StrutDirection _dir) {
		return _col + colAdd4Jump[_dir.ordinal()];
	} // getCol4Jump
	
	public static int getRow4Enable(int _row, StrutDirection _dir) {
		return _row + rowAdd4Enable[_dir.ordinal()];
	} // getRow4Enable
	
	public static int getCol4Enable(int _col, StrutDirection _dir) {
		return _col + colAdd4Enable[_dir.ordinal()];
	} // getCol4Enable
	
} // StrutDirection

