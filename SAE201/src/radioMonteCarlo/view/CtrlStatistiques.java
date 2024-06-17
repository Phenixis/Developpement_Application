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
	ObservableList<Statistique> liste = FXCollections.observableArrayList();
	
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
    		for (Representation repr : spec.getRepresentations()) {
    			liste.add(new Statistique(spec, repr));
    		}
    	}
    	
    	System.out.println("In updateListe");
    	listStatistiques.setItems(liste);
    	System.out.println(listStatistiques.getItems());
    	listStatistiques.refresh();
    }
   
    
    public void initialize() {
    	new Artiste("Jean Dupont");
    	new Artiste("Marie Curie");
    	new Artiste("Ludwig Beethoven");

    	TableColumn<Statistique,String> colonne1 = new TableColumn<Statistique,String>("Date de la représentation");
    	colonne1.setCellValueFactory(new PropertyValueFactory<Statistique, String>("dateRepr"));
    	listStatistiques.getColumns().set(0, colonne1);
	
    	TableColumn<Statistique, String> colonne2 = new TableColumn<Statistique,String>("Heure de la représentation");
    	colonne2.setCellValueFactory(new PropertyValueFactory<Statistique, String>("heureRepr"));
    	listStatistiques.getColumns().set(1, colonne2);
		
    	TableColumn<Statistique, String> colonne3 = new TableColumn<Statistique,String>("Nom du spectacle");
    	colonne3.setCellValueFactory(new PropertyValueFactory<Statistique, String>("nomSpec"));
    	listStatistiques.getColumns().set(2, colonne3);
		
    	TableColumn<Statistique,Integer> colonne4 = new TableColumn<Statistique,Integer>("Nombre de billets vendus pour la représentation");
    	colonne4.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletRepr"));
    	listStatistiques.getColumns().set(3, colonne4);
		
    	TableColumn<Statistique,Integer> colonne5 = new TableColumn<Statistique,Integer>("Nombre de représentation");
    	colonne5.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbRepr"));
    	listStatistiques.getColumns().set(4, colonne5);
		
    	TableColumn<Statistique,Integer> colonne6 = new TableColumn<Statistique,Integer>("Nombre de billets vendus total");
    	colonne6.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletTotal"));
    	listStatistiques.getColumns().set(5, colonne6);
    	
    	this.updateListe();
    	listStatistiques.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
	