package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main_frame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame window = new main_frame();
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
	public main_frame() {
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


		
		//TOP HEADER
		JPanel paneltop_1 = new JPanel();
		paneltop_1.setLayout(null);
		paneltop_1.setBackground(Color.blue);
		paneltop_1.setBounds(0, 0, 959, 100);
		frame.getContentPane().add(paneltop_1);
		
		//BG
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(20, 0, 150, 100);
		paneltop_1.add(lblNewLabel2);
		
		//WELCOME
		JLabel lblNewLabel3 = new JLabel("WELCOME ABOARD!");
		lblNewLabel3.setForeground(new Color(255, 255, 255));
		lblNewLabel3.setFont(new Font("Proxima Nova", Font.ITALIC, 28));
		lblNewLabel3.setBounds(652, 35, 297, 30);
		paneltop_1.add(lblNewLabel3);
		
		
		ImageIcon image1 = new ImageIcon("main_image.jpg");
		
		JButton btn1 = new JButton("BOOK");
		btn1.setFont(new Font("Proxima Nova", Font.BOLD, 25));
		btn1.setBounds(241, 518, 200, 43);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {

				pInfo_frame info = new pInfo_frame();
				info.setVisible(true);
				
				frame.dispose();
			}
		});
		
		JButton btn2 = new JButton("RETURN");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about_frame abt = new about_frame();
				abt.setVisible(true);
				frame.dispose();
			}
		});
		btn2.setFont(new Font("Proxima Nova", Font.BOLD, 25));
		btn2.setBounds(522, 518, 200, 43);
		frame.getContentPane().add(btn2);
		JLabel lblNewLabel = new JLabel(image1);
		lblNewLabel.setBounds(0, 98, 959, 575);
		
		frame.getContentPane().add(lblNewLabel);


	}

	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame window = new main_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
}