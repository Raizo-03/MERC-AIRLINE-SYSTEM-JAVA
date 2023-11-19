package Main;

public class Transaction {
	private String name;
	private int age;
	private int numOfPassenger;
	private double total;
	private String transacNum;
	
	public Transaction(String transacNum, String name, int age, int numOfPassenger, double total) {
		this.transacNum = transacNum;
		this.name = name;
		this.age = age;
		this.numOfPassenger = numOfPassenger;
		this.total = total;
	}
	public Transaction() {
	}
	public void setTransacNum(String transacNum) {
		this.transacNum = transacNum;
	}
	
	public String getTransacNum() {
		return transacNum;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNumOfPassenger() {
		return numOfPassenger;
	}
	
	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
}
