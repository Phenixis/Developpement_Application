package radioMonteCarlo.view;

import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
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
    @FXML private TableView<Statistique> listStatistiques;

    @FXML void clicTriSpectacle(ActionEvent event) {
    	
    }

    @FXML void clicTriDate(ActionEvent event) {

    }

    @FXML void clicOk(ActionEvent event) {
    	main.fermerStatistiques();
    }
    
    public void initialize() {
        
    	/*ArrayList<Artiste>()
    	
    	new Artiste("Jean Dupont");
        new Artiste("Marie Curie");
        new Artiste("Ludwig Beethoven");
    	
        new Spectacle("Jean",45,Genre.liste[0],47,);
        new Spectacle("Jean",15,Genre.liste[2],62);
        new Spectacle("Jean",60,Genre.liste[0],38);
        new Spectacle("Jean",30,Genre.liste[5],25);*/
    	
        System.out.println(Spectacle.list.size());
        
    	for(Spectacle spec : Spectacle.list) {
    		liste.add(Statistique.calculerStats(spec));
    	}
    	
    	LabelDate.setText(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
    	
		listStatistiques.setItems(liste);
		listStatistiques.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
