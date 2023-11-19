package Main;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.io.File;
import javax.swing.*;
import java.awt.*;



public class pInfo_frame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblImage;
	private JButton btnNewButton, btnProceed, btnCancel;
	
	
	/**
	 * Launch the application.
	 */
	
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pInfo_frame window = new pInfo_frame();
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
	public pInfo_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("AviaLux Airlines");
		frame.setResizable(false);
		frame.setSize(975,712);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());

		JPanel paneltop_1 = new JPanel();
		paneltop_1.setLayout(null);
		paneltop_1.setBackground(Color.blue);
		paneltop_1.setBounds(0, 0, 959, 100);
		frame.getContentPane().add(paneltop_1);
		
		//HEADERS
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(20, 0, 150, 100);
		paneltop_1.add(lblNewLabel2);
		

		ImageIcon image3 = new ImageIcon("progress1.jpg");
		
		JLabel lblNewLabel4 = new JLabel("Personal Details");
		lblNewLabel4.setForeground(new Color(255, 255, 255));
		lblNewLabel4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel4.setBounds(627, 69, 129, 20);
		paneltop_1.add(lblNewLabel4);
		
		JLabel lblNewLabel5 = new JLabel("Travel Details");
		lblNewLabel5.setBackground(new Color(192, 192, 192));
		lblNewLabel5.setForeground(new Color(192, 192, 192));
		lblNewLabel5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel5.setBounds(745, 69, 117, 20);
		paneltop_1.add(lblNewLabel5);
		
		JLabel lblNewLabel6 = new JLabel("Confirmation");
		lblNewLabel6.setForeground(new Color(192, 192, 192));
		lblNewLabel6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel6.setBounds(865, 69, 117, 20);
		paneltop_1.add(lblNewLabel6);
		
		JLabel lblNewLabel3 = new JLabel(image3);
		lblNewLabel3.setBounds(627, 0, 332, 100);
		paneltop_1.add(lblNewLabel3);
	
		
		
		//BODY
		
		ImageIcon image1 = new ImageIcon("pInfo_Frame.jpg");
		
				
		JLabel lblNewLabel7 = new JLabel("Travellers Information");
		lblNewLabel7.setFont(new Font("Arial Black", Font.PLAIN, 50));
		lblNewLabel7.setBounds(194, 127, 612, 100);
		frame.getContentPane().add(lblNewLabel7);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setText("Your name (fname mInitial lname)");
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField.setBounds(331, 284, 374, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setText("Your Age");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(331, 341, 189, 38);
		frame.getContentPane().add(textField_1);

		
		textField_2 = new JTextField();
		textField_2.setText("Number of Passenger (including you)");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(331, 397, 374, 38);
		frame.getContentPane().add(textField_2);

		
		String [] travelT =  {"Local Travel", "International Travel"};
		JComboBox comboBox = new JComboBox(travelT);
		comboBox.setBounds(331, 456, 134, 31);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String)comboBox.getSelectedItem();
				textField_3.setText(str);
				
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setBounds(486, 456, 159, 31);
		textField_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		String [] travelD =  {"Option A", "Option B", "Option C", "Option D", "Option E", "Option F", "Option G"
				, "Option H","Option I", "Option J"};
		JComboBox comboBox_1 = new JComboBox(travelD);
		comboBox_1.setBounds(331, 523, 134, 31);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String)comboBox_1.getSelectedItem();
				
		        if (str.equals("Option A")) {
		            textField_4.setText("Manila to Batanes");
		        } else if (str.equals("Option B")) {
		            textField_4.setText("Batanes to Manila");
		        } else if (str.equals("Option C")) {
		            textField_4.setText("Manila to Palawan");
		        } else if (str.equals("Option D")) {
		            textField_4.setText("Palawan to Manila");
		        } else if (str.equals("Option E")) {
		            textField_4.setText("Manila to South Korea");
		        } else if (str.equals("Option F")) {
		            textField_4.setText("South Korea to Manila");
		        } else if (str.equals("Option G")) {
		            textField_4.setText("Manila to Japan");
		        } else if (str.equals("Option H")) {
		            textField_4.setText("Japan to Manila");
		        } else if (str.equals("Option I")) {
		            textField_4.setText("Manila to Vietnam");
		        } else if (str.equals("Option J")) {
		            textField_4.setText("Vietnam to Manila");
		        }
		    }
		});
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textField_4.setBounds(486, 523, 159, 31);
		frame.getContentPane().add(textField_4);
		
		JButton btn1 = new JButton("Flights");
		btn1.setBounds(653, 487, 103, 38);
		btn1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flight_info f = new flight_info();
				f.setVisible(true);
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btn1);
		
		btnProceed = new JButton("Proceed");
		btnProceed.setFont(new Font("Proxima Nova", Font.BOLD, 25));
		btnProceed.setBounds(240, 584, 200, 43);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		        String name = textField.getText();
		        Passenger passengerObj = new Passenger();
		        int age = Integer.parseInt(textField_1.getText());
		        int numOfPassenger = Integer.parseInt(textField_2.getText());
		        String type = textField_3.getText();
		        String destination = textField_4.getText();
		        passengerObj.setName(name);
		        passengerObj.setAge(age);
		        passengerObj.setNumOfPassenger(numOfPassenger);
		        
		        
		        
		        travel_dets2 t = new travel_dets2(name, age, numOfPassenger,type, destination); 

		    
		        
		        
		        if (destination.isEmpty()) {
		        	JOptionPane.showMessageDialog(frame, "Input Travel Destination", " ", JOptionPane.ERROR_MESSAGE);
		        	}else if (type.isEmpty()){
			        	JOptionPane.showMessageDialog(frame, "Input Necessary Details", " ", JOptionPane.ERROR_MESSAGE);
		        	}else if (name.isEmpty()) {
			        	JOptionPane.showMessageDialog(frame, "Input Necessary Details", " ", JOptionPane.ERROR_MESSAGE);
			        
		        	}else {
		        		if (age >= 59) {
				        	t.setSenior(true);
		        			JOptionPane.showMessageDialog(frame, "Information Save!", " ", JOptionPane.INFORMATION_MESSAGE);	
		        			t.initialize();
		        			frame.dispose();
		        		}else if (age >= 17) {
		        			t.setMinor(true);
		        			JOptionPane.showMessageDialog(frame, "Information Save!", " ", JOptionPane.INFORMATION_MESSAGE);	
		        			t.initialize();
		        			frame.dispose();	        			
		        		}else {
		        			JOptionPane.showMessageDialog(frame, "Information Save!", " ", JOptionPane.INFORMATION_MESSAGE);	
		        			t.initialize();
		        			frame.dispose();
		        		}
		        	}
				}catch (Exception f) {
					JOptionPane.showMessageDialog(frame, "There's an error in your inputs. Age and number of passengers should be numbers only.", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frame.getContentPane().add(btnProceed);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Proxima Nova", Font.BOLD, 25));
		btnCancel.setBounds(505, 584, 200, 43);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_frame t = new main_frame();
				t.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancel);
		
		//IMAGE PROPMT
		
		lblImage = new JLabel();
		lblImage.setPreferredSize(new Dimension(300, 300));
		lblImage.setBounds(59, 264, 166, 171);
		frame.getContentPane().add(lblImage);
		
		btnNewButton = new JButton("Upload Image");
		btnNewButton.setBounds(90, 460, 114, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);
                    lblImage.setIcon(imageIcon);
                    travel_dets2.setFilePath(filePath);

			}
			}
				
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("?");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_1.setBounds(875, 118, 60, 51);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guide guide = new guide();
				guide.setVisible(true);
				frame.dispose();
				
			}
			
		});
		
		
		
	
		
		JLabel lblNewLabel = new JLabel(image1);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 100, 959, 573);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public void setVisible(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pInfo_frame window = new pInfo_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}