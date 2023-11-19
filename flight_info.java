package Main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class flight_info {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flight_info window = new flight_info();
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
	public flight_info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(975,712);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());

		JPanel paneltop_1 = new JPanel();
		paneltop_1.setLayout(null);
		paneltop_1.setBackground(Color.blue);
		paneltop_1.setBounds(0, 0, 959, 100);
		frame.getContentPane().add(paneltop_1);
		
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(20, 0, 150, 100);
		paneltop_1.add(lblNewLabel2);
		
		ImageIcon image1 = new ImageIcon("pInfo_Flights.jpg");
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton.setBounds(394, 576, 179, 53);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pInfo_frame i = new pInfo_frame();
				i.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		JLabel lblNewLabel = new JLabel(image1);
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 25));
		lblNewLabel.setBounds(0, 100, 959, 562);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flight_info window = new flight_info();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

}