package radioMonteCarlo.view;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import radioMonteCarlo.model.Artiste;
import radioMonteCarlo.model.Genre;
import radioMonteCarlo.model.Heure;
import radioMonteCarlo.model.Representation;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.controller.main;

public class CtrlRepresentation {

    @FXML private ChoiceBox<Spectacle> cbSpectacle;
    @FXML private ChoiceBox<String> cbHeure;
    @FXML private Button bnValider;
    @FXML private Button bnAnnuler;
    @FXML private DatePicker dpJour;
    
    
    @FXML
    void updateCbHeure(ActionEvent event) {
    	if (dpJour.getValue() != null && cbSpectacle.getValue() != null) {
	    	
	    	cbHeure.getItems().clear();
	    	for (int temps = Heure.HORAIRE_OUVERTURE; temps <= Heure.HORAIRE_FERMETURE-cbSpectacle.getValue().getDuree(); temps+=15) {
	    		cbHeure.getItems().add(Heure.intToString(temps));
	    	}
	    	
	    	for (Representation repr: Representation.list) {
	    		
	    		if (repr.getDate().equals(dpJour.getValue().toString())) {
	    			int heureDebut = Heure.stringToInt(repr.getHeure());
	    			int duree = repr.getSpectacle().getDuree();
	    			
	    			for (int temps=heureDebut; temps < heureDebut+duree+15; temps += 15) {
	    				cbHeure.getItems().remove(Heure.intToString(temps));
	    			}
	    		}
	    	}
    	}
    }
    
    @FXML
    void clicValider(ActionEvent event) {
    	Representation rep = new Representation(dpJour.getValue().toString(), cbHeure.getValue(), false,cbSpectacle.getValue());
    	cbSpectacle.getValue().ajoutRepresentation(rep);
    	System.out.println(Representation.list);
    	
    	this.reinitialiserValeurs();
    	
    	main.fermerRepresentation();
    }

    @FXML
    void clicAnnuler(ActionEvent event) {
    	main.fermerRepresentation();
    	this.reinitialiserValeurs();
    }
    
    void reinitialiserValeurs() {
    	cbSpectacle.valueProperty().set(null);
    	cbHeure.valueProperty().set(null);
    	dpJour.valueProperty().set(null);
    }
    
    public void initialize() {
    	cbSpectacle.getItems().addAll(Spectacle.list);
    	
    	bnValider.setDefaultButton(true);
    	bnAnnuler.setCancelButton(true);
    	
    	// Disable validation si valeur pas toutes remplies
    	bnValider.disableProperty().bind(
    			Bindings.when(Bindings.or(Bindings.or(cbSpectacle.valueProperty().isNull(), dpJour.armedProperty()), cbHeure.valueProperty().isNull())).
    			then(true).otherwise(false)
    			);
    	
    	
    	
    	// Disable choix jour si Spectacle pas choisi.
    	dpJour.disableProperty().bind(
    			Bindings.when(cbSpectacle.valueProperty().isNull()).
    			then(true).otherwise(false)
    			);

    	// Disable choix heure si Spectacle ou Jour pas choisi.
    	cbHeure.disableProperty().bind(
    			Bindings.when(Bindings.or(cbSpectacle.valueProperty().isNull(), dpJour.valueProperty().isNull())).
    			then(true).otherwise(false)
    			);
    }
}

