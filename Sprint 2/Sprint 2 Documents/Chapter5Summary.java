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
import flashcards.Chapter3Flashcards;
import quizzes.Chapter5Quiz;
import quizzes.Chapter5Quiz;
import textbooks.Chapter5Textbook;
import textbooks.Chapter5Textbook;

/**
 * Chapter 5 (Classes) Summary Screen 
 * 
 * The user is able to move to the last page of the chapter, quiz section, flashcards, and table of contents 
 * just like the textbook.
 * 
 * @author Anthony Ephault
 *
 */
public class Chapter5Summary extends JPanel
{
	private CardLayout cardLayout;
	
    // other screens linked
    private JFrame tocFrame;			// table of contents screen
    private	JFrame textbookFrame; 		// chapter 5 summary screen
    private JFrame quizFrame;			// chapter 5 quiz screen
    private	JFrame flashcardsFrame;		// chaoter 5 flashcards screen
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
    private JButton btnChp3Textbook; 	// button to go back to the Chapter 5 Textbook
    
    private JButton btnHelp;			// help button
    
    /**
     * Chapter3Summary() - Constructor
     * 
     * Holds all the contents to print to the screen
     * 
     */
	public Chapter5Summary() 
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
        lblTitle = new JLabel("");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 200, 70);
        // chapter summary title
        lblChapterSummary = new JLabel("Chapter Summary");
        lblChapterSummary.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblChapterSummary.setBounds(50, 175, 400, 45);
        // summary text
        lblSummaryText = new JLabel("<html>\r\n"
                + "    <p>In Java, classes serve as fundamental components of object-oriented programming, encapsulating both data (attributes) and behavior (methods) related to specific concepts.</p>\r\n"
                + "    <p><b>Introduction to Classes:</b></p>\r\n"
                + "    <p>Classes in Java are fundamental for object-oriented programming:</p>\r\n"
                + "    <ul>\r\n"
                + "        <li><b>They encapsulate data (attributes) and behavior (methods) related to a specific concept.</li>\r\n"
                + "        <li><b>Class declaration includes the class name and a code block containing members like fields, constructors, and methods.</li>\r\n"
                + "    </ul>\r\n"
                + "	   <p>Constructors, special methods used for object initialization, can be default (provided by Java if not explicitly defined) or parameterized (allowing custom initialization of object attributes).</p>\\r\\n\"\r\n"
                + "    <p><b>Constructors and Instantiation:</b></p>\\r\\n\"\r\n"
                + "    <p>Constructors are special methods used to initialize objects:</p>\\r\\n\"\r\n"
                + "    <ul>\\r\\n\"\r\n"
                + "        <li><b>Default constructors are provided by Java if none are explicitly defined.</li>\\r\\n\"\r\n"
                + "        <li><b>Parameterized constructors allow custom initialization of object attributes.</li>\\r\\n\"\r\n"
                + "    </ul>\\r\\n\""
                +" 	   <p>Access modifiers like public, protected, default, and private control access to class members, facilitating encapsulation—a key principle of object-oriented design. Encapsulation involves bundling data and methods within a class and controlling access using access modifiers.</p>\\r\\n\"\r\n"
                + "    <p><b>Access Modifiers and Encapsulation:</b></p>\\r\\n\"\r\n"
                + "    <p>Access modifiers (public, protected, default, private) control access to class members:</p>\\r\\n\"\r\n"
                + "    <ul>\\r\\n\"\r\n"
                + "        <li><b>Encapsulation involves bundling data and methods within a class and controlling access using access modifiers.</li>\\r\\n\"\r\n"
                + "        <li><b>Encapsulation promotes code reusability, modularity, and maintainability by hiding implementation details.</li>\\r\\n\"\r\n"
                + "    </ul>\\r\\n\""
                + "    This practice promotes code reusability, modularity, and maintainability by hiding implementation details and providing a well-defined interface for interacting with objects.</p>\r\n"
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
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter5Summary.this);
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter5Summary.this);
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
        // button to go to back to chp 5 textbook
        btnChp3Textbook = new JButton("Classes Textbook");
        btnChp3Textbook.setBounds(260, 650, 260, 60);
        btnChp3Textbook.setBackground(lightBlue);
        // changes screen based on button click
        btnChp3Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter5Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    textbookFrame = new JFrame("Chapter 5: Classes Textbook");
                    // add the chapter summary panel
                    Chapter5Textbook textbookPanel = new Chapter5Textbook();
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
        btnFlashcards = new JButton("Classes Flashcards");
        btnFlashcards.setBounds(540, 650, 200, 60);
        btnFlashcards.setBackground(lightBlue);
        btnFlashcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter5Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    flashcardsFrame = new JFrame("Chapter 5: Classes Flashcards");
                    // add the chapter summary panel
                    Chapter5Flashcards flashcardsPanel = new Chapter5Flashcards();
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
                JOptionPane.showMessageDialog(null, "Welcome to the Chapter 5 Textbook: Classes!\n\n"
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
        summaryPage.add(btnChp3Textbook);
        summaryPage.add(btnFlashcards);
        summaryPage.add(btnHelp);
        add(summaryPage, "mainCard");
	
    }
    
	/**
	 * 
	 * Temporary main function to run the chapter 5 textbook directly
	 * 
	 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chapter 5: Classes Summary");
        Chapter5Summary chapter3Summary = new Chapter5Summary();
        frame.getContentPane().add(chapter5Summary);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
      
}
