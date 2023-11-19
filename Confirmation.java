package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Confirmation implements ActionListener {
    private JFrame frame;
    private JLabel tran, nameI, airlineTypeI, destin, destinAb, ageI, travelInsu, tripT, seniorI, 
    numPas, departure, arrival, depTime, arrTime, bookDate, bookTime, upperClass;

    public Confirmation() {
        //initialize();
    }
    public Confirmation(String transac, String name, String airlineType, String destination, int age, String travelInsurance, String tripType, String senior, String numPass) {
    	tran = new JLabel();
    	tran.setText(transac);
    	tran.setFont(new Font("Tahoma", Font.BOLD, 27));
    	tran.setBounds(60, 300, 300, 40);
    	
    	nameI = new JLabel();
        String nameLabel = name;
        String uppercaseName = nameLabel.toUpperCase();
    	nameI.setText(uppercaseName);
    	nameI.setFont(new Font("Antonio", Font.BOLD, 16));
    	nameI.setBounds(753, 80, 200, 50);
    	
    	airlineTypeI = new JLabel();
        String airlineLabel = airlineType;
        String uppercaseAirline = airlineLabel.toUpperCase();
    	airlineTypeI.setText(uppercaseAirline);
    	airlineTypeI.setFont(new Font("Antonio", Font.BOLD, 20));
    	airlineTypeI.setBounds(440, 80, 200, 50);
    	
    	destin = new JLabel();
    	String destinLabel = destination;
        String uppercaseDestin = destinLabel.toUpperCase();
        destin.setText(uppercaseDestin);
        destin.setBounds(440, 160, 300, 50);
    	destin.setFont(new Font("Antonio", Font.BOLD, 16));
    	
    	destinAb = new JLabel();
    	if (destination.equals("Manila to Batanes")) {
    		destinAb.setText("MNL          BTN");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
            
    	}else if (destination.equals("Batanes to Manila")) {
    		destinAb.setText("BTN          MNL");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
            
    	}else if (destination.equals("Manila to Palawan")) {
    		destinAb.setText("MNL          PLW");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
            
    	}else if (destination.equals("Palawan to Manila")) {
    		destinAb.setText("PLW          MNL");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("Manila to South Korea")) {
    		destinAb.setText("MNL          SKR");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("South Korea to Manila")) {
    		destinAb.setText("SKR          MNL");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("Manila to Japan")) {
    		destinAb.setText("MNL          JPN");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("Japan to Manila")) {
    		destinAb.setText("JPN          MNL");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("Manila to Vietnam")) {
    		destinAb.setText("MNL          VNM");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}else if (destination.equals("Vietnam to Manila")) {
    		destinAb.setText("VNM          MNL");
    		destinAb.setFont(new Font("Antonio", Font.BOLD, 35));
            destinAb.setBounds(5, 75, 300, 50);
            destinAb.setForeground(Color.YELLOW);
    	}
    	
    	ageI = new JLabel();
    	String ageP = String.valueOf(age);
    	ageI.setText(ageP);
    	ageI.setFont(new Font("Antonio", Font.BOLD, 20));
    	ageI.setBounds(753, 160, 200, 50);
    	
    	travelInsu = new JLabel();
    	 String insuranceLabel = travelInsurance;
        String uppercaseInsu = insuranceLabel.toUpperCase();
        travelInsu.setText(uppercaseInsu);
        travelInsu.setFont(new Font("Antonio", Font.BOLD, 17));
        travelInsu.setBounds(440, 220, 200, 50);
        
        tripT = new JLabel();
        String triptLabel = tripType;
        String uppercaseTripT = triptLabel.toUpperCase();
        tripT.setText(uppercaseTripT);
        tripT.setFont(new Font("Antonio", Font.BOLD, 17));
        tripT.setBounds(753, 220, 200, 50);
        
        
        seniorI = new JLabel();
        String seniorLabel = senior;
        String uppercaseSenior = seniorLabel.toUpperCase();
        seniorI.setText(uppercaseSenior);
        seniorI.setFont(new Font("Antonio", Font.BOLD, 17));
        seniorI.setBounds(585, 220, 200, 50);
        
        numPas = new JLabel();
        numPas.setText(numPass);
        numPas.setFont(new Font("Antonio", Font.BOLD, 20));
        numPas.setBounds(880, 160, 200, 50);
        
        LocalDate randomDate = generateRandomDate();
        String formattedDate = formatAsDayMonthYear(randomDate);

        departure = new JLabel();
        departure.setText(formattedDate);
        departure.setFont(new Font("Antonio", Font.BOLD, 20));
        departure.setBounds(438, 280, 200, 50);
        
        LocalTime randomTime = generateRandomTime();
        LocalTime randomTime2 = generateRandomTime2();
        String formattedTime = formatAs12HourClock(randomTime);
        String formattedTime2 = formatAs12HourClock2(randomTime2);
        
        depTime = new JLabel();
        depTime.setText(formattedTime);
        depTime.setFont(new Font("Antonio", Font.BOLD, 20));
        depTime.setBounds(438, 320, 200, 50);
        
        
        arrival = new JLabel();
        String arriv = departure.getText();
        arrival.setText(arriv);
        arrival.setFont(new Font("Antonio", Font.BOLD, 20));
        arrival.setBounds(580, 280, 200, 50);
        
        arrTime = new JLabel();
        arrTime.setText(formattedTime2);
        arrTime.setFont(new Font("Antonio", Font.BOLD, 20));
        arrTime.setBounds(580, 320, 200, 50);
        
        
        LocalDate currentDate = LocalDate.now();
        String formattedDate3 = formatDate(currentDate);
        bookDate = new JLabel();
        bookDate.setText(formattedDate3);
        bookDate.setFont(new Font("Antonio", Font.BOLD, 20));
        bookDate.setBounds(753, 280, 200, 50);

        LocalTime currentTime = LocalTime.now();
        String formattedTime3 = formatTime(currentTime);
        bookTime = new JLabel();
        bookTime.setText(formattedTime3);
        bookTime.setFont(new Font("Antonio", Font.BOLD, 20));
        bookTime.setBounds(753, 320, 200, 50);
        
        
        upperClass = new JLabel();
        if (airlineType.equals("Private Class")) {
        	upperClass.setText("PRIVATE");
        	upperClass.setFont(new Font("Antonio", Font.ITALIC, 25));
        	upperClass.setBounds(810, 2, 200, 50);
        }else if (airlineType.equals("Business Class")) {
        	upperClass.setText("BUSINESS");
        	upperClass.setFont(new Font("Antonio", Font.ITALIC, 25));
        	upperClass.setBounds(810, 2, 200, 50);
        }else if (airlineType.equals("Regular Class")) {
        	upperClass.setText("REGULAR");
        	upperClass.setFont(new Font("Antonio", Font.ITALIC, 25));
        	upperClass.setBounds(810, 2, 200, 50);
        }
    }

    void initialize() {
        frame = new JFrame("AviaLux Airlines");
        frame.setSize(1000, 430);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(tran);
		frame.getContentPane().add(nameI);
		frame.getContentPane().add(airlineTypeI);
		frame.getContentPane().add(destin);
		frame.getContentPane().add(destinAb);
		frame.getContentPane().add(ageI);
		frame.getContentPane().add(travelInsu);
		frame.getContentPane().add(tripT);
		frame.getContentPane().add(seniorI);
		frame.getContentPane().add(numPas);
		frame.getContentPane().add(departure);
		frame.getContentPane().add(depTime);
		frame.getContentPane().add(arrival);
		frame.getContentPane().add(arrTime);
		frame.getContentPane().add(bookDate);
		frame.getContentPane().add(bookTime);
		frame.getContentPane().add(upperClass);


		ImageIcon mainIcon = new ImageIcon("main_icon.jpg");
		frame.setIconImage(mainIcon.getImage());
		
		ImageIcon image1 = new ImageIcon("ticket.png");

        // Create a JLabel as the background
        JLabel backgroundLabel = new JLabel(image1);
        backgroundLabel.setOpaque(true);
        backgroundLabel.setBackground(Color.LIGHT_GRAY);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getContentPane().add(backgroundLabel);
		

        frame.setVisible(true);

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}    
    public static LocalDate generateRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2023, 6, 1).toEpochDay();
        int maxDay = (int) LocalDate.now().toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static String formatAsDayMonthYear(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, MMMM, yyyy");
        return date.format(formatter);
    }
    
    public static LocalTime generateRandomTime() {
        Random random = new Random();
        int hour = random.nextInt(12) + 1; // 1 to 12
        int minute = random.nextInt(60); // 0 to 59
        return LocalTime.of(hour, minute);
    }

    public static String formatAs12HourClock(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return time.format(formatter);
    }
    
    public static LocalTime generateRandomTime2() {
        Random random = new Random();
        int hour = random.nextInt(12) + 1; // 1 to 12
        int minute = random.nextInt(60); // 0 to 59
        return LocalTime.of(hour, minute);
    }

    public static String formatAs12HourClock2(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return time.format(formatter);
    }
   
    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, MMMM, yyyy");
        return date.format(formatter);
    }
    
    public static String formatTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return time.format(formatter);
    }
}
