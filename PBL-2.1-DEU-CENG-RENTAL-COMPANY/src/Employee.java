
public class Employee {
	private int employeeID;
	private static int uniqueID = 1;
	private String name;
	private String surname;
	private String gender;
	private Date birthDate;
	private boolean avaibility;
	public Employee(String name, String surname, String gender, Date birthDate){
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthDate = birthDate;
		employeeID = uniqueID;
		uniqueID++;
		avaibility = true;
	}
	

	public int getEmployeeID() {
		return employeeID;
	}
	public static int getUniqueID() {
		return uniqueID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public boolean isAvaibility() {
		return avaibility;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setAvaibility(boolean contract) {
		this.avaibility = contract;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
}
