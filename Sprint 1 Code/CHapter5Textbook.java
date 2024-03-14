package textbook;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import application.tableOfContents;
import summaries.Chapter5summary;
import quizzes.Chapter5Quiz;

public class chapter5 extends JPanel 
{
    private CardLayout cardLayout;

    // other screens linked
    private JFrame tocFrame;			// table of contents screen
    private	JFrame summaryFrame; 		// chapter 3 summary screen
    private JFrame quizFrame;			// chapter 3 quiz screen
    // screen information
    private JLabel lblTitle; 			// chapter title
    private JLabel lblTitlePage2;		// chapter title for page 2
    private JLabel lblTitlePage3;		// chapter title for page 2
    // text for the screen
    private JLabel lblPage1Number;		// page one number
    private JLabel lblPage2Number;		// page two number	
    private JLabel lblPage3Number;		// page three number 
    // textbook information variables
    private	JLabel lblSubtitlePage1;	// subtitle page 1
    private JLabel lblTextPage1;		// text for page 1
    private	JLabel lblSubtitlePage2;	// subtitle page 2
    private JLabel lblTextPage2;		// text for page 2
    private	JLabel lblSubtitlePage3;	// subtitle page 3
    private JLabel lblTextPage3;		// text for page 3
    // buttons
    // page 1
    private JButton btnToTOC; 			// button to go back to the table of contents
    private JButton btnQuiz; 			// button to proceed to the chapter quiz
    private JButton btnSummary; 		// button to proceed to the summary screen
    private JButton btnNextPage; 		// button to go to the next page of the textbook (if there is one)
    // page 2
    private JButton btnToTOCPage2;  	// button to go back to the table of contents (page 2)
    private JButton btnQuiz2; 			// button to proceed to the chapter quiz (page 2)
    private JButton btnSummary2; 		// button to proceed to the summary screen (page 2)
    private JButton btnNextPage2; 		// button to go to the next page of the textbook (if there is one) (page 2)
    private JButton	btnPrevPage;		// button to go to the previous page of the textbook (if there is one) (page 2)
    // page 3
    private JButton btnToTOCPage3;  	// button to go back to the table of contents (page 3)
    private JButton btnQuiz3; 			// button to proceed to the chapter quiz (page 3)
    private JButton btnSummary3; 		// button to proceed to the summary screen (page 3)
    private JButton	btnPrevPage2;		// button to go to the previous page of the textbook (if there is one) (page 3)

