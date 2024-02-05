package IdanAshkenazi_AvivZaarur;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

	public static void main(String[] args) {
		
		launch();
		
	}	
		
	public void start(Stage primaryStage) throws Exception	{
		
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);

	}

}
