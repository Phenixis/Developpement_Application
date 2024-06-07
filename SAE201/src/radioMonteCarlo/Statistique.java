package radioMonteCarlo;

import java.util.ArrayList;

public class Statistique {
	
    ArrayList<Information> listeInfo=new ArrayList<>();
    
    
    
    public Statistique() {
		
	}



	public void ajoutInformation(Information info) {
    	listeInfo.add(info);
    }


}