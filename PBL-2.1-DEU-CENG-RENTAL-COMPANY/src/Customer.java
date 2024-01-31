
public class Customer {
	private static int uniqueID = 1;
	private int customerID;
	private String name;
	private String surname;
	public Customer( String name, String surname) {
		this.name = name;
		this.surname = surname;
		customerID = uniqueID;
		uniqueID++;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void listCustomer() {
		System.out.println("ID:" + customerID);
		System.out.println("name : "+name);
		System.out.println("surname : "+surname);
		
	}
	
}


