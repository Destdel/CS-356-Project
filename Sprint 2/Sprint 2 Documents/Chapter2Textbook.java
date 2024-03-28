package textbooks;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import application.tableOfContents;
import summaries.Chapter2Summary;
import summaries.Chapter3Summary;
import quizzes.Chapter2Quiz;

/**
 * Chapter 2 Textbook for the Learning Java Application.
 * If-Else Statements
 * 
 * @author Destiny Deleon
 *
 */
public class Chapter2Textbook extends JPanel 
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
    
    // boolean variables for practice questions
    boolean pqPageOne = false;			// flag used to see if the user got the practice question on page one correct
    boolean pqPageTwo = false;			// flag used to see if the user got the practice question on page two correct
    boolean pqPageThreeMCQ = false;		// flag used to see if the user got the practice question on page three (MC) correct
    boolean pqPageThreeSA = false;		// flag used to see if the user got the practice question on page three (SA) correct
    private boolean mcQuestionDisplayed = false;	// flag used to see if mc question displaying - if it is do not create another window
    private boolean saQuestionDisplayed = false;	// flag used to see if sa question displaying - if it is do not create another window
    
    // practice question variables
    // page 1
    private JFrame practiceQuestionFramePage1;    // frame for practice question page 1
    private JPanel practiceQuestionPanelPage1;    // panel for practice question page 1
    private JLabel lblQuestionPage1;             // practice question text for page 1
    private JRadioButton rbOptionAPage1;         // A choice for practice question page 1
    private JRadioButton rbOptionBPage1;         // B choice for practice question page 1
    private JRadioButton rbOptionCPage1;         // C choice for practice question page 1
    private JRadioButton rbOptionDPage1;         // D choice for practice question page 1
    private JButton btnSubmitPage1;              // submit button for practice question page 1
    // page 2
    private JFrame practiceQuestionFramePage2;   // frame for practice question page 2
    private JPanel practiceQuestionPanelPage2;   // panel for practice question page 2
    private JLabel lblQuestionPage2;             // practice question text for page 2
    private JRadioButton rbOptionAPage2;         // A choice for practice question page 2
    private JRadioButton rbOptionBPage2;         // B choice for practice question page 2
    private JRadioButton rbOptionCPage2;         // C choice for practice question page 2
    private JRadioButton rbOptionDPage2;         // D choice for practice question page 2
    // page 3
    // multiple choice question
    private JButton btnSubmitPage2;              // submit button for practice question page 2
    private JFrame mcqFramePage3;                // frame for multiple-choice question page 3
    private JPanel mcqPanelPage3;                // panel for multiple-choice question page 3
    private JLabel lblQuestionPage3;             // question text for multiple-choice question page 3
    private JRadioButton rbOptionAPage3;         // A choice for multiple-choice question page 3
    private JRadioButton rbOptionBPage3;         // B choice for multiple-choice question page 3
    private JRadioButton rbOptionCPage3;         // C choice for multiple-choice question page 3
    private JRadioButton rbOptionDPage3;         // D choice for multiple-choice question page 3
    private JButton btnSubmitPage3;              // submit button for multiple-choice question page 3
    private JLabel lblQuestion1Number;			 // text to display question number (1/2)
    // short answer
    private JFrame shortAnswerFramePage3;        // frame for short answer question page 3
    private JPanel shortAnswerPanelPage3;        // panel for short answer question page 3
    private JLabel lblQuestionShortAnswerPage3;  // question text for short answer question page 3
    private JTextField answerTextFieldPage3;     // text field for short answer question page 3
    private JButton btnSubmitShortAnswerPage3;   // submit button for short answer question page 3
    private JLabel lblQuestion2Number;			// text to display question number (2/2)
    
    private JButton btnHelp;			// help button

    /**
	 * 
	 * Chapter2Textbook() - Constructor
	 * 
	 * Used to create the chapter 2 (if-else statements) textbook which the user is able to flip through and read.
	 * The user is also able to access the summary, quiz, and table of contents for this chapter as well.
	 * 
	 **/
    public Chapter2Textbook() 
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
        lblTitle = new JLabel("If/Else");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 400, 70);
        // page number text
        lblPage1Number = new JLabel("Page 1");
        lblPage1Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage1Number.setBounds(280, 725, 200, 40);
        // page 1 subtitle
        lblSubtitlePage1 = new JLabel("What is a If Statement?");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 225, 400, 45);

        // page 1 text
        lblTextPage1 = new JLabel("<html>In Java, an if statement is a control flow statement that allows "
        		+ "you to execute a block of code based on a condition. It is used to decide whether "
        		+ "a certain statement or block of statements will be executed or not i.e if a certain "
        		+ "condition is true then a block of statement is executed otherwise not. It's one of "
        		+ "the fundamental building blocks of programming logic. </html>");
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
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
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
        // button to go to next page
        btnNextPage = new JButton("Next Page");
        btnNextPage.setBounds(290, 650, 200, 60);
        btnNextPage.setBackground(lightBlue);
        // changes screen based on button click
        btnNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if practice question is already answered don't print the practice question again
                if (!pqPageOne)
                {    // create JFrame & JPanel for the practice question
                    practiceQuestionFramePage1 = new JFrame("Chapter 2: Practice Question #1");
                    practiceQuestionPanelPage1 = new JPanel(null);
                    
                    // change background & add border
                    practiceQuestionPanelPage1.setBackground(new Color(200, 230, 200));
                    practiceQuestionPanelPage1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

                    // create text for the question
                    lblQuestionPage1 = new JLabel("If statements allow you to exectue code based on what?");
                    lblQuestionPage1.setBounds(75, 50, 325, 30);
                    lblQuestionPage1.setHorizontalAlignment(SwingConstants.CENTER);              // center the text
                    practiceQuestionPanelPage1.add(lblQuestionPage1);

                    // create four radio buttons to hold each option
                    rbOptionAPage1 = new JRadioButton("A: A condition");
                    rbOptionBPage1 = new JRadioButton("B: A controller");
                    rbOptionCPage1 = new JRadioButton("C: An event");
                    rbOptionDPage1 = new JRadioButton("D: A thread");

                    // set location for each radio button
                    rbOptionAPage1.setBounds(100, 100, 300, 30);
                    rbOptionBPage1.setBounds(100, 150, 300, 30);
                    rbOptionCPage1.setBounds(100, 200, 300, 30);
                    rbOptionDPage1.setBounds(100, 250, 300, 30);

                    // Create JButton to submit the answer
                    btnSubmitPage1 = new JButton("Submit");
                    btnSubmitPage1.setBounds(300, 350, 200, 30); // Set bounds for the submit button
                    btnSubmitPage1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // check which radio button is selected & provides user with feedback if they got it right or wrong
                            if ((!rbOptionAPage1.isSelected()) && (!rbOptionBPage1.isSelected()) && (!rbOptionCPage1.isSelected()) && (!rbOptionAPage1.isSelected())) 
                                 JOptionPane.showMessageDialog(null, "You must select an option!");      // must enter an answer
                            else if (rbOptionAPage1.isSelected()) {
                                JOptionPane.showMessageDialog(null, "Correct!");                        // correct
                                practiceQuestionFramePage1.dispose();                                    // close practice question
                                pqPageOne = true;                                                        // set flag to true so PQ only appears once
                                cardLayout.show(Chapter2Textbook.this, "secondPage");                    // move to the next page
                            }
                            else 
                                JOptionPane.showMessageDialog(null, "Incorrect. Please try again.");    // incorrect
                        }
                    });
                    
                    // set bounds for submit button
                    btnSubmitPage1.setBounds(200, 300, 100, 30);
                    
                    // create a ButtonGroup to connect all radio options
                    ButtonGroup buttonGroupPage1 = new ButtonGroup();
                    buttonGroupPage1.add(rbOptionAPage1);
                    buttonGroupPage1.add(rbOptionBPage1);
                    buttonGroupPage1.add(rbOptionCPage1);
                    buttonGroupPage1.add(rbOptionDPage1);

                    // add radio buttons to the panel & practice question
                    practiceQuestionPanelPage1.add(rbOptionAPage1);
                    practiceQuestionPanelPage1.add(rbOptionBPage1);
                    practiceQuestionPanelPage1.add(rbOptionCPage1);
                    practiceQuestionPanelPage1.add(rbOptionDPage1);
                    practiceQuestionPanelPage1.add(btnSubmitPage1);
                    practiceQuestionFramePage1.getContentPane().add(practiceQuestionPanelPage1);
                    
                    // add a window listener to enable buttons when practice question window is closed
                    practiceQuestionFramePage1.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            btnToTOC.setEnabled(true);
                            btnQuiz.setEnabled(true);
                            btnSummary.setEnabled(true);
                        }
                    });

                    // set size of the screen & make it visible
                    practiceQuestionFramePage1.setSize(500, 420); 
                    practiceQuestionFramePage1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                    practiceQuestionFramePage1.setVisible(true);
                    
                    // disable other buttons while practice question is displayed
                    btnToTOC.setEnabled(false);
                    btnQuiz.setEnabled(false);
                    btnSummary.setEnabled(false);
                }
                else    cardLayout.show(Chapter2Textbook.this, "secondPage");                     // move to the next page
            }
        });
        
        // button to go to chp summary slide
        btnSummary = new JButton("If/Else Chapter Summary");
        btnSummary.setBounds(540, 650, 200, 60);
        btnSummary.setBackground(lightBlue);
        btnSummary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 2 Summary");
                    // add the chapter summary panel
                    Chapter2Summary summaryPanel = new Chapter2Summary();
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
        
        // help button code
        btnHelp = new JButton("?");
        btnHelp.setBounds(725, 10, 50, 50); 	// set bounds
        btnHelp.setBackground(lightBlue);		// change color
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display the help window
                JOptionPane.showMessageDialog(null, "Welcome to the Chapter 2 Textbook: If-Else Statements!\n\n"
                        + "Use the buttons at the bottom to flip through the textbook or go to other sections (Summary, Quiz) of the application.\n\n"
                        + "You may go back to the table of contents at any time.\n\n"
                        + "Practice questions will pop up as you flip through the pages in a seperate window. You MUST answer them correctly to move forward.\n\n"
                        + "Enjoy learning!", "Help", JOptionPane.INFORMATION_MESSAGE);
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
        firstPage.add(btnHelp);
        add(firstPage, "mainCard");

        // PAGE 2:: create next page of the textbook if it clicked
        JPanel secondPage = new JPanel(null);
        secondPage.setBackground(new Color(200, 230, 200));
        secondPage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // title for the second page
        lblTitlePage2 = new JLabel("If/Else");
        lblTitlePage2.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage2.setBounds(50, 50, 400, 70);
        // page number text
        lblPage2Number = new JLabel("Page 2");
        lblPage2Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage2Number.setBounds(280, 725, 200, 40);
        // page 2 subtitle
        lblSubtitlePage2 = new JLabel("What is an Else Statement?");
        lblSubtitlePage2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage2.setBounds(50, 225, 700, 45);
        // page 2 text
        lblTextPage2 = new JLabel("<html>In Java, an else statement is used in conjunction with an if statement to execute a block of "
                + "code when the condition specified in the if statement evaluates to false. The else statement "
                + "follows immediately after the body of the if statement and before any subsequent if or else if statements. </html>");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
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
        btnQuiz2 = new JButton("If/Else Chapter Quiz");
        btnQuiz2.setBounds(25, 650, 175, 60);
        btnQuiz2.setBackground(lightBlue);
        btnQuiz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 try {
                     // close the current frame
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
                     currentFrame.dispose();
                     // create the chapter quiz frame
                     quizFrame = new JFrame("Chapter 2 Quiz");
                     // add the chapter quiz panel
                     Chapter2Quiz quizPanel = new Chapter2Quiz();
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
                cardLayout.show(Chapter2Textbook.this, "mainCard");
            }
        });

        // button to go to next page (page 2)
        btnNextPage2 = new JButton("Next Page");
        btnNextPage2.setBounds(395, 650, 175, 60);
        btnNextPage2.setBackground(lightBlue);
        btnNextPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the practice question on page two has already been answered
                if (!pqPageTwo) {
                    if (practiceQuestionFramePage2 == null || !practiceQuestionFramePage2.isVisible()) {
                        // create JFrame & JPanel for the practice question
                        practiceQuestionFramePage2 = new JFrame("Chapter 2: Practice Question #2");
                        practiceQuestionPanelPage2 = new JPanel(null);

                        // change background & add border
                        practiceQuestionPanelPage2.setBackground(new Color(200, 230, 200));
                        practiceQuestionPanelPage2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

                        // create text for the question
                        lblQuestionPage2 = new JLabel("When is the code within the else statement exectued?");
                        lblQuestionPage2.setBounds(75, 50, 325, 30);
                        lblQuestionPage2.setHorizontalAlignment(SwingConstants.CENTER); // center the text
                        practiceQuestionPanelPage2.add(lblQuestionPage2);

                        // create four radio buttons to hold each option
                        rbOptionAPage2 = new JRadioButton("A: When there is an error in the if statement");
                        rbOptionBPage2 = new JRadioButton("B: When a ballon pops");
                        rbOptionCPage2 = new JRadioButton("C: When all conditions evaluate to false");
                        rbOptionDPage2 = new JRadioButton("D: None of the above");

                        // set location for each radio button
                        rbOptionAPage2.setBounds(100, 100, 300, 30);
                        rbOptionBPage2.setBounds(100, 150, 300, 30);
                        rbOptionCPage2.setBounds(100, 200, 300, 30);
                        rbOptionDPage2.setBounds(100, 250, 300, 30);

                        // Create JButton to submit the answer
                        btnSubmitPage2 = new JButton("Submit");
                        btnSubmitPage2.setBounds(300, 350, 200, 30); // Set bounds for the submit button
                        btnSubmitPage2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // check which radio button is selected & provides user with feedback if they got it right or wrong
                                if ((!rbOptionAPage2.isSelected()) && (!rbOptionBPage2.isSelected()) && (!rbOptionCPage2.isSelected()) && (!rbOptionDPage2.isSelected())) 
                                    JOptionPane.showMessageDialog(null, "You must select an option!"); // must enter an answer
                                else if (rbOptionCPage2.isSelected()) {
                                    JOptionPane.showMessageDialog(null, "Correct!"); // correct
                                    practiceQuestionFramePage2.dispose(); // close practice question
                                    pqPageTwo = true; // set flag to true so practice question only appears once
                                    cardLayout.show(Chapter2Textbook.this, "thirdPage"); // move to the next page
                                } else 
                                    JOptionPane.showMessageDialog(null, "Incorrect. Please try again."); // incorrect
                            }
                        });

                        // set bounds for submit button
                        btnSubmitPage2.setBounds(200, 300, 100, 30);

                        // create a ButtonGroup to connect all radio options
                        ButtonGroup buttonGroupPage2 = new ButtonGroup();
                        buttonGroupPage2.add(rbOptionAPage2);
                        buttonGroupPage2.add(rbOptionBPage2);
                        buttonGroupPage2.add(rbOptionCPage2);
                        buttonGroupPage2.add(rbOptionDPage2);

                        // add radio buttons to the panel & practice question
                        practiceQuestionPanelPage2.add(rbOptionAPage2);
                        practiceQuestionPanelPage2.add(rbOptionBPage2);
                        practiceQuestionPanelPage2.add(rbOptionCPage2);
                        practiceQuestionPanelPage2.add(rbOptionDPage2);
                        practiceQuestionPanelPage2.add(btnSubmitPage2);
                        practiceQuestionFramePage2.getContentPane().add(practiceQuestionPanelPage2);
                        
                        // add a window listener to enable buttons when practice question window is closed
                        practiceQuestionFramePage2.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                btnToTOCPage2.setEnabled(true);
                                btnQuiz2.setEnabled(true);
                                btnSummary2.setEnabled(true);
                                btnPrevPage.setEnabled(true);
                            }
                        });

                        // set size of the screen & make it visible
                        practiceQuestionFramePage2.setSize(500, 420); 
                        practiceQuestionFramePage2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                        practiceQuestionFramePage2.setVisible(true);
                        
                        // disable buttons while practice question is open
                        btnToTOCPage2.setEnabled(false);
                        btnQuiz2.setEnabled(false);
                        btnSummary2.setEnabled(false);
                        btnPrevPage.setEnabled(false);
                    }
                } else 
                    cardLayout.show(Chapter2Textbook.this, "thirdPage"); // move to the next page
            }
        });
        
        // button to go to the chapter summary screen (page 2)
        btnSummary2 = new JButton("If/Else Chapter Summary");
        btnSummary2.setBounds(580, 650, 175, 60);
        btnSummary2.setBackground(lightBlue);
        btnSummary2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
                    currentFrame.dispose();
                    // create the chapter summary frame
                    summaryFrame = new JFrame("Chapter 2 Summary");
                    // add the chapter summary panel
                    Chapter2Summary summaryPanel = new Chapter2Summary();
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
        lblTitlePage3 = new JLabel("If/Else");
        lblTitlePage3.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitlePage3.setBounds(50, 50, 400, 70);
        // page number text
        lblPage3Number = new JLabel("Page 3");
        lblPage3Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage3Number.setBounds(280, 725, 200, 40);
        // page 3 subtitle
        lblSubtitlePage3 = new JLabel("What is a Nest If Statement?");
        lblSubtitlePage3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage3.setBounds(50, 225, 700, 45);
        // page 3 text
        lblTextPage3 = new JLabel("<html> In Java, a nested if statement is an "
        		+ "if statement that is placed inside another if statement. This allows "
        		+ "for conditional branching within conditional branches, allowing for "
        		+ "more complex decision-making in your code.</html>");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
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
        btnQuiz3 = new JButton("If/Else Chapter Quiz");
        btnQuiz3.setBounds(40, 650, 200, 60);
        btnQuiz3.setBackground(lightBlue);
        btnQuiz3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // close the current frame
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
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
        // button to go to previous page (page 3)
        btnPrevPage2 = new JButton("Previous Page");
        btnPrevPage2.setBounds(290, 650, 200, 60);
        btnPrevPage2.setBackground(lightBlue);
        btnPrevPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch to the second page when "Previous Page" is clicked
                cardLayout.show(Chapter2Textbook.this, "secondPage");
            }
        });
     // button to go to chp summary slide (page 3)
        btnSummary3 = new JButton("Loops Chapter Summary");
        btnSummary3.setBounds(540, 650, 200, 60);
        btnSummary3.setBackground(lightBlue);
        btnSummary3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if both questions have been answered correctly
                if (pqPageThreeMCQ && pqPageThreeSA) {
                    // Move to the chapter summary slide
                    try {
                        // close the current frame
                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
                        currentFrame.dispose();
                        // create the chapter summary frame
                        JFrame summaryFrame = new JFrame("Chapter 3 Summary");
                        JPanel summaryPanel = new Chapter3Summary();
                        summaryFrame.getContentPane().add(summaryPanel);
                        summaryFrame.setSize(800, 800);
                        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        summaryFrame.setVisible(true);
                    } catch (IllegalArgumentException ex) {
                        // ignore this error, the program works just fine
                    }
                } else {
                    // display the first multiple-choice question if not answered yet
                    if (!pqPageThreeMCQ) {
                        DisplayMultipleChoiceQuestion();
                    } else {
                    	DisplayShortAnswerQuestion();
                    }
                }
                
                // disable buttons again if practice question windows are displayed
                if (mcQuestionDisplayed || saQuestionDisplayed) {
                    btnToTOCPage3.setEnabled(false);
                    btnQuiz3.setEnabled(false);
                    btnPrevPage2.setEnabled(false);
                }
            }
        });

        // add components to third page
        thirdPage.add(lblTitlePage3);
        thirdPage.add(lblPage3Number);
        thirdPage.add(lblSubtitlePage3);
        thirdPage.add(lblTextPage3);
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
	 * Function used to display the multiple choice question on page 3 (1/2)
	 *
	 */
	 private void DisplayMultipleChoiceQuestion() 
	 {
		// allow practice question screen to only display once
		if (!mcQuestionDisplayed)
		{	mcQuestionDisplayed = true;			// set flag
		
		    // create JFrame & JPanel for the multiple-choice practice question
		    mcqFramePage3 = new JFrame("Chapter 2: Practice Question #3 Multiple Choice (1/2)");
		    mcqPanelPage3 = new JPanel(null);
		
		    // change background & add border
		    mcqPanelPage3.setBackground(new Color(200, 230, 200));
		    mcqPanelPage3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		    // Create text for the question
		    lblQuestionPage3 = new JLabel("How many nested if statments can you have?");
		    lblQuestionPage3.setBounds(150, 50, 400, 30);
		    lblQuestionPage3.setHorizontalAlignment(SwingConstants.CENTER); // center the text
		    mcqPanelPage3.add(lblQuestionPage3);
		
		    // create four radio buttons to hold each option
		    rbOptionAPage3 = new JRadioButton("A: 1");
		    rbOptionBPage3 = new JRadioButton("B: Infinity");
		    rbOptionCPage3 = new JRadioButton("C: 3");
		    rbOptionDPage3 = new JRadioButton("D: 7,563");
		
		    // set location for each radio button
		    rbOptionAPage3.setBounds(40, 100, 600, 30);
		    rbOptionBPage3.setBounds(40, 150, 600, 30);
		    rbOptionCPage3.setBounds(40, 200, 600, 30);
		    rbOptionDPage3.setBounds(40, 250, 600, 30);
		
		    // create JButton to submit the answer
		    btnSubmitPage3 = new JButton("Submit");
		    btnSubmitPage3.setBounds(250, 300, 200, 30); // Set bounds for the submit button
		    btnSubmitPage3.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // check which radio button is selected & provide user with feedback if they got it right or wrong
		            if ((!rbOptionAPage3.isSelected()) && (!rbOptionBPage3.isSelected()) && (!rbOptionCPage3.isSelected()) && (!rbOptionDPage3.isSelected())) {
		                JOptionPane.showMessageDialog(null, "You must select an option!"); // Must enter an answer
		            } else if (rbOptionBPage3.isSelected()) {
		                JOptionPane.showMessageDialog(null, "Correct!"); // correct
		                mcqFramePage3.dispose();                            // close mc practice question
		                pqPageThreeMCQ = true;                               // see flag since mc question was answered correctly
		
		                // display the short answer question
		                DisplayShortAnswerQuestion();
		            } else {
		                JOptionPane.showMessageDialog(null, "Incorrect. Please try again."); // incorrect
		            }
		        }
		    });
		    
		    // question number text
		    lblQuestion1Number = new JLabel("(1/2)");
		    lblQuestion1Number.setHorizontalAlignment(SwingConstants.CENTER); 
		    lblQuestion1Number.setBounds(250, 330, 200, 40);
		    mcqPanelPage3.add(lblQuestion1Number);
		
		    // create a ButtonGroup to connect all radio options
		    ButtonGroup buttonGroupPage3 = new ButtonGroup();
		    buttonGroupPage3.add(rbOptionAPage3);
		    buttonGroupPage3.add(rbOptionBPage3);
		    buttonGroupPage3.add(rbOptionCPage3);
		    buttonGroupPage3.add(rbOptionDPage3);
		
		    // add radio buttons to the panel & practice question
		    mcqPanelPage3.add(rbOptionAPage3);
		    mcqPanelPage3.add(rbOptionBPage3);
		    mcqPanelPage3.add(rbOptionCPage3);
		    mcqPanelPage3.add(rbOptionDPage3);
		    mcqPanelPage3.add(btnSubmitPage3);
		    mcqFramePage3.getContentPane().add(mcqPanelPage3);
		    
		    // add a window listener to enable buttons when practice question window is closed
		    mcqFramePage3.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (!pqPageThreeMCQ)
                    {	btnToTOCPage3.setEnabled(true);
                    	btnQuiz3.setEnabled(true);
                    	btnPrevPage2.setEnabled(true);
                    	// reset flag to allow reloading of the MCQ practice question
                    	mcQuestionDisplayed = false;
                    }
                }
            });
		
		    // set size of the screen & make it visible
		    mcqFramePage3.setSize(700, 405);
		    mcqFramePage3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    mcqFramePage3.setVisible(true);
		    
		    // disable other buttons when practice question is open
		    btnToTOCPage3.setEnabled(false);
            btnQuiz3.setEnabled(false);
            btnPrevPage2.setEnabled(false);
		}
	}
	
	/**
	 * Function used to display the short answer question on page 3 (2/2)
	 */
	private void DisplayShortAnswerQuestion() 
	{
		// only allow screen to display once
		if (!saQuestionDisplayed) 
		{	// disable buttons when the short answer question is displayed
		    btnToTOCPage3.setEnabled(false);
		    btnQuiz3.setEnabled(false);
		    btnPrevPage2.setEnabled(false);
			
			saQuestionDisplayed = true;			// set flag
	        
		    // reset the flag for the short answer question - in the case if the SA question is closed when MC was answered correctly
		    pqPageThreeSA = false;
		
		    // create JFrame & JPanel for the short answer practice question
		    shortAnswerFramePage3 = new JFrame("Chapter 2: Practice Question #3 Short Answer (2/2)");
		    shortAnswerPanelPage3 = new JPanel(null);
		
		    // change background & add border
		    shortAnswerPanelPage3.setBackground(new Color(200, 230, 200));
		    shortAnswerPanelPage3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		    // create text for the question
		    lblQuestionShortAnswerPage3 = new JLabel("Nested if statements allow for more _________ decision-making");
		    lblQuestionShortAnswerPage3.setBounds(50, 50, 400, 30);
		    lblQuestionShortAnswerPage3.setHorizontalAlignment(SwingConstants.CENTER);     // center the text
		    shortAnswerPanelPage3.add(lblQuestionShortAnswerPage3);
		
		    // create JTextField for user input
		    answerTextFieldPage3 = new JTextField();
		    answerTextFieldPage3.setBounds(150, 100, 200, 30);
		    shortAnswerPanelPage3.add(answerTextFieldPage3);
		    
		    // allow the user to use the enter key to answer the question
		    answerTextFieldPage3.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // check the user's answer & provide feedback
		            String userAnswer = answerTextFieldPage3.getText().trim().toLowerCase(); 	// convert to lowercase
		            if (userAnswer.equals("complex")) {
		                JOptionPane.showMessageDialog(null, "Correct!");	 // correct
		                shortAnswerFramePage3.dispose(); 					// close SA practice question
		                pqPageThreeSA = true; 								// set SA flag to true
	
		                // move to the chapter summary slide if both questions were answered correctly
		                if (pqPageThreeMCQ && pqPageThreeSA) {
		                    // move to the chapter summary slide
		                    try {
		                        // close the current frame
		                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
		                        currentFrame.dispose();
		                        // create the chapter summary frame
		                        JFrame summaryFrame = new JFrame("Chapter 2 Summary");
		                        JPanel summaryPanel = new Chapter2Summary();
		                        summaryFrame.getContentPane().add(summaryPanel);
		                        summaryFrame.setSize(800, 800);
		                        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                        summaryFrame.setVisible(true);
		                    } catch (IllegalArgumentException ex) {
		                        // ignore this error, the program works just fine
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Incorrect. Please try again."); // incorrect
		                }
		            }
		        }
		    });
		
		    // create JButton to submit the answer
		    btnSubmitShortAnswerPage3 = new JButton("Submit");
		    btnSubmitShortAnswerPage3.setBounds(200, 150, 100, 30);                           // set bounds for the submit button
		    btnSubmitShortAnswerPage3.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            // check the user's answer & provide feedback
		            String userAnswer = answerTextFieldPage3.getText().trim().toLowerCase();      // convert answer to lowercase - to not make case sensitive
		            if (userAnswer.equals("break")) 
		            {
		                JOptionPane.showMessageDialog(null, "Correct!"); // correct
		                shortAnswerFramePage3.dispose();                   // close SA practice question
		                pqPageThreeSA = true;                              // set SA flag to true
		
		                // move to the chapter summary slide if both questions were answered correctly
		                if (pqPageThreeMCQ && pqPageThreeSA) 
		                {	// move to the chapter summary slide
		                    try 
		                    {
		                        // close the current frame
		                        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Chapter2Textbook.this);
		                        currentFrame.dispose();
		                        // create the chapter summary frame
		                        JFrame summaryFrame = new JFrame("Chapter 2 Summary");
		                        JPanel summaryPanel = new Chapter2Summary();
		                        summaryFrame.getContentPane().add(summaryPanel);
		                        summaryFrame.setSize(800, 800);
		                        summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		                        summaryFrame.setVisible(true);
		                    } catch (IllegalArgumentException ex) {
		                        // ignore this error, the program works just fine
		                    }
		                } else 
		                    JOptionPane.showMessageDialog(null, "Incorrect. Please try again."); // incorrect
		            }
		        }  
		    });
		    shortAnswerPanelPage3.add(btnSubmitShortAnswerPage3);
		        
		    // question number text
		    lblQuestion2Number = new JLabel("(2/2)");
		    lblQuestion2Number.setHorizontalAlignment(SwingConstants.CENTER); 
		    lblQuestion2Number.setBounds(200, 180, 100, 40);
		    shortAnswerPanelPage3.add(lblQuestion2Number);
		    
		    // add a window listener to enable buttons when practice question window is closed
		    shortAnswerFramePage3.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    btnToTOCPage3.setEnabled(true);
                    btnQuiz3.setEnabled(true);
                    btnPrevPage2.setEnabled(true);
                    // reset flag to allow reloading of the SA practice question
                    saQuestionDisplayed = false;
                }
            });
	
		    // set size of the screen & make it visible
		    shortAnswerFramePage3.getContentPane().add(shortAnswerPanelPage3);
		    shortAnswerFramePage3.setSize(500, 255);
		    shortAnswerFramePage3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		    shortAnswerFramePage3.setVisible(true);
		    
		}
	}

    /**
	 * 
	 * Temporary main function to run the chapter 2 textbook directly
	 * 
	 */
    public static void main(String[] args) {
        // Example of usage (main method for testing)
        JFrame frame = new JFrame("Chapter 2: Loops Textbook");
        Chapter2Textbook chapter2Textbook = new Chapter2Textbook();
        frame.getContentPane().add(chapter2Textbook);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
