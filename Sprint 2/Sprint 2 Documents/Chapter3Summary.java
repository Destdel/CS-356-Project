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
import quizzes.Chapter1Quiz;
import quizzes.Chapter3Quiz;
import textbooks.Chapter1Textbook;
import textbooks.Chapter3Textbook;

/**
 * Chapter 3 (Loops) Summary Screen 
 * 
 * The user is able to move to the last page of the chapter, quiz section, flashcards, and table of contents 
 * just like the textbook.
 * 
 * @author Max Flannick
 *
 */
public class Chapter3Summary extends JPanel
{
	private CardLayout cardLayout;
	
    // other screens linked
    private JFrame tocFrame;			// table of contents screen
    private	JFrame textbookFrame; 		// chapter 3 summary screen
    private JFrame quizFrame;			// chapter 3 quiz screen
    private	JFrame flashcardsFrame;		// chaoter 3 flashcards screen
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
    private JButton btnChp3Textbook; 	// button to go back to the Chapter 3 Textbook
    
    private JButton btnHelp;			// help button
    
    /**
     * Chapter3Summary() - Constructor
     * 
     * Holds all the contents to print to the screen
     * 
     */
	public Chapter3Summary() 
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
        lblTitle = new JLabel("Loops");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 200, 70);
        // chapter summary title
        lblChapterSummary = new JLabel("Chapter Summary");
        lblChapterSummary.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblChapterSummary.setBounds(50, 175, 400, 45);
        // summary text
        lblSummaryText = new JLabel("<html>\r\n"
                + "    <p>Loops are essential programming constructs that allow you to execute a block of code repeatedly. They are important to save code and increase efficiency.</p>\r\n"
                + "    <p><b>Types of Loops:</b></p>\r\n"
                + "    <p>In Java, there are three main types of loops: <b>for</b>, <b>while</b>, and <b>do-while</b> loops. Each type is unique and used in their own ways.</p>\r\n"
                + "    <ul>\r\n"
                + "        <li><b>For Loops:</b> Use for loops when you know the number of iterations in advance, such as iterating over a known range of values or items. There are three parts of a for loop: initialization (i=0), condition (i \"less than\" 5), and iteration expression (i++).</li>\r\n"
                + "        <li><b>While Loops:</b> While loops are suitable when you need to repeat a block of code as long as a specific condition remains true. They are useful when you don't know how many times you'll run the loop. Example: user input until told to stop.</li>\r\n"
                + "        <li><b>Do-While Loops:</b> Do-while loops are similar to while loops but they are guaranteed to run at least once, and can help when you want the code to run at least once in the loop.</li>\r\n"
                + "    </ul>\r\n"
                + "    It's important to be cautious of infinite loops due to improper initialization, condition, or updating of loop variables. This is common in while loops because programmers may forget to update the variable used in the condition in the loop.</p>\r\n"
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
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter3Summary.this);
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
        btnQuiz = new JButton("Loops Chapter Quiz");
        btnQuiz.setBounds(40, 650, 200, 60);
        btnQuiz.setBackground(lightBlue);
        btnQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter3Summary.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 3 Quiz");
                    Chapter3Quiz quizPanel = new Chapter3Quiz();
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
        btnChp3Textbook = new JButton("Back to Loops Textbook");
        btnChp3Textbook.setBounds(260, 650, 260, 60);
        btnChp3Textbook.setBackground(lightBlue);
        // changes screen based on button click
        btnChp3Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter3Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    textbookFrame = new JFrame("Chapter 3: Loops Textbook");
                    // add the chapter summary panel
                    Chapter3Textbook textbookPanel = new Chapter3Textbook();
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter3Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    flashcardsFrame = new JFrame("Chapter 3: Loops Flashcards");
                    // add the chapter summary panel
                    Chapter3Flashcards flashcardsPanel = new Chapter3Flashcards();
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
                JOptionPane.showMessageDialog(null, "Welcome to the Chapter 3 Textbook: Loops!\n\n"
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
	 * Temporary main function to run the chapter 3 textbook directly
	 * 
	 */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chapter 3: Loops Summary");
        Chapter3Summary chapter3Summary = new Chapter3Summary();
        frame.getContentPane().add(chapter3Summary);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
      
}

