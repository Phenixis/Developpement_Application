package radioMonteCarlo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import radioMonteCarlo.model.Artiste;
import radioMonteCarlo.model.Genre;
import radioMonteCarlo.model.Representation;
import radioMonteCarlo.model.Spectacle;
import radioMonteCarlo.view.CtrlRepresentation;
import radioMonteCarlo.view.FenAccueil;
import radioMonteCarlo.view.FenRepresentation;
import radioMonteCarlo.view.FenSpectacle;
import radioMonteCarlo.view.FenStatistiques;

public class main extends Application {
	static private FenSpectacle fSpectacle;
	static private FenRepresentation fRepresentation;
	static private FenStatistiques fStatistiques;
	static private FenAccueil fAccueil;
	
	public void start(Stage primaryStage) throws Exception {
    	new Artiste("Jean Dupont");
    	new Spectacle("Test", 30, Genre.liste[1], 480, Artiste.liste);
    	new Representation("2024-05-28", "18h30", false, 666, Spectacle.list.get(0));
    	Spectacle.list.get(0).ajoutRepresentation(Representation.list.get(0));
		
		fSpectacle = new FenSpectacle();
		fRepresentation = new FenRepresentation();
		fStatistiques = new FenStatistiques();
		fAccueil = new FenAccueil();
		
		fSpectacle.initModality(Modality.APPLICATION_MODAL);
		fRepresentation.initModality(Modality.APPLICATION_MODAL);
		fStatistiques.initModality(Modality.APPLICATION_MODAL);
		
		fSpectacle.setResizable(false);
		fRepresentation.setResizable(false);
		fStatistiques.setResizable(false);
		fAccueil.setResizable(false);
		
		fAccueil.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void ouvrirSpectacle() {
		fSpectacle.afficher();
	}
	
	public static void ouvrirRepresentation() {
		fRepresentation.afficher();
	}
	
	
	public static void ouvrirStatistiques() {
		try {
			
			fStatistiques = new FenStatistiques();
			fStatistiques.initModality(Modality.APPLICATION_MODAL);
			fStatistiques.setResizable(false);
			fStatistiques.afficher();
		} catch (IOException e) {
		}
	}
	
	public static void fermerSpectacle() {
		fSpectacle.close();
	}
	
	public static void fermerRepresentation() {
		fRepresentation.close();
	}
	
	public static void fermerStatistiques() {
		fStatistiques.close();
	}
	
	public static void fermerAppli() {
		System.exit(0);
	}
}
