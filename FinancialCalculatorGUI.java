package Calculator;

import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class FinancialCalculatorGUI{


    private static String labelPrefix = "Enter your known values into the apposite fields, and then ";
    private int numClicks = 0;
    final JLabel label = new JLabel(labelPrefix);
	JLabel label3 = new JLabel(" ");

	public JTextField pvField;
	public JTextField fvField;
	public JTextField pmtField;
	public JTextField nField;
	public JTextField iField;

    //Specify the look and feel to use.  Valid values:
    //null (use the default), "Metal", "System", "Motif", "GTK+"
    final static String LOOKANDFEEL = null;

    public Component createComponents() {

	pvField = new JTextField(2);
	fvField = new JTextField(2);
	pmtField = new JTextField(2);
	nField = new JTextField(2);
	iField = new JTextField(2);        


	//button1 and its actions
	JButton button1 = new JButton("Present Value (PV)");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                financialcalculator Calculation = new financialcalculator();
                    double fv = Double.parseDouble(fvField.getText());
                    double pmt = Double.parseDouble(pmtField.getText());
                    int n = (int) Double.parseDouble(nField.getText());
                    double i = Double.parseDouble(iField.getText());
                double Answer = Calculation.getPV(n, i, fv, pmt);
                label3.setText("The answer is: " + Answer);
                        }});


        JButton button2 = new JButton("Future Value (FV)");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                financialcalculator Calculation = new financialcalculator();
                    double PV = Double.parseDouble(pvField.getText());
                    double pmt = Double.parseDouble(pmtField.getText());
                    int n = (int) Double.parseDouble(nField.getText());
                    double i = Double.parseDouble(iField.getText());
                double Answer = Calculation.getFV(n, i, PV, pmt);
                label3.setText("The answer is: " + Answer);
                        }});


	JButton button3 = new JButton("Payment (pmt)");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                financialcalculator Calculation = new financialcalculator();
                    double PV = Double.parseDouble(pvField.getText());
                    double FV = Double.parseDouble(fvField.getText());
                    int n = (int) Double.parseDouble(nField.getText());
                    double i = Double.parseDouble(iField.getText());
                double Answer = Calculation.getpmt(n, i, PV, FV);
                label3.setText("The answer is: " + Answer);
                        }});

	JButton button4 = new JButton("Number of Periods (n)");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	financialcalculator Calculation = new financialcalculator();
        double PV = Double.parseDouble(pvField.getText());
        double FV = Double.parseDouble(fvField.getText());
        double pmt = Double.parseDouble(pmtField.getText());
        double i = Double.parseDouble(iField.getText());
	int Answer = Calculation.getn( i, PV, FV, pmt);
	label3.setText("The answer is: " + Answer);
            }});

	JButton button5 = new JButton("Interest Rate (i)");
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	financialcalculator Calculation = new financialcalculator();
        double PV = Double.parseDouble(pvField.getText());
        double FV = Double.parseDouble(fvField.getText());
        double pmt = Double.parseDouble(pmtField.getText());
        int n = (int) Double.parseDouble(nField.getText());
	double Answer = Calculation.geti( n, PV, FV, pmt);
	label3.setText("The answer is: " + Answer);
            }});


	JLabel nothing = new JLabel("select the value you wish to calculate. ");

        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */

        JPanel pane = new JPanel(new GridLayout(7, 2));

        pane.add(label);
        pane.add(nothing);

            pane.add(button1);
        pane.add(pvField);
        
        pane.add(button2);
        pane.add(fvField);
        
        pane.add(button3);
        pane.add(pmtField);
        
        pane.add(button4);
        pane.add(nField);
        
        pane.add(button5);
        pane.add(iField);

        pane.add(label3);

        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );

        return pane;
    }
/*
    public void actionPerformed(ActionEvent e) {

	financialcalculator Calculation = new financialcalculator();
	
	
        double FV = Double.parseDouble(FVfield2.getText());
        double pmt = Double.parseDouble(pmtfield3.getText());
        int n = (int) Double.parseDouble(nfield4.getText());
        double i = Double.parseDouble(ifield5.getText());
	
	double Answer = Calculation.getPV(n, i, FV, pmt);
	
	label3.setText("The answer is: " + Answer);
    }
*/
    private static void initLookAndFeel() {
        String lookAndFeel = null;

        if (LOOKANDFEEL != null) {
            if (LOOKANDFEEL.equals("Metal")) {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                                   + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Set the look and feel.
        initLookAndFeel();

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Financial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FinancialCalculatorGUI app = new FinancialCalculatorGUI();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

