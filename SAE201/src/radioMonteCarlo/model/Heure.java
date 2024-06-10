package radioMonteCarlo.model;

public class Heure {
	static public intToMin(int heure) {
		return heure/60;
	}
	
	static public intToString(int heure) {
		// heure = 90, return = "01:30"
	}
	
	for (int demiheure = 0; demiheure < 24*60; demiheure+=30) {
		Heure.intToString(demiheure);
	}
}
