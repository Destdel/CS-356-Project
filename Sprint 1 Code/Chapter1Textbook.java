package textbooks;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
import summaries.Chapter1Summary;
import quizzes.Chapter1Quiz;

/**
 * Chapter 1 Textbook for the Learning Java Application.
 * The Basics
 * 
 * @author Anthony Ephault
 *
 */
public class Chapter1Textbook extends JPanel 
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

    /**
	 * 
	 * Chapter1Textbook() - Constructor
	 * 
	 * Used to create the chapter 1 (basics) textbook which the user is able to flip through and read.
	 * The user is also able to access the summary, quiz, and table of contents for this chapter as well.
	 * 
	 **/
    public Chapter1Textbook() 
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
        lblTitle = new JLabel("Basics");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 300, 70);
        // page number text
        lblPage1Number = new JLabel("Page 1");
        lblPage1Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage1Number.setBounds(280, 725, 200, 40);
        // page 1 subtitle
        lblSubtitlePage1 = new JLabel("1.1 Writing Your First Java Program");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 150, 600, 40);
        // page 1 text
        lblTextPage1 = new JLabel("<html>"
                + "<b>Package Declaration:</b> A package in Java is used to organize related classes and interfaces into a single namespace. While optional, it's recommended for larger projects to prevent naming conflicts. Example: <code>package com.example.myproject;</code><br><br>"
                + "<b>Import Statements:</b> Import statements are used to make classes and interfaces from other packages available in the current source file. They can be specific, importing only the classes or interfaces needed, or can use the wildcard (*) to import all classes and interfaces from a package. Example: <code>import java.util.Scanner;</code><br><br>"
                + "<b>Class Declaration:</b> A class in Java serves as a blueprint for creating objects. The class declaration specifies the name of the class and its visibility, followed by the class body enclosed in curly braces. Example: <code>public class MyClass { }</code><br><br>"
                + "<b>Main Method:</b> The main method is the entry point of a Java program. It must be declared as <code>public static void main(String[] args)</code>. The main method accepts a single parameter, an array of strings (<code>args</code>), which can be used to pass command-line arguments to the program. Inside the main method is the code that will be executed when the program is run.<br><br>"
                + "<b>Simple 'Hello, World!' Program:</b> The 'Hello, World!' program is often the first program written by beginners in any programming language. It outputs the phrase 'Hello, World!' to the console. Example:<br><code>public class HelloWorld {<br>&nbsp;&nbsp;&nbsp;&nbsp;public static void main(String[] args) {<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(\"Hello, World!\");<br>&nbsp;&nbsp;&nbsp;&nbsp;}</code><br><br>"
                + "<b>Compiling Java Code:</b> Java source code needs to be compiled into bytecode using the Java compiler (<code>javac</code>). After writing the Java program in a text file with a <code>.java</code> extension (e.g., <code>HelloWorld.java</code>), navigate to the directory containing the Java file and run <code>javac FileName.java</code>. If compilation is successful, it will generate a bytecode file named <code>FileName.class</code>."
                + "</html>");
        lblTextPage1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        lblTextPage1.setBounds(50, 190, 700, 475);
        
        // button to go to TOC
        btnToTOC = new JButton("Table of Contents");
        btnToTOC.setBounds(500, 50, 200, 70);
        btnToTOC.setBackground(lightBlue);
        btnToTOC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     // close current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
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
        btnQuiz = new JButton("Basics Chapter Quiz");
        btnQuiz.setBounds(40, 650, 200, 60);
        btnQuiz.setBackground(lightBlue);
        btnQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 1 Quiz");
                    Chapter1Quiz quizPanel = new Chapter1Quiz();
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
                cardLayout.show(Chapter1Textbook.this, "secondPage");
            }
        });
        // button to go to chp summary slide
        btnSummary = new JButton("Basics Chapter Summary");
        btnSummary.setBounds(540, 650, 200, 60);
        btnSummary.setBackground(lightBlue);
        btnSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 1 Summary");
                    // add the chapter summary panel
                    Chapter1Summary summaryPanel = new Chapter1Summary();
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
        lblTitlePage2 = new JLabel("Basics");
        lblTitlePage2.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage2.setBounds(50, 50, 400, 70);
        // page number text
        lblPage2Number = new JLabel("Page 2");
        lblPage2Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage2Number.setBounds(280, 725, 200, 40);
        lblSubtitlePage2 = new JLabel("1.2 Java Syntax and Structure");
        lblSubtitlePage2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage2.setBounds(50, 150, 550, 40);
        // page 2 text
        lblTextPage2 = new JLabel("<html>"
        	    + "<b>Identifiers and Keywords:</b> Identifiers are names given to variables, methods, classes, etc. Keywords are reserved words with predefined meanings."
        	    + "<br><br>"
        	    + "<b>Naming Rules:</b> Class names start with uppercase letters and follow camel case. Variables and methods start with lowercase letters and follow camel case. Constants are in uppercase with underscores."
        	    + "<br><br>"
        	    + "<b>Comments:</b> Single-line comments start with //, while multi-line comments are enclosed in /* */."
        	    + "<br><br>"
        	    + "<b>Basic Syntax:</b> Statements end with a semicolon. Expressions evaluate to a single value. Blocks of code are enclosed in curly braces."
        	    + "<br><br>"
        	    + "<b>Understanding Java's syntax and structure is essential for writing clear, maintainable code.</b>"
        	    + "<br><br>"
        	    + "<b>Next Topic:</b> Data Types in Java: Primitive types include byte, short, int, long, float, double, char, boolean. Reference types include arrays, objects, and Strings."
        	    + "<br><br>"
        	    + "<b>Further Exploration:</b> Advanced Java Concepts: Explore topics like inheritance, polymorphism, exception handling, and generics to enhance your understanding of Java programming."
        	    + "</html>");
        lblTextPage2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblTextPage2.setBounds(50, 190, 700, 475);
        // button to go to TOC on the second page
        btnToTOCPage2 = new JButton("Table of Contents");
        btnToTOCPage2.setBounds(500, 50, 200, 70);
        btnToTOCPage2.setBackground(lightBlue);
        btnToTOCPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
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
        btnQuiz2 = new JButton("Basics Chapter Quiz");
        btnQuiz2.setBounds(25, 650, 175, 60);
        btnQuiz2.setBackground(lightBlue);
        btnQuiz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 try {
                     // close the current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                     currentFrame.dispose();
                     // create the chapter quiz frame
                     quizFrame = new JFrame("Chapter 1 Quiz");
                     // add the chapter quiz panel
                     Chapter1Quiz quizPanel = new Chapter1Quiz();
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
                cardLayout.show(Chapter1Textbook.this, "mainCard");
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
                cardLayout.show(Chapter1Textbook.this, "thirdPage");
            }
        });
        // button to go to the chapter summary screen (page 2)
        btnSummary2 = new JButton("Loops Chapter Summary");
        btnSummary2.setBounds(580, 650, 175, 60);
        btnSummary2.setBackground(lightBlue);
        btnSummary2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 1 Summary");
                    // add the chapter summary panel
                    Chapter1Summary summaryPanel = new Chapter1Summary();
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
        secondPage.add(lblSubtitlePage2);
        secondPage.add(lblTextPage2);
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
        lblTitlePage3 = new JLabel("Basics");
        lblTitlePage3.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage3.setBounds(50, 50, 400, 70);
        // page number text
        lblPage3Number = new JLabel("Page 3");
        lblPage3Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage3Number.setBounds(280, 725, 200, 40);
        lblSubtitlePage3 = new JLabel("1.5 Understanding Data Types in Java");
        lblSubtitlePage3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        lblSubtitlePage3.setBounds(50, 150, 600, 30);
        // page 3 text
        lblTextPage3 = new JLabel("<html>"
        	    + "<b>Primitive Data Types:</b><br>"
        	    + "- byte: 8-bit, -128 to 127.<br>"
        	    + "- short: 16-bit, -32,768 to 32,767.<br>"
        	    + "- int: 32-bit, -2^31 to 2^31 - 1.<br>"
        	    + "- long: 64-bit, -2^63 to 2^63 - 1.<br>"
        	    + "- float: 32-bit, ±3.40282347E+38F.<br>"
        	    + "- double: 64-bit, ±1.79769313486231570E+308.<br>"
        	    + "- char: 16-bit Unicode.<br>"
        	    + "- boolean: true or false.<br><br>"
        	    + "<b>Reference Data Types:</b><br>"
        	    + "- Arrays: Collections of elements of the same type.<br>"
        	    + "- Objects: Instances of classes representing entities.<br>"
        	    + "- Strings: Sequences of characters.<br><br>"
        	    + "<b>Variables and Values:</b><br>"
        	    + "- Variable Declaration: Specify data type and name.<br>"
        	    + "- Initializing Variables: Assign values at declaration or later.<br><br>"
        	    + "<b>Type Casting and Conversion:</b><br>"
        	    + "- Type Casting: Convert between data types.<br>"
        	    + "- Type Conversion: Convert values between data types.<br><br>"
        	    + "Understanding Java's data types is vital for efficient coding, optimizing memory usage, and ensuring accurate data representation."
        	    + "</html>");
        lblTextPage3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        lblTextPage3.setBounds(50, 180, 700, 475);
        // button to go back to TOC on the third page
        btnToTOCPage3 = new JButton("Table of Contents");
        btnToTOCPage3.setBounds(500, 50, 200, 70);
        btnToTOCPage3.setBackground(lightBlue);
        btnToTOCPage3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
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
        btnQuiz3 = new JButton("Basics Chapter Quiz");
        btnQuiz3.setBounds(40, 650, 200, 60);
        btnQuiz3.setBackground(lightBlue);
        btnQuiz3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 1 Quiz");
                    Chapter1Quiz quizPanel = new Chapter1Quiz();
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
                cardLayout.show(Chapter1Textbook.this, "secondPage");
            }
        });
        // button to go to chp summary slide (page 3)
        btnSummary3 = new JButton("Basics Chapter Summary");
        btnSummary3.setBounds(540, 650, 200, 60);
        btnSummary3.setBackground(lightBlue);
        btnSummary3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Textbook.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 1 Summary");
                    Chapter1Summary summaryPanel = new Chapter1Summary();
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
        thirdPage.add(lblTextPage3);
        thirdPage.add(lblSubtitlePage3);
        thirdPage.add(btnToTOCPage3);
        thirdPage.add(btnQuiz3);
        thirdPage.add(btnPrevPage2);
        thirdPage.add(btnSummary3);

        // add third page to the panel
        add(thirdPage, "thirdPage");

        // show page 1 one as the "maincard" (default)
        cardLayout.show(this, "mainCard");
    }

    /**
	 * 
	 * Temporary main function to run the chapter 1 textbook directly
	 * 
	 */
    public static void main(String[] args) {
        // Example of usage (main method for testing)
        JFrame frame = new JFrame("Chapter 1: Java Basics Textbook");
        Chapter1Textbook chapter1 = new Chapter1Textbook();
		frame.getContentPane().add(chapter1);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
