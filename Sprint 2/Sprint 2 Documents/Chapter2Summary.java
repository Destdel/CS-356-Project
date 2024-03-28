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
import flashcards.Chapter2Flashcards;
import quizzes.Chapter2Quiz;
import textbooks.Chapter2Textbook;

/**
 * Chapter 2 (If/Else) Summary Screen 
 * 
 * The user is able to move to the last page of the chapter, quiz section, flashcards, and table of contents 
 * just like the textbook.
 * 
 * @author Destiny Deleon
 *
 */
public class Chapter2Summary extends JPanel
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
     * Chapter2Summary() - Constructor
     * 
     * Holds all the contents to print to the screen
     * 
     */
	public Chapter2Summary() 
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
        lblTitle = new JLabel("If/Else");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 400, 70);
        // chapter summary title
        lblChapterSummary = new JLabel("Chapter Summary");
        lblChapterSummary.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblChapterSummary.setBounds(50, 225, 400, 45);
        
        // summary text
        lblSummaryText = new JLabel("<html> In Java, control flow statements like 'if', 'else', "
        		+ "and nested 'if' statements are essential tools for programming logic. The "
        		+ "'if' statement executes a block of code based on a condition, determining "
        		+ "whether a certain statement or block will be executed. The 'else' statement "
        		+ "complements 'if', executing a block of code when the 'if' condition evaluates "
        		+ "to false. Nested 'if' statements enable conditional branching within conditional "
        		+ "branches, facilitating more intricate decision-making in Java programming.</p>\r\n"
                + "</html>");
        lblSummaryText.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        lblSummaryText.setBounds(50, 275, 700, 150);
        
        
        // button to go to TOC
        btnToTOC = new JButton("Table of Contents");
        btnToTOC.setBounds(450, 50, 200, 70);
        btnToTOC.setBackground(lightBlue);
        btnToTOC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                     // close current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Summary.this);
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
        btnQuiz = new JButton("If/Else Chapter Quiz");
        btnQuiz.setBounds(40, 650, 200, 60);
        btnQuiz.setBackground(lightBlue);
        btnQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Summary.this);
                    currentFrame.dispose();
                    // create the chapter quiz frame
                    quizFrame = new JFrame("Chapter 2 Quiz");
                    Chapter2Quiz quizPanel = new Chapter2Quiz();
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
        btnChp3Textbook = new JButton("Back to If/Else Textbook");
        btnChp3Textbook.setBounds(260, 650, 260, 60);
        btnChp3Textbook.setBackground(lightBlue);
        // changes screen based on button click
        btnChp3Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    textbookFrame = new JFrame("Chapter 2: If/Else Textbook");
                    // add the chapter summary panel
                    Chapter2Textbook textbookPanel = new Chapter2Textbook();
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
        
        // button to go to chp 2 flashcards slide
        btnFlashcards = new JButton("Loops Flashcards");
        btnFlashcards.setBounds(540, 650, 200, 60);
        btnFlashcards.setBackground(lightBlue);
        btnFlashcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Summary.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    flashcardsFrame = new JFrame("Chapter 2: If/Else Flashcards");
                    // add the chapter summary panel
                    Chapter2Flashcards flashcardsPanel = new Chapter2Flashcards();
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
                JOptionPane.showMessageDialog(null, "Welcome to the Chapter 2 Textbook: If/Else!\n\n"
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
        JFrame frame = new JFrame("Chapter 2: If/Else Summary");
        Chapter3Summary chapter3Summary = new Chapter3Summary();
        frame.getContentPane().add(chapter3Summary);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
      
}

