import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable
{

    @FXML
    private ImageView studentImageView;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label studentNumLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private TextArea favActTextArea;

    @FXML
    private ListView<Student> studentsListView;

    private Student selectedStudent;


    /**
     * This method will initialize variables and get values from student class
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {  firstNameLabel.setText("");
       lastNameLabel.setText("");
       studentNumLabel.setText("");
    }

    /**
     * This method will get the select student
     */

    public void selectedStudent(Student student)
    {
        selectedStudent = student;

        getDataFromObject();
        studentsListView.getItems().addAll(Main.getStudentsList());
    }

    /**
     * This method will get the data from the student object
     * @param
     */
    public void getDataFromObject() {


        firstNameLabel.setText(selectedStudent.getFirstName());
        lastNameLabel.setText(selectedStudent.getLastName());
        studentNumLabel.setText(Integer.toString(Student.getStudentNumber()));
        //studentNumLabel.setText(String.format("Student Number : %20d", Student.getStudentNumber()));
        birthdayLabel.setText(selectedStudent.getBirthday().toString());
        ageLabel.setText(Integer.toString(selectedStudent.getAge()));
        studentImageView.setImage(selectedStudent.getStudentImage());
        favActTextArea.setText(selectedStudent.getFavActivitiesString());


    }

    /**
     * This method will take the user back to Create Student scene and allow to create new student object
     * @param event
     * @throws IOException
     */

    public void createStudent(ActionEvent event) throws IOException
    {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("NewStudentView.fxml"));
        Parent studentView = loader.load();
        Scene studentScene = new Scene(studentView);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(studentScene);
        window.setTitle("Create new student Card");
        window.show();

    }

    /**
     * This method will get the different information for different students and make list of student
     */
     public void listViewSelectedStudent()
     {
         selectedStudent = studentsListView.getSelectionModel().getSelectedItem();
                  getDataFromObject();

     }

}
