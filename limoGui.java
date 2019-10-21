package limo3;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class limoGui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					limoGui window = new limoGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public limoGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("start");
		btnStart.setBounds(12, 217, 96, 25);
		frame.getContentPane().add(btnStart);
		
		JButton btnPause = new JButton("pause");
		btnPause.setBounds(120, 217, 96, 25);
		frame.getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("resume");
		btnResume.setBounds(228, 217, 85, 25);
		frame.getContentPane().add(btnResume);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(46, 35, 284, 14);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(46, 70, 284, 14);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(46, 106, 284, 14);
		frame.getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(46, 143, 284, 14);
		frame.getContentPane().add(progressBar_3);
		
		textField = new JTextField();
		textField.setBounds(362, 35, 61, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(362, 70, 61, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(362, 101, 61, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(362, 138, 61, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea txtrThreadTestApplication = new JTextArea();
		txtrThreadTestApplication.setText("Thread Test Application ");
		txtrThreadTestApplication.setBounds(166, 8, 147, 15);
		frame.getContentPane().add(txtrThreadTestApplication);
		
		JTextArea txtrGrandTotal = new JTextArea();
		txtrGrandTotal.setText("Grand Total");
		txtrGrandTotal.setBounds(239, 169, 1, 15);
		frame.getContentPane().add(txtrGrandTotal);
		
		JTextArea txtrGrandTotal_1 = new JTextArea();
		txtrGrandTotal_1.setText("Grand Total");
		txtrGrandTotal_1.setBounds(234, 179, 96, 15);
		frame.getContentPane().add(txtrGrandTotal_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(362, 177, 61, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
