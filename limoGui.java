package limo3;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class limoGui {

	private JFrame frame;
	private JTextField threadOneProgress;
	private JTextField threadTwoProgress;
	private JTextField threadThreeProgress;
	private JTextField threadFourProgress;
	private JTextField GrandTotal;
	private JProgressBar progressBar1;
	private JProgressBar progressBar2;
	private JProgressBar progressBar3;
	private JProgressBar progressBar4;
	
	private Task task;

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
	
	   private class Task extends Thread {    
		      public Task(){
		      }
		      public void run(){
		         for(int i =0; i<= 100; i+=10){
		            final int progress = i;
		            
		            SwingUtilities.invokeLater(new Runnable() {
		               public void run() {
		                  progressBar1.setValue(progress);
		                  threadOneProgress.setText(threadOneProgress.getText() 
		                     + String.format("Completed %d%% of task.\n", progress));
		               }
		            });
		            try {
		               Thread.sleep(100);
		            } catch (InterruptedException e) {}
		         }
		      }
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
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "hi");
				task = new Task();                
	            task.start();
			}
		});
		btnStart.setBounds(12, 217, 96, 25);
		frame.getContentPane().add(btnStart);
		
		JButton btnPause = new JButton("pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "hi");
			}
		});
		btnPause.setBounds(120, 217, 96, 25);
		frame.getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("resume");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "hi");
			}
		});
		btnResume.setBounds(228, 217, 85, 25);
		frame.getContentPane().add(btnResume);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setBounds(46, 35, 284, 14);
		frame.getContentPane().add(progressBar1);
		
		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setBounds(46, 70, 284, 14);
		frame.getContentPane().add(progressBar2);
		
		JProgressBar progressBar3 = new JProgressBar();
		progressBar3.setBounds(46, 106, 284, 14);
		frame.getContentPane().add(progressBar3);
		
		JProgressBar progressBar4 = new JProgressBar();
		progressBar4.setBounds(46, 143, 284, 14);
		frame.getContentPane().add(progressBar4);
		
		threadOneProgress = new JTextField();
		threadOneProgress.setBounds(362, 35, 61, 19);
		frame.getContentPane().add(threadOneProgress);
		threadOneProgress.setColumns(10);
		
		threadTwoProgress = new JTextField();
		threadTwoProgress.setBounds(362, 70, 61, 19);
		frame.getContentPane().add(threadTwoProgress);
		threadTwoProgress.setColumns(10);
		
		threadThreeProgress = new JTextField();
		threadThreeProgress.setBounds(362, 101, 61, 19);
		frame.getContentPane().add(threadThreeProgress);
		threadThreeProgress.setColumns(10);
		
		threadFourProgress = new JTextField();
		threadFourProgress.setBounds(362, 138, 61, 19);
		frame.getContentPane().add(threadFourProgress);
		threadFourProgress.setColumns(10);
		
		JTextArea txtrGrandTotal = new JTextArea();
		txtrGrandTotal.setText("Grand Total");
		txtrGrandTotal.setBounds(239, 169, 1, 15);
		frame.getContentPane().add(txtrGrandTotal);
		
		GrandTotal = new JTextField();
		GrandTotal.setBounds(362, 177, 61, 19);
		frame.getContentPane().add(GrandTotal);
		GrandTotal.setColumns(10);
		
		JLabel label = new JLabel("1:");
		label.setBounds(12, 34, 66, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setBounds(12, 69, 66, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setBounds(12, 105, 66, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setBounds(12, 142, 66, 15);
		frame.getContentPane().add(label_3);
		
		JLabel lblGrandTotal = new JLabel("Grand Total:");
		lblGrandTotal.setBounds(259, 179, 85, 15);
		frame.getContentPane().add(lblGrandTotal);
		
		JLabel lblThreadTestApplication = new JLabel("Thread Test Application ");
		lblThreadTestApplication.setBounds(99, 8, 166, 15);
		frame.getContentPane().add(lblThreadTestApplication);
	}
	

}

   
