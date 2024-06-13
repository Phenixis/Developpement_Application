package radioMonteCarlo.view;

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
    @FXML private TableView<Statistique> listStatistiques=new TableView<>()	;
    @FXML private TableColumn<Statistique, String> colSpectacle;
    @FXML private TableColumn<Statistique, String> colDate;
    @FXML private TableColumn<Statistique, String> colHeure;
    @FXML private TableColumn<Statistique, Boolean> colAnnulation;
    @FXML private TableColumn<Statistique, String> colBillet;
    @FXML private TableColumn<Statistique, String> colBilletsTotal;
    @FXML private TableColumn<Statistique, String> colNbRep;
    
    
    
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
    	
    	System.out.println(liste);
    	colSpectacle.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colSpectacle"));
    	colDate.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colDate"));
    	colHeure.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colHeure"));
    	colAnnulation.setCellValueFactory(new PropertyValueFactory<Statistique,Boolean>("colAnnulation"));
    	colBillet.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colBillet"));
    	colBilletsTotal.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colBilletsTotal"));
    	colNbRep.setCellValueFactory(new PropertyValueFactory<Statistique,String>("colNbRep"));
    	
    	
    	
    	ObservableList<Statistique> ajout = FXCollections.observableArrayList(
                liste
        );
    	
    	listStatistiques.setItems(ajout);
    	
    }
}
