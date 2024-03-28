package summaries;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import application.tableOfContents;
import flashcards.Chapter1Flashcards;
import quizzes.Chapter1Quiz;
import quizzes.Chapter1Quiz;
import textbooks.Chapter1Textbook;
import textbooks.Chapter3Textbook;

/**
 * Chapter 1 (Basics) Summary Screen 
 * 
 * The user is able to move to the last page of the chapter, quiz section, flashcards, and table of contents 
 * just like the textbook.
 * 
 * @author Anthony Ephault
 *
 */
public class Chapter1Summary extends JPanel
{
	private CardLayout cardLayout;
	
    // other screens linked
    private JFrame tocFrame;			// table of contents screen
    private	JFrame textbookFrame; 		// chapter 1 summary screen
    private JFrame quizFrame;			// chapter 1 quiz screen
    private	JFrame flashcardsFrame;		// chaoter 1 flashcards screen
    // textbook information variables
    private	JLabel lblChapterSummary;	// subtitle page 1
    private JLabel lblSummaryText;		// text for page 1
    // screen information
    private JLabel lblTitle; 			// chapter title
    // buttons
    // page 1
    private JButton btnToTOC; 			// button to go back to the table of contents
    private JButton btnQuiz; 			// button to proceed to the chapter quiz
    private JButton btnFlashcards; 		// button to proceed to the flashcards screen
    private JButton btnChp1Textbook; 	// button to go back to the Chapter 1 Textbook
    
    private JButton btnHelp;			// help button
    
    /**
     * Chapter3Summary() - Constructor
     * 
     * Holds all the contents to print to the screen
     * 
     */
	public Chapter1Summary() 
    {
    	// declare variables basic screen variables
        Color lightBlue = new Color(173, 216, 230);     // color for the buttons
        
        setLayout(new CardLayout());                    // card layout to change pages
        cardLayout = (CardLayout) getLayout();    
        
        // SUMMARY SCREEN
        JPanel summaryPage = new JPanel(null);
        // change background & add border
        summaryPage.setBackground(new Color(200, 230, 200));
        summaryPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // print screen information
        // title text
        lblTitle = new JLabel("Basics");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 200, 70);
        // chapter summary title
        lblChapterSummary = new JLabel("Chapter Summary");
        lblChapterSummary.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblChapterSummary.setBounds(50, 175, 400, 45);
        // summary text
        lblSummaryText = new JLabel("<html>\r\n"
                + "    <p>\"Getting Started with Java\" covers the essential aspects of setting up a Java Development Environment, writing your first Java program, understanding Java syntax and structure, and grasping data types in Java. It begins with instructions on installing the Java Development Kit (JDK), configuring environment variables, and selecting an Integrated Development Environment (IDE) like Eclipse or IntelliJ IDEA.</p>\r\n"
                + "    <ul>\r\n"
                + "        <li><b>Then progresses to explain the structure of a Java program, including package declaration, import statements, class declaration, and the main method, followed by practical steps to write and compile a simple \"Hello, World!\" program.</li>\r\n"
                + "    </ul>\r\n"
                +" 	   <p>Additionally, it delves into Java syntax details such as identifiers, keywords, naming rules for classes, variables, and methods, as well as commenting conventions.</p>\\r\\n\"\r\n"
                + "    <p>Furthermore, the chapter introduces Java's data types, including primitive data types like integers, floating-point numbers, characters, and booleans, as well as reference data types like arrays, objects, and Strings.</p>\\r\\n\"\r\n"
                + "    <ul>\\r\\n\"\r\n"
                + "        <li><b>It covers topics such as declaring variables, initializing values, and understanding type casting and conversion.</li>\\r\\n\"\r\n"
                + "    </ul>\\r\\n\""
                + "    This comprehensive overview of Java fundamentals sets a strong foundation for learners venturing into Java programming, equipping them with the knowledge needed to work with variables, data types, operators, control flow, and decision-making structures effectively.</p>\r\n"
                + "</html>\r\n");
        lblSummaryText.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblSummaryText.setBounds(50, 200, 700, 450);
        
        // button to go to TOC
        btnToTOC = new JButton("Table of Contents");
        btnToTOC.setBounds(450, 50, 200, 70);
        btnToTOC.setBackground(lightBlue);
        btnToTOC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     // close current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Summary.this);
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Summary.this);
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
        // button to go to back to chp 3 textbook
        btnChp1Textbook = new JButton("Basics Textbook");
        btnChp1Textbook.setBounds(260, 650, 260, 60);
        btnChp1Textbook.setBackground(lightBlue);
        // changes screen based on button click
        btnChp1Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    textbookFrame = new JFrame("Chapter 1: Basics Textbook");
                    // add the chapter summary panel
                    Chapter1Textbook textbookPanel = new Chapter1Textbook();
                    textbookFrame.add(textbookPanel);
                    // set size and make visible
                    textbookFrame.setSize(800, 800);
                    textbookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    textbookFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        
        // button to go to chp 3 flashcards slide
        btnFlashcards = new JButton("Loops Flashcards");
        btnFlashcards.setBounds(540, 650, 200, 60);
        btnFlashcards.setBackground(lightBlue);
        btnFlashcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter1Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    flashcardsFrame = new JFrame("Chapter 3: Loops Flashcards");
                    // add the chapter summary panel
                    Chapter1Flashcards flashcardsPanel = new Chapter1Flashcards();
                    flashcardsFrame.add(flashcardsPanel);
                    // set size and make visible
                    flashcardsFrame.setSize(800, 800);
                    flashcardsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    flashcardsFrame.setVisible(true);
                } catch (IllegalArgumentException ex) {
                    // ignore this error, the program works just fine
                }
            }
        });
        
        // help button code
        btnHelp = new JButton("?");
        btnHelp.setBounds(725, 10, 50, 50); 	// set bounds
        btnHelp.setBackground(lightBlue);		// change color
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display the help window
                JOptionPane.showMessageDialog(null, "Welcome to the Chapter 1 Textbook: Basics!\n\n"
                        + "Use the buttons at the bottom to flip through the textbook or go to other sections (Summary, Quiz) of the application.\n\n"
                        + "You may go back to the table of contents at any time.\n\n"
                        + "Practice questions will pop up as you flip through the pages in a seperate window. You MUST answer them correctly to move forward.\n\n"
                        + "Enjoy learning!", "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // print contents to screen
        summaryPage.add(lblTitle);
        summaryPage.add(lblChapterSummary);
        summaryPage.add(lblSummaryText);
        summaryPage.add(btnToTOC);
        summaryPage.add(btnQuiz);
        summaryPage.add(btnChp1Textbook);
        summaryPage.add(btnFlashcards);
        summaryPage.add(btnHelp);
        add(summaryPage, "mainCard");
	
    }
    
	/**
	 * 
	 * Temporary main function to run the chapter 1 textbook directly
	 * 
	 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chapter 1: Basics Summary");
        Chapter1Summary chapter3Summary = new Chapter1Summary();
        frame.getContentPane().add(chapter1Summary);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
      
}
