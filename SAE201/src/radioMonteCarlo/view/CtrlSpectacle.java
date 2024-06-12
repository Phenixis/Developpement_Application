package radioMonteCarlo.view;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import radioMonteCarlo.model.Artiste;
import radioMonteCarlo.controller.main;
import radioMonteCarlo.model.Genre;
import radioMonteCarlo.model.Heure;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.model.Tarif;
import radioMonteCarlo.model.Zone;

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
   
    @FXML private Label labelErreurNom;

    @FXML private Label labelErreurTarifs;

    @FXML private Label LabelErreurNbSpec;

    ArrayList<Artiste> artiste = new ArrayList<>();
    Artiste a = new Artiste("oui");
    @FXML void clicDroite(ActionEvent event) {
    	
    }

    @FXML void clicGauche(ActionEvent event) {

    }

    @FXML void clicValider(ActionEvent event) {
    	// VERIFIER si les valeurs son numerique et tout
    	
    	// SINON afficher texte erreur sur l'IHM
    	
    	// Dans le cas où c bon
    	
    	Tarif t1 = new Tarif(new Zone("Balcon"),Integer.parseInt(txtTarifBalcon.getText()));
    	Tarif t2 = new Tarif(new Zone("Loges"),Integer.parseInt(txtTarifLoges.getText()));
    	Tarif t3 = new Tarif(new Zone("Orchestre"),Integer.parseInt(txtTarifOrchestre.getText()));
    	for(Artiste i : listViewArtistesSelectionnés.getItems()) {
    		artiste.add(i);
    	}
    	
    	Spectacle spectacle = new Spectacle(txtNom.getText(),Heure.stringToInt(cbDuree.getValue()),cbGenre.getValue(),Integer.parseInt(txtNbSpec.getText()),artiste);
    	
    	main.fermerSpectacle();
    	initialize();
    }

    @FXML void clicAnnuler(ActionEvent event) {
    	main.fermerSpectacle();
    	initialize();
    }
    
    @FXML
    void appuieTxtNbSpec(KeyEvent event) {

    }

    @FXML
    void appuieTarifBalcon(KeyEvent event) {

    }

    @FXML
    void appuieTarifOrchestre(KeyEvent event) {

    }

    @FXML
    void appuieTarifLoges(KeyEvent event) {

    }
    
    void reinitialiser() {
    	txtTarifBalcon.setText(null);
    	txtTarifOrchestre.setText(null);
    	txtTarifLoges.setText(null);
    	txtNom.setText(null);
    	txtNbSpec.setText(null);
    	cbDuree.setValue(null);
    	cbGenre.setValue(null);
    }
    
    public void initialize() {
    	this.reinitialiser();
    	
    	// Property False si il manque une information
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
    	
    	// Disable validation si il manque une information
    	bnValider.disableProperty().bind(
    		Bindings.when(manque).
    		then(true).otherwise(false)
    	);	
    	
    	// Rempli cbGenre
    	cbGenre.getItems().addAll(Genre.liste);
    	
    	// Rempli cbDuree
    	for (int temps = 15; temps <= 3*60; temps+=15) {
    		cbDuree.getItems().add(Heure.intToString(temps));
    	}
    	listViewArtistesSelectionnés.getItems().add(a);
    	
    }
    
    private boolean estDecimal(String str) {
    	return str.matches("\\d*(\\.\\d+)?");
    }
    
    private boolean estEntier(String str) {
    	return str.matches("\\d*");
  	}
    
    
    
    	

}

