package radioMonteCarlo.controller;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
		fStatistiques.afficher();
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
