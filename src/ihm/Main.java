package ihm;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< HEAD
		System.out.println("Lancement de l'application");
        Parent root = FXMLLoader.load(getClass().getResource("ressources/Menu.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("ressources/Choix_joueur.fxml"));
>>>>>>> 8234d1247461715477e5a73a00bb6c077372e26d
        primaryStage.setTitle("Shadow Hunters");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
