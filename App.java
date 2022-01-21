
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		Pane root = new Pane();
		Scene scene = new Scene(root,200,400);
		arg0.setScene(scene);
		arg0.show();
	
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
