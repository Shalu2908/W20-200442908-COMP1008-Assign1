import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {

    @FXML
    private ImageView newStudentImageView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField stuNumTextField;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private Label ageLabel;

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

//    @FXML
//    private Button viewStudentButton;

    // Made a Private newStudent Object
    private Student newStudent;


    /**
     * This method will set initial values of the fields
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        stuNumTextField.setText(String.valueOf(Student.getStudentNumber()+1));
        ageLabel.setVisible(false);
        stuNumTextField.setEditable(false);
        errorLabel.setText("");
        newStudentImageView.setImage(new Image("./Images/image.png"));
    }

    /**
     * This method will launch Filechooser object so that user can choose an image when user pushes the button
     */
    public void fileChooseButtonPushed(ActionEvent event)
    {
        //here we will get the stage to open up the window
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Open Image");

        // set filters for .jpg and .png
        FileChooser.ExtensionFilter imageFilters = new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png");
        filechooser.getExtensionFilters().add(imageFilters);

        // set the start directory
        String userDirectoryString  = System.getProperty("user.home")+"\\Pictures";
        File userDirectory = new File(userDirectoryString);

        // it will make sure that our File can reach the directory
        if(!userDirectory.canRead())
            userDirectory = new File(System.getProperty("user.home"));

        //set the fileChooser to start with userDirectory
        filechooser.setInitialDirectory(userDirectory);

        // it will make the file chooser visible
        File imageFile = filechooser.showOpenDialog(stage);

        // now imageFile is not null and if the user cancels to choose the image it would not give null pointer exception
        if(imageFile != null && imageFile.isFile())
        {
           newStudentImageView.setImage(new Image(imageFile.toURI().toString()));
        }


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
                newStudent = new Student (firstNameTextField.getText(), lastNameTextField.getText(), birthdayPicker.getValue(),newStudentImageView.getImage());
                addFavouriteActivities();
                System.out.println("New Student :"+ newStudent);
                Main.getStudentsList().add(newStudent);
                changeScreenOnButtonPushed(event);

            }catch (IllegalArgumentException | IOException e )
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

        if(birthdayPicker.getValue()== null)
        {
            if(errorMessage.isEmpty())
                errorMessage = "Student age must be set.";
            else if (firstNameTextField.getText().isEmpty() &&
            !lastNameTextField.getText().isEmpty())
                errorMessage = "First name and student birthday field must not be empty.";

            else if (!firstNameTextField.getText().isEmpty() &&
                     lastNameTextField.getText().isEmpty())
                errorMessage = "Last name and birthday field must not be empty.";
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
            newStudent.addFavActivities("Reading");

        if(playingCheckBox.isSelected())
            newStudent.addFavActivities("Playing");

        if(runningCheckBox.isSelected())
            newStudent.addFavActivities("Running");

        if(photographyCheckBox.isSelected())
            newStudent.addFavActivities("Photography");

        if(dancingCheckBox.isSelected())
            newStudent.addFavActivities("Dancing");

        if(skiingCheckBox.isSelected())
            newStudent.addFavActivities("Skiing");

        if(gamingCheckBox.isSelected())
            newStudent.addFavActivities("Gaming");

        if(shoppingCheckBox.isSelected())
            newStudent.addFavActivities("Shopping");
    }
    /**
     * This method will change the screen and pass the information from the selected student to the student object
     */

    public void changeScreenOnButtonPushed(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StudentsView.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        StudentViewController controller = loader.getController();
        controller.selectedStudent(newStudent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.setTitle("View Students");
        window.show();

    }

    /**
     *  This method will get the age from student object and show it when date is choose from the DatePicker
     */

    public void onAction(ActionEvent event)
    {
        ageLabel.setText("Age :"+(Period.between(birthdayPicker.getValue(), LocalDate.now()).getYears()));
        ageLabel.setVisible(true);
    }

    /**
     *  This method will load the default student
     */

    public void getDefaultStudent(ActionEvent event) throws IOException {

        firstNameTextField.setText("Shalu");
        lastNameTextField.setText("Sharma");
        birthdayPicker.setValue(LocalDate.of(1999,1,1));
        shoppingCheckBox.setSelected(true);
        dancingCheckBox.setSelected(true);
        newStudentImageView.setImage(new Image("./Images/studentImage.jpg"));
    }


}
