package radioMonteCarlo.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import radioMonteCarlo.controller.main;

public class CtrlAccueil {

    @FXML
    private Button bnQuitter;

    @FXML
    private Button bnStatistiques;

    @FXML
    private Button bnRepresentation;

    @FXML
    private Button bnSpectacle;

    @FXML private VBox easterEgg;

    @FXML
    void clicRepresentation(ActionEvent event) {
    	main.ouvrirRepresentation();
    }

    @FXML
    void clicSpectacle(ActionEvent event) {
    	main.ouvrirSpectacle();
    }

    @FXML
    void clicStatistiques(ActionEvent event) {
    	main.ouvrirStatistiques();
    }

    @FXML
    void clicEasterEgg(ActionEvent event) {

    }

    @FXML
    void clicQuitter(ActionEvent event) {
    	main.fermerAppli();
    }

}
