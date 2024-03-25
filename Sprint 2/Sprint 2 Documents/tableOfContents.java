package application;

// import packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Border;
import summaries.Chapter3Summary;
import textbooks.Chapter1Textbook;
import textbooks.Chapter2Textbook;
import textbooks.Chapter3Textbook;
import textbooks.Chapter4Textbook;
import textbooks.Chapter5Textbook;

// MARK:: hyperlink buttons as we go along


/**
 * Table of Contents w/ Hyperlinks
 * 
 * 
 * @author Max Flannick
 *
 */
public class tableOfContents extends JFrame 
{
	// define stages
	private JPanel executePanel;
	private JFrame chapter1Textbook, chapter2Textbook, chapter3Textbook, chapter4Textbook, chapter5Textbook;	// textbook screens
	private JFrame chapter1Summary, chapter2Summary, chapter3Summary, chapter4Summary, chapter5Summary;			// summary screens
	// table of contents header
	private JLabel lblToc;						// table of contents
	// chapter 1 information
	private JLabel lblChapter1Title;			// chapter 1 header
	private JButton btnChapter1Textbook;		// chapter 1 textbook section (Hyperlink)
	private JButton btnChapter1Summary;			// chapter 1 summary section (Hyperlink)
	private JButton btnChapter1Quiz;			// chapter 1 quiz section (Hyperlink)
	private JButton btnChapter1Flashcards;		// chapter 1 flashcards section (Hyperlink)
	// chapter 2 information
	private JLabel  lblChapter2Title;			// chapter 2 header
	private JButton btnChapter2Textbook;		// chapter 2 textbook section (Hyperlink)
	private JButton btnChapter2Summary;			// chapter 2 summary section (Hyperlink)
	private JButton btnChapter2Quiz;			// chapter 2 quiz section (Hyperlink)
	private JButton btnChapter2Flashcards;		// chapter 2 flashcards section (Hyperlink)
	private JButton btnChapter2MatchingMini;	// chapter 2 matching minigame (HyperLink)
	// chapter 3 information
	private JLabel 	lblChapter3Title;			// chapter 3 header
	private JButton btnChapter3Textbook;		// chapter 3 textbook section (Hyperlink)
	private JButton btnChapter3Summary;			// chapter 3 summary section (Hyperlink)
	private JButton btnChapter3CodingSnip;		// chapter 3 coding snippets section (Hyperlink)
	private JButton btnChapter3Quiz;			// chapter 3 quiz section (Hyperlink)
	private JButton btnChapter3Flashcards;		// chapter 3 flashcards section (Hyperlink)
	private JButton btnChapter3MatchingMini;	// chapter 3 matching minigame (HyperLink)
	// chapter 4 information
	private JLabel 	lblChapter4Title;			// chapter 4 header
	private JButton btnChapter4Textbook;		// chapter 4 textbook section (Hyperlink)
	private JButton btnChapter4Summary;			// chapter 4 summary section (Hyperlink)
	private JButton btnChapter4CodingSnip;		// chapter 4 coding snippets section (Hyperlink)
	private JButton btnChapter4Quiz;			// chapter 4 quiz section (Hyperlink)
	private JButton btnChapter4Flashcards;		// chapter 4 flashcards section (Hyperlink)
	private JButton btnChapter4CodingMini;		// chapter 4 matching minigame (HyperLink)
	// chapter 5 information
	private JLabel 	lblChapter5Title;			// chapter 5 header
	private JButton btnChapter5Textbook;		// chapter 5 textbook section (Hyperlink)
	private JButton btnChapter5Summary;			// chapter 5 summary section (Hyperlink)
	private JButton btnChapter5CodingSnip;		// chapter 5 coding snippets section (Hyperlink)
	private JButton btnChapter5Quiz;			// chapter 5 quiz section (Hyperlink)
	private JButton btnChapter5Flashcards;		// chapter 5 flashcards section (Hyperlink)
	// image information
	private JLabel lblChapter1Image;			// chapter 1 image (label)
	private ImageIcon imgChapter1Image;			// chapter 1 image
	private JLabel lblChapter2Image;			// chapter 2 image (label)
	private ImageIcon imgChapter2Image;			// chapter 2 image
	private JLabel lblChapter2Image2;			// chapter 2 image (2nd) (label)
	private ImageIcon imgChapter2Image2;		// chapter 2 image (2nd)
	private JLabel lblChapter3Image;			// chapter 3 image (label)
	private ImageIcon imgChapter3Image;			// chapter 3 image
	private JLabel lblChapter4Image;			// chapter 5 image (label)
	private ImageIcon imgChapter4Image;			// chapter 4 image
	private JLabel lblChapter5Image;			// chapter 5 image (label)
	private ImageIcon imgChapter5Image;			// chapter 5 image
	// visible buttons
	private JButton btnToChapter1Textbook;		// chapter 1 textbook section (Visible Button)
	private	JButton	btnHelp;					// help button
	
