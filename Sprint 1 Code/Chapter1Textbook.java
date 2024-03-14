package textbook;

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

public class chapter1 extends JPanel 
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

    public chapter1() 
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
        lblTitle.setBounds(50, 50, 200, 70);
        // page number text
        lblPage1Number = new JLabel("Page 1");
        lblPage1Number.setHorizontalAlignment(SwingConstants.CENTER); 
        lblPage1Number.setBounds(280, 725, 200, 40);
        // page 1 subtitle
        lblSubtitlePage1 = new JLabel("1.1 Writing Your First Java Program");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 225, 400, 45);
        // page 1 text
        lblTextPage1 = new JLabel("<html>Package Declaration:"
        		+ "A package in Java is a way to organize related classes and interfaces into a single namespace."
        		+ "The package declaration statement appears at the beginning of a Java source file and specifies the package to which the class or interface belongs."
        		+ "It is optional but recommended for larger projects to prevent naming conflicts."
        		+ "Example:"
        		+ "package com.example.myproject;"
        		+ "Import Statements:"
        		+ "Import statements are used to make classes and interfaces from other packages available in the current source file."
        		+ "They appear after the package declaration (if present) and before the class declaration."
        		+ "Import statements can be specific, importing only the classes or interfaces needed, or can use the wildcard (*) to import all classes and interfaces from a package."
        		+ "Example:"
        		+ "import java.util.Scanner;"
        		+ "\n"
        		+ "Class Declaration:"
        		+ "A class in Java is a blueprint for creating objects."
        		+ "Every Java program must have at least one class, and the class declaration specifies the name of the class and its visibility."
        		+ "The class declaration is followed by the class body enclosed in curly braces."
        		+ "Example:"
        		+ "import java.util.Scanner;"
        		+ "\n"
        		+ "Main Method:"
        		+ "The main method is the entry point of a Java program."
        		+ "It is declared with the signature:"
        		+ "public static void main(String[] args)"
        		+ "The main method must be declared as public, static, and void."
        		+ "It accepts a single parameter, an array of strings (args), which can be used to pass command-line arguments to the program."
        		+ "The main method contains the code that will be executed when the program is run"
        		+ "Example:"
        		+ "public static void main(String[] args) {"
        		+ "// Code to be executed goes here"
        		+ "}"
        		+ "\n"
        		+ "Writing a Simple \\\"Hello, World!\\\" Program:"
        		+ "A \\\"Hello, World!\\\" program is often the first program written by beginners in any programming language. It simply outputs the phrase \\\"Hello, World!\\\" to the console."
        		+ "package com.example.helloworld;"
        		+ "\n"
        		+ "public class HelloWorld {"
        		+ "    public static void main(String[] args) {"
        		+ "	        System.out.println(\\\"Hello, World!\\\");"
        		+ "    }"
        		+ "}"
        		+ "The package declaration (package com.example.helloworld;) specifies the package to which the class belongs."
        		+ "The class declaration (public class HelloWorld {) defines the class named HelloWorld."
        		+ "The main method (public static void main(String[] args) {) is the entry point of the program."
        		+ "Inside the main method, the statement System.out.println(\\\"Hello, World!\\\"); prints \\\"Hello, World!\\\" to the console."
        		+ "\n"
        		+ "Compiling Java Code using the javac Compiler:"
        		+ "Once the Java program is written in a text file with a .java extension (e.g., HelloWorld.java), it needs to be compiled into bytecode using the Java compiler (javac)."
        		+ "Open a command prompt or terminal and navigate to the directory containing the Java file."
        		+ "Use the javac command followed by the name of the Java file to compile it."
        		+ "Example:"
        		+ "javac HelloWorld.java"
        		+ "If the compilation is successful, it will generate a bytecode file named HelloWorld.class, which contains the compiled code.<html>");
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
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                cardLayout.show(chapter1.this, "secondPage");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
        lblSubtitlePage1 = new JLabel("1.2 Java Syntax and Structure");
        lblSubtitlePage1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage1.setBounds(50, 225, 400, 45);
        // page 2 text
        lblTextPage2 = new JLabel("<html>Identifiers and Keywords in Java:"
        		+ "Identifiers: In Java, identifiers are names given to variables, methods, classes, packages, and interfaces. They consist of letters, digits, underscores (_), and dollar signs ($), and must begin with a letter, underscore, or dollar sign. Identifiers are case-sensitive."
        		+ "\n"
        		+ "Examples: myVariable, calculateArea, MyClass, myPackage, MyInterface"
        		+ "Keywords: Keywords are reserved words in Java that have predefined meanings and cannot be used as identifiers. They are part of the language syntax and have specific purposes."
        		+ "\n"
        		+ "Examples of Java keywords: public, class, static, void, if, else, for, while, return, new, true, false, null, etc."
        		+ "Rules for Naming Classes, Variables, and Methods:"
        		+ "\n"
        		+ "Classes: Class names should start with an uppercase letter and follow camel case convention (e.g., MyClass, BankAccount, EmployeeDetails)."
        		+ "\n"
        		+ "Variables and Methods: Variable and method names should start with a lowercase letter and follow camel case convention. They should be descriptive and meaningful to enhance code readability."
        		+ "\n"
        		+ "Constants: Constants are variables whose values cannot be changed once assigned. They are conventionally written in uppercase letters with underscores separating words (e.g., MAX_VALUE, PI, DEFAULT_SIZE)."
        		+ "\n"
        		+ "Comments in Java:"
        		+ "\n"
        		+ "Single-line Comments (//): Single-line comments start with two forward slashes (//) and continue until the end of the line. They are used for short comments or explanations within the code."
        		+ "\n"
        		+ "// This is a single-line comment"
        		+ "int x = 5; // Assigning value 5 to variable x"
        		+ "Multi-line Comments (/ /): Multi-line comments begin with /* and end with */. They can span multiple lines and are used for longer explanations or comments."
        		+ "\n"
        		+ "/*\n"
        		+ " * This is a multi-line comment."
        		+ " * It can span multiple lines and is used"
        		+ " * for longer explanations or comments."
        		+ " *\n"
        		+ "Basic Syntax for Statements, Expressions, and Blocks of Code:"
        		+ "\n"
        		+ "Statements: In Java, a statement is a complete unit of execution that ends with a semicolon (;). Examples of statements include variable declarations, assignment statements, method calls, and control flow statements (if, for, while, etc.)."
        		+ "\n"
        		+ "int x = 5; // Variable declaration and assignment statement"
        		+ "System.out.println(\"Hello, World!\"); // Method call statement"
        		+ "Expressions: An expression is a combination of variables, operators, and method invocations that evaluates to a single value. Expressions can be used within statements and other expressions."
        		+ "\n"
        		+ "int result = 2 * (3 + 5); // Example of an expression"
        		+ "Blocks of Code: A block of code is enclosed within curly braces ({}) and consists of one or more statements. Blocks of code are used to group statements together, typically within control flow statements or method bodies."
        		+ "\n"
        		+ "if (x > 0) { // Start of a block"
        		+ "    System.out.println(\"x is positive\");"
        		+ "    // Additional statements"
        		+ "} // End of the block"
        		+ "Understanding these fundamental aspects of Java syntax and structure is crucial for writing clear, readable, and maintainable code. By adhering to naming conventions, using comments effectively, and understanding the basic syntax, developers can create Java programs that are easier to understand and maintain."
        		+ "\n"
        		+ "User"
        		+ "go into detail about this:"
        		+ "1.4 Understanding Data Types in Java"
        		+ "\n"
        		+ "Primitive data types: byte, short, int, long, float, double, char, boolean"
        		+ "Reference data types: arrays, objects, Strings"
        		+ "Declaring variables and initializing values"
        		+ "Type casting and type conversion</html>");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                     JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                cardLayout.show(chapter1.this, "mainCard");
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
                cardLayout.show(chapter1.this, "thirdPage");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
        lblSubtitlePage3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblSubtitlePage3.setBounds(50, 225, 400, 45);
        // page 2 text
        lblTextPage3 = new JLabel("<html>Primitive Data Types:"
        		+ "byte: Represents an 8-bit signed integer. Range: -128 to 127."
        		+ "short: Represents a 16-bit signed integer. Range: -32,768 to 32,767."
        		+ "int: Represents a 32-bit signed integer. Range: -2^31 to 2^31 - 1."
        		+ "long: Represents a 64-bit signed integer. Range: -2^63 to 2^63 - 1."
        		+ "float: Represents a 32-bit floating-point number. Range: ±3.40282347E+38F."
        		+ "double: Represents a 64-bit floating-point number. Range: ±1.79769313486231570E+308."
        		+ "char: Represents a single 16-bit Unicode character. Range: '\\u0000' to '\\uffff'."
        		+ "boolean: Represents a boolean value, which can be either true or false."
        		+ "Reference Data Types:"
        		+ "\n"
        		+ "Arrays: Arrays are collections of elements of the same type, accessed by an index. They can be of primitive types or reference types."
        		+ "\n"
        		+ "int[] numbers = new int[5]; // Declaring and initializing an array of integers"
        		+ "Objects: Objects are instances of classes and represent real-world entities. They have attributes (fields) and behaviors (methods)."
        		+ "\n"
        		+ "Person person = new Person(\"John\", 25); // Creating an instance of the Person class"
        		+ "Strings: Strings are sequences of characters enclosed in double quotes. In Java, strings are immutable objects."
        		+ "\n"
        		+ "String message = \"Hello, World!\"; // Declaring and initializing a string"
        		+ "Declaring Variables and Initializing Values:"
        		+ "\n"
        		+ "Variable Declaration: To declare a variable in Java, you specify the variable's data type followed by its name."
        		+ "\n"
        		+ "int age; // Variable declaration"
        		+ "Initializing Variables: Variables can be initialized at the time of declaration or later in the code."
        		+ "\n"
        		+ "int age = 30; // Initializing a variable at the time of declaration"
        		+ "Type Casting and Type Conversion:"
        		+ "\n"
        		+ "Type Casting: Type casting is the process of converting a value from one data type to another. Implicit casting (widening) is done automatically by the compiler when no data is lost, while explicit casting (narrowing) requires explicit syntax."
        		+ "\n"
        		+ "double x = 5; // Implicit casting from int to double"
        		+ "int y = (int) 5.7; // Explicit casting from double to int"
        		+ "Type Conversion: Type conversion is the process of converting a value from one data type to another. Java automatically performs widening conversions when necessary, but narrowing conversions may result in loss of data and require explicit casting."
        		+ "\n"
        		+ "int a = 10;"
        		+ "double b = a; // Widening conversion (implicit"
        		+ "Understanding data types in Java is fundamental for writing efficient and error-free code. By selecting appropriate data types, developers can optimize memory usage and ensure accurate representation of data. Additionally, mastering type casting and conversion enables manipulation and transformation of data as required by different operations and algorithms."
        		+ "\n"
        		+ "User</html>");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
                cardLayout.show(chapter1.this, "secondPage");
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
                    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(chapter1.this);
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
        JFrame frame = new JFrame("Chapter 1: Java Basics Textbook");
        chapter1 chapter1 = new chapter1();
		frame.getContentPane().add(chapter1);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
