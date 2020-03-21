import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
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
    private TextArea favActTextArea;


    /**
     * This method will initialize variables and get values from student class
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Student Student1 = new Student ("shalu","sharma",200442908);
        Student1.addFavActivities("dancing");
        Student1.addFavActivities("reading");
        firstNameLabel.setText(String.format("First Name: %s",Student1.getFirstName()));
        lastNameLabel.setText(String.format("Last Name: %s",Student1.getLastName()));
        studentNumLabel.setText(String.format("Student Number: %d",Student1.getStudentNumber()));
        studentImageView.setImage(Student1.getStudentImage());
        favActTextArea.setText(Student1.getFavActivitiesString());



    }
}
