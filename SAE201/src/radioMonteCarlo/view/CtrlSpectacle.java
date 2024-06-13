package radioMonteCarlo.view;

import java.util.ArrayList;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableNumberValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
    @FXML private Label labelErreurTarifs;
    @FXML private Label LabelErreurNbSpec;
    @FXML private Label LabelErreurArtiste;
    
    ObservableList<Artiste> listArtistes = FXCollections.observableArrayList();
    ObservableList<Artiste> listArtistesSelectionnes = FXCollections.observableArrayList();
    
    ArrayList<Artiste> artistes = new ArrayList<>();
    
    @FXML void selectionne(ActionEvent event) {
    	listArtistesSelectionnes.addAll(listViewArtistes.getSelectionModel().getSelectedItems());
    	for(Artiste a : listArtistesSelectionnes) {
    		listArtistes.remove(a);
    	}
    	listViewArtistesSelectionnés.setItems(listArtistesSelectionnes);
		listViewArtistes.setItems(listArtistes);
		
		if(listArtistesSelectionnes.size() == 0) {
			LabelErreurArtiste.setVisible(true);
		} else {
			LabelErreurArtiste.setVisible(false);
		}
    }

    @FXML void deselectionne(ActionEvent event) {
    	listArtistes.addAll(listViewArtistesSelectionnés.getSelectionModel().getSelectedItems());
    	for(Artiste a : listArtistes) {
    		listArtistesSelectionnes.remove(a);
    	}
    	
    	listViewArtistesSelectionnés.setItems(listArtistesSelectionnes);
		listViewArtistes.setItems(listArtistes);
		
		if(listArtistesSelectionnes.size() == 0) {
			LabelErreurArtiste.setVisible(true);
		} else {
			LabelErreurArtiste.setVisible(false);
		}
    }

    @FXML void clicValider(ActionEvent event) {
    	
    	Tarif t1 = new Tarif(new Zone("Balcon"),Integer.parseInt(txtTarifBalcon.getText()));
    	Tarif t2 = new Tarif(new Zone("Loges"),Integer.parseInt(txtTarifLoges.getText()));
    	Tarif t3 = new Tarif(new Zone("Orchestre"),Integer.parseInt(txtTarifOrchestre.getText()));
    	
    	for(Artiste i : listViewArtistesSelectionnés.getItems()) {
    		artistes.add(i);
    	}
    	
    	Spectacle spectacle = new Spectacle(txtNom.getText(),Heure.stringToInt(cbDuree.getValue()),cbGenre.getValue(),Integer.parseInt(txtNbSpec.getText()),artistes);
    	
    	Artiste.liste.clear();
    	
    	this.initialize();
    	main.fermerSpectacle();
    }

    @FXML void clicAnnuler(ActionEvent event) {
    	Artiste.liste.clear();
    	this.initialize();
    	main.fermerSpectacle();
    }
    
    @FXML
    void appuieTxtNbSpec(KeyEvent event) {
    	if(txtNbSpec.getText().length() == 0) {
    		LabelErreurNbSpec.setVisible(false);
    	}
    	else if(this.estEntier(txtNbSpec.getText()) == false) {
    		LabelErreurNbSpec.setText("Saisie incorrect, la valeur doit être numérique");
        	LabelErreurNbSpec.setVisible(true);
    	}
    	else if(Integer.parseInt(txtNbSpec.getText()) > 480 || Integer.parseInt(txtNbSpec.getText()) < 0) {
    		LabelErreurNbSpec.setText("La valeur ne doit pas excéder 480");
    		txtNbSpec.setText("480");
    		LabelErreurNbSpec.setVisible(true);
    	}
    	else {
    		LabelErreurNbSpec.setVisible(false);
    	}
    }

    @FXML
    void appuieTarif(KeyEvent event) {
    	TextField target = (TextField) event.getTarget();
    	if(target.getText() == null) {
    		if(this.erreurDecimale()) {
        		labelErreurTarifs.setVisible(false);
        	}
    	}
    	else if(!this.estDecimal(target.getText())) {
    		labelErreurTarifs.setText("Les tarifs doivent être numériques");
    		labelErreurTarifs.setVisible(true);
    	}
    }
    
    private boolean erreurDecimale() {
    	return this.estDecimal(txtTarifBalcon.getText()) && this.estDecimal(txtTarifLoges.getText()) && this.estDecimal(txtTarifOrchestre.getText());
    }

    void reinitialiser() {
    	txtTarifBalcon.setText("");
    	txtTarifOrchestre.setText("");
    	txtTarifLoges.setText("");
    	txtNom.setText("");
    	txtNbSpec.setText("480");
    	cbDuree.setValue(null);
    	cbGenre.setValue(null);
    	LabelErreurNbSpec.setVisible(false);
    	labelErreurTarifs.setVisible(false);
    	LabelErreurArtiste.setVisible(false);

    }
    
    public void initialize() {
    	this.reinitialiser();
    	
    	Artiste artiste1 = new Artiste("Jean Dupont");
        Artiste artiste2 = new Artiste("Marie Curie");
        Artiste artiste3 = new Artiste("Ludwig Beethoven");
    	
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
    		,Bindings.or(cbGenre.valueProperty().isNull(), Bindings.or(labelErreurTarifs.visibleProperty(),LabelErreurNbSpec.visibleProperty()))
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

    	// Rempli Liste des artistes
    	listViewArtistes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	listViewArtistesSelectionnés.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    	listArtistes.clear();
    	listArtistesSelectionnes.clear();
    	listArtistes.addAll(Artiste.liste);
		listViewArtistes.setItems(listArtistes);
    	
    }
    
    private boolean estDecimal(String str) {
    	return str.matches("\\d*(\\.\\d+)?");
    }
    
    private boolean estEntier(String str) {
    	return str.matches("\\d*");
  	}
}