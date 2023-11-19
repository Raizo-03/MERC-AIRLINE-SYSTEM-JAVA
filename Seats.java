package Main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seats {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats window = new Seats();
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
	public Seats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		
		JPanel paneltop_1 = new JPanel();
		paneltop_1.setLayout(null);
		paneltop_1.setBackground(Color.blue);
		paneltop_1.setBounds(0, 0, 684, 661);
		frame.getContentPane().add(paneltop_1);
		
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		
		ImageIcon image3 = new ImageIcon("seat.png");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(20, 0, 150, 100);
		paneltop_1.add(lblNewLabel2);
		
		//SEAT BUTTONS
		
		JButton button1A = new JButton("1A");
		button1A.setBounds(197, 163, 55, 48);
		button1A.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		paneltop_1.add(button1A);
		
		JButton button1B = new JButton("1B");
		button1B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button1B.setBounds(262, 163, 55, 48);
		paneltop_1.add(button1B);
		
		JButton button2A = new JButton("2A\r\n\r\n");
		button2A.setBounds(197, 229, 55, 48);
		button2A.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		paneltop_1.add(button2A);
		
		JButton button2B = new JButton("2B\r\n\r\n");
		button2B.setBounds(262, 229, 55, 48);
		button2B.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e ) {
				
			}
		});
		paneltop_1.add(button2B);
		
		JButton button3A = new JButton("3A\r\n\r\n");
		button3A.setBounds(197, 295, 55, 48);
		paneltop_1.add(button3A);
		button3A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton button3B = new JButton("3B");
		button3B.setBounds(262, 295, 55, 48);
		paneltop_1.add(button3B);
		button3B.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
			}
			
		});
		
		JButton button4A = new JButton("4A");
		button4A.setBounds(262, 295, 55, 48);
		paneltop_1.add(button4A);
		button4A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		JLabel planePic = new JLabel(image3);
		planePic.setBounds(165, 0, 390, 748);
		paneltop_1.add(planePic);
		
	
		
		
		
		
		
		
		
		
	}
}
