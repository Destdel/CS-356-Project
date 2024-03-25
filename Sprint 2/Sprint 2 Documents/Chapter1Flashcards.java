package flashcards;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Chapter1Flashcards extends JPanel 
{
	public Chapter1Flashcards() 
	{
		setBorder(BorderFactory.createLineBorder(Color.black, 5));		// set border
		setBackground(new Color(200, 230, 200)); 						// set background color
		
		/*
        JFrame frame = new JFrame("Chapter 3: Summary");
        Chapter3Textbook chapter3Textbook = new Chapter3Textbook();
        frame.getContentPane().add(chapter3Textbook);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        */
	
	}
	
	// MARK:: remove once complete for linking purposes
    public static void main(String[] args) 
    {
    	
    }
 
}
