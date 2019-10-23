package limo3;

/***
 * multithreaded GUI application 
 * create a swing form in eclipse and run simultaneous threads in a non blocking way
 */

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
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class limoGui {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public limoGui() {

		prepareGUI();
	}

	public static void main(String[] args) {

		/// call the GUI constructor on the Event Dispatch Thread

		SwingUtilities.invokeLater(new Runnable() { // Note 1
			public void run() {
				limoGui swingControlDemo = new limoGui();
				swingControlDemo.showProgressBarDemo();

			}
		});

	}

	private void prepareGUI() {

		mainFrame = new JFrame("Java Swing Examples");

		mainFrame.getContentPane().setLayout(null);
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}

		});
		headerLabel = new JLabel();
		statusLabel = new JLabel();
		statusLabel.setSize(350, 100);

		controlPanel = new JPanel();

		mainFrame.getContentPane().add(headerLabel);
		mainFrame.getContentPane().add(controlPanel);
		mainFrame.getContentPane().add(statusLabel);
		mainFrame.setVisible(true);

		JLabel label = new JLabel("1:");
		label.setBounds(12, 34, 66, 15);
		mainFrame.getContentPane().add(label);

		JLabel label_1 = new JLabel("2:");
		label_1.setBounds(12, 69, 66, 15);
		mainFrame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("3:");
		label_2.setBounds(12, 105, 66, 15);
		mainFrame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("4:");
		label_3.setBounds(12, 142, 66, 15);
		mainFrame.getContentPane().add(label_3);

	}

	private JProgressBar progressBar;
	private JProgressBar progressBar2;
	private JProgressBar progressBar3;
	private JProgressBar progressBar4;
	private Task task;
	private Task task2;
	private Task task3;
	private Task task4;
	private Worker worker;
	private Worker worker2;
	private Worker worker3;
	private Worker worker4;
	private JButton startButton;
	private JTextArea threadOneProgress;
	private JTextArea threadOneProgress2;
	private JTextArea threadOneProgress3;
	private JTextArea threadOneProgress4;
	private JTextArea GrandTotal;

	private void showProgressBarDemo() {

		headerLabel.setText("Thread Test Application ");
		headerLabel.setBounds(99, 8, 166, 15);

		// create 4 progress bars and add to frame
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBounds(46, 35, 284, 14);
		mainFrame.getContentPane().add(progressBar);

		progressBar2 = new JProgressBar(0, 100);
		progressBar2.setValue(0);
		progressBar2.setStringPainted(true);
		progressBar2.setBounds(46, 70, 284, 14);
		mainFrame.getContentPane().add(progressBar2);

		progressBar3 = new JProgressBar(0, 100);
		progressBar3.setValue(0);
		progressBar3.setStringPainted(true);
		progressBar3.setBounds(46, 106, 284, 14);
		mainFrame.getContentPane().add(progressBar3);

		progressBar4 = new JProgressBar(0, 100);
		progressBar4.setValue(0);
		progressBar4.setStringPainted(true);
		progressBar4.setBounds(46, 143, 284, 14);
		mainFrame.getContentPane().add(progressBar4);

		// create a start button

		startButton = new JButton("Start");
		startButton.setBounds(12, 217, 96, 25);

		// create output text panels
		threadOneProgress = new JTextArea();
		threadOneProgress.setBounds(362, 35, 61, 19);
		threadOneProgress2 = new JTextArea();
		threadOneProgress2.setBounds(362, 70, 61, 19);
		threadOneProgress3 = new JTextArea();
		threadOneProgress3.setBounds(362, 101, 61, 19);
		threadOneProgress4 = new JTextArea();
		threadOneProgress4.setBounds(362, 138, 61, 19);

		// add output text panels to window
		mainFrame.getContentPane().add(threadOneProgress);
		mainFrame.getContentPane().add(threadOneProgress2);
		mainFrame.getContentPane().add(threadOneProgress3);
		mainFrame.getContentPane().add(threadOneProgress4);
		threadOneProgress.setColumns(10);
		threadOneProgress2.setColumns(10);
		threadOneProgress3.setColumns(10);
		threadOneProgress4.setColumns(10);

		JTextField txtrGrandTotal_1 = new JTextField();
		txtrGrandTotal_1.setFont(new Font("Dialog", Font.BOLD, 12));
		txtrGrandTotal_1.setText("Grand Total :");
		txtrGrandTotal_1.setBounds(234, 179, 96, 15);

		mainFrame.getContentPane().add(txtrGrandTotal_1);

		GrandTotal = new JTextArea();
		GrandTotal.setBounds(362, 177, 61, 19);
		mainFrame.getContentPane().add(GrandTotal);
		GrandTotal.setColumns(10);
		GrandTotal.setText("0");

		// JScrollPane scrollPane = new JScrollPane(threadOneProgress);

		// When start button is clicked start 4 tasks

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/**
				 * start a version using SwingWorker
				 */
				worker = new Worker(progressBar, threadOneProgress, GrandTotal, 60);
				worker.execute();
				worker2 = new Worker(progressBar2, threadOneProgress2, GrandTotal, 60);
				worker2.execute();
				worker3 = new Worker(progressBar3, threadOneProgress3, GrandTotal, 60);
				worker3.execute();
				worker4 = new Worker(progressBar4, threadOneProgress4, GrandTotal, 60);
				worker4.execute();
				/***
				 * task = new Task(progressBar, threadOneProgress, GrandTotal, 60);
				 * task.start(); task2 = new Task(progressBar2, threadOneProgress2, GrandTotal,
				 * 60); task2.start(); task3 = new Task(progressBar3, threadOneProgress3,
				 * GrandTotal, 60); task3.start(); task4 = new Task(progressBar4,
				 * threadOneProgress4, GrandTotal , 60); task4.start();
				 * 
				 ***/
			}
		});
		mainFrame.add(startButton);
		mainFrame.add(progressBar);

		// create a pause button
		JButton btnPause = new JButton("pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "hi");
			}
		});
		btnPause.setBounds(120, 217, 96, 25);
		mainFrame.getContentPane().add(btnPause);

		// create a resume button
		JButton btnResume = new JButton("resume");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "hi");
			}
		});
		btnResume.setBounds(228, 217, 85, 25);
		mainFrame.getContentPane().add(btnResume);
	}

	/// CREATE A SWING WORKER THREAD TO UPDATE GUI

	class Worker extends SwingWorker<Boolean, Integer> {

		private final JProgressBar WorkerThreadProgressBar;
		private final JTextArea WorkerThreadTextArea;
		private final JTextArea WorkerGrandTotalArea;
		private final int WorkerSleepTime;

		Worker(JProgressBar WTPB, JTextArea WTTA, JTextArea WGTA, int WST) {
			WorkerThreadProgressBar = WTPB;
			WorkerThreadTextArea = WTTA;
			WorkerGrandTotalArea = WGTA;
			WorkerSleepTime = WST;
		}

		@Override
		protected Boolean doInBackground() throws Exception {
			// To identify whether the background job is running out of EDT
			System.out.println("doSomething() running in EDT?" + SwingUtilities.isEventDispatchThread());

			for (int i = 0; i <= 100; i += 1) {
				final int progress = i;
				int j = i;

				try {
					Thread.sleep(WorkerSleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace(System.out);
				}
				publish(i);
			}

			return true;
		}

		@Override
		protected void done() {
			try {
				/// label.setText(String.format("%d", get()));
			} catch (Exception ignore) {
			}
		}

		@Override
		protected void process(List<Integer> chunks) {
			for (int num : chunks) {
				WorkerThreadTextArea.setText(String.format("%d", num));
				WorkerThreadProgressBar.setValue(num);

				synchronized (WorkerGrandTotalArea) {
					// synchronizing the update of GrandTotalObject
					if (num < 100)

					{

						try {
							Thread.sleep(50);
							WorkerGrandTotalArea.setText(
									String.format("%d", (1 + Integer.parseInt(WorkerGrandTotalArea.getText()))));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace(System.out);

						}
					}

				}
			}

		}
	}

	// create a thread with parameters progress bar
	// thread total label
	// grand total label
	// interval in milliseconds for sleep step in each thread
	// this is unused
	private class Task extends Thread {
		private final JProgressBar ThreadProgressBar;
		private final JTextArea ThreadTextArea;
		private final JTextArea GrandTotalArea;
		private final int SleepTime;

		public Task(final JProgressBar JP, JTextArea JT, JTextArea GT, int ST) {
			ThreadProgressBar = JP;
			ThreadTextArea = JT;
			SleepTime = ST;
			GrandTotalArea = GT;

		}

		public void run() {
			for (int i = 0; i <= 100; i += 1) {
				final int progress = i;
				int j = i;

				// asyncExec(new Runnable() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						// update the gui for this thread
						ThreadProgressBar.setValue(progress);
						ThreadTextArea.setText(String.format("%d", progress));
						// this wont work !!

						synchronized (GrandTotalArea) {
							// synchronizing the update of GrandTotalObject
							if (j < 100)

							{

								try {
									sleep(50);
									GrandTotalArea.setText(
											String.format("%d", (1 + Integer.parseInt(GrandTotalArea.getText()))));
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace(System.out);

								}
							}

						}

					}
				});
				try {
					Thread.sleep(SleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace(System.out);
				}
			}
		}
	}

}
