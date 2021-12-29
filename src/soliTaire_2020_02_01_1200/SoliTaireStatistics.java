package soliTaire_2020_02_01_1200;

public class SoliTaireStatistics {
	private int[] histogramm;

	public SoliTaireStatistics(int _numPegs) {
		this.histogramm = new int[_numPegs];
		for (int i = 0; i < this.histogramm.length; i++) {
			this.histogramm[i] = 0;
		}
	} // constructor

	public void update(int _actualJumpCount) {
		this.histogramm[_actualJumpCount]++;
		return;
	} // update
	
	public int getCount(int _index) {
		return this.histogramm[_index];
	} // getCount

	public String toString() {
		String result = "";
		for (int i = 0; i < this.histogramm.length; i++) {
			result += i + "\t" + this.histogramm[i] + "\n";
		}
		return result;
	} // toString
	
} // SoliTaireStatistics

