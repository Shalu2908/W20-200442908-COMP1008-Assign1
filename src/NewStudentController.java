import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {


    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField stuNumTextField;

    @FXML
    private Label errorLabel;


    @FXML
    private CheckBox readingCheckBox;

    @FXML
    private CheckBox dancingCheckBox;

    @FXML
    private CheckBox runningCheckBox;

    @FXML
    private CheckBox shoppingCheckBox;

    @FXML
    private CheckBox playingCheckBox;

    @FXML
    private CheckBox gamingCheckBox;

    @FXML
    private CheckBox photographyCheckBox;

    @FXML
    private CheckBox skiingCheckBox;

    // Made a Private newStudent Object
    private Student newStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setText("");
    }

    /**
     * This method enables the submit button to show the error message to user,
     * and the information of newStudent is passed here.
     */
    public void submitDataOnButtonPushed(ActionEvent event)
    {

        if(getErrorMessage())
        {
            try
            {
                newStudent = new Student (firstNameTextField.getText(), lastNameTextField.getText(), Integer.parseInt(stuNumTextField.getText()));
                addFavouriteActivities();

                System.out.println("New Student :"+ newStudent);
            }catch (IllegalArgumentException e)
            {
                errorLabel.setText(e.getMessage());
            }
        }
    }

    /**
     * This will check that all the field must have their values in in it
     * if any field is null, it will display a nice message for user.
     * @return
     */
    public boolean getErrorMessage()
    {
        String errorMessage = "";
        if (firstNameTextField.getText().isEmpty())
            errorMessage = "First name field must not be empty.";

        if (lastNameTextField.getText().isEmpty()) {
            if (errorMessage.isEmpty())
                errorMessage = "Last name field must not be empty.";
            else
                errorMessage = "Both first and last name fields must not be empty.";
        }

        if(stuNumTextField.getText().isEmpty())
        {
            if(errorMessage.isEmpty())
                errorMessage = "Student number field must not be empty.";
            else if (firstNameTextField.getText().isEmpty() &&
            !lastNameTextField.getText().isEmpty())
                errorMessage = "First name and student Number must not be empty.";

            else if (!firstNameTextField.getText().isEmpty() &&
                     lastNameTextField.getText().isEmpty())
                errorMessage = "Last name and student Number must not be empty.";
            else
                errorMessage = "All fields must not be empty.";
        }

        errorLabel.setText(errorMessage);

        if(errorMessage=="")
            return true;
        else
            return false;
    }

    /**
     * This method will add activities in newStudent object
     */

    public void addFavouriteActivities()
    {
        if(readingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Reading"));

        if(playingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Playing"));

        if(runningCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Running"));

        if(photographyCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Photography"));

        if(dancingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Dancing"));

        if(skiingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Skiing"));

        if(gamingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Gaming"));

        if(shoppingCheckBox.isSelected())
            newStudent.addFavActivities(String.format("Shopping"));
    }
    /**
     * This method will change the screen and pass the information from the selected student to the student object
     */

    public void changeScreenOnButtonPushed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentView.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        StudentViewController controller = loader.getController();
        controller.getDataFromObject(newStudent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.setTitle("Student Card");
        window.show();

    }

}
