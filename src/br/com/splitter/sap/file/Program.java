package br.com.splitter.sap.file;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import br.com.splitter.sap.splitscreen.SplitPanel;

public class Program {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SplitPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	            frame.setLocation(450,250);
	            frame.setTitle("Java SAP Splitter");            
	                          
	}
}
