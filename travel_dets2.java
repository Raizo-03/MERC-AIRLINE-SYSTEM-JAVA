package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.*;

import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.event.*;

public class travel_dets2 implements ActionListener {
    JFrame frame;
    private String name, travelDestination;
    private int age, numOfPassenger;
	private JLabel l, m, n, o, p, controlNumberLabel, cnumberLabel, ifTheresAdult, ifThereSenior, ifOneWayRound;
    private static String filePath;
    private JTextField txtName, txtPassengers, txtAge, txtDestination;
    private JButton btnName, btnPassenger, btnAge, btnProceed, btnReset, btnReturn;
    private JComboBox airplaneType, travelT, travelD, travelInsurance, ifA, ifS;
    private JRadioButton radio1, radio2;
    private ButtonGroup buttonGroup;

	public travel_dets2() {
		 
	 }
	
    public travel_dets2(String name, int age, int numOfPassenger, String travelType, String travelDestination) {
    
        l = new JLabel(name);
        l.setFont(new Font("Tahoma", Font.BOLD, 20));
        l.setBounds(1010, 280, 250, 209);
        
        
        m = new JLabel();
        m.setText(String.valueOf(age) + " YEARS OLD");
        m.setFont(new Font("Tahoma", Font.BOLD, 20));
        m.setBounds(1020, 320, 250, 209);
        
       
        
        n = new JLabel();
        n.setText(String.valueOf(numOfPassenger)+ " PASSENGER(S)");
        n.setFont(new Font("Tahoma", Font.BOLD, 20));
        n.setBounds(1020, 360, 250, 209);
        
        o = new JLabel();
        o.setText(travelType);
        o.setFont(new Font("Tahoma", Font.BOLD, 20));
        o.setBounds(1020, 400, 250, 209);
        
        p = new JLabel();
        p.setText(travelDestination);
        p.setFont(new Font("Tahoma", Font.BOLD, 20));
        p.setBounds(1020, 440, 250, 209);
        
        controlNumberLabel = new JLabel();
        controlNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        controlNumberLabel.setBounds(80, 50, 500, 209);
        String controlNumber = generateControlNumber();
        controlNumberLabel.setText(controlNumber);
        
		cnumberLabel = new JLabel();
		cnumberLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		cnumberLabel.setText("Transaction Number");
		cnumberLabel.setBounds(80, 20, 500, 209);
		
	     // TextFields
        txtName = new JTextField();
        txtName.setBounds(320, 190, 200, 35);
        txtName.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		txtName.setColumns(10);
		
		
		btnName = new JButton("✔");
		btnName.setFont(new Font("Proxima Nova", Font.BOLD,8 ));
		btnName.setBounds(520, 190, 40, 35);
		btnName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String name = txtName.getText();
				l.setText(name);
				}catch (Exception f) {
					JOptionPane.showMessageDialog(frame, "Invalid Input!", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
        txtPassengers = new JTextField();
        txtPassengers.setBounds(320, 270, 50, 35);
        txtPassengers.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		txtPassengers.setColumns(10);
		
		btnPassenger = new JButton("✔");
		btnPassenger.setFont(new Font("Proxima Nova", Font.BOLD,8 ));
		btnPassenger.setBounds(370, 270, 40, 35);
		btnPassenger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				String passenger = txtPassengers.getText();
				n.setText(passenger + " PASSENGER(S)");	
				
				int passengers = Integer.parseInt(passenger);
				
				if (passengers > 1) {
					ifS.enable();
				}
			
				}catch (Exception s) {
					JOptionPane.showMessageDialog(frame, "Invalid input!", " ", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		
		String [] airplaneT =  {"Private Class", "Business Class", "Regular Class"};
		airplaneType = new JComboBox(airplaneT);
		airplaneType.setBounds(320, 350, 150, 35);
		airplaneType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String airline = (String)airplaneType.getSelectedItem();
				//textField_3.setText(str);	
				try {
		        if (airline.equals("Private Class")) {
		        		String numPass = txtPassengers.getText();
		        		int nP = Integer.parseInt(numPass);
		        		
		        		if (nP > 13) {
		        			  JOptionPane.showMessageDialog(frame, "Sorry! You have exceeded the number of\r\n"
		  		            		+ "passengers required", "", JOptionPane.ERROR_MESSAGE);
		        			  txtPassengers.setText(null);
		        		}
		        } else if (airline.equals("Business Class")){
		        	String numPass = txtPassengers.getText();
	        		int nP = Integer.parseInt(numPass);
	        		if (nP > 22) {
		        	JOptionPane.showMessageDialog(frame, "Sorry! You have exceeded the number of\r\n"
  		            		+ "passengers required", "", JOptionPane.ERROR_MESSAGE);
      			  txtPassengers.setText(null);

	        		}
		        }else if(airline.equals("Regular Class")) {
		        	String numPass = txtPassengers.getText();
	        		int nP = Integer.parseInt(numPass);
        		
	        		if (nP > 47) {
	        			JOptionPane.showMessageDialog(frame, "Sorry! You have exceeded the number of\r\n"
	  		            		+ "passengers required", "", JOptionPane.ERROR_MESSAGE);
	        			  txtPassengers.setText(null);
	        		}
		        }
		  
			}catch(Exception f) {
        		JOptionPane.showMessageDialog(frame, "Invalid Input!" + "\n" + "Please input the number of passenger", "", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		
	    txtAge = new JTextField();
	    txtAge.setBounds(320, 420, 50, 35);
	    txtAge.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
	    txtAge.setColumns(10);

	 	btnAge = new JButton("✔");
		btnAge.setFont(new Font("Proxima Nova", Font.BOLD,8 ));
		btnAge.setBounds(370, 420, 40, 35);
		btnAge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText();
				
				 if (age.isEmpty()) {
			            JOptionPane.showMessageDialog(frame, "Invalid Age!", "", JOptionPane.ERROR_MESSAGE);
			            return; // Exit the method if age is not entered
			        }
				try {
				m.setText(age + " YEARS OLD");
				int aGE = Integer.parseInt(age);
				if (aGE < 18) {
	                ifA.setEnabled(true);
					if(ifA.getSelectedItem() == "No") {
						JOptionPane.showMessageDialog(frame, "Cannot travel alone and must be accompanied by at least one\r\n"
								+ "(1) Adult and/or Senior Citizen ", "ERROR", JOptionPane.ERROR_MESSAGE);
						txtAge.setText(null);
					}
				}else if (aGE >= 59) {
					ifS.enable();
				}else if (aGE >= 19) {
					ifA.disable();
				}else {
					ifS.setSelectedItem("No");
				}
				}catch (NumberFormatException  f) {
					JOptionPane.showMessageDialog(frame, "Invalid Input!", "", JOptionPane.ERROR_MESSAGE);
		            txtAge.setText("");
				}	
			}
		});
		
		String [] travelType1 =  {"Local Travel", "International Travel"};
		travelT = new JComboBox(travelType1);
		travelT.setBounds(320, 480, 150, 35);
		travelT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String)travelT.getSelectedItem();					
				o.setText(str);
			}
		});
		
	     txtDestination = new JTextField();
	     txtDestination.setBounds(455, 555, 180, 35);
	     txtDestination.setFont(new Font("Bahnschrift", Font.PLAIN,18));
	     txtDestination.setColumns(10);
		
		String [] travelOption =  {"Option A", "Option B", "Option C", "Option D", "Option E", "Option F", "Option G"
					, "Option H","Option I", "Option J"};
		travelD = new JComboBox(travelOption);
		travelD.setBounds(320, 555, 134, 31);
		travelD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = (String)travelD.getSelectedItem();
					
					if (str == "Option A") {
						txtDestination.setText("Manila to Batanes");
						p.setText("Manila to Batanes");
					}else if (str == "Option B") {
						txtDestination.setText("Batanes to Manila");
						p.setText("Batanes to Manila");
					}else if (str == "Option C") {
						txtDestination.setText("Manila to Palawan");
						p.setText("Manila to Palawan");
					}else if (str == "Option D") {
						txtDestination.setText("Palawan to Manila");
						p.setText("Palawan to Manila");
					}else if (str == "Option E") {
						txtDestination.setText("Manila to South Korea");
						p.setText("Manila to South Korea");
					}else if (str == "Option F") {
						txtDestination.setText("South Korea to Manila");
						p.setText("South Korea to Manila");
					}else if (str == "Option G") {
						txtDestination.setText("Manila to Japan");
						p.setText("Manila to Japan");
					}else if (str == "Option H") {
						txtDestination.setText("Japan to Manila");
						p.setText("Japan to Manila");
					}else if (str == "Option I") {
						txtDestination.setText("Manila to Vietnam");
						p.setText("Manila to Vietnam");
					}else if (str == "Option J") {
						txtDestination.setText("Vietnam to Manila");
						p.setText("Vietnam to Manila");
					}
				}
			});
		
		String insurance[] = {"Yes", "No"};
		travelInsurance = new JComboBox<>(insurance);
		travelInsurance.setBounds(700, 220, 150, 35);

		
		
		radio1 = new JRadioButton("One Way");
		radio1.setBounds(700, 320, 150, 35);
		radio1.setFont(new Font("Tahoma", Font.BOLD, 10));
		radio2 = new JRadioButton("Round Trip");
		radio2.setBounds(700, 350, 150, 35);
		radio2.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radio1);
		buttonGroup.add(radio2);
		//radio1.setSelected(true); // Selects radioButton1 by default
		
		
		ifOneWayRound = new JLabel();
		radio1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	ifOneWayRound.setText("One Way");
		    }
		});

		radio2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	ifOneWayRound.setText("Round Trip");
		    }
		});
		
		ifTheresAdult = new JLabel("If with age of 19-above");
		ifTheresAdult.setFont(new Font("Tahoma", Font.BOLD, 18));
		ifTheresAdult.setBounds(700, 380, 450, 35);
		String yo[] = {"Yes", "No"};
		ifA = new JComboBox<>(yo);
		ifA.setBounds(700, 420, 150, 35);
		ifA.disable();
		
		ifThereSenior = new JLabel("If with age of 59-above");
		ifThereSenior.setFont(new Font("Tahoma", Font.BOLD, 18));
		ifThereSenior.setBounds(700, 480, 450, 35);
		String s[] = {"Yes", "No"};
		ifS = new JComboBox<>(s);
		ifS.setBounds(700, 520, 150, 35);
		ifS.setSelectedIndex(1);
		ifS.disable();
		

		btnProceed = new JButton("CONFIRM");
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnProceed.setBounds(300, 610, 200, 50);
		btnProceed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//CLASSES
				AirlineType type = new AirlineType();
				Passenger passengers = new Passenger();
				Destination destination = new Destination();
				Transaction transaction = new Transaction();
				
				String nameI = l.getText();
				String ageI = m.getText();
				ageI = ageI.replaceAll("\\D+", ""); // Remove non-numeric characters
				String numPassI = n.getText();
				numPassI = numPassI.replaceAll("\\D+", ""); // Remove non-numeric characters
				String travelTI = o.getText();// LOCAL / INTERNATIONAL
				String travelDI = p.getText();// TRAVEL DESTINATION
				int agePI = Integer.parseInt(ageI);// AGE
				int numPassenger = Integer.parseInt(numPassI);// NUMBER OF PASSENGER
				String airlineI = (String)airplaneType.getSelectedItem();// PRIVATE, BUSINESS, REGULAR
				String travelInsu = (String)travelInsurance.getSelectedItem();//TRAVEL INSU
				String OneRound = ifOneWayRound.getText();// IF ONE WAY/ ROUNTRIP
				String Senior = (String)ifS.getSelectedItem(); // IF THERES A SENIOR
				String trans = controlNumberLabel.getText();
				
		
				//txtName, txtPassengers, txtAge, txtDestination
				int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to confirm?", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				if (confirmation == JOptionPane.YES_OPTION) {
					
				    if (buttonGroup.getSelection() == null || travelInsurance.getSelectedItem() == null) {
				        JOptionPane.showMessageDialog(frame, "Input Necessary Details", "ERROR", JOptionPane.ERROR_MESSAGE);
				    } else {
                
				passengers.setName(nameI);
				String name = passengers.getName();
				passengers.setAge(agePI);
				int age = passengers.getAge();
				passengers.setNumOfPassenger(numPassenger);
				int numPass = passengers.getNumOfPassenger();
				type.setAirlineT(airlineI);
				String airline = type.getAirlineT();
				destination.setDestination(travelDI);
				String destin = destination.getDestination();

				 // VARIABLES: ticketPrice, travelTax, baggageFee, travelI, total
				//	public double ticketPrice, travelTax, baggageFee, travelI, total;

		        if (airline.equals("Private Class") && destin.equals("Manila to Batanes") && OneRound.equals("One Way")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 0.00;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		              
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 4260.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 0.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
			                
			                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                

		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 4260.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Manila to Batanes") && OneRound.equals("Round Trip")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 0.00;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		              
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 4260.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 0.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
			                
			                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                

		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 8000.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double travelTax = 4260.0;
		                double processingFee = 550.0;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }
				    
		      }else if (airline.equals("Business Class") && destin.equals("Manila to Batanes") && OneRound.equals("One Way")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {          	
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                		
		                		
		                		
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			              
			              
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			               
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                		
			                		
			           }
		      }else if (airline.equals("Business Class") && destin.equals("Manila to Batanes") && OneRound.equals("Round Trip")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {          	
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                		
		                		
		                		
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			              
			              
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			               
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 12500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
				       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                		
			                		
			           }
		      }else if (airline.equals("Regular Class") && destin.equals("Manila to Batanes") && OneRound.equals("One Way")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;
		                double baggageFee = 950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;
		                double baggageFee = 950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		              
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;
		                double baggageFee = 950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;
		                double baggageFee = 950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
			                
			               
		            }
		      }else if (airline.equals("Regular Class") && destin.equals("Manila to Batanes") && OneRound.equals("Round Trip")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;
		                double baggageFee = 950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;
		                double baggageFee = 950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		              
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;
		                double baggageFee = 950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;
		                double baggageFee = 950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
			                
			               
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Batanes to Manila") && OneRound.equals("One Way")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Batanes to Manila") && OneRound.equals("Round Trip")) {
		            if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();	
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;
		                double baggageFee = 1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9800.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;
		                double baggageFee = 1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                //    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior) {

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Batanes to Manila") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                
		                
		                

		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  5700.00;		
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                		              
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  0.00;		
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();				                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  5700.00;		
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();				                                       
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Batanes to Manila") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                
		                
		                

		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  5700.00;		
		                double baggageFee = 2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		                		              
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  0.00;		
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();				                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 12950.00;
		                double discount = ticketPrice * 0.0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =  5700.00;		
		                double baggageFee = 2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();				                                       
		            }
		      }else if (airline.equals("Regular Class") && destin.equals("Batanes to Manila") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                	                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		            }
		      }else if (airline.equals("Regular Class") && destin.equals("Batanes to Manila") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 0.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                	                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3900.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax = 2500.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();		                
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Manila to Palawan") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
       
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;		
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
       
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
	                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;		
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
       
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
            
			              
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;		
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
       
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
   
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Manila to Palawan") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
     
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;		
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
     
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
	                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;		
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
     
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
          
			              
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9100.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 4260.00;		
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
     
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
 
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Manila to Palawan") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
 
		          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
   
		          }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		          }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Manila to Palawan") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
 
		          }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 0.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		          }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 10500.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax = 5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                

		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		      }else if (airline.equals("Regular Class") && destin.equals("Manila to Palawan") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	0.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	2500.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	0.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	2500.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		      }else if (airline.equals("Regular Class") && destin.equals("Manila to Palawan") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	0.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	2500.00;	
		                double baggageFee =950.00;
		                double travelI = 950.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	0.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                

		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 3200.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 255.0;
		                double travelTax =	2500.00;	
		                double baggageFee =950.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Palawan to Manila") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
         
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
            
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
	                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	4260.00;	
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		              
		            }
		      }else if (airline.equals("Private Class") && destin.equals("Palawan to Manila") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		                
		                
		            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 4500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
       
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
			                
			                
			                
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
          
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
	                
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 9850.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	4260.00;	
		                double baggageFee =1250.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		              
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Palawan to Manila") && OneRound.equals("One Way")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
 
		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			              
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		      }else if (airline.equals("Business Class") && destin.equals("Palawan to Manila") && OneRound.equals("Round Trip")) {
		          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 6500.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();

		            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0.20;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	0.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();			                
			                
			              
		            }else if (travelInsu.equals("No") && Senior.equals("No")) {
		                double ticketPrice = 10975.00;
		                double discount = ticketPrice * 0;
		                double discountedPrice = ticketPrice - discount;
		                double processingFee = 550.0;
		                double travelTax =	5700.00;	
		                double baggageFee =2850.00;
		                double travelI = 0.00;
		                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
		                transaction.setName(name);
		                transaction.setAge(age);
		                transaction.setNumOfPassenger(numPass);
		                transaction.setTotal(total);
		                transaction.setTransacNum(trans);
		                
		                
		                String transactionNumber = transaction.getTransacNum();
		                String nameTicket = transaction.getName();
		                int ageTicket = transaction.getAge();
		                
		                String numPassengerI = String.valueOf(numPass);
		                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

		                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
		                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
		                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
		                confirmationTicket.initialize();
		                frame.dispose();
		            }
		  
		     }
		}
				} else {
		    // handle when user clicks "No" or closes the dialog
		}
			}
			
		});
		
		
		//2ND METHOD FOR PROCEED BUTTON
		btnProceed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//CLASSES
				AirlineType type = new AirlineType();
				Passenger passengers = new Passenger();
				Destination destination = new Destination();
				Transaction transaction = new Transaction();
				
				
				String nameI = l.getText();
				String ageI = m.getText();
				ageI = ageI.replaceAll("\\D+", ""); // Remove non-numeric characters
				String numPassI = n.getText();
				numPassI = numPassI.replaceAll("\\D+", ""); // Remove non-numeric characters
				String travelTI = o.getText();// LOCAL / INTERNATIONAL
				String travelDI = p.getText();// TRAVEL DESTINATION
				int agePI = Integer.parseInt(ageI);// AGE
				int numPassenger = Integer.parseInt(numPassI);// NUMBER OF PASSENGER
				String airlineI = (String)airplaneType.getSelectedItem();// PRIVATE, BUSINESS, REGULAR
				String travelInsu = (String)travelInsurance.getSelectedItem();//TRAVEL INSU
				String OneRound = ifOneWayRound.getText();// IF ONE WAY/ ROUNTRIP
				String Senior = (String)ifS.getSelectedItem(); // IF THERES A SENIOR
				String trans = controlNumberLabel.getText();
				
				//txtName, txtPassengers, txtAge, txtDestination
				//int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to confirm?", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				//if (confirmation == JOptionPane.YES_OPTION) {
					
				    if (buttonGroup.getSelection() == null || travelInsurance.getSelectedItem() == null) {
				        JOptionPane.showMessageDialog(frame, "Input Necessary Details", "ERROR", JOptionPane.ERROR_MESSAGE);
				    } else {
						passengers.setName(nameI);
						String name = passengers.getName();
						passengers.setAge(agePI);
						int age = passengers.getAge();
						passengers.setNumOfPassenger(numPassenger);
						int numPass = passengers.getNumOfPassenger();
						type.setAirlineT(airlineI);
						String airline = type.getAirlineT();
						destination.setDestination(travelDI);
						String destin = destination.getDestination();
						
						 // VARIABLES: ticketPrice, travelTax, baggageFee, travelI, total
						//	public double ticketPrice, travelTax, baggageFee, travelI, total;
					
				if (airline.equals("Regular Class") && destin.equals("Palawan to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Regular Class") && destin.equals("Palawan to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 3575.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Private Class") && destin.equals("Manila to South Korea") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =1250.00;
				                double travelI = 4500.00;
				                double total = (ticketPrice + travelTax + baggageFee + travelI) * numPass ;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				          
				          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =1250.00;
				                double travelI = 4500.00;
				                double total = (ticketPrice + travelTax + baggageFee + travelI) * numPass ;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =1250.00;
				                double travelI = 0.00;
				                double total = (ticketPrice + travelTax + baggageFee + travelI) * numPass ;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.0;	
				                double baggageFee =1250.00;
				                double travelI = 0.00;
				                double total = (ticketPrice + travelTax + baggageFee + travelI) * numPass ;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Private Class") && destin.equals("Manila to South Korea") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				          
				          }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				         
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 27450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.0;	
				                double baggageFee =1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Business Class") && destin.equals("Manila to South Korea") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	  	
				      }else if (airline.equals("Business Class") && destin.equals("Manila to South Korea") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 37390.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to South Korea") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to South Korea") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 12055.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				          
				      }else if (airline.equals("Private Class") && destin.equals("South Korea to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.0;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }
				      }else if (airline.equals("Private Class") && destin.equals("South Korea to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 30890.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.0;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }
				      }else if (airline.equals("Business Class") && destin.equals("South Korea to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0 ;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				            	
				                double ticketPrice = 39650.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }
				      
				      }else if (airline.equals("Business Class") && destin.equals("South Korea to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0 ;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 39650.00 ;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				            	
				                double ticketPrice = 39650.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }
				        	
				      }else if (airline.equals("Regular Class") && destin.equals("South Korea to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }
				      }else if (airline.equals("Regular Class") && destin.equals("South Korea to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 13100.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }
				      }else if (airline.equals("Private Class") && destin.equals("Manila to Japan") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Private Class") && destin.equals("Manila to Japan") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 40450.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				          
				      }else if (airline.equals("Business Class") && destin.equals("Manila to Japan") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice- discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

					         }
				      }else if (airline.equals("Business Class") && destin.equals("Manila to Japan") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice- discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 45355.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();

					         }
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to Japan") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to Japan") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 27800.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				          
				      }else if (airline.equals("Private Class") && destin.equals("Japan to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass) + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }
				      }else if (airline.equals("Private Class") && destin.equals("Japan to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 43855.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }
				      }else if (airline.equals("Business Class") && destin.equals("Japan to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Business Class") && destin.equals("Japan to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 49780.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				          
				      }else if (airline.equals("Regular Class") && destin.equals("Japan to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Regular Class") && destin.equals("Japan to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 29400.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                	
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				          
				      }else if (airline.equals("Private Class") && destin.equals("Manila to Vietnam") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Private Class") && destin.equals("Manila to Vietnam") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 8505.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }
				      }else if (airline.equals("Business Class") && destin.equals("Manila to Vietnam") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }		    	  
				      }else if (airline.equals("Business Class") && destin.equals("Manila to Vietnam") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 12345.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }	
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to Vietnam") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				            	
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }	
				      }else if (airline.equals("Regular Class") && destin.equals("Manila to Vietnam") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				            	
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 3200.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }	
				      }else if (airline.equals("Private Class") && destin.equals("Vietnam to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	
				     }else if (airline.equals("Private Class") && destin.equals("Vietnam to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 4500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 14300.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	4260.00;	
				                double baggageFee =	1250.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	
				          
				     }else if (airline.equals("Business Class") && destin.equals("Vietnam to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }	
				     }else if (airline.equals("Business Class") && destin.equals("Vietnam to Manila") && OneRound.equals("Round Trip")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				                
				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 6500.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
					              
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	0.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
					              
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 16320.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 550.0;
				                double travelTax =	5700.00;	
				                double baggageFee =	2850.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
				              
				                
				                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }	
				     }else if (airline.equals("Regular Class") && destin.equals("Vietnam to Manila") && OneRound.equals("One Way")) {
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();		
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = ((discountedPrice + travelTax + baggageFee + travelI) * numPass)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	
				     }else if (airline.equals("Regular Class") && destin.equals("Vietnam to Manila") && OneRound.equals("Round Trip")) {		
				          if (travelInsu.equals("Yes") && Senior.equals("Yes")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                

				            }else if (travelInsu.equals("Yes") && Senior.equals("No")) { 
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 950.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();		
				                
				            }else if (travelInsu.equals("No") && Senior.equals("Yes")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0.20;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	0.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				                
				            }else if (travelInsu.equals("No") && Senior.equals("No")) {
				                double ticketPrice = 4600.00;
				                double discount = ticketPrice * 0;
				                double discountedPrice = ticketPrice - discount;
				                double processingFee = 255.0;
				                double travelTax =	2500.00;	
				                double baggageFee =	950.00;
				                double travelI = 0.00;
				                double total = (((discountedPrice + travelTax + baggageFee + travelI) * numPass)* 2)  + processingFee;
				                transaction.setName(name);
				                transaction.setAge(age);
				                transaction.setNumOfPassenger(numPass);
				                transaction.setTotal(total);
				                transaction.setTransacNum(trans);
		                
				                String transactionNumber = transaction.getTransacNum();
				                String nameTicket = transaction.getName();
				                int ageTicket = transaction.getAge();
				                
				                String numPassengerI = String.valueOf(numPass);
				                
				                Confirmation confirmationTicket = new Confirmation(transactionNumber, nameTicket, airline, destin, ageTicket, travelInsu, OneRound, Senior, numPassengerI);

				                JOptionPane.showMessageDialog(frame, "Transaction Number: " + trans + "\n" + "Processing Fee: ₱" + processingFee + "\n" + "Ticket Price: ₱" + ticketPrice + "\n" 
				                 + "Discount: ₱" + discount  + "\n" + "Discounted Price: ₱" + discountedPrice + "\n" + "Travel Tax: ₱"
				                        + travelTax + "\n" + "Baggage Fee: ₱" + baggageFee + "\n" + "Travel Insurance: ₱" + travelI + "\n" + "Total: ₱" + total + "\n" + "\n" + "\n" + "Click \"OK\" to proceed and print ticket", "SUMMARY", JOptionPane.INFORMATION_MESSAGE);
				                confirmationTicket.initialize();
				                frame.dispose();
				            }	
						
				    	
				    }
			}
				
			}
			});
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReset.setBounds(525, 610, 200, 50);
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to reset?", "Reset Confirmation", JOptionPane.WARNING_MESSAGE);
                if (confirmation == JOptionPane.YES_OPTION) {
                	l.setText(null);
                	m.setText(null);
                	n.setText(null);
                	o.setText(null);
                	p.setText(null);
                	JOptionPane.showMessageDialog(frame, "Reset performed!");
                }
            }
		});
		
		btnReturn = new JButton("RETURN");
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReturn.setBounds(760, 610, 200, 50);
		btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(frame, "Are you sure you want to return?", "", JOptionPane.WARNING_MESSAGE);
                if (confirmation == JOptionPane.YES_OPTION) {
                	pInfo_frame info = new pInfo_frame();
                	info.setVisible(true);
                	frame.dispose();
                }
			}
		});

      }
    
    //INITIALIZE METHOD FOR THE FRAME
    
    void initialize() {
		frame = new JFrame("AviaLux Airlines");
		frame.setSize(1275, 712);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.getContentPane().add(l);
        frame.getContentPane().add(m);
        frame.getContentPane().add(n);
        frame.getContentPane().add(o);
        frame.getContentPane().add(p);
        frame.getContentPane().add(controlNumberLabel);
        frame.getContentPane().add(cnumberLabel);
        frame.getContentPane().add(txtName);
        frame.getContentPane().add(btnName);
        frame.getContentPane().add(txtPassengers);
        frame.getContentPane().add(btnPassenger);
        frame.getContentPane().add(airplaneType);
        frame.getContentPane().add(txtAge);
        frame.getContentPane().add(btnAge);
        frame.getContentPane().add(travelT);
        frame.getContentPane().add(txtDestination);
        frame.getContentPane().add(travelD);
        frame.getContentPane().add(travelInsurance);
        frame.getContentPane().add(radio1);
        frame.getContentPane().add(radio2);
        frame.getContentPane().add(ifTheresAdult);
        frame.getContentPane().add(ifA);
        frame.getContentPane().add(ifThereSenior);
        frame.getContentPane().add(ifS);
        frame.getContentPane().add(btnProceed);
        frame.getContentPane().add(btnReset);
        frame.getContentPane().add(btnReturn);
        frame.setVisible(true);
        
        
    	ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		JPanel paneltop_1 = new JPanel();
		paneltop_1.setLayout(null);
		paneltop_1.setBackground(Color.blue);
		paneltop_1.setBounds(0, 0, 1259, 100);
		frame.getContentPane().add(paneltop_1);
		
		
		ImageIcon image2 = new ImageIcon("main_image2.jpg");
		JLabel lblNewLabel2 = new JLabel(image2);
		lblNewLabel2.setBounds(20, 0, 150, 100);
		paneltop_1.add(lblNewLabel2);
		
		ImageIcon image3 = new ImageIcon("progress2.jpg");
		JLabel lblNewLabel4 = new JLabel("Personal Details");
		lblNewLabel4.setForeground(new Color(255, 255, 255));
		lblNewLabel4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel4.setBounds(868, 69, 129, 20);
		paneltop_1.add(lblNewLabel4);
		
		JLabel lblNewLabel5 = new JLabel("Travel Details");
		lblNewLabel5.setBackground(new Color(192, 192, 192));
		lblNewLabel5.setForeground(new Color(255, 255, 255));
		lblNewLabel5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel5.setBounds(1025, 69, 117, 20);
		paneltop_1.add(lblNewLabel5);
		
		JLabel lblNewLabel6 = new JLabel("Confirmation");
		lblNewLabel6.setForeground(new Color(192, 192, 192));
		lblNewLabel6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel6.setBounds(1152, 69, 107, 20);
		paneltop_1.add(lblNewLabel6);
		
		JLabel lblNewLabel3 = new JLabel(image3);
		lblNewLabel3.setBounds(917, 0, 332, 100);
		paneltop_1.add(lblNewLabel3);
		
		ImageIcon image1 = new ImageIcon("travel_dets.jpg");
		
		ImageIcon imageIcon = new ImageIcon(filePath);
		Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    imageIcon = new ImageIcon(image);
	    
	    
	
		JLabel lblNewLabel_1 = new JLabel(imageIcon);
		lblNewLabel_1.setPreferredSize(new Dimension(300, 300));
		lblNewLabel_1.setBounds(1038, 143, 190, 209);
		frame.getContentPane().add(lblNewLabel_1);

		
		

		
		JLabel lblNewLabel = new JLabel(image1);	
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 100, 1259, 573);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel cnumberLabel = new JLabel();
		cnumberLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		cnumberLabel.setText("Transaction Number");
		cnumberLabel.setBounds(80, 50, 500, 209);
		frame.getContentPane().add(cnumberLabel);
		

	}
    private String generateControlNumber() {
        long randomNumber = (long) (Math.random() * 900000000000000L) + 100000000000000L;
        String controlNumber = String.valueOf(randomNumber);

        return controlNumber;
    }
    
	public static void setFilePath(String path) {
        	filePath = path;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setSenior(Boolean e) {
		
		ifS.enable();
	}
	
	public void setMinor (Boolean f) {
		ifA.enable();
	}

}