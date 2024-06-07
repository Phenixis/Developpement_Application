/**
 * 
 */
/**
 * @author racorre
 *
 */
module SAE201 {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	opens radioMonteCarlo to javafx.graphics, javafx.fxml, javafx.base;
	opens radioMonteCarlo.view to javafx.graphics, javafx.fxml, javafx.base;
	opens radioMonteCarlo.controller to javafx.graphics, javafx.fxml, javafx.base;
	
}