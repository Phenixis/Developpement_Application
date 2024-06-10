package radioMonteCarlo.model;

import java.util.ArrayList;

public class Genre {
	
	static String[] liste = {"Danse", "Opera", "Musique", "Cirque", "Marionnette", "Theatre"};
	
	static boolean contains(String value) {
		for(String genre: Genre.liste) {
			if (value.equals(genre)) {
				return true
			}
		}
		
		return false;
	}
}
