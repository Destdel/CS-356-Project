package textbooks;

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

public class Chapter3Textbook extends JPanel 
{
    private CardLayout cardLayout;

    // screen information
    private JLabel lblTitle; // chapter title
    // buttons
    private JButton btnToTOC; 		// button to go back to the table of contents
    private JButton btnQuiz; 		// button to proceed to the chapter quiz
    private JButton btnSummary; 	// button to proceed to the summary screen
    private JButton btnNextPage; 	// button to go to the next page of the textbook (if there is one)
    private JButton	btnPrevPage;	// button to go to the previous page of the textbook (if there is one)

    public Chapter3Textbook() 
    {
        // declare variables basic screen variables
    	Color lightBlue = new Color(173, 216, 230);		// color for the buttons
    	
        setLayout(new CardLayout());					// card layout to change pages
        cardLayout = (CardLayout) getLayout();			

        // create the main content panel (1st page)
        JPanel mainContentPanel = new JPanel(null);
        // change background & add border
        mainContentPanel.setBackground(new Color(200, 230, 200));
        mainContentPanel. setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
        // print screen information
        // title text
        lblTitle = new JLabel("Loops");
        lblTitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 60));
        lblTitle.setBounds(50, 50, 200, 70);
        // button to go to TOC
        btnToTOC = new JButton("Table of Contents");
        btnToTOC.setBounds(500, 50, 200, 70);
        btnToTOC.setBackground(lightBlue);
        // button to go to chp quiz slide
        btnQuiz = new JButton("Loops Chapter Quiz");
        btnQuiz.setBounds(40, 650, 200, 60);
        btnQuiz.setBackground(lightBlue);
        // button to go to next page
        btnNextPage = new JButton("Next Page");
        btnNextPage.setBounds(290, 650, 200, 60);
        btnNextPage.setBackground(lightBlue);
        // button to go to chp summary slide
        btnSummary = new JButton("Loops Chapter Summary");
        btnSummary.setBounds(540, 650, 200, 60);
        btnSummary.setBackground(lightBlue);
        // changes screen based on button click
        btnNextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the blank screen when "Next Page" is clicked
                cardLayout.show(Chapter3Textbook.this, "blankCard");
            }
        });

        // print contents to screen
        mainContentPanel.add(lblTitle);
        mainContentPanel.add(btnToTOC);
        mainContentPanel.add(btnQuiz);
        mainContentPanel.add(btnNextPage);
        mainContentPanel.add(btnSummary);
        add(mainContentPanel, "mainCard");

        // create next page of the textbook if it clicked
        JPanel blankScreenPanel = new JPanel();
        JLabel blankLabel = new JLabel("Blank Screen");
        blankScreenPanel.add(blankLabel);

        // print next page contents
        add(blankScreenPanel, "blankCard");

        // show page 1 one as the "maincard" (default)
        cardLayout.show(this, "mainCard");
    }

    // MARK:: remove once complete for linking purposes
    public static void main(String[] args) {
        // Example of usage (main method for testing)
        JFrame frame = new JFrame("Chapter 3: Loops Textbook");
        Chapter3Textbook chapter3Textbook = new Chapter3Textbook();
        frame.getContentPane().add(chapter3Textbook);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}