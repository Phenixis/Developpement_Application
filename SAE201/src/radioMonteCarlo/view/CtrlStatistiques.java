package radioMonteCarlo.view;

import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import radioMonteCarlo.model.Statistique;
import radioMonteCarlo.controller.main;

public class CtrlStatistiques {

    @FXML private Button bnTriDate;
    @FXML private Button bnTriSpectacle;
    @FXML private Button bnOk;
    @FXML private Label LabelDate;
    @FXML private TableView<Statistique> listStatistiques;

    @FXML void clicTriSpectacle(ActionEvent event) {

    }

    @FXML void clicTriDate(ActionEvent event) {

    }

    @FXML void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }
    
    public void initialize() {
    	LabelDate.setText(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
    }
}
