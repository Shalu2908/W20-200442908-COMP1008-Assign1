import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private TextArea favActTextArea;

    private Student selectedStudent;


    /**
     * This method will initialize variables and get values from student class
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        firstNameLabel.setText("");
       lastNameLabel.setText("");
       studentNumLabel.setText("");
    }

    /**
     * This method will get the data from the student object
     * @param student
     */
    public void getDataFromObject(Student student) {
        selectedStudent = student;
        firstNameLabel.setText(String.format("First Name: %s", student.getFirstName()));
        lastNameLabel.setText(String.format("Last Name: %s", student.getLastName()));
        studentNumLabel.setText(String.format("Student Number: %d", student.getStudentNumber()));
        studentImageView.setImage(student.getStudentImage());
        favActTextArea.setText(student.getFavActivitiesString());
    }


}
