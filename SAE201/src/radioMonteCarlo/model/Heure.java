package radioMonteCarlo.model;

public class Heure {
	static public float intToMin(int heure) {
		return heure/60;
	}
	
	static public String intToString(int heure) {
		// heure = 90, return = "01:30"
		int nbHeure = (int) (Heure.intToMin(heure)*60);
		
		return "" + nbHeure + ":" + (heure-nbHeure*60);
	}
	
}
