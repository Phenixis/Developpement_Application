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
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.model.Statistique;
import radioMonteCarlo.controller.main;

public class CtrlStatistiques {
	ObservableList<Statistique> liste = FXCollections.observableArrayList();
	
    @FXML private Button bnTriDate;
    @FXML private Button bnTriSpectacle;
    @FXML private Button bnOk;
    @FXML private Label LabelDate;
    @FXML  TableView<Statistique> listStatistiques=new TableView<>()	;
    @FXML  TableColumn<Statistique, String> nomSpectacle=new TableColumn<>();

  
    
    
    
    @FXML void clicTriSpectacle(ActionEvent event) {
    	
    }

    @FXML void clicTriDate(ActionEvent event) {

    }

    @FXML void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }
   
    
    public void initialize() {
        
    	
    	new Artiste("Jean Dupont");
        new Artiste("Marie Curie");
        new Artiste("Ludwig Beethoven");
    	
       
    	
        System.out.println(Spectacle.list.size());
        
    	for(Spectacle spec : Spectacle.list) {
    		liste.add(Statistique.calculerStats(spec));
    	}
    	
    	nomSpectacle.setCellValueFactory(new PropertyValueFactory<Statistique,String>("nomSpectacle"));
    	
    	
    	
    	
    	System.out.println(liste);
    	listStatistiques.getItems().addAll(liste);
    	listStatistiques.setItems(liste);
    	
    }
}
