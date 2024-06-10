package radioMonteCarlo.view;

import java.util.Date;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import radioMonteCarlo.model.Representation;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.controller.main;

public class CtrlRepresentation {

    @FXML private ChoiceBox<Spectacle> cbSpectacle;
    @FXML private ChoiceBox<Date> cbHeure;
    @FXML private Button bnValider;
    @FXML private Button bnAnnuler;
    @FXML private DatePicker dpJour;
    Spectacle oui = new Spectacle("oui",10,"ui",10);
    Date non = new Date();
    @FXML
    void clicValider(ActionEvent event) {
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
    	cbHeure.getItems().add(non);
    }
    
    
}

