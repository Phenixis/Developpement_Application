package radioMonteCarlo.model;

public class Heure {
	static public final int JOURNEE = 24*60; 
	static public final int HORAIRE_OUVERTURE = Heure.stringToInt("18h30");
	static public final int HORAIRE_FERMETURE = Heure.stringToInt("01h00")+Heure.JOURNEE;
	static private final String separateur = "h";
	
	static public float intToMin(int minutes) {
		// minutes = 90, return = 1.5
		if (minutes > Heure.JOURNEE) {
			minutes = minutes%Heure.JOURNEE;
		}
		return minutes/60;
	}
	
	static public int minToInt(float heure) {
		// heures = 1.5, return 90
		return (int) (heure*90);
	}
	
	static public String intToString(int heure) {
		// heure = 90, return = "01:30"
		String res = "";
		
		int nbHeure = (int) (Heure.intToMin(heure));
		
		if (nbHeure < 10) {
			res = res + "0";
		}
		
		res = res + nbHeure + Heure.separateur;
		
		if (heure%60 < 10) {
			res = res + "0";
		}
		
		res = res + (heure%60);
		
		return res;
	}
	
	static public int stringToInt(String heure) {
		// heure = "01:30", return = 90
		return Integer.parseInt(heure.substring(0, heure.indexOf(Heure.separateur)))*60 + Integer.parseInt(heure.substring(heure.indexOf(Heure.separateur)+1));
	}
	
}
