package radioMonteCarlo.view;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenSpectacle extends Stage {
	CtrlSpectacle ctrl = new CtrlSpectacle();
	public FenSpectacle() throws IOException {
		this.setTitle("Nouveau Spectacle");
		Scene laScene = new Scene(creerSceneGraph());
		
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/creationSpectacle.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
	
	public void afficher() {
		this.show();
		ctrl.initialize();
	}
}

