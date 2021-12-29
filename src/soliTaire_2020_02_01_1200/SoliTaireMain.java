package soliTaire_2020_02_01_1200;

import java.util.Date;

import javax.swing.SwingUtilities;

public class SoliTaireMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SoliTairePlayer player = new SoliTairePlayer();
				Date currentDateToPrint = new Date();
				System.out.println(currentDateToPrint);
				player.run();
			}
		});
	} // main
	
} // SoliTaireMain
