package radioMonteCarlo.view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import radioMonteCarlo.model.Artiste;
import radioMonteCarlo.controller.main;

public class CtrlSpectacle {

    @FXML private ImageView imageScene;
    @FXML private Button bnGauche;
    @FXML private Button bnDroite;
    @FXML private Button bnAnnuler;
    @FXML private Button bnValider;
    @FXML private ListView<Artiste> listViewArtistesSelectionnés;
    @FXML private ListView<Artiste> listViewArtistes;
    @FXML private TextField txtTarifBalcon;
    @FXML private TextField txtDuree;
    @FXML private TextField txtTarifLoges;
    @FXML private TextField txtNbSpec;
    @FXML private TextField txtTarifOrchestre;
    @FXML private TextField txtNom;
    @FXML private ChoiceBox<String> cbGenre;

    @FXML void clicDroite(ActionEvent event) {

    }

    @FXML void clicGauche(ActionEvent event) {

    }

    @FXML void clicValider(ActionEvent event) {

    }

    @FXML void clicAnnuler(ActionEvent event) {
    	main.fermerSpectacle();
    }
    
    public void initialize() {
    	BooleanBinding manque = Bindings.and(
    		Bindings.and(txtTarifLoges.textProperty().isEmpty()
    					,txtDuree.textProperty().isEmpty())
    		,Bindings.and(txtTarifOrchestre.textProperty().isEmpty()
    					,txtNbSpec.textProperty().isEmpty())
    	);
    	
    	bnValider.disableProperty().bind(
    		Bindings.when(manque).
    		then(true).otherwise(false)
    	);	
    }

}

