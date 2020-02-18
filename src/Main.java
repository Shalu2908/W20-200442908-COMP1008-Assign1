import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    /**
     * This extends Application and add the start () method
     */
    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start (Stage window) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Student Card");
        window.show();
    }

}