	/**
	 * 
	 * tableOfContents() - Constructor
	 * 
	 * Used to create the table of contents and link every section within it.
	 * 
	 **/
	public tableOfContents()
	{
		// declare & initialize variables
		Image originalImage, resizedImage; 				// temporary image variables for resizing
		Color lightBlue = new Color(173, 216, 230); 	// color for buttons
		// declare JFrames to hold screen contents
		//JFrame chapter2Textbook, chapter3Textbook, chapter4Textbook, chapter5Textbook;
		
		// get content pane and setting the layout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

		// set the execute panel
		executePanel = new JPanel();
		setTitle("Learning Java Application");
		executePanel.setLayout(null);
		executePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5));		// set border
		executePanel.setBackground(new Color(200, 230, 200)); 						// set background color
		
		// put table of contents title
        lblToc = new JLabel("<html><u>Table of Contents</u></html>");
        lblToc.setFont(new Font("Comic Sans MS", Font.BOLD, 30)); 					// change font
        lblToc.setHorizontalAlignment(SwingConstants.CENTER); 						// center the text
        lblToc.setBounds(0, 10, 800, 40);
        
        // contents for each chapter
        // CHP:: chapter 1
        lblChapter1Title = new JLabel("Chapter 1: The Basics");
        lblChapter1Title.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 		// change font
        lblChapter1Title.setBounds(50, 50, 800, 16);
        // buttons
        btnChapter1Textbook = createTransparentButton("Textbook", 65, 68, 150, 22);
        btnChapter1Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 3 textbook
                chapter1Textbook = new JFrame("Chapter 1: The Basics Textbook");
                // add the Chapter1Textbook panel to the JFrame
                chapter1Textbook.add(new Chapter1Textbook());
                // set frame size and make it visible
                chapter1Textbook.setSize(800, 800);
                chapter1Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter1Textbook.setVisible(true);
            }
        });
        // MARK: action listeners for each as we go along
        btnChapter1Summary = createTransparentButton("Summary", 65, 90, 150, 22);
        btnChapter1Quiz = createTransparentButton("Quiz", 65, 112, 130, 22);
        btnChapter1Flashcards = createTransparentButton("Flashcards", 65, 134, 150, 22);
        
        // CHP:: chapter 2
        lblChapter2Title = new JLabel("Chapter 2: If-Else Statements");
        lblChapter2Title.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 		// change font
        lblChapter2Title.setBounds(50, 165, 800, 15);
        // buttons
        btnChapter2Textbook = createTransparentButton("Textbook", 65, 183, 150, 22);
        btnChapter2Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 2 textbook
                chapter2Textbook = new JFrame("Chapter 2: If-Else Statements Textbook");
                // add the Chapter2Textbook panel to the JFrame
                chapter2Textbook.add(new Chapter2Textbook());
                // set frame size and make it visible
                chapter2Textbook.setSize(800, 800);
                chapter2Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter2Textbook.setVisible(true);
            }
        });
        btnChapter2Summary = createTransparentButton("Summary", 65, 205, 150, 22);
        btnChapter2Quiz = createTransparentButton("Quiz", 65, 227, 130, 22);
        btnChapter2Flashcards = createTransparentButton("Flashcards", 65, 249, 150, 22);
        btnChapter2MatchingMini = createTransparentButton("Matching Minigame", 65, 271, 200, 22);
        
        // CHP:: chapter 3
        lblChapter3Title = new JLabel("Chapter 3: Loops");
        lblChapter3Title.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 		// change font
        lblChapter3Title.setBounds(50, 302, 800, 15);
        // buttons
        btnChapter3Textbook = createTransparentButton("Textbook", 65, 320, 150, 22);
        btnChapter3Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 3 textbook
                chapter3Textbook = new JFrame("Chapter 3: Loops Textbook");
                // add the Chapter3Textbook panel to the JFrame
                chapter3Textbook.add(new Chapter3Textbook());
                // set frame size and make it visible
                chapter3Textbook.setSize(800, 800);	
                chapter3Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter3Textbook.setVisible(true);
            }
        });
        
        btnChapter3Summary = createTransparentButton("Summary", 65, 342, 150, 22);
        btnChapter3Summary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 2 textbook
                chapter3Summary = new JFrame("Chapter 3: Loops Summary");
                // add the Chapter2Textbook panel to the JFrame
                chapter3Summary.add(new Chapter3Summary());
                // set frame size and make it visible
                chapter3Summary.setSize(800, 800);
                chapter3Summary.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter3Summary.setVisible(true);
            }
        });
        
        btnChapter3CodingSnip = createTransparentButton("Coding Snippets", 65, 364, 150, 22);
        btnChapter3Quiz = createTransparentButton("Quiz", 65, 386, 130, 22);
        btnChapter3Flashcards = createTransparentButton("Flashcards", 65, 408, 150, 22);
        btnChapter3MatchingMini = createTransparentButton("Matching Minigame", 65, 430, 200, 22);
        
        // CHP:: chapter 4
        lblChapter4Title = new JLabel("Chapter 4: Functions"); 
        lblChapter4Title.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 		// change font
        lblChapter4Title.setBounds(50, 461, 800, 15);
        // buttons
        btnChapter4Textbook = createTransparentButton("Textbook", 65, 479, 150, 22);
        btnChapter4Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 4 textbook
                chapter4Textbook = new JFrame("Chapter 4: Functions Textbook");
                // add the Chapter4Textbook panel to the JFrame
                chapter4Textbook.add(new Chapter4Textbook());
                // set frame size and make it visible
                chapter4Textbook.setSize(800, 800);
                chapter4Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter4Textbook.setVisible(true);
            }
        });
        btnChapter4Summary = createTransparentButton("Summary", 65, 501, 150, 22);
        btnChapter4CodingSnip = createTransparentButton("Coding Snippets", 65, 523, 150, 22);
        btnChapter4Quiz = createTransparentButton("Quiz", 65, 545, 130, 22);
        btnChapter4Flashcards = createTransparentButton("Flashcards", 65, 567, 150, 22);
        btnChapter4CodingMini = createTransparentButton("Coding Minigame", 65, 589, 200, 22);
        
        // CHP:: chapter 5
        lblChapter5Title = new JLabel("Chapter 5: Classes");
        lblChapter5Title.setFont(new Font("Comic Sans MS", Font.BOLD, 16)); 		// change font
        lblChapter5Title.setBounds(50, 620, 800, 15);
        // buttons
        btnChapter5Textbook = createTransparentButton("Textbook", 65, 642, 150, 22);
        btnChapter5Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 5 textbook
                chapter5Textbook = new JFrame("Chapter 1: Classes Textbook");
                // add the Chapter5Textbook panel to the JFrame
                chapter5Textbook.add(new Chapter5Textbook());
                // set frame size and make it visible
                chapter5Textbook.setSize(800, 800);
                chapter5Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter5Textbook.setVisible(true);
            }
        });
        btnChapter5Summary = createTransparentButton("Summary", 65, 664, 150, 22);
        btnChapter5CodingSnip = createTransparentButton("Coding Snippets", 65, 686, 150, 22);
        btnChapter5Quiz = createTransparentButton("Quiz", 65, 708, 130, 22);
        btnChapter5Flashcards = createTransparentButton("Flashcards", 65, 730, 150, 22);
        
        // IMAGES
        // chapter 1
        imgChapter1Image = new ImageIcon("C:\\Max\\cs356\\java-4-logo-png-transparent.png");
        // use temp variables to resize the image
        originalImage = imgChapter1Image.getImage();
        resizedImage = originalImage.getScaledInstance(75, 135, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter1Image.setImage(resizedImage);
        lblChapter1Image = new JLabel(imgChapter1Image);
        lblChapter1Image.setBounds(450, 50, 85, 150); 
        
        // chapter 2
        // image #1
        imgChapter2Image = new ImageIcon("C:\\Max\\cs356\\if-3-logo.png");
        // use temp variables to resize the image
        originalImage = imgChapter2Image.getImage();
        resizedImage = originalImage.getScaledInstance(110, 90, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter2Image.setImage(resizedImage);
        lblChapter2Image = new JLabel(imgChapter2Image);
        lblChapter2Image.setBounds(350, 175, 110, 90); 
        // image #2
        imgChapter2Image2 = new ImageIcon("C:\\Max\\cs356\\8ea5234ce9c0b1121c5092df0f1beb45.png");
        // use temp variables to resize the image
        originalImage = imgChapter2Image2.getImage();
        resizedImage = originalImage.getScaledInstance(110, 90, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter2Image2.setImage(resizedImage);
        lblChapter2Image2 = new JLabel(imgChapter2Image2);
        lblChapter2Image2.setBounds(450, 225, 110, 90); 
        
        // chapter 3
        imgChapter3Image = new ImageIcon("C:\\Max\\cs356\\loop-icon-2048x2048-puej29yn.png");
        // use temp variables to resize the image
        originalImage = imgChapter3Image.getImage();
        resizedImage = originalImage.getScaledInstance(150, 110, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter3Image.setImage(resizedImage);
        lblChapter3Image = new JLabel(imgChapter3Image);
        lblChapter3Image.setBounds(400, 350, 150, 110); 
        
        // chapter 4
        imgChapter4Image = new ImageIcon("C:\\Max\\cs356\\Function-PNG-Picture.png");
        // use temp variables to resize the image
        originalImage = imgChapter4Image.getImage();
        resizedImage = originalImage.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter4Image.setImage(resizedImage);
        lblChapter4Image = new JLabel(imgChapter4Image);
        lblChapter4Image.setBounds(400, 475, 150, 130); 
        
        // chapter 5
        imgChapter5Image = new ImageIcon("C:\\Max\\cs356\\5022991.png");
        // use temp variables to resize the image
        originalImage = imgChapter5Image.getImage();
        resizedImage = originalImage.getScaledInstance(150, 130, Image.SCALE_SMOOTH);
        // get ready to display image
        imgChapter5Image.setImage(resizedImage);
        lblChapter5Image = new JLabel(imgChapter5Image);
        lblChapter5Image.setBounds(400, 625, 150, 130); 
        
        // button in bottom right to go to chapter 1 textbook
        btnToChapter1Textbook = new JButton("Chapter 1 Textbook");
        btnToChapter1Textbook.setBounds(575, 690, 200, 50);
        btnToChapter1Textbook.setBackground(lightBlue);			// set background color
        btnToChapter1Textbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// close the current table of contents frame
                dispose();
            	// create a new JFrame for chapter 3 textbook
                chapter1Textbook = new JFrame("Chapter 1: The Basics Textbook");
                // add the Chapter1Textbook panel to the JFrame
                chapter1Textbook.add(new Chapter1Textbook());
                // set frame size and make it visible
                chapter1Textbook.setSize(800, 800);
                chapter1Textbook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                chapter1Textbook.setVisible(true);
            }
        });
        
        // help button
        btnHelp = new JButton("?");
        btnHelp.setBounds(725, 10, 50, 50); 	// set bounds
        btnHelp.setBackground(lightBlue);		// change color
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display the help window
                JOptionPane.showMessageDialog(null, "Welcome to the Java Learning Application!\n\n"
                        + "This is the table of contents section of the application.\n\n"
                        + "You are freely able to access any section within the application. However, it is important to note that all sections build off their respective textbooks.\n\n"
                        + "If you wish to move chronologically then you can click the button in the top right to move to the first textbook section.\n\n"
                        + "Each section will allow you to return to this screen as well.", "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // print table of contents title
        executePanel.add(lblToc);
        // print chapter 1 contents
        executePanel.add(lblChapter1Title);				// title
        executePanel.add(btnChapter1Textbook);			// chp1 textbook
        executePanel.add(btnChapter1Summary);			// chp1 summary
        executePanel.add(btnChapter1Quiz);				// chp1 quiz
        executePanel.add(btnChapter1Flashcards);		// chp1 flashcards
        // print chapter 2 contents
        executePanel.add(lblChapter2Title);				// title
        executePanel.add(btnChapter2Textbook);			// chp2 textbook
        executePanel.add(btnChapter2Summary);			// chp2 summary
        executePanel.add(btnChapter2Quiz);				// chp2 quiz
        executePanel.add(btnChapter2Flashcards);		// chp2 flashcards
        executePanel.add(btnChapter2MatchingMini);		// chp2 matching minigame
        // print chapter 3 contents
        executePanel.add(lblChapter3Title);				// title
        executePanel.add(btnChapter3Textbook);			// chp3 textbook
        executePanel.add(btnChapter3Summary);			// chp3 summary
        executePanel.add(btnChapter3CodingSnip);		// chp3 coding snippets
        executePanel.add(btnChapter3Quiz);				// chp3 quiz
        executePanel.add(btnChapter3Flashcards);		// chp3 flashcards
        executePanel.add(btnChapter3MatchingMini);		// chp3 matching minigame
        // print chapter 4 contents
        executePanel.add(lblChapter4Title);				// title
        executePanel.add(btnChapter4Textbook);			// chp4 textbook
        executePanel.add(btnChapter4Summary);			// chp4 summary
        executePanel.add(btnChapter4CodingSnip);		// chp4 coding snippets
        executePanel.add(btnChapter4Quiz);				// chp4 quiz
        executePanel.add(btnChapter4Flashcards);		// chp4 flashcards
        executePanel.add(btnChapter4CodingMini);		// chp4 matching minigame
        // print chapter 5 contents
        executePanel.add(lblChapter5Title);				// title
        executePanel.add(btnChapter5Textbook);			// chp5 textbook
        executePanel.add(btnChapter5Summary);			// chp5 summary
        executePanel.add(btnChapter5CodingSnip);		// chp5 coding snippets
        executePanel.add(btnChapter5Quiz);				// chp5 quiz
        executePanel.add(btnChapter5Flashcards);		// chp5 flashcards
        // print images
        executePanel.add(lblChapter1Image);				// chp1 image
        executePanel.add(lblChapter2Image);				// chp2 image
        executePanel.add(lblChapter2Image2);			// chp2 image (2nd)
        executePanel.add(lblChapter3Image);				// chp3 image
        executePanel.add(lblChapter4Image);				// chp4 image
        executePanel.add(lblChapter5Image);				// chp5 image
        // button in bottom right to go to chapter 1 textbook
        executePanel.add(btnToChapter1Textbook);
        // help button
        executePanel.add(btnHelp);
        
		// add executePanel to the container
        container.add(executePanel, BorderLayout.CENTER);

        // set frame size and make it visible
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	/**
	 *  Creates a transparent button that will be 
	 *  hyperlinked to its corresponding section.
	 * 
	 * @param text The text that will be on the button
	 * @param x Location horizontally on the screen
	 * @param y Location vertically on the screen
	 * @param width Width of the button
	 * @param height Height of the button
	 * @return button The updated button
	 */
	 private JButton createTransparentButton(String text, int x, int y, int width, int height) 
	 {		
		 	// declare a temporary button
		 	JButton button = new JButton(text);
		 	
		 	// make button transparent
	        button.setOpaque(false);
	        button.setContentAreaFilled(false);
	        button.setBorderPainted(false);
	        button.setForeground(Color.BLUE); 
	        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        
	        // left align all text
	        button.setHorizontalAlignment(SwingConstants.LEFT);
	        // set font size
	        Font smallerFont = new Font("Comic Sans MS", Font.BOLD, 13); 
	        button.setFont(smallerFont);
	        // set size
	        button.setBounds(x, y, width, height);
	        
	        // returns the new button
	        return button;
	 }
	 
		/**
		 * 
		 * Main function used to display the table of contents
		 * 
		 */
		public static void main(String[] args)
		{
			tableOfContents dbgui = new tableOfContents();
			dbgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		/**
		 * Connection function needed to connect w/ SQL developer
		 * 
		 * @return connection - connection to the developer (includes proper url, user, & password)
		 * @throws SQLException - exception needed for connection to developer
		 * @throws ClassNotFoundException - exception needed for connection to developer
		 */
		private Connection connect() throws SQLException, ClassNotFoundException 
		{
			// variables needed for connecting/logging on to the database
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "mflannick";
			String password = "mflannick";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// connect to database
			Connection connection = DriverManager.getConnection(url, user, password);
			// return connection
			return connection;

		}
	
}
