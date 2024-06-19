package radioMonteCarlo.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

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
import radioMonteCarlo.model.Representation;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.model.Statistique;
import radioMonteCarlo.controller.main;

public class CtrlStatistiques {
	ObservableList<Statistique> liste = FXCollections.observableArrayList();
	

    @FXML private Button bnOk;
    @FXML private Label LabelDate;
    @FXML TableView<Statistique> listStatistiques=new TableView<>()	;
    @FXML TableColumn<Statistique, String> nomSpectacle=new TableColumn<>();
    @FXML TableColumn<Statistique,String> date;
    @FXML TableColumn<Statistique,String> heure;
    @FXML TableColumn<Statistique,String> nom;
    @FXML TableColumn<Statistique,Integer> nbBilletRepr;
    @FXML TableColumn<Statistique,Integer> nbRepr;
    @FXML TableColumn<Statistique,Integer> nbBilletTotals;
    
    
    @FXML void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }
    
    public void initialize() {
    	listStatistiques.setItems(liste);
    	
    	LabelDate.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

    	date.setCellValueFactory(new PropertyValueFactory<Statistique, String>("dateRepr"));
	
    	heure.setCellValueFactory(new PropertyValueFactory<Statistique, String>("heureRepr"));
    	heure.setSortable(false);
		
    	nom.setCellValueFactory(new PropertyValueFactory<Statistique, String>("nomSpec"));
		
    	nbBilletRepr.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletRepr"));
    	nbBilletRepr.setSortable(false);
		
    	nbRepr.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbRepr"));
    	nbRepr.setSortable(false);
		
    	nbBilletTotals.setCellValueFactory(new PropertyValueFactory<Statistique, Integer>("nbBilletTotal"));
    	nbBilletTotals.setSortable(false);

    	for (Representation repr : Representation.list) {
    		listStatistiques.getItems().add(new Statistique(repr.getSpectacle(), repr));
		}
    	
    	listStatistiques.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
	