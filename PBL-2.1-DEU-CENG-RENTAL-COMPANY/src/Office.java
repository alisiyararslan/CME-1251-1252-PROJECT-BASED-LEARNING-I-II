
public class Office {
	private Car[] cars = new Car[0];
	private long phoneNumber;
	private String address;
	private String city;
	private int officeID;
	private static int uniqueID = 1;
	private  int count;
	private Employee[] employees;
	private boolean delete;
	public Office(long phoneNumber, String address, String city){
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		officeID = uniqueID;
		uniqueID++;
		employees = new Employee[3];//!
		count = 0;
		delete = false;
	}
	
	public void addEmployee(Employee person) {
		if (count < 3) {
			for (int i = 0; i < employees.length; i++) {
				if (employees[i] == null) {
					employees[i] = person;
					count++;
					break;
				}
			}
		}
		else {
			System.out.println("Office is full.");
		}
	}
	
	public void deleteEmployee(int employeeID) {
        for (int j = 0; j < employees.length; j++) {
        	if (employees[j].getEmployeeID()==employeeID) {
        		employees[j]=null;
        		count--;
        		break;
			}
            
        }
    }
	
	
	public void listEmployee()
	{
		for (int i = 0; i < employees.length; i++) {
			if(employees[i] != null) {
				System.out.println((i+1)+".employee");
				System.out.println("ID:" +employees[i].getEmployeeID());
				System.out.println("Name :"+employees[i].getName());
				System.out.println("Surname :"+employees[i].getSurname());
				System.out.println("Gender :"+employees[i].getGender());
				System.out.println("Birth Date :"+employees[i].getBirthDate().getDay()+"/"+employees[i].getBirthDate().getMonth()+"/"+employees[i].getBirthDate().getYear());
			}
		}
	}
	public void addCar(Car auto) {
        Car[] newCars = new Car[cars.length+1];

        if (cars.length > 0) {
            for (int i = 0; i < cars.length; i++) 
                newCars[i] = cars[i];
        }
        newCars[cars.length] = auto;
        cars = newCars;
    }
	public void listCar()
	{
		for (int i = 0; i < cars.length; i++) {
			
			System.out.println((i+1)+".car");
			System.out.println("Brand :"+cars[i].getBrand());
			System.out.println("Model :"+cars[i].getModel());
			System.out.println("Class :"+cars[i].get_class());
			System.out.println("Kilometer :"+cars[i].getKilometer());
			System.out.println("Office ID :"+ officeID);
			System.out.println("Avaiblitiy: " + cars[i].isAvailibity());
			
		}
	}
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public Car[] getCars() {
		return cars;
	}
	public void setCars(Car[] cars) {
		this.cars = cars;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getOfficeID() {
		return officeID;
	}
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}
	public Employee[] getEmployees() {
		return employees;
	}
	public  int getCount() {
		return count;
	}

	public  void setCount(int count) {
		//Office.count = count;
		this.count = count;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public void setEmpoyees(Employee[] empoyees) {
		this.employees = empoyees;
	}
}
