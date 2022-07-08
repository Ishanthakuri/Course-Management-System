
/**
 * The class course is the parent class which has four attributes,
 * Each attribute has a getter method and one setter method is used to set the value of instance variable: courseLeader
 * Then, the display method will display the values.
 * 
 * @author (Ishan Singh Thakuri) 
 * 
 * @version (11.0.4)
 */
public class Course
{
    /*Declaration of 4 Attributes:
    (courseID,courseName, courseLeader,duation)*/
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;

    //Setting the Construtor for courseID, courseName, duration. 
    public Course (String courseID,String courseName,int duration)
    {
        //Initializing the parameter values to instance variables: courseID, courseName, duration.
        this.courseID=courseID;
        this.courseName=courseName;
        this.duration=duration;
        courseLeader="";
    }
    //Accessor method for courseName attriburtes.
    public String getcourseName()
    {
        return this.courseName;
        //to be more specific I used this keyword.
    }
    //Accessor method for courseID attributes. 
    public String getcourseID()
    {
        return this.courseID;
    }
    //Accessor method for courseLeader attributes.
    public String getcourseLeader()
    {
        return this.courseLeader;
    }
    //Accessor method for duration attributes.
    public int getduration()
    {
        return this.duration;
    }
    //Method to set the Course Leader for new course Leader.
    public void setcourseleader(String newcourseLeader)
    {
        /*Assing the parameter values to instance variables.
        and LHS belongs to object and RHS belongs to method*/

        this.courseLeader=newcourseLeader;        

    }
    //Method to display the attributes
    public void display()
    {
        //print courseID , courseName and duration.
        System.out.println("**************************Add Course*************************");
        System.out.println("The CourseID is "+courseID+".");
        System.out.println("The Course Name is "+courseName+".");
        System.out.println("The Course Duration is "+duration+" weeks.");

        //Display info only if Course_Leader is not an empty string.
        if(this.courseLeader.equals("") == false)
        {
            System.out.println("The Course Leader is " +courseLeader+".");
        }
        else
        {
            System.out.println("The Course Leader is not decided");
        }
        System.out.println("");
    }

}

    



     
    