 package edu.csulb.cecs274;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 
public class GUIDemo {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	
	public GUIDemo()
	{
		// we reuse these code
		prepareGUI();
	}
	
	// we use the sample pattern of code
	public static void main(String[] args) 
	{
	 GUIDemo GUIdemo = new GUIDemo();
	 GUIdemo.showGUIDemo();
	
	}
	
	private void prepareGUI()
	{
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		
		mainFrame.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent windowEvent) 
			{	
				System.exit(0);	
			}	
		});
	
		headerLabel = new JLabel("", JLabel.CENTER);	
		statusLabel = new JLabel("",JLabel.CENTER);	
		statusLabel.setSize(350,100);
	
		controlPanel = new JPanel();	
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	
	}
	
	// we change this so that it has only 1 text field and a button
	private void showGUIDemo()
	{
		headerLabel.setText("GUI Demo - Odd or Even");
	
		JLabel namelabel= new JLabel("Any Integer: ", JLabel.RIGHT);
	
		final JTextField numText = new JTextField(6);
	
		JButton calcButton = new JButton("OddOrEven");
		// we write code to determine odd or even number
		calcButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String data = "Result: " + numText.getText();
				try 
				{
					int num = Integer.parseInt(numText.getText());
					if (num % 2 == 0) 
					{
						data += " is an even number";
					}
					else
						data += " is an odd number";
				}
				catch (Exception ex) 
				{
					data += " invalid input";
				}
				statusLabel.setText(data);
			}
		});
	
		controlPanel.add(namelabel);	
		controlPanel.add(numText);
	
		controlPanel.add(calcButton);
		// 	setVisible will show the information
	
		mainFrame.setVisible(true);
	
	}
	
}
