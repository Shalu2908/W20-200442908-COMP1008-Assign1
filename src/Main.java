import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{

    /**
     * Created a staic arrayList that hold all the student object into it
     */
    private static ArrayList<Student> studentsList;
    /**
     * This extends Application and add the start () method
     */
    public static void main(String[] args){
        // Here we are intialize the list to a new list.
        studentsList = new ArrayList<>();
        launch(args);
    }

    /**
     * This method will return the list of student objects
     */
    public  static ArrayList<Student> getStudentsList()
        {
           return studentsList;
        }
    /**
     * This will uploads the window and show student's information on window
     * @param window
     * @throws Exception
     */
    @Override
    public void start (Stage window) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Create Student");
        window.show();
    }

}
