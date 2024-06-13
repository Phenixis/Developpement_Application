package radioMonteCarlo.view;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenStatistiques extends Stage {
	CtrlStatistiques ctrl = new CtrlStatistiques();
	public FenStatistiques() throws IOException {
		this.setTitle("Statistiques");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/affichageStatistiques.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
	
	public void afficher() {
		this.show();
		ctrl.initialize();
	}
}

