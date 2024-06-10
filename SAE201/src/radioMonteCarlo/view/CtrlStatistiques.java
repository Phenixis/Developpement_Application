package radioMonteCarlo.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import radioMonteCarlo.Statistique;
import radioMonteCarlo.controller.main;

public class CtrlStatistiques {

    @FXML
    private Button bnTriDate;

    @FXML
    private Button bnTriSpectacle;

    @FXML
    private Button bnOk;

    @FXML
    private TableView<Statistique> listStatistiques;

    @FXML
    void clicTriSpectacle(ActionEvent event) {

    }

    @FXML
    void clicTriDate(ActionEvent event) {

    }

    @FXML
    void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }

}
