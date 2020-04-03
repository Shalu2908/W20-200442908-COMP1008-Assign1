import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Student
 {

    /**These are instance variables for a student
     * They are marked as private so that ONLY the student class can control how they are set
     */

     private String firstName, lastName;
     private int newStudentNumber;
     private static int studentNumber = 100000000;
     private LocalDate birthday;
     private Image studentImage;
     private ArrayList<String> favActivities;


     /**
     * This is the constructor.  It's goal is to validate the arguments and set
     * valid values in the instance variables
     *  eg. firstName,LastName and studentNumber
     */
    public Student(String firstName, String lastName, LocalDate birthday)
    {
        setFirstName(firstName);
        setLastName (lastName);
        //newStudentNumber = setStudentNumber(studentNumber);
        newStudentNumber = setStudentNumber(studentNumber);
        setBirthday(birthday);
        setStudentImage(studentImage);
        favActivities = new ArrayList<>();

    }


     /**
      * This method will return birthday of student
      */
     public LocalDate getBirthday() {
         return birthday;
     }
     /**
      * This method sets the birthday
      */
     public void setBirthday(LocalDate birthday) {

        if( Period.between(birthday,LocalDate.now()).getYears() >=10 && Period.between(birthday,LocalDate.now()).getYears() <=120)
             this.birthday = birthday;
         else
           throw new IllegalArgumentException("Student's age must be between 10-120 years.");
     }



     /**
      * This method will calculate the difference between the born year and the present year and returns the age
      */

     public int getAge()
     {
         return Period.between(birthday,LocalDate.now()).getYears();
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
      * This will return the new student
      */
     public int getNewStudentNumber() {
         return newStudentNumber;
     }

     /**
      *  This method will return student number
      * @return
      */
    public static int getStudentNumber()
    {
        //studentNumber++;
        return studentNumber;
    }

     /**
      * This method will put validation on student number
      * @param studentNumber
      */
    private int setStudentNumber(int studentNumber) {
        if (studentNumber >= 100000000 && studentNumber <= 999999999) {
            newStudentNumber = studentNumber;
            studentNumber = Student.studentNumber++;
        }
        else {
            throw new IllegalArgumentException("Student Number must be in between 100000000 to 999999999");
        }
        return  studentNumber;
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
