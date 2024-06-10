package radioMonteCarlo.model;

public class Genre {
	
	public static String[] liste = {"Danse", "Opera", "Musique", "Cirque", "Marionnette", "Theatre"};
	
	static boolean contains(String value) {
		for(String genre: Genre.liste) {
			if (value.equals(genre)) {
				return true;
			}
		}
		
		return false;
	}
}
