package radioMonteCarlo.view;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenRepresentation extends Stage {
	CtrlRepresentation ctrl = new CtrlRepresentation();
	
	
	public FenRepresentation() throws IOException {
		this.setTitle("Nouvelle représentation");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/creationRepresentation.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void afficher() {
		this.show();
		ctrl.initialize();
	}
}

