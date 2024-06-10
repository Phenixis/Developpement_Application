package radioMonteCarlo.view;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.controller.main;

public class CtrlRepresentation {

    @FXML private ChoiceBox<Spectacle> cbSpectacle;

    @FXML private ChoiceBox<Date> cbHeure;

    @FXML private Button bnValider;

    @FXML private Button bnAnnuler;

    @FXML private DatePicker dpJour;

    @FXML
    void clicValider(ActionEvent event) {

    }

    @FXML
    void clicAnnuler(ActionEvent event) {
    	main.fermerRepresentation();
    }

}

