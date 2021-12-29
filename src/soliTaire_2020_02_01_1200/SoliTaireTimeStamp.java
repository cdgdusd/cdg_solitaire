package soliTaire_2020_02_01_1200;

public class SoliTaireTimeStamp {
	private final long timeStamp;
	
	public SoliTaireTimeStamp() {
		timeStamp = System.currentTimeMillis();
	} // constructor
	
	public long getTimeStamp() {
		return timeStamp;
	} // getTimeStamp
	
} // SoliTaireTimeStamp

