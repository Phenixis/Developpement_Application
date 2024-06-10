package radioMonteCarlo.view;

import java.util.Date;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
    Spectacle oui = new Spectacle("oui",10,"ui",10);
    
    @FXML
    void clicValider(ActionEvent event) {
    	Representation rep = new Representation(dpJour.getValue().toString(), cbHeure.getValue(), false,cbSpectacle.getValue());
    	System.out.println(rep);
    }

    @FXML
    void clicAnnuler(ActionEvent event) {
    	main.fermerRepresentation();
    	cbSpectacle.valueProperty().set(null);
    	cbHeure.valueProperty().set(null);
    	dpJour.valueProperty().set(null);
    }
    
    public void initialize() {
    	bnValider.setDefaultButton(true);
    	bnAnnuler.setCancelButton(true);
    	bnValider.disableProperty().bind(
    			Bindings.when(Bindings.or(Bindings.or(cbSpectacle.valueProperty().isNull(), dpJour.armedProperty()), cbHeure.valueProperty().isNull())).
    			then(true).otherwise(false)
    			);
    	cbSpectacle.getItems().add(oui);
    	
    	cbHeure.disableProperty().bind(
    			Bindings.when(Bindings.or(cbSpectacle.valueProperty().isNull(), dpJour.armedProperty())).
    			then(true).otherwise(false)
    			);
    	
    	
    	
    	for (int temps = 15; temps <= 3*60; temps+=15) {
    		System.out.println(temps);
    		if (true) { // vérifier la disponibilité par rapport à la date
    			cbHeure.getItems().add(Heure.intToString(temps));    			
    		}
    	}
    }
    
    
}

