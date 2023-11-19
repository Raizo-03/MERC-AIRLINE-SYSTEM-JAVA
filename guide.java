package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class guide {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guide window = new guide();
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
	public guide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(1475,712);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		
		ImageIcon image1 = new ImageIcon("guide.png");
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton.setBounds(600, 574, 179, 53);
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
		lblNewLabel.setBounds(0, 0, 1370, 662);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guide window = new guide();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
}