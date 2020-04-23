package ihm;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
    public void start(Stage primaryStage) throws Exception{
		System.out.println("Lancement de l'application");
        Pane root = FXMLLoader.load(getClass().getResource("ressources/Jouer_tour(1)lancer_des.fxml"));
        primaryStage.setTitle("Shadow Hunters");
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
