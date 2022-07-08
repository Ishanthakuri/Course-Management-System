
/**
 * This NonAcademicCourse is a child class of Course class which has 8 attributes.
 * Each attribute has a getter method and one setter method is used to set the value of instance variable: instructorName.
 *
 * @author (Ishan Singh Thakuri)
 * @version (11.0.4)
 */
public class NonAcademicCourse extends Course
{
    /*Declaring the 8  attributes:
     * (instructorName, duration, startDate, completionDate, examDate,prerquisite, isRegistered, isReomoved)
     */
    private String instructorName;
    private int duration;
    private String startDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;

    //Setting up  constructor for courseID , courseName , duration , prerequisite.
    public NonAcademicCourse(String courseID,String courseName, int duration,String prerequisite)
    {
        /*Assing the parameter values to instance variables: courseID, courseName, duration , prerequisite. 
        and super keyword is used to call the parameter of the constructor in Course class.*/
        super(courseID,courseName,duration);
        this.prerequisite=prerequisite;
        this.duration= duration;
        startDate="";
        completionDate="";
        examDate="";
        isRegistered= false;
        isRemoved = false;
    }
    //Accessor method for instructorName attributes. 
    public String getinstructorName()
    {
        return this.instructorName;
    }

    public int getduration()
    {
        return this.duration;
    }   
    //Accessor method for startDate attributes. 
    public String getstartDate()
    {
        return this.startDate;
    }
    //Accessor method for completionDate attributes.
    public String getcompletionDate()
    {
        return this.completionDate;
    }
    //Accessor method for examDate attributes.
    public String getexamDate()
    {
        return this.examDate;
    }
    //Accessor method for prerequisite attributes. 
    public String getprerequisite()
    {
        return this.prerequisite;
    }
    //Accessor method for isRegistered attributes.
    public boolean getisRegistered()
    {
        return this.isRegistered;
    }
    //Accessor method for isRemoved attributes. 
    public boolean getisRemoved()
    {
        return this.isRemoved;

    }
    //Methods to set the instructor name as new instructorname.
    public void setinstructorname(String newinstructorname)
    {
        if(this.isRegistered == false)
        {
            this.instructorName=newinstructorname;

            //LHS belongs to object and RHS belongs to method
        }
        else
        {
            System.out.println("It is not possible to change the instructor name because the instructor has been set to: "
                +this.instructorName+".");
            System.out.println();
        }
    }
    //Method to register a new course.
    public void register(String courseLeader,String instructorName,String StartingDate,String CompletionDate,String ExamDate)
    {
        if(this.isRegistered == false)
        {
            //setting up instructorname to called instructorName as parameter.
            setinstructorname(instructorName);
            setcourseleader(courseLeader);
            //Initializing the parameter values to instance variables: startDate, completionDate, examDate.
            this.startDate=StartingDate;
            this.completionDate=CompletionDate;
            this.examDate=ExamDate;
            //Assing  the isRegistered to true.
            isRegistered=true; 
        }
        else
        {
            System.out.println("The course has already been registered with: ");
            System.out.println("Starting Date: "+this.startDate);
            System.out.println("Completion Date: "+this.completionDate);
            System.out.println();
        }
    }
    //Method to remove an existing course if the course has been removed or not and 
    public void remove()
    {
        if(this.isRemoved == true)
        {
            System.out.println("The non-academic course has already been removed.");
            System.out.println();

        }
        else
        {
            //Initialize the empty values to the repective instance vairable to remove it.
            setcourseleader("");
            instructorName="";
            startDate="";
            completionDate="";
            examDate="";
            //Initialize false to the isRegistered because it has been removed.
            isRegistered=false;
            //Initialize true to the isRemoved because now the course has been removed.
            isRemoved=true;
            System.out.println();
            System.out.println("The non-academic course has been removed.");

        }
    }
    //Method to display the attribute values
    @Override
    public void display()
    {
        //super keyword is used for the call to Course class display method.
        super.display();
        if(isRegistered == true)
        {
            //print instructorName, startDate, completionDate, examDate.
            System.out.println("******************Register Non Academic Course********************");            
            System.out.println("The Instructor is: "+instructorName+".");  
            System.out.println("The Starting Date is: "+startDate+".");
            System.out.println("The Completion Date is: "+completionDate+".");
            System.out.println("The Exam Date is: "+examDate+".");
            System.out.println("The prerequisite is: "+prerequisite);
            System.out.println();
        }
    }
}
