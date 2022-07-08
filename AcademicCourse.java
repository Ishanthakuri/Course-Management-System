
/**
 * This AcademicCourse is a child class of Course class which has 7 attributes.
 * Each attribute has a getter method and two setter method is used to set the value of instance variable: lectureName
 * and numberofAssessments.
 * @author (Ishan Singh Thakuri)
 * @version (11.0.4)
 */
public class AcademicCourse extends Course
{
    /*Declaraing 7 Attritubes:
     * (lecturerName, level, credit, starting_Date,completion_Date,numberofAssessments, isRegistered)
     */
    private String lecturerName;
    private String level;
    private String credit;
    private String starting_Date;
    private String completion_Date;
    private int numberofAssessments;
    private boolean isRegistered;

    //Setting up the constructor for courseID, courseName, duration, level, credit, numberofAssessments.
    public AcademicCourse (String courseID, String courseName,int duration,String level, String credit,int numberofAssessments)
    {
        //Initializing the parameter values to instance variables: courseID, courseName, duration, level , credit ,numberofAssessments. 
        super(courseID,courseName,duration);

        this.level=level;
        this.credit=credit;
        this.numberofAssessments=numberofAssessments;

        lecturerName="";
        starting_Date="";
        completion_Date="";
        isRegistered=false;
    }
    //Accessor method for level attributes.
    public String getlevel()
    {
        return this.level;
    }
    //Accessor method for lecturerName attributes.
    public String getlecturerName()
    {
        return this.lecturerName;
    }
    //Accessor method for credit attributes.
    public String getcredit()
    {
        return this.credit;
    }
    //Accessor method for starting_Date attributes.
    public String getstartingDate()
    {
        return this.starting_Date;
    }
    //Accessor method for completon_Date attributes.
    public String getcompletiondDate()
    {
        return this.completion_Date;
    }
    //Accessor method for numberofAssessments attributes.
    public int getnumberofassessments()
    {
        return this.numberofAssessments;
    }
    //Accessor method for isRegistered attributes.
    public boolean getisRegister()
    {
        return this.isRegistered;
    }
    //Methods to set the Lecture Name for new lecturer Name
    public void setlecturername(String newlecturerName)
    {
        this.lecturerName=newlecturerName;

        //LHS belongs to object and RHS belongs to method
    }
    //Methods to set the number of Assessments for new number of Assessments.
    public void setnumberofAssessments(int newnumberofAssessments)
    {
        this.numberofAssessments=newnumberofAssessments;

        //LHS belongs to object and RHS belongs to method
    }
    //Methods to register the particular academic course.
    public void register(String courseLeadername,String lecturerName,String startingDate,String completionDate)
    {
        if(this.isRegistered == false)
        {
            //super keyword is used to call setter method from Course class.
            super.setcourseleader(courseLeadername);

            //Assing parameter values instance variables: lecuturerName, starting_Date, compeltion date.
            this.lecturerName=lecturerName;
            this.starting_Date=startingDate;
            this.completion_Date=completionDate;
            //Assing the isRegistered to true.
            this.isRegistered=true;
        }
        else if(this.isRegistered == true)
        {
            System.out.println("The academic course is already registered with: ");
            System.out.println("Instructor name: " + this.lecturerName);
            System.out.println("Starting Date " + this.starting_Date);
            System.out.println("Completion Date " + this.completion_Date);
            System.out.println();
        }
    }
    //method to display the attributes values.
    public void display()
    {
        //super keyword is used for the call to Course class display method.
        super.display();
        if(this.isRegistered == true)
        {
            //print lecturerName, level, credit, starting_Date, completion_Date, numberofAssessments.
            System.out.println("******************Register Academic Course********************");
            System.out.println("The Lecturer name is "+this.lecturerName+"."); 
            System.out.println("The Course Level is "+this.level+".");
            System.out.println("The Course Credit is "+this.credit+".");
            System.out.println("The Starting Date is "+this.starting_Date+".");
            System.out.println("The Completion Date is "+this.completion_Date+".");
            System.out.println("The Number of Assessments is "+this.numberofAssessments+".");
            System.out.println();

        }
    }
}

