package Main;

public class Passenger {
	
	private String name;
	private int age;
	private int numOfPassenger;
	
	public Passenger(String name, int age, int numOfPassenger) {
		this.name = name;
		this.age = age;
		this.numOfPassenger = numOfPassenger;
	}
	public Passenger() {
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
}
