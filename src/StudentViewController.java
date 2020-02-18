import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    @FXML
    private ImageView studentImageView;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label studentNumLabel;

    @FXML
    private ListView listView;


    /**
     * This method will initialize variables and get values from student class
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Student Student1 = new Student ("shalu","sharma",200442908) ;
        firstNameLabel.setText(String.format("First Name: %s",Student1.getFirstName()));
        lastNameLabel.setText(String.format("Last Name: %s",Student1.getLastName()));
        studentNumLabel.setText(String.format("Student Number: %d",Student1.getStudentNumber()));
        studentImageView.setImage(new Image("./images/studentImage.jpg"));


        listView.getItems().addAll("Dancing" , "Cooking", "Reading", "Listen to Music"," Meditation");

    }
}
