import javafx.scene.control.ListView;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Student
 {

    /**These are instance variables for a student
     * They are marked as private so that ONLY the student class can control how they are set
     */

    private String firstName, lastName;
    private int studentNumber;
    private Image studentImage;
    private  ListView listView;



     /**
      *  This will return image
      * @return
      */
     public Image getStudentImage() {
         return studentImage;
     }

     /**
     * This is the constructor.  It's goal is to validate the arguments and set
     * valid values in the instance variables
     *  eg. firstName,LastName and studentNumber
     */
    public Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName (lastName);
        setStudentNumber(studentNumber);
    }

     /**
      * These are get/set methods for each instance variables
      * @return
      */

    public String getFirstName() {
        return firstName;
    }

     /**
      * This method will put validation on first name and make the first letter capital
      * @param firstName
      */
    public void setFirstName(String firstName) {

     if( firstName.length() > 1)
        this.firstName = firstName.substring(0,1).toUpperCase()+firstName.substring(1) ;
     else
         throw new IllegalArgumentException("Student first Name should be more than one characters");
    }

    // This method will return the last Name
    public String getLastName() {
        return lastName;
    }

     /**
      * This method will put validation on last name and make the first letter capital
      * @param lastName
      */
    public void setLastName(String lastName) {

        if( lastName.length() > 1)
            this.lastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1);
        else
            throw new IllegalArgumentException("Student's last Name should be more than one characters");
    }

     /**
      *  This method will return student number
      * @return
      */
    public int getStudentNumber() {
        return studentNumber;
    }

     /**
      * This method will put validation on student number
      * @param studentNumber
      */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 100000000 && studentNumber <= 999999999)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("Student Number must be in between 100000000 to 999999999");
    }

     /**
      *  A toString() method that returns a String in form of firstName lastName and student #: 123456
      * @return
      */
        public String toString()
        {
            return String.format("%s %s Student #: %d",firstName,lastName,studentNumber);

        }


 }
