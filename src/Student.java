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
     private ArrayList<String> favActivities;

     /**
     * This is the constructor.  It's goal is to validate the arguments and set
     * valid values in the instance variables
     *  eg. firstName,LastName and studentNumber
     */
    public Student(String firstName, String lastName, int studentNumber)
    {
        setFirstName(firstName);
        setLastName (lastName);
        setStudentNumber(studentNumber);
        setStudentImage(studentImage);
        favActivities = new ArrayList<>();

    }

     /**
      *  This will return image
      * @return
      */
     public Image getStudentImage() {
         return studentImage;
     }

     /**
      * This method sets the student image
      * @param studentImage
      */
     public void setStudentImage(Image studentImage) {
         this.studentImage = studentImage;
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
      * This method will return activities of student
      * * @return
      * @return
      */
     public ArrayList<String> getFavActivities() {
         return favActivities;
     }


     /**
      *  This method checks ArrayList should not be empty
      */
     public void addFavActivities(String activities){
         if (!activities.isEmpty())
             favActivities.add(activities);
         else
             throw new IllegalArgumentException("Favourite activities must not be empty.");
     }

     /**
      * This method will get the activities of student and convert the list into  string
      * @return
      */

     public String getFavActivitiesString(){
         StringBuilder sb = new StringBuilder();
         for (String activities: favActivities)
             sb.append(String.format("%s%n",activities));
         return sb.toString();
     }

     /**
      *  A toString() method that returns a String in form of firstName lastName and student #: 123456
      * @return
      */
        public String toString()
        {
            return String.format("%s %s Student #: %d " +
                    "\n Favourite Activities are:%n%s",firstName,lastName,studentNumber, favActivities);

        }


 }
