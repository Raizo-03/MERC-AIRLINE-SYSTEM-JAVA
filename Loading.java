package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Font;

public class Loading {

	private JFrame frame;
	private JProgressBar progressBar;
    private Timer timer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
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
	public Loading() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(487, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		
		JPanel labelPanel = new JPanel(	);
		labelPanel.setLayout(null);
		labelPanel.setBounds(50, 100, 100, 50);
		labelPanel.setBackground(Color.BLUE);
		
	    ImageIcon gifIcon = new ImageIcon("airplane.gif");
        
        
        progressBar = new JProgressBar(0, 100);
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 15));
        progressBar.setBackground(new Color(0, 0, 0));
        progressBar.setSize(471, 38);
        progressBar.setLocation(0, 423);
        progressBar.setForeground(new Color(255, 0, 0));
        progressBar.setStringPainted(true);

        // You can adjust the height of the progress bar by setting its preferred size
        Dimension preferredSize = progressBar.getPreferredSize();
        preferredSize.height = 30; // Set the desired height
        progressBar.setPreferredSize(new Dimension(146, 31));
        
        labelPanel.add(progressBar, BorderLayout.SOUTH);
        // Create a timer to simulate progress
        timer = new Timer(1000, new ActionListener() {
            private int progressValue = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressValue < 100) {
                    progressValue += 20; // Simulate progress
                    progressBar.setValue(progressValue);
                    progressBar.setString("Loading: " + progressValue + "%");
                } else {
                    timer.stop(); // Stop the timer when progress reaches 100%
                    progressBar.setString("Loading Complete!");
                	main_frame mainFrame = new main_frame();
    				mainFrame.setVisible(true);
    				frame.dispose();
                }
            }
        });
        timer.start();
        
        
        
		frame.getContentPane().add(labelPanel);
		JLabel gifLabel = new JLabel(gifIcon);
		gifLabel.setSize(471, 461);
		gifLabel.setLocation(0, 0);
		labelPanel.add(gifLabel);
		

		
		
		
		
		
	}

	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
