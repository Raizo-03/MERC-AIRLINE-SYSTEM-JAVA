package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class about_frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about_frame window = new about_frame();
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
	public about_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(500,620);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		
		
		JPanel labelPanel = new JPanel(	);
		labelPanel.setLayout(null);
		labelPanel.setBounds(50, 100, 100, 50);
		labelPanel.setBackground(Color.BLUE);
		
		ImageIcon image1 = new ImageIcon("about_image.jpg");
		JLabel imagelbl = new JLabel(image1);
		imagelbl.setBounds(143, 11, 300,174);
		labelPanel.add(imagelbl);
		
		JLabel aboutLbl1 = new JLabel("About");
		aboutLbl1.setForeground(new Color(255, 255, 255));
		aboutLbl1.setFont(new Font("Proxima Nova", Font.BOLD, 24));
		aboutLbl1.setBounds(64, 164, 100, 52);
		labelPanel.add(aboutLbl1);
		
		
		JLabel aboutLbl2 = new JLabel("AviaLux Airline Ticketing System");
		aboutLbl2.setForeground(new Color(255, 255, 255));
		aboutLbl2.setBounds(64, 217, 330, 29);
		aboutLbl2.setFont(new Font("Proxima Nova", Font.BOLD, 15));
		labelPanel.add(aboutLbl2);
		
		JLabel aboutLbl3 = new JLabel("Version : 1.0");
		aboutLbl3.setForeground(new Color(255, 255, 255));
		aboutLbl3.setFont(new Font("Proxima Nova", Font.BOLD, 15));
		aboutLbl3.setBounds(64, 250, 330, 29);
		labelPanel.add(aboutLbl3);
		
		JLabel aboutLbl4 = new JLabel("Developers ");
		aboutLbl4.setForeground(new Color(255, 255, 255));
		aboutLbl4.setFont(new Font("Proxima Nova", Font.BOLD, 15));
		aboutLbl4.setBounds(64, 308, 330, 29);
		labelPanel.add(aboutLbl4);
		
		JLabel aboutLbl5 = new JLabel("College of Computing And Information Sciences");
		aboutLbl5.setForeground(new Color(255, 255, 255));
		aboutLbl5.setFont(new Font("Proxima Nova", Font.BOLD, 13));
		aboutLbl5.setBounds(64, 348, 430, 29);
		labelPanel.add(aboutLbl5);
		
		
		JLabel aboutLbl6 = new JLabel("University Of Makati");
		aboutLbl6.setForeground(new Color(255, 255, 255));
		aboutLbl6.setFont(new Font("Proxima Nova", Font.BOLD, 13));
		aboutLbl6.setBounds(64, 376, 430, 29);
		labelPanel.add(aboutLbl6);
		
		
		JLabel aboutLbl7 = new JLabel("© 2023 AviaLux Airlines");
		aboutLbl7.setForeground(new Color(255, 255, 255));
		aboutLbl7.setFont(new Font("Proxima Nova", Font.BOLD, 13));
		aboutLbl7.setBounds(64, 496, 430, 29);
		labelPanel.add(aboutLbl7);
		
		JButton buttonPrcd = new JButton("PROCEED");
		buttonPrcd.setFont(new Font("Proxima Nova", Font.BOLD, 16));
		buttonPrcd.setBounds(64, 428, 379, 37);
		labelPanel.add(buttonPrcd);
		
		buttonPrcd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Loading loadingFrame = new Loading();
		    	loadingFrame.setVisible(true);
		    	
				//main_frame mainFrame = new main_frame();
				//mainFrame.setVisible(true);
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(labelPanel);

	}
	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about_frame window = new about_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}