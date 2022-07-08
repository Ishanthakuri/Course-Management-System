
/**
 * Write a description of class INGCollege here.
 *
 * @author (Ishan Singh Thakuri)
 * @version (11.0.11)
 * 
 * Variables declaration representation:
 *       
 *  1)_R or R represent Register(Register Non Academic)
 *  2)_N represent Non(Non Academic Course)
 *  3)_NR or NR represent Non Register(Register Non Academic Course)
 *  4)NRF represent Non Register Form(JButton for Register Non Academic Course)
 *  5)bgBtn represent Background color for Button
 *  6)bgColor represent Background color for Background.
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class INGCollege implements ActionListener
{
    private JFrame courseFrame, academicFrame, nonAcademicFrame, removeFrame;
    private JPanel coursePanel, academicPanel, registerPanel, nonAcademicPanel, nonRegisterPanel;
    //Instance variable for CourseForm.
    private JButton academicCourseBtn,nonAcademicCourseBtn;

    //Instance variable for Academic course
    private JTextField courseIDField, courseNameField, durationField, levelField,creditField,numberField;
    private JButton clear, add1, register, exit;
    private String forCourseID,forCourseName, forDuration, forLevel, forCredit, forNumber;
    private int n_Duration, n_Number, n_Credit;

    //Instance variable for Register Academic course
    private JTextField courseIDField_R, courseLeaderField, lecturerField;
    private JButton clearR, registerR, displayR, back;
    private JComboBox<String> year, month, day, year1, month1, day1;
    private String forCourseID_R , forCourseLeader , forLecturer ,startRegister, completionRegister;
    private AcademicCourse ac;

    //Instance variable for Non Academic Course
    private JTextField courseIDField_N, courseNameField_N, durationField_N;
    private JTextArea preField;
    private String  forCourseID_N, forCourseName_N, forDuration_N, forPre;
    private int N_Duration;
    private JButton add2, exitN, registerNR, clear1;
    //Instance variable for Register Non Academic Course        
    private JTextField courseIDField_NR, courseLeaderField_NR, instructorField, removeIDField;
    private JButton clearNR, remove, backNR, displayNR, registerNRF, removedBtn;
    private JComboBox <String> year2, month2, day2, year3, month3, day3, year4, month4, day4;
    private String forCourseID_NR , forCourseLeader_NR , forInstructor , forRemoveID, startNRegister, CompletionNRegister, examDate;
    private NonAcademicCourse nAc;

    //other Instance variable.
    private JButton mainDisplayBtn;
    private ImageIcon clearImg, registerImg, displayImg, exitImg, registerRImg, removeImg, addImg, backImg;
    private Color bgColor, bgBtn, customColorT;

    private String[] months = {"MM","January","February","March" ,"April" ,"May" ,"June" ,"July" ,
            "August","September","October","November","December"};
    private String[] days = {"DD","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"
        ,"24","25","26","27","28","29","30","31"};
    private String[] years = {"YYYY","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};

    private static AcademicCourse obj_Academic;
    private static NonAcademicCourse obj_nonAcademic;

    //private JButton Register;
    private static INGCollege ing = new INGCollege();

    /*Using generic version where only a specified type of data can be stored.
    and arrayList is the class which is in java.util.ArrayList)*/
    public ArrayList<Course> list = new ArrayList<Course>();//Creating arrayList

    /**CourseForm method*/
    public void CourseForm(){

        //JFrame for frame.
        courseFrame = new JFrame("Islington College Form");
        courseFrame.setSize(500,500);
        courseFrame.setLocationRelativeTo(null);//Center the frame

        //JPanel for Panel.
        coursePanel = new JPanel();
        coursePanel.setBounds(0,0,500,700);

        //Color for JTextField Background. 
        customColorT = new Color(247,247,247);

        bgColor = new Color(222,229,236);//Object for Color.
        coursePanel.setBackground(bgColor);//set Background Color for Panel.

        JLabel topic = new JLabel("COURSE");
        topic.setBounds(75,50,380,80);
        Font headFont1 = new Font ("Serif", Font.BOLD,80);
        topic.setFont(headFont1);
        coursePanel.add(topic);

        //JButton for Academic Course.
        academicCourseBtn = new JButton("Add Academic Course");
        Font customFont = new Font("Times New Roman",Font.BOLD,30);
        academicCourseBtn.setFont(customFont);
        academicCourseBtn.setSize(350,50);
        academicCourseBtn.setLocation(70,200);
        bgBtn = new Color(79,169,242);
        academicCourseBtn.setBackground(bgBtn);
        academicCourseBtn.setForeground(Color.WHITE);
        academicCourseBtn.addActionListener(this);//Action Listener
        coursePanel.add(academicCourseBtn);

        //JButton for nonAcademic Course.
        nonAcademicCourseBtn = new JButton("Add Non-Academic Course");
        Font headFont3 = new Font("Times New Roman",Font.BOLD,30);
        nonAcademicCourseBtn.setFont(headFont3);
        nonAcademicCourseBtn.setSize(415,50);
        nonAcademicCourseBtn.setLocation(35,280);
        nonAcademicCourseBtn.setForeground(Color.WHITE);
        nonAcademicCourseBtn.setBackground(bgBtn);
        nonAcademicCourseBtn.addActionListener(this);//Action Listener
        coursePanel.add(nonAcademicCourseBtn);
        
        mainDisplayBtn = new JButton("Display");
        mainDisplayBtn.setFont(headFont3);
        mainDisplayBtn.setSize(315,50);
        mainDisplayBtn.setLocation(85,360);
        mainDisplayBtn.setForeground(Color.WHITE);
        mainDisplayBtn.setBackground(bgBtn);
        mainDisplayBtn.addActionListener(this);//Action Listener
        coursePanel.add(mainDisplayBtn);

        //Adding on course frame and setting visible to true and for size Resizable false and course Panel layout to null.
        coursePanel.setLayout(null);
        courseFrame.add(coursePanel);
        courseFrame.setVisible(true);
        courseFrame.setResizable(false);
        courseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**Main method*/
    public static void main(String[] args)
    {
        ing.CourseForm();
    }

    /**AcademicGUI method*/
    public void AcademicGUI()
    {
        //JFrame for Academic Course
        academicFrame = new JFrame("Academic Course Form");
        academicFrame.setSize(650,700);
        academicFrame.setLocation(100,50);

        JPanel panelBgColorA = new JPanel();
        panelBgColorA.setSize(50,750);
        panelBgColorA.setLocation(600,0);
        panelBgColorA.setBackground(bgBtn);

        //JPanel for Academic Course
        academicPanel = new JPanel();
        academicPanel.setSize(600,700);
        academicPanel.setLocation(0,0);
        //Adding background for academic panel from the instance reference variable.
        academicPanel.setBackground(bgColor);

        //JLabel for topic 
        JLabel topic = new JLabel("ACADEMIC COURSE");
        topic.setBounds(100,50,500,80);
        Font headFont2 = new Font ("Serif", Font.BOLD,40);
        topic.setFont(headFont2);
        academicPanel.add(topic);

        //JLabel for courseID
        JLabel courseID = new JLabel();
        courseID.setText("CourseID:");
        Font customFont = new Font("Times New Roman",Font.PLAIN,25);
        courseID.setFont(customFont);
        courseID.setBounds(90,145,120,100);
        //JTextFiled for courseID
        courseIDField = new JTextField();
        courseIDField.setBounds(210, 180, 250, 35);
        courseIDField.setBackground(customColorT);//Adding Background color.
        courseIDField.setFont(customFont);
        //Adding courseID and courseIDField on academic panel.
        academicPanel.add(courseID);
        academicPanel.add(courseIDField);

        //JLabel for courseName
        JLabel courseName = new JLabel("Course Name:");
        courseName.setFont(customFont);
        courseName.setBounds(50,210,180,100);
        //JTextField for courseName
        courseNameField = new JTextField();
        courseNameField.setBounds(210, 245, 250, 35);
        courseNameField.setBackground(customColorT);//Adding Background Color
        courseNameField.setFont(customFont);
        //Adding courseName and courseNameField on academic panel
        academicPanel.add(courseName);
        academicPanel.add(courseNameField);

        //JLabel for duration
        JLabel duration = new JLabel("Duration:");
        duration.setFont(customFont);
        duration.setBounds(100,280,120,100);
        //JTextField for duration
        durationField = new JTextField();
        durationField.setBounds(210, 310, 170, 35);
        durationField.setBackground(customColorT);//Adding background color
        durationField.setFont(customFont);
        //Adding duration and durationField on academic panel 
        academicPanel.add(duration);
        academicPanel.add(durationField);

        //JLabel for level
        JLabel level = new JLabel("Level:");
        level.setFont(customFont);
        level.setBounds(135,350,120,100);
        //JTextField for levelField
        levelField = new JTextField();
        levelField.setBounds(210, 380, 170, 35);
        levelField.setBackground(customColorT);//Action Listener
        levelField.setFont(customFont);
        //Adding level and levelField on academic panel.
        academicPanel.add(level);
        academicPanel.add(levelField);

        //JLabel for credit
        JLabel credit = new JLabel("Credit:");
        credit.setFont(customFont);
        credit.setBounds(135,410,280,100);
        //JTextField for creditField
        creditField = new JTextField();
        creditField.setBounds(210, 440, 70, 35);
        creditField.setBackground(customColorT);//Adding Background color.
        creditField.setFont(customFont);
        //Adding credit and creditField on academic panel.
        academicPanel.add(credit);
        academicPanel.add(creditField);

        //JLabel for number
        JLabel number = new JLabel("Number of Assessments:");
        number.setFont(customFont);
        number.setBounds(40,460,280,100);
        //JLabel for numberField
        numberField = new JTextField();
        numberField.setBounds(300, 495, 70, 35);
        numberField.setBackground(customColorT);//Adding Background color.
        numberField.setFont(customFont);
        //Adding number and numberField on academic panel.
        academicPanel.add(number);
        academicPanel.add(numberField);

        //clear image icon for Academic course
        clearImg = new ImageIcon("images/clear.PNG");//load the image to a imageIcon
        Image image1 = clearImg.getImage();//get the image.
        Image newImage1 = image1.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        clearImg = new ImageIcon(newImage1);//transform it.

        //clear JButton
        clear = new JButton("Clear", clearImg);
        Font buttonFont = new Font("Dialog",Font.BOLD,20);
        clear.setFont(buttonFont);
        clear.setBounds(380, 430, 150,50);
        clear.setBackground(Color.WHITE);
        clear.addActionListener(this);//Action Listener
        //Adding clear button on  academic panel.
        academicPanel.add(clear);

        //register image icon for Academic Course.
        registerImg = new ImageIcon("images/Register0.PNG");//load the image to a imageIcon
        Image image2 = registerImg.getImage();//get the image. 
        Image newImage2 = image2.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        registerImg = new ImageIcon(newImage2);//transform it.

        //register JButton
        register = new JButton("Register" ,registerImg);
        register.setFont(buttonFont);
        register.setBounds(320,550,200,70);
        register.setBackground(Color.WHITE);
        register.addActionListener(this);// Action Listener
        //Adding register button on academic panel.
        academicPanel.add(register);

        //add image icon for Academic Course.
        addImg = new ImageIcon("images/add.png");//load the image to a imageIcon.
        Image image3 = addImg.getImage();//get the image
        Image newImage3 = image3.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        addImg = new ImageIcon(newImage3);//transform it.

        //add JButton
        add1 = new JButton("Add Course" ,addImg);
        add1.setFont(buttonFont);
        add1.setBounds(80,550,200,70);
        add1.setBackground(Color.WHITE);
        add1.addActionListener(this);//Action Listener.
        //Adding add button on academic panel
        academicPanel.add(add1);

        //add exit image icon
        exitImg = new ImageIcon("images/Exit.PNG");//load the image to a imageIcon
        Image image4 = exitImg.getImage();//transform it
        Image newImage4 = image4.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        exitImg = new ImageIcon(newImage4);//transform it back

        //add exit JButton
        exit = new JButton("Exit",exitImg);
        exit.setBounds(400,495,120,40);
        exit.setFont(buttonFont);
        exit.setBackground(Color.WHITE);//Background color for exit Button.
        exit.addActionListener(this);//Action Listener
        //Adding exit button on academic panel.
        academicPanel.add(exit);

        //**********************Register Panel for Academic Course*************************************

        //JPanel for Register Academic Course.
        registerPanel = new JPanel();
        registerPanel.setSize(600,700);
        registerPanel.setBackground(bgColor);//Background color for Register Panel.

        JLabel topic_R = new JLabel("REGISTER ");
        topic_R.setBounds(200,30,200,80);
        Font headFont3 = new Font ("Serif", Font.BOLD,32);
        topic_R.setFont(headFont3);
        //Adding topic to register panel.
        registerPanel.add(topic_R);

        JLabel topic_R1 = new JLabel( "ACADEMIC COURSE");
        topic_R1.setBounds(130,80,500,80);
        topic_R1.setFont(headFont3);
        registerPanel.add(topic_R1);

        //JLabel for CourseID for Register
        JLabel courseID_R = new JLabel("CourseID:");
        //Font CustomFont = new Font("Times New Roman",Font.PLAIN,25);
        courseID_R.setFont(customFont);
        courseID_R.setBounds(100,145,120,100);

        //JTextField for courseIDField_R
        courseIDField_R = new JTextField();
        courseIDField_R.setBounds(210, 180, 250, 35);
        courseIDField_R.setBackground(this.customColorT);
        courseIDField_R.setFont(customFont);//Adding Font for JTextField
        //Adding courseID and CourseIDField on register panel.
        registerPanel.add(courseID_R);
        registerPanel.add(courseIDField_R);

        //JLabel for courseLeader
        JLabel courseLeader = new JLabel("Course Leader:");
        courseLeader.setFont(customFont);
        courseLeader.setBounds(50,210,180,100);
        //JTextField for courseLeaderField
        courseLeaderField = new JTextField();
        courseLeaderField.setBounds(210, 245, 250, 35);
        courseLeaderField.setBackground(customColorT);//Adding Background Color for JTextField.
        courseLeaderField.setFont(customFont);//Adding Font for JTextField.
        //Adding courseLeader and CourseLeaderField on Register Panel.
        registerPanel.add(courseLeader);
        registerPanel.add(courseLeaderField);

        //JTextField for lecturer
        JLabel lecturer= new JLabel("Lecturer Name:");
        lecturer.setFont(customFont);
        lecturer.setBounds(50,280,180,100);
        //JTextField for lecturerField
        lecturerField = new JTextField();
        lecturerField.setBounds(210, 315, 250, 35);
        lecturerField.setBackground(customColorT);
        lecturerField.setFont(customFont);
        //Adding lecturer and lecturerField on register panel.
        registerPanel.add(lecturer);
        registerPanel.add(lecturerField);

        JLabel sDate = new JLabel("Starting Date:");
        sDate.setFont(customFont);
        sDate.setBounds(50,330,140,150);
        //Adding Date on Register Panel.
        registerPanel.add(sDate);

        //JComboBox for month and passing the months array in parameter.
        month = new JComboBox<String>(months);
        month.setFont(customFont);
        month.setBounds(210,385,155,35);
        registerPanel.add(month);

        //JComboBox for  day and passing the day array in parameter.
        day = new JComboBox<String>(days);
        day.setFont(customFont);
        day.setBounds(380,385,80,35);
        //Adding day on register panel.
        registerPanel.add(day);

        //JComboBox for year and passing the year array in parameter.
        year = new JComboBox<String>(years);
        year.setFont(customFont);
        year.setBounds(480,385,105,35);
        registerPanel.add(year);//Adding year on Register Panel.

        //JLabel for Completion Date.
        JLabel cDate = new JLabel("Completion Date:");
        cDate.setFont(customFont);
        cDate.setBounds(50,390,200,150);
        //Adding label on register panel.
        registerPanel.add(cDate);

        //JComboBox for month1 and passing the month array in parameter.
        month1 = new JComboBox<String>(months);
        month1.setFont(customFont);
        month1.setBounds(235,450,145,35);
        registerPanel.add(month1);

        //JComboBox for day1 and passing the day array in parameter.
        day1 = new JComboBox<String>(days);
        day1.setFont(customFont);
        day1.setBounds(390,450,80,35);
        registerPanel.add(day1);

        //JComboBox for year1 and passing the year array in parameter.
        year1 = new JComboBox<String>(years);
        year1.setFont(customFont);
        year1.setBounds(480,450,105,35);
        registerPanel.add(year1);

        //Image Icon for Back
        backImg = new ImageIcon("images/Back.png");//load the image to a ImageIcon
        Image image5 = backImg.getImage();//get the image 
        Image newImage5 = image5.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        backImg = new ImageIcon(newImage5);//transform it.
        //back JButton
        back = new JButton("Back",backImg);
        back.setBounds(70,580,120,40);
        back.setFont(buttonFont);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);//Action Listener.
        //Adding back button on Register Panel.
        registerPanel.add(back);

        //Clear button for Register Academic Course
        clearR = new JButton("Clear" ,clearImg);
        clearR.setBounds(70,530,120,40);
        clearR.setFont(buttonFont);
        clearR.setBackground(Color.WHITE);
        clearR.addActionListener(this);//Action Listener.
        //Adding clearR button for Register Academic Course.
        registerPanel.add(clearR);

        //Register Image Icon
        registerRImg = new ImageIcon("images/Register.PNG");//load the image to a imageIcon
        Image image6 = registerRImg.getImage();//get the image
        Image newImage6 = image6.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        registerRImg = new ImageIcon(newImage6);//transform it back

        //JButton registerR for Register Academic Course
        registerR = new JButton("Register", registerRImg);
        registerR.setFont(buttonFont);
        registerR.setBounds(400, 540, 150,70);
        registerR.setBackground(Color.WHITE);
        registerR.addActionListener(this);//Action Listener
        //Adding registerR button 
        registerPanel.add(registerR);

        //Display Image Icon
        displayImg = new ImageIcon("images/Display.PNG");//load the image to a imageIcon.
        Image image7 = displayImg.getImage();//get the image
        Image newImage7 = image7.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        displayImg = new ImageIcon(newImage7);//transform it.

        //JButton for Display
        displayR = new JButton("Display", displayImg);
        displayR.setFont(buttonFont);
        displayR.setBounds(230,540,150,70);
        displayR.setBackground(Color.WHITE);
        displayR.addActionListener(this);//Action Listener
        //Adding displayR button on register panel.
        registerPanel.add(displayR);

        /*setting register panel visible to false ,panelBgColor to true and academic Frame visible to true ,register panel 
         * ,panelBgColorA ,academic panel and academic frame layout to null and adding academic panel panelBgColor and 
         * register panel to academic frame*/ 

        panelBgColorA.setLayout(null);
        registerPanel.setLayout(null);
        academicFrame.setLayout(null);
        academicPanel.setLayout(null);
        panelBgColorA.setVisible(true);
        registerPanel.setVisible(false);
        academicFrame.setVisible(true);
        academicFrame.setResizable(false);
        academicFrame.add(panelBgColorA);
        academicFrame.add(registerPanel);
        academicFrame.add(academicPanel);
        academicFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**Non AcademicGUI method*/
    public void NonAcademicGUI() 
    {
        //JFrame for frame2
        nonAcademicFrame = new JFrame("Non Academic Course Form");
        nonAcademicFrame.setSize(650,750);
        nonAcademicFrame.setLocation(900,50);

        JPanel panelBgColor = new JPanel();
        panelBgColor.setSize(50,750);
        panelBgColor.setLocation(600,0);
        panelBgColor.setBackground(bgBtn);

        nonAcademicPanel = new JPanel();
        nonAcademicPanel.setSize(600,750);
        nonAcademicPanel.setLocation(0,0);
        nonAcademicPanel.setBackground(bgColor);

        //JLabel for topic
        JLabel topic = new JLabel("NON ACADEMIC COURSE");
        topic.setBounds(50,50,530,80);
        Font headFont2 = new Font ("Serif", Font.BOLD,40);
        topic.setFont(headFont2);
        //Adding Topic on nonAcademic panel.
        nonAcademicPanel.add(topic);

        JLabel courseID_N = new JLabel("CourseID:");
        Font customFont = new Font("Times New Roman",Font.PLAIN,25);
        courseID_N.setFont(customFont);
        courseID_N.setBounds(90,145,120,100);
        //JTextField of CourseID for Non Academic Course
        courseIDField_N = new JTextField();
        courseIDField_N.setBounds(210, 180, 250, 35);
        courseIDField_N.setBackground(customColorT);
        courseIDField_N.setFont(customFont);
        //Adding courseID and CourseIDField on nonAcademic panel
        nonAcademicPanel.add(courseID_N);
        nonAcademicPanel.add(courseIDField_N);

        JLabel courseName_N = new JLabel("Course Name:");
        courseName_N.setFont(customFont);
        courseName_N.setBounds(50,210,180,100);
        //JTextField of courseNameField for Non Academic Course.
        courseNameField_N = new JTextField();
        courseNameField_N.setBounds(210, 245, 250, 35);
        courseNameField_N.setBackground(customColorT);
        courseNameField_N.setFont(customFont);
        //Adding course Name and course Name Field on nonAcademic panel
        nonAcademicPanel.add(courseName_N);
        nonAcademicPanel.add(courseNameField_N);

        JLabel duration_N = new JLabel("Duration:");
        duration_N.setFont(customFont);
        duration_N.setBounds(100,280,120,100);
        //JTextField of durationField for Non Academic Course.
        durationField_N = new JTextField();
        durationField_N.setBounds(210, 310, 170, 35);
        durationField_N.setBackground(customColorT);
        durationField_N.setFont(customFont);
        //Adding duration and duration field on nonAcademic panel
        nonAcademicPanel.add(duration_N);
        nonAcademicPanel.add(durationField_N);

        JLabel pre = new JLabel("Prerequisite:");
        pre.setFont(customFont);
        pre.setBounds(70,350,150,100);
        preField = new JTextArea();
        preField.setBounds(215, 380, 300, 150);
        preField.setBackground(customColorT);
        preField.setLineWrap(true);
        preField.setFont(customFont);
        //Adding prerequisite and prerequisite field on nonAcademic panel
        nonAcademicPanel.add(pre);
        nonAcademicPanel.add(preField);

        //Clear ImageIcon
        clearImg = new ImageIcon("images/clear.PNG");//load the image to a imageIcon
        Image image1 = clearImg.getImage();//get the image.
        Image newImage1 = image1.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        clearImg = new ImageIcon(newImage1);//transform it.

        //clear button for NonAcademic Course
        clear1 = new JButton("Clear", clearImg);
        Font buttonFont = new Font("Dialog",Font.BOLD,20);
        clear1.setFont(buttonFont);
        clear1.setBounds(390, 630, 130,50);
        clear1.setBackground(Color.WHITE);
        clear1.addActionListener(this);//Action Listener
        //Adding on clear1 on nonAcademic panel
        nonAcademicPanel.add(clear1);

        //Register button for Register NonAcademic Course
        registerImg = new ImageIcon("images/Register0.PNG");//load the image to a imageIcon
        Image image3 = registerImg.getImage();//get the image.
        Image newImage3 = image3.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        registerImg = new ImageIcon(newImage3);//transform it.

        //Register button for changing panel to Register Non Academic Course
        registerNR = new JButton("Register" ,registerImg);
        registerNR.setFont(buttonFont);
        registerNR.setBounds(320,545,200,70);
        registerNR.setBackground(Color.WHITE);
        registerNR.addActionListener(this);//Action Listener
        //Adding registerNR on nonAcademic panel
        nonAcademicPanel.add(registerNR);

        //add ImageIcon
        addImg = new ImageIcon("images/add.png");//load the image to a imageIcon.
        Image image4 = addImg.getImage();//get the image.
        Image newImage4 = image4.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        addImg = new ImageIcon(newImage4);//transform it.

        //add JButton
        add2 = new JButton("Add Course" ,addImg);
        add2.setFont(buttonFont);
        add2.setBounds(80,545,200,70);
        add2.setBackground(Color.WHITE);
        add2.addActionListener(this);//Action Listener
        //Adding on nonAcademic panel
        nonAcademicPanel.add(add2);

        //exit Image Icon
        exitImg = new ImageIcon("images/Exit.PNG");//load the image to a imageIcon
        Image image5 = exitImg.getImage();//transform it
        Image newImage5 = image5.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        exitImg = new ImageIcon(newImage5);//transform it back

        //exit JButton
        exitN = new JButton("Exit",exitImg);
        exitN.setBounds(80,630,120,50);
        exitN.setFont(buttonFont);
        exitN.setBackground(Color.WHITE);
        exitN.addActionListener(this);//Action Listener
        //Adding exitN button to nonAcademic panel
        nonAcademicPanel.add(exitN);

        //**********************Register for Non Academic Course Panel*************************************

        //RegisterPanel for Register Non Academic
        nonRegisterPanel = new JPanel();
        nonRegisterPanel.setSize(600,750);
        nonRegisterPanel.setBackground(bgColor);

        JLabel topic_R = new JLabel("REGISTER ");
        topic_R.setBounds(200,30,200,80);
        Font headFont3 = new Font ("Serif", Font.BOLD,32);
        topic_R.setFont(headFont3);
        nonRegisterPanel.add(topic_R);

        JLabel topic_R2 = new JLabel( "NON ACADEMIC COURSE");
        topic_R2.setBounds(80,80,500,80);
        topic_R2.setFont(headFont3);
        nonRegisterPanel.add(topic_R2);
        //JLabel for courseID_NR
        JLabel courseID_NR = new JLabel("CourseID:");
        courseID_NR.setFont(customFont);
        courseID_NR.setBounds(95,145,120,100);
        //JTextField for courseIDField_NR(non Register)
        courseIDField_NR = new JTextField();
        courseIDField_NR.setBounds(235, 180, 250, 35);
        courseIDField_NR.setBackground(customColorT);
        courseIDField_NR.setFont(customFont);
        //Adding courseID_NR and courseIDField_NR on nonRegisterPanel
        nonRegisterPanel.add(courseID_NR);
        nonRegisterPanel.add(courseIDField_NR);

        JLabel courseLeader = new JLabel("Course Leader:");
        courseLeader.setFont(customFont);
        courseLeader.setBounds(50,210,180,100);
        //JTextField for courseLeaderField_NR(non Register)
        courseLeaderField_NR = new JTextField();
        courseLeaderField_NR.setBounds(235, 245, 250, 35);
        courseLeaderField_NR.setBackground(customColorT);
        courseLeaderField_NR.setFont(customFont);
        //Adding CourseLeader and courseLeaderField_NR on nonRegisterPanel
        nonRegisterPanel.add(courseLeader);
        nonRegisterPanel.add(courseLeaderField_NR);

        JLabel instructor= new JLabel("Instructor Name:");
        instructor.setFont(customFont);
        instructor.setBounds(50,280,180,100);
        //JTextField for instructorField
        instructorField = new JTextField();
        instructorField.setBounds(235, 315, 250, 35);
        instructorField.setBackground(customColorT);
        instructorField.setFont(customFont);
        //Adding instructor and instructorField on nonRegisterPanel
        nonRegisterPanel.add(instructor);
        nonRegisterPanel.add(instructorField);

        JLabel sDate = new JLabel("Start Date:");
        sDate.setFont(customFont);
        sDate.setBounds(50,330,140,150);
        nonRegisterPanel.add(sDate);

        //JComboBox of month for Start Date
        month2 = new JComboBox<String>(months);
        month2.setFont(customFont);
        month2.setBounds(235,385,145,35);
        nonRegisterPanel.add(month2);

        //JComboBox of day for Start Date
        day2 = new JComboBox<String>(days);
        day2.setFont(customFont);
        day2.setBounds(395,385,80,35);
        nonRegisterPanel.add(day2);

        //JComboBox of year for Start Date
        year2 = new JComboBox<String>(years);
        //JComboBox of year for Start Date
        year2.setFont(customFont);
        year2.setBounds(485,385,105,35);
        nonRegisterPanel.add(year2);

        JLabel cDate = new JLabel("Completion Date:");
        cDate.setFont(customFont);
        cDate.setBounds(50,390,200,150);
        nonRegisterPanel.add(cDate);

        //JComboBox of month for Completion Date.
        month3 = new JComboBox<String>(months);
        month3.setFont(customFont);
        month3.setBounds(235,450,145,35);
        nonRegisterPanel.add(month3);

        //JComboBox of day for Completion Date.
        day3 = new JComboBox<String>(days);
        day3.setFont(customFont);
        day3.setBounds(395,450,80,35);
        nonRegisterPanel.add(day3);

        //JComboBox of year for Completion Date.
        year3 = new JComboBox<String>(years);
        year3.setFont(customFont);
        year3.setBounds(485,450,105,35);
        nonRegisterPanel.add(year3);

        JLabel eDate = new JLabel("Exam Date:");
        eDate.setFont(customFont);
        eDate.setBounds(50,455,200,150);
        nonRegisterPanel.add(eDate);

        //JComboBox of months for Exam Date.
        month4 = new JComboBox<String>(months);
        month4.setFont(customFont);
        month4.setBounds(235,515,145,35);
        nonRegisterPanel.add(month4);

        //JComboBox of day for Exam Date.
        day4 = new JComboBox<String>(days);
        day4.setFont(customFont);
        day4.setBounds(395,515,80,35);
        nonRegisterPanel.add(day4);

        //JComboBox of year for Exam Date.
        year4 = new JComboBox<String>(years);
        year4.setFont(customFont);
        year4.setBounds(485,515,105,35);
        nonRegisterPanel.add(year4);

        //back ImageIcon 
        backImg = new ImageIcon("images/Back.png");//load the image to a imageIcon
        Image image6 = backImg.getImage();//transform it
        Image newImage6 = image6.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        backImg = new ImageIcon(newImage6);//transform it back

        //back JButton for non academic course
        backNR = new JButton("Back",backImg);
        backNR.setBounds(50,640,120,40);
        backNR.setFont(buttonFont);
        backNR.setBackground(Color.WHITE);
        backNR.addActionListener(this);//Action Listener
        //Adding backNR button on nonRegisterPanel
        nonRegisterPanel.add(backNR);

        //Clear button for Register Non Academic Course
        clearNR = new JButton("Clear" ,clearImg);
        clearNR.setBounds(50,590,150,40);
        clearNR.setFont(buttonFont);
        clearNR.setBackground(Color.WHITE);
        clearNR.addActionListener(this);//Action Listener
        //Adding clearNr button on registerPanel1
        nonRegisterPanel.add(clearNR);

        //registerRImg ImageIcon
        registerRImg = new ImageIcon("images/Register.PNG");//load the image to a imageIcon
        Image image7 = registerRImg.getImage();//transform it or get the image
        Image newImage7 = image7.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        registerRImg = new ImageIcon(newImage7);//transform it back

        //registerJButton  for Register Non Academic Course
        registerNRF = new JButton("Register", registerRImg);
        registerNRF.setFont(buttonFont);
        registerNRF.setBounds(220,590,160,90);
        registerNRF.setBackground(Color.WHITE);
        registerNRF.addActionListener(this);//Action Listener
        //Adding registerNRF(Non Register Form) button on nonRegisterPanel
        nonRegisterPanel.add(registerNRF);

        //Remove ImageIcon
        removeImg = new ImageIcon("images/remove.PNG");
        Image image2 = removeImg.getImage();
        Image newImage2 = image2.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        removeImg = new ImageIcon(newImage2);

        //remove JButton for Register Non Academic Course
        remove = new JButton("Remove" ,removeImg);
        remove.setFont(buttonFont);
        remove.setBackground(Color.WHITE);
        remove.setBounds(400,590,150,40);
        remove.addActionListener(this);//Action Listener
        //Adding remove button on nonRegisterPanel
        nonRegisterPanel.add(remove);

        //display Image Icon 
        ImageIcon displayImg = new ImageIcon("images/Display.PNG");//load the image to a imageIcon.
        Image image8 = displayImg.getImage();//get the image
        Image newImage8 = image8.getScaledInstance(30,30,java.awt.Image.SCALE_DEFAULT);
        displayImg = new ImageIcon(newImage8);//transform it.

        //Display JButton for Register Non Academic Course
        displayNR = new JButton("Display", displayImg);
        displayNR.setFont(buttonFont);
        displayNR.setBounds(400, 640, 150,40);
        displayNR.setBackground(Color.WHITE);
        displayNR.addActionListener(this);//Action Listener.
        //Adding displayNR to nonRegisterPanel
        nonRegisterPanel.add(displayNR); 

        /*setting nonRegister panel visible to false nonAcademicFrame visible to true and panelBgColor to true ,non 
         * register panel,non academic panel and panelBgColor and non Academic frame layout to null and adding nonRegister
         * panel and non Academic panel to non AcademicFrame*/ 
        nonAcademicFrame.setLayout(null);
        panelBgColor.setLayout(null);
        nonAcademicPanel.setLayout(null);
        nonRegisterPanel.setLayout(null);
        nonAcademicFrame.add(panelBgColor);
        panelBgColor.setVisible(true);
        nonRegisterPanel.setVisible(false);
        nonAcademicFrame.add(nonRegisterPanel);
        nonAcademicFrame.add(nonAcademicPanel);
        nonAcademicFrame.setVisible(true);
        nonAcademicFrame.setResizable(false);
        nonAcademicFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void removeGUI() 
    {
        //JFrame for removeFrame
        removeFrame = new JFrame("Remove Non Academic Course Form");
        removeFrame.setSize(450,250);
        removeFrame.setLocationRelativeTo(null);//Center the frame

        JPanel removePanel = new JPanel();
        removePanel.setBounds(0,0,450,250);
        removePanel.setBackground(bgColor);

        JLabel removeID = new JLabel("Course ID:");
        Font customFont = new Font("Times New Roman",Font.PLAIN,25);
        removeID.setFont(customFont);
        removeID.setBounds(20,20,120,100);
        //JTextField of removeIDField for Register Non Academic Course
        removeIDField = new JTextField();
        removeIDField.setBounds(140, 55, 250, 35);
        removeIDField.setBackground(customColorT);
        removeIDField.setFont(customFont);
        //Adding removeIDField and removeID to remove Panel
        removePanel.add(removeIDField);
        removePanel.add(removeID);

        //removed JButton for Register Non Academic Course
        removedBtn = new JButton("Remove" ,removeImg);
        Font buttonFont = new Font("Dialog",Font.BOLD,20);
        removedBtn.setFont(buttonFont);
        removedBtn.setBackground(Color.WHITE);//Background color for button
        removedBtn.setBounds(130,120,180,60);
        removedBtn.addActionListener(this);
        //Adding removed button on removePanel
        removePanel.add(removedBtn);

        /*Setting removeFrame visible to true and and Resizable to false and panel layout to null and 
        adding remove panel to removeFrame*/
        removeFrame.setVisible(true);
        removeFrame.setResizable(false);
        removePanel.setLayout(null);
        removeFrame.add(removePanel);
        removeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == academicCourseBtn){
            AcademicGUI();//call the AcademicGUI method.
        }
        if(a.getSource() == nonAcademicCourseBtn){
            NonAcademicGUI();//call the NonAcademicGUI method.
        }
        if(a.getSource() == remove){
            removeGUI();//call the removeGUI method.
        }
        if(a.getSource() == register){
            registerPanel.setVisible(true);
            academicPanel.setVisible(false);
        }
        if(a.getSource() == back){
            registerPanel.setVisible(false);
            academicPanel.setVisible(true);
        }
        if(a.getSource() == exit){
            this.academicFrame.dispose();
        }
        if(a.getSource() == backNR){
            nonRegisterPanel.setVisible(false);
            nonAcademicPanel.setVisible(true);
        }
        if (a.getSource() == exitN){
            this.nonAcademicFrame.dispose();
        }
        if(a.getSource() == registerNR){
            nonRegisterPanel.setVisible(true);
            nonAcademicPanel.setVisible(false);
        }
        if(a.getSource() == clear){
            courseIDField.setText("");
            courseNameField.setText("");
            durationField.setText("");
            levelField.setText("");
            creditField.setText("");
            numberField.setText("");    
        }
        if(a.getSource() == clear1){
            courseIDField_N.setText("");
            courseNameField_N.setText("");
            durationField_N.setText("");
            preField.setText("");
        }
        if(a.getSource() == clearR){
            courseIDField_R.setText("");
            courseLeaderField.setText("");
            lecturerField.setText("");
            year.setSelectedIndex(0);
            month.setSelectedIndex(0);
            day.setSelectedIndex(0);
            year1.setSelectedIndex(0);
            month1.setSelectedIndex(0);
            day1.setSelectedIndex(0);
        }
        if(a.getSource() == clearNR){
            courseIDField_NR.setText("");
            courseLeaderField_NR.setText("");
            instructorField.setText(""); 
            year2.setSelectedIndex(0);
            month2.setSelectedIndex(0);
            day2.setSelectedIndex(0);    
            year3.setSelectedIndex(0);
            month3.setSelectedIndex(0);
            day3.setSelectedIndex(0);     
            year4.setSelectedIndex(0);
            month4.setSelectedIndex(0);
            day4.setSelectedIndex(0);
        }
        if(a.getSource() == add1 ){
            try{ 
                forCourseID = courseIDField.getText();
                forCourseName = courseNameField.getText();
                forNumber = numberField.getText();

                forDuration = durationField.getText();
                forLevel = levelField.getText();
                forCredit = creditField.getText();
                //auto unboxing
                n_Duration = Integer.parseInt(forDuration);
                n_Number = Integer.parseInt(forNumber);
                n_Credit = Integer.parseInt(forCredit);
                //declaring boolean variable.
                boolean while_clicked = false;

                if(n_Duration == 0 ){
                    JOptionPane.showMessageDialog(academicFrame,"Duration Error.\n"+"Duration can't be zero.","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(n_Credit == 0){
                    JOptionPane.showMessageDialog(academicFrame,"Credit Error.\n"+"Credit can't be zero.","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for(Course var : list){
                    if(var.getcourseID().equals(forCourseID)){
                        while_clicked = true; 
                        break;
                    }
                }
                if(while_clicked == false){
                    //calling the constructor of Academic course class
                    obj_Academic = new AcademicCourse(forCourseID, forCourseName, n_Duration, forLevel, forCredit,n_Number);
                    list.add(obj_Academic); //Adding the object to the academic course class
                    //adding dialog box
                    JOptionPane.showMessageDialog(academicFrame,"Academic Course Added.\n\n CourseID: "+forCourseID + "\n CourseName: "+ forCourseName + "\n Duration: "
                    + n_Duration +" weeks" + "\n Level: " + forLevel + "\n Credit: " + forCredit + "\n Number: " + n_Number );
                }
                else if(while_clicked == true){
                    JOptionPane.showMessageDialog(academicFrame,"Invalid Number.\n"+"CourseID already exits.Please enter a different CourseID."
                    ,"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException empty1){
                try{
                    if(forCourseID.equals("") || forCourseName.equals("")  || forDuration.equals("") || forLevel.equals("") || forCredit.equals("") || forNumber.equals(""))
                    {
                        JOptionPane.showMessageDialog(academicFrame,"Empty TextField.\n"+"Please fill up the TextField.","Warning",JOptionPane.WARNING_MESSAGE);
                    }    
                }
                catch(NullPointerException empty2){
                    JOptionPane.showMessageDialog(academicFrame,"Empty TextField.\n"+"Please fill up the TextField.","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if(a.getSource() == registerR ){
            try{
                //Using String instance variable.
                forCourseID_R = courseIDField_R.getText();
                forCourseLeader = courseLeaderField.getText();
                forLecturer = lecturerField.getText();

                /*declaring string variables and selected the items from JComboBox and since getSelectedItem has return type object 
                so converting to string by using toString method*/
                String selectYear = year.getSelectedItem().toString();//using to string method 
                String selectMonth = month.getSelectedItem().toString();//using To string method
                String selectDay = day.getSelectedItem().toString();//Using to string method 
                //Concat
                startRegister = selectMonth +" "+ selectDay + " "+ selectYear;

                String selectYear_1 = year1.getSelectedItem().toString();//Using to toString method
                String selectMonth_1 = month1.getSelectedItem().toString();//Using toString method
                String selectDay_1 = day1.getSelectedItem().toString();//Using toString method
                //Concat
                completionRegister = selectMonth_1+" " + selectDay_1 +" "+ selectYear_1;
                if(forCourseID_R.equals("")|| forCourseLeader.equals("") || forLecturer.equals("")) {
                    JOptionPane.showMessageDialog(academicFrame,"Looks like you didn't fill up fields.","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for( Course checking : list){
                    if(forCourseID.equals(forCourseID_R)){
                        //Checking object type
                        if (checking instanceof AcademicCourse){
                            ac = (AcademicCourse)checking;//down casting.
                            if(ac.getisRegister() == false){
                                ac.register(forCourseLeader,forLecturer, startRegister,completionRegister);
                                JOptionPane.showMessageDialog(academicFrame, "The Academic Course has been Registered.\n\n CourseID: "
                                    +forCourseID_R + "\n Course Leader: "+ forCourseLeader + "\n Lecturer: "+ forLecturer + "\n Start Date: "
                                    + startRegister + "\n Completion Date: " + completionRegister);
                                break;
                            }
                            else if(ac.getisRegister() == true){
                                JOptionPane.showMessageDialog(academicFrame, "The academic course is already registered");
                                break;
                            }
                        }
                    } 
                    else{
                        JOptionPane.showMessageDialog(academicFrame,"Invalid CourseID."+"\n Course ID of Academic Course and Register must be match.","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            catch(NullPointerException registerexp0) {
                JOptionPane.showMessageDialog(academicFrame,"Looks like you didn't fill up fields.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        if(a.getSource() == displayR){
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(nonAcademicFrame,"Looks like you didn't fill up the fields.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else{
                for(Course variable : list){
                    //Checking Object type
                    if(variable instanceof AcademicCourse){
                        ac = (AcademicCourse)variable;//down casting  
                        ac.display();//calling display method from child class Academic Course.
                    }
                }
            }
        }    

        if(a.getSource() == add2){
            try{
                forCourseID_N =courseIDField_N.getText();
                forCourseName_N =courseNameField_N.getText();
                forDuration_N =durationField_N.getText();
                N_Duration = Integer.parseInt(forDuration_N);

                forPre = preField.getText();
                //declaring a boolean variable
                boolean while_clicked_2 = false;

                if(N_Duration == 0) {
                    JOptionPane.showMessageDialog(nonAcademicFrame,"Duration Error.\n"+"Duration can't be zero.","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for(Course var2 : list){
                    if(var2.getcourseID().equals(forCourseID_N)){
                        while_clicked_2 = true;
                        break;
                    }
                }
                if(while_clicked_2 == false){
                    obj_nonAcademic = new NonAcademicCourse(forCourseID_N,forCourseName_N, N_Duration,forPre);
                    //Adding the object to the non academic course class
                    list.add(obj_nonAcademic);
                    //adding dialog box
                    JOptionPane.showMessageDialog(nonAcademicFrame,"Non Academic Course Added.\n\n CourseID: "+forCourseID_N + "\n CourseName: "+ forCourseName_N + "\n Duration: "
                        + N_Duration + " weeks"+"\n Prerequisite: " + forPre );
                }
                else if(while_clicked_2 == true){
                    JOptionPane.showMessageDialog(nonAcademicFrame,"Invalid Number.\n"+"CourseID already exits.Please enter a different CourseID."
                    ,"Error",JOptionPane.ERROR_MESSAGE);                
                }
            }
            catch(NumberFormatException nonAEmpty ){
                try{
                    if(forCourseID_N.equals("") || forCourseName_N.equals("")  || forDuration_N.equals("") || forPre.equals(""))
                    {
                        JOptionPane.showMessageDialog(nonAcademicFrame,"Empty TextField.\n"+"Please fill up the TextField.","Warning",JOptionPane.WARNING_MESSAGE);
                    }    
                }
                catch(NullPointerException nonAEmpty2){
                    JOptionPane.showMessageDialog(nonAcademicFrame,"Empty TextField.\n"+"Please fill up the TextField.","Warning",JOptionPane.WARNING_MESSAGE);
                }  
            }
        }
        if(a.getSource() == registerNRF){
            try{
                //Using string instance variables
                forCourseID_NR =courseIDField_NR.getText();
                forCourseLeader_NR=courseLeaderField_NR.getText();
                forInstructor =instructorField.getText();
                /*declaring string variables and selected the items from jComboBox and since getSelectedItem has return type object 
                so converting to string by using toString method*/
                String selectedMonth = month2.getSelectedItem().toString();
                String selectedDay = day2.getSelectedItem().toString();
                String selectedYear = year2.getSelectedItem().toString();
                //Concat
                startNRegister = selectedMonth + " " + selectedDay + " " + selectedYear;

                String selectedMonth3 = month3.getSelectedItem().toString();
                String selectedDay3 = day3.getSelectedItem().toString();
                String selectedYear3 = year3.getSelectedItem().toString();
                //Concat
                CompletionNRegister = selectedMonth3 +" " + selectedDay3 + " " + selectedYear3;

                String selectedMonth4 = month4.getSelectedItem().toString();
                String selectedDay4 = day4.getSelectedItem().toString();
                String selectedYear4 = year4.getSelectedItem().toString();
                //Concat
                examDate = selectedMonth4 + " "+ selectedDay4 + " " + selectedYear4;

                if(forCourseID_NR.equals("") || forCourseLeader_NR.equals("") || forInstructor.equals("")){
                    JOptionPane.showMessageDialog(nonAcademicFrame,"Looks like you didn't fill up.","Warning",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (Course Checking1 : list){
                    if(forCourseID_N.equals(forCourseID_NR)){
                        //Checking object type.
                        if(Checking1 instanceof NonAcademicCourse){
                            nAc = (NonAcademicCourse)Checking1;//down casting
                            //if the academic Course is not Registered
                            if(nAc.getisRegistered() == false){
                                nAc.register( forCourseLeader_NR, forInstructor , startNRegister , CompletionNRegister,examDate);
                                JOptionPane.showMessageDialog(nonAcademicFrame,"The Non Academic Course has been Registered\n\n Course Leader: "
                                    + forCourseLeader_NR + "\nInstructor Name: " + forInstructor+ "\nStart Date: "+ startNRegister +"\nCompletion Date: "
                                    + CompletionNRegister + "\nExam Date :" + examDate);
                                break;
                            }
                            //if the academic Course is Registered
                            else if (nAc.getisRegistered() == true){
                                JOptionPane.showMessageDialog(nonAcademicFrame, "The Non Academic Course has already been Registered");
                                break;
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(nonAcademicFrame,"Invalid CourseID."+"\n Course ID of Non Academic Course and Register must be match.","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
            catch (NullPointerException registerexp){
                JOptionPane.showMessageDialog(nonAcademicFrame,"Looks like you didn't fill up.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        if(a.getSource() == displayNR){
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(nonAcademicFrame,"Looks like you didn't fill up the field.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                for(Course variable2 : list){
                    //Checking Object type.
                    if(variable2 instanceof NonAcademicCourse){
                        nAc = (NonAcademicCourse)variable2;//down casting.
                        nAc.display();//calling method display from child class Non Academic Course.
                    }
                }
            }
        }

        if(a.getSource() == mainDisplayBtn){
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(courseFrame,"Looks like you didn't fill up the fields.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else
            {
                for(Course mainvariable : list){
                    //Checking Object type
                    if(mainvariable instanceof AcademicCourse){
                        ac = (AcademicCourse)mainvariable;//down casting  
                        ac.display();//calling display method from child class Academic Course.
                    }
                    if(mainvariable instanceof NonAcademicCourse){
                        nAc = (NonAcademicCourse)mainvariable;//down casting.
                        nAc.display();//calling display method from child class Non Academic Course.
                    }
                }   
            }
        }
        
        if(a.getSource() == removedBtn){
            forRemoveID =removeIDField.getText();//getting text of removeIDField.
            if(forRemoveID.isEmpty()){
                JOptionPane.showMessageDialog(removeFrame,"Looks like you didn't fill up the CourseID.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            for(Course checking2 : list){
                if(forCourseID_N.equals(forRemoveID)){
                    //checking object type.
                    if (checking2 instanceof NonAcademicCourse){
                        nAc = (NonAcademicCourse)checking2;//down casting
                        //if the register non academic is already removed
                        if( nAc.getisRemoved() == true){
                            JOptionPane.showMessageDialog(removeFrame,"Non-academic course has already been removed.");
                        }
                        //if the register non academic is not removed.
                        else if( nAc.getisRemoved() == false){
                            nAc.remove();//calling remove method from Child class Non Academic Course
                            JOptionPane.showMessageDialog(removeFrame,"The non-academic course has been removed.");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(removeFrame,"Invalid CourseID."+"\n Course ID of Non Academic Course must be match for removing.","Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }           
        }
    }
}

