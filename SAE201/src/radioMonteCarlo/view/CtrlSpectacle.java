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
import radioMonteCarlo.model.Genre;

public class CtrlSpectacle {

    @FXML private ImageView imageScene;
    @FXML private Button bnGauche;
    @FXML private Button bnDroite;
    @FXML private Button bnAnnuler;
    @FXML private Button bnValider;
    @FXML private ListView<Artiste> listViewArtistesSelectionnés;
    @FXML private ListView<Artiste> listViewArtistes;
    @FXML private TextField txtTarifBalcon;
    @FXML private TextField txtTarifLoges;
    @FXML private TextField txtNbSpec;
    @FXML private TextField txtTarifOrchestre;
    @FXML private TextField txtNom;
    @FXML private ChoiceBox<String> cbGenre;
    @FXML private ChoiceBox<String> cbDuree;

    @FXML void clicDroite(ActionEvent event) {

    }

    @FXML void clicGauche(ActionEvent event) {

    }

    @FXML void clicValider(ActionEvent event) {

    }

    @FXML void clicAnnuler(ActionEvent event) {
    	main.fermerSpectacle();
    	initialize();
    }
    
    public void initialize() {
    	txtTarifBalcon.setText("");
    	txtTarifOrchestre.setText("");
    	txtTarifLoges.setText("");
    	txtNom.setText("");
    	txt.setText("");
    	cbDuree.setValue("1h30");
    	cbGenre.setValue("");
    	
    	
    	
    	BooleanBinding manque = Bindings.or(
    		Bindings.or(
    			Bindings.or(
    				Bindings.or(txtTarifLoges.textProperty().isEmpty()
    					,cbDuree.valueProperty().isNull())
    				,Bindings.or(txtTarifOrchestre.textProperty().isEmpty()
    					,txtNbSpec.textProperty().isEmpty())
    			),Bindings.or(txtTarifBalcon.textProperty().isEmpty()
    					,txtNom.textProperty().isEmpty()))
    		,cbGenre.valueProperty().isNull()
    	);
    	
    	bnValider.disableProperty().bind(
    		Bindings.when(manque).
    		then(true).otherwise(false)
    	);	
    	
    	cbGenre.getItems().addAll(Genre.liste);
    	
    }
    
    private boolean estDecimal(String str) {
    	return str.matches("\\d*(\\.\\d+)?");
    }
    
    private boolean estEntier(String str) {
    	return str.matches("\\d*");
  	}

}

