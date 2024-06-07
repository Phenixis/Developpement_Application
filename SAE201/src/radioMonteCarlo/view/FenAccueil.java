package radioMonteCarlo.view;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenAccueil extends Stage {
	
	public FenAccueil() throws IOException {
		this.setTitle("Accueil");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Accueil.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
}

