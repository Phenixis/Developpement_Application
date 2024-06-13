package radioMonteCarlo.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import radioMonteCarlo.model.Artiste;
import radioMonteCarlo.model.Genre;
import radioMonteCarlo.model.Representation;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.model.Statistique;
import radioMonteCarlo.controller.main;

public class CtrlStatistiques {
	ObservableList<Statistique> liste = FXCollections.observableArrayList(Statistique.liste);
	
    @FXML private Button bnTriDate;
    @FXML private Button bnTriSpectacle;
    @FXML private Button bnOk;
    @FXML private Label LabelDate;
    @FXML TableView<Statistique> listStatistiques=new TableView<>()	;
    @FXML TableColumn<Statistique, String> nomSpectacle=new TableColumn<>();
    
    @FXML void clicTriSpectacle(ActionEvent event) {
    	
    }

    @FXML void clicTriDate(ActionEvent event) {

    }

    @FXML void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }
    
    void updateListe() {
    	liste.clear();
    	for(Spectacle spec : Spectacle.list) {
    		liste.add(new Statistique(spec));
    	}
    	System.out.println(liste);
    	listStatistiques.setItems(liste);
    }
   
    
    public void initialize() {
    	new Artiste("Jean Dupont");
    	new Artiste("Marie Curie");
    	new Artiste("Ludwig Beethoven");

    	TableColumn<Statistique,String> dateRepr = new TableColumn<Statistique,String>("Date de la représentation");
		dateRepr.setCellValueFactory(new PropertyValueFactory<Statistique,String>("dateRepr"));
		listStatistiques.getColumns().set(0, dateRepr);
		
		TableColumn<Statistique, String> heureRepr = new TableColumn<Statistique,String>("Heure de la représentation");
		heureRepr.setCellValueFactory(new PropertyValueFactory<Statistique, String>("heureRepr"));
		listStatistiques.getColumns().set(1, heureRepr);
		
		TableColumn<Statistique, String> nomSpec = new TableColumn<Statistique,String>("Nom du spectacle");
		nomSpec.setCellValueFactory(new PropertyValueFactory<Statistique, String>("nomSpec"));
		listStatistiques.getColumns().set(2, nomSpec);
		
		TableColumn<Statistique,Integer> nbBilletRepr = new TableColumn<Statistique,Integer>("Nombre de billets vendus pour la représentation");
		nbBilletRepr.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletRepr"));
		listStatistiques.getColumns().set(3, nbBilletRepr);
		
		TableColumn<Statistique,Integer> nbRepr = new TableColumn<Statistique,Integer>("Nombre de représentation");
		nbRepr.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbRepr"));
		listStatistiques.getColumns().set(4, nbRepr);
		
		TableColumn<Statistique,Integer> nbBilletTotal = new TableColumn<Statistique,Integer>("Nombre de billets vendus total");
		nbBilletTotal.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletTotal"));
		listStatistiques.getColumns().set(5, nbBilletTotal);

    	listStatistiques.setItems(liste);
    	listStatistiques.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
