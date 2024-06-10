package radioMonteCarlo.model;

public class Heure {
	static public float intToMin(int minutes) {
		// minutes = 90, return = 1.5
		return minutes/60;
	}
	
	static public int minToInt(float heure) {
		// heures = 1.5, return 90
		return (int) (heure*90);
	}
	
	static public String intToString(int heure) {
		// heure = 90, return = "01:30"
		int nbHeure = (int) (Heure.intToMin(heure)*60);
		
		return "" + nbHeure + ":" + (heure-(nbHeure*60));
	}
	
	static public int stringToInt(String heure) {
		// heure = "01:30", return = 90
		return Integer.parseInt(heure.substring(0, heure.indexOf(":")))*60 + Integer.parseInt(heure.substring(heure.indexOf(":")));
	}
	
}