    public chapter5() 
    {
    	// declare variables basic screen variables
        Color lightBlue = new Color(173, 216, 230);        // color for the buttons
        
        setLayout(new CardLayout());                    // card layout to change pages
        cardLayout = (CardLayout) getLayout();          

        // PAGE 1:: create the main content panel (1st page)
        JPanel firstPage = new JPanel(null);
        // change background & add border
        firstPage.setBackground(new Color(200, 230, 200));
        firstPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
        // print screen information
        // page number 
        // title text
        lblTitle = new JLabel("Classes");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 200, 70);
        // page number text
        lblPage1Number = new JLabel("Page 1");
        lblPage1Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage1Number.setBounds(280, 725, 200, 40);
        // page 1 subtitle
        lblSubtitlePage1 = new JLabel("5.1 Introduction to Classes");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 225, 400, 45);
        // page 1 text
        lblTextPage1 = new JLabel("<html>In Java, classes are the fundamental building blocks of object-oriented programming. They serve as templates for creating objects, which are instances of a class. Each class encapsulates data (attributes) and behavior (methods) related to a particular concept or entity."
        		+ "Class Declaration: A class is declared using the class keyword followed by the class name and a code block that contains the class's members."
        		+ "\n"
        		+ "public class MyClass {"
        		+ "    // Class members (fields, constructors, methods)"
        		+ "}"
        		+ "Attributes (Fields): Attributes represent the state of an object and are defined as variables within a class."
        		+ "\n"
        		+ "public class Person {"
        		+ "    String name;"
        		+ "    int age;"
        		+ "}"
        		+ "Methods: Methods define the behavior of an object and are declared within a class. They can perform operations, manipulate data, and interact with other objects."
        		+ "\n"
        		+ "public class Person {"
        		+ "    public void displayInfo() {"
        		+ "        System.out.println(\"Name: \" + name);"
        		+ "        System.out.println(\"Age: \" + age);"
        		+ "    }"
        		+ "}<html>");
        lblTextPage1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblTextPage1.setBounds(50, 275, 700, 150);
        
        // button to go to TOC
        btnToTOC = new JButton("Table of Contents");
        btnToTOC.setBounds(500, 50, 200, 70);
        btnToTOC.setBackground(lightBlue);
        btnToTOC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     // close current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                     currentFrame.dispose();
                     // create the table of contents frame
                     tocFrame = new JFrame("Table of Contents");
                     // add table of contents
                     tableOfContents tocPanel = new tableOfContents();
                     tocFrame.add(tocPanel);
                     // set size and make visible
                     tocFrame.setSize(800, 800);
                     tocFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     tocFrame.setVisible(true);
                 } catch (IllegalArgumentException ex) { 
                     // ignore this error, the program works just fine
                 }
             }
        });
        // button to go to chp quiz slide
        btnQuiz = new JButton("Classes Chapter Quiz");
        btnQuiz.setBounds(40, 650, 200, 60);
        btnQuiz.setBackground(lightBlue);
        btnQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 5 Quiz");
                    Chapter5Quiz quizPanel = new Chapter5Quiz();
                    quizFrame.getContentPane().add(quizPanel);
                    quizFrame.setSize(800, 800);
                    quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    quizFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        // button to go to next page
        btnNextPage = new JButton("Next Page");
        btnNextPage.setBounds(290, 650, 200, 60);
        btnNextPage.setBackground(lightBlue);
        // changes screen based on button click
        btnNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch to the blank screen when "Next Page" is clicked
                cardLayout.show(chapter5.this, "secondPage");
            }
        });
        // button to go to chp summary slide
        btnSummary = new JButton("Classes Chapter Summary");
        btnSummary.setBounds(540, 650, 200, 60);
        btnSummary.setBackground(lightBlue);
        btnSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 5 Summary");
                    // add the chapter summary panel
                    Chapter5summary summaryPanel = new Chapter5summary();
                    summaryFrame.add(summaryPanel);
                    // set size and make visible
                    summaryFrame.setSize(800, 800);
                    summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    summaryFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });

        // print contents to screen
        firstPage.add(lblTitle);
        firstPage.add(lblPage1Number);
        firstPage.add(lblSubtitlePage1);
        firstPage.add(lblTextPage1);
        firstPage.add(btnToTOC);
        firstPage.add(btnQuiz);
        firstPage.add(btnNextPage);
        firstPage.add(btnSummary);
        add(firstPage, "mainCard");

        // PAGE 2:: create next page of the textbook if it clicked
        JPanel secondPage = new JPanel(null);
        secondPage.setBackground(new Color(200, 230, 200));
        secondPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // title for the second page
        lblTitlePage2 = new JLabel("Classes");
        lblTitlePage2.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage2.setBounds(50, 50, 400, 70);
        // page number text
        lblPage2Number = new JLabel("Page 2");
        lblPage2Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage2Number.setBounds(280, 725, 200, 40);
        lblSubtitlePage1 = new JLabel("5.2 Constructors and Instantiation");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 225, 400, 45);
        // page 2 text
        lblTextPage2 = new JLabel("<html>Constructors are special methods used for initializing objects. They have the same name as the class and do not have a return type. In Java, when an object is created using the new keyword, a constructor is invoked to initialize the object."
        		+ "Default Constructor: If a class does not explicitly define any constructors, Java provides a default constructor with no arguments, which initializes the object's attributes to their default values."
        		+ "\n"
        		+ "public class Person {"
        		+ "    // Default constructor"
        		+ "    public Person() {"
        		+ "        // Initialization code"
        		+ "    }"
        		+ "}"
        		+ "Parameterized Constructor: Constructors can also accept parameters, allowing for custom initialization of object attributes."
        		+ "\n"
        		+ "public class Person {"
        		+ "    String name;"
        		+ "    int age;"
        		+ "    \n"
        		+ "    // Parameterized constructor"
        		+ "    public Person(String name, int age) {"
        		+ "        this.name = name;"
        		+ "        this.age = age;"
        		+ "    }"
        		+ "}"
        		+ "Object Instantiation: Objects are created using the new keyword followed by a call to a constructor."
        		+ "\n"
        		+ "Person person1 = new Person(); // Using default constructor"
        		+ "Person person2 = new Person(\"John\", 30); // Using parameterized constructor</html>");
        lblTextPage2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblTextPage2.setBounds(50, 275, 700, 150);
        // button to go to TOC on the second page
        btnToTOCPage2 = new JButton("Table of Contents");
        btnToTOCPage2.setBounds(500, 50, 200, 70);
        btnToTOCPage2.setBackground(lightBlue);
        btnToTOCPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the table of contents frame
                    tocFrame = new JFrame("Table of Contents");
                    // add the table of contents
                    tableOfContents tocPanel = new tableOfContents();
                    tocFrame.add(tocPanel);
                    // set size and make visible
                    tocFrame.setSize(800, 800);
                    tocFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    tocFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        // button to go to the chapter quiz screen (page 2)
        btnQuiz2 = new JButton("Classes Chapter Quiz");
        btnQuiz2.setBounds(25, 650, 175, 60);
        btnQuiz2.setBackground(lightBlue);
        btnQuiz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 try {
                     // close the current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                     currentFrame.dispose();
                     // create the chapter quiz frame
                     quizFrame = new JFrame("Chapter 5 Quiz");
                     // add the chapter quiz panel
                     Chapter5Quiz quizPanel = new Chapter5Quiz();
                     quizFrame.add(quizPanel);
                     // set size and make visible
                     quizFrame.setSize(800, 800);
                     quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     quizFrame.setVisible(true);
                 } catch (IllegalArgumentException ex) {
                     // ignore this error, the program works just fine
                 }
             }
        });
        // button to go to previous page (page 2)
        btnPrevPage = new JButton("Previous Page");
        btnPrevPage.setBounds(210, 650, 175, 60);
        btnPrevPage.setBackground(lightBlue);
        // changes screen based on button click
        btnPrevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch to the blank screen when "Previous Page" is clicked
                cardLayout.show(chapter5.this, "mainCard");
            }
        });
        // button to go to next page (page 2)
        btnNextPage2 = new JButton("Next Page");
        btnNextPage2.setBounds(395, 650, 175, 60);
        btnNextPage2.setBackground(lightBlue);
        btnNextPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch to the third page when "Next Page" is clicked
                cardLayout.show(chapter5.this, "thirdPage");
            }
        });
        // button to go to the chapter summary screen (page 2)
        btnSummary2 = new JButton("Classes Chapter Summary");
        btnSummary2.setBounds(580, 650, 175, 60);
        btnSummary2.setBackground(lightBlue);
        btnSummary2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 5 Summary");
                    // add the chapter summary panel
                    Chapter5summary summaryPanel = new Chapter5summary();
                    summaryFrame.add(summaryPanel);
                    // set size and make visible
                    summaryFrame.setSize(800, 800);
                    summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    summaryFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });

        // print components to second screen
        secondPage.add(lblTitlePage2);
        secondPage.add(lblPage2Number);
        secondPage.add(btnToTOCPage2);
        secondPage.add(btnQuiz2);
        secondPage.add(btnPrevPage);
        secondPage.add(btnNextPage2);
        secondPage.add(btnSummary2);

        // print next page contents
        add(secondPage, "secondPage");
        
        // PAGE 3:: create third page of the textbook
        JPanel thirdPage = new JPanel(null);
        thirdPage.setBackground(new Color(200, 230, 200));
        thirdPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // title for the third page
        lblTitlePage3 = new JLabel("Classes");
        lblTitlePage3.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage3.setBounds(50, 50, 400, 70);
        // page number text
        lblPage3Number = new JLabel("Page 3");
        lblPage3Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage3Number.setBounds(280, 725, 200, 40);
        lblSubtitlePage3 = new JLabel("5.3 Access Modifiers and Encapsulation");
        lblSubtitlePage3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage3.setBounds(50, 225, 400, 45);
        // page 2 text
        lblTextPage3 = new JLabel("<html>Access modifiers control the visibility and accessibility of class members (fields, constructors, methods) within and outside the class. Encapsulation is a fundamental principle of object-oriented programming that emphasizes bundling data and methods within a class and controlling access to them."
        		+ "Access Modifiers: Java provides four access modifiers: public, protected, default (no modifier), and private. They determine the level of access to class members."
        		+ "\n"
        		+ "public class MyClass {"
        		+ "    public int publicField;"
        		+ "    protected int protectedField;"
        		+ "    int defaultField;"
        		+ "    private int privateField;"
        		+ "}"
        		+ "Encapsulation: Encapsulation involves hiding the internal state of an object and restricting access to it using access modifiers. It helps in achieving data hiding and abstraction, improving code maintainability and security."
        		+ "\n"
        		+ "public class Person {"
        		+ "    private String name;"
        		+ "    private int age;"
        		+ "    \n"
        		+ "    // Getter methods"
        		+ "    public String getName() {"
        		+ "        return name;"
        		+ "    }"
        		+ "    \n"
        		+ "    public int getAge() {"
        		+ "        return age;"
        		+ "    }"
        		+ "    \n"
        		+ "    // Setter methods"
        		+ "    public void setName(String name) {"
        		+ "        this.name = name;"
        		+ "    }"
        		+ "    \n"
        		+ "    public void setAge(int age) {"
        		+ "        this.age = age;"
        		+ "    }"
        		+ "}"
        		+ "Benefits of Encapsulation: Encapsulation promotes code reusability, modularity, and maintainability by hiding implementation details and providing a well-defined interface for interacting with objects."
        		+ "\n"
        		+ "By understanding the concepts of classes, constructors, access modifiers, and encapsulation in Java, developers can create well-structured and maintainable object-oriented programs. These concepts form the foundation of Java programming and are essential for building complex and scalable applications.</html>");
        lblTextPage3.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblTextPage3.setBounds(50, 275, 700, 150);
        // button to go back to TOC on the third page
        btnToTOCPage3 = new JButton("Table of Contents");
        btnToTOCPage3.setBounds(500, 50, 200, 70);
        btnToTOCPage3.setBackground(lightBlue);
        btnToTOCPage3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the table of contents frame
                    tocFrame = new JFrame("Table of Contents");
                    // add the table of contents
                    tableOfContents tocPanel = new tableOfContents();
                    tocFrame.add(tocPanel);
                    // set size and make visible
                    tocFrame.setSize(800, 800);
                    tocFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    tocFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        // button to go to chp quiz slide (page 3)
        btnQuiz3 = new JButton("Classes Chapter Quiz");
        btnQuiz3.setBounds(40, 650, 200, 60);
        btnQuiz3.setBackground(lightBlue);
        btnQuiz3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 5 Quiz");
                    Chapter5Quiz quizPanel = new Chapter5Quiz();
                    quizFrame.getContentPane().add(quizPanel);
                    quizFrame.setSize(800, 800);
                    quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    quizFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        // button to go to previous page (page 3)
        btnPrevPage2 = new JButton("Previous Page");
        btnPrevPage2.setBounds(290, 650, 200, 60);
        btnPrevPage2.setBackground(lightBlue);
        btnPrevPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch to the second page when "Previous Page" is clicked
                cardLayout.show(chapter5.this, "secondPage");
            }
        });
        // button to go to chp summary slide (page 3)
        btnSummary3 = new JButton("Classes Chapter Summary");
        btnSummary3.setBounds(540, 650, 200, 60);
        btnSummary3.setBackground(lightBlue);
        btnSummary3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter5.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 5 Summary");
                    Chapter5summary summaryPanel = new Chapter5summary();
                    summaryFrame.getContentPane().add(summaryPanel);
                    summaryFrame.setSize(800, 800);
                    summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    summaryFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });

        // add components to third page
        thirdPage.add(lblTitlePage3);
        thirdPage.add(lblPage3Number);
        thirdPage.add(btnToTOCPage3);
        thirdPage.add(btnQuiz3);
        thirdPage.add(btnPrevPage2);
        thirdPage.add(btnSummary3);

        // add third page to the panel
        add(thirdPage, "thirdPage");

        // show page 1 one as the "maincard" (default)
        cardLayout.show(this, "mainCard");
    }

    // MARK:: remove once complete for linking purposes
    public static void main(String[] args) {
        // Example of usage (main method for testing)
        JFrame frame = new JFrame("Chapter 5: Classes");
        chapter5 chapter5 = new chapter5();
        frame.getContentPane().add(chapter5);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
