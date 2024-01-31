
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
	//error check for Contract start date must be smaller than the contract end date 
	static int DateDifference(int sday, int smonth, int syear, int eday, int emonth, int eyear) {
        int dayDifference = 0;
        int i = 0;
        while(true) {
            if(sday == eday && smonth == emonth && syear == eyear) {
                dayDifference = i;
                break;
            }
            i++;
            sday++;
            if(smonth < 8) {
                if(smonth == 2 && sday > 28) {
                    smonth = 3;
                    sday = 1;
                }
                else {
                    if(smonth % 2 == 0 && sday > 30) {
                        smonth++;
                        sday = 1;
                    }
                    else if(smonth % 2 == 0 && sday > 31) {
                        smonth++;
                        sday = 1;
                    }
                }
            }
            else {
                if(smonth % 2 == 0 && sday > 31) {
                    smonth++;
                    sday++;
                }
                else if(smonth % 2 == 0 && sday > 30) {
                    smonth ++;
                    sday = 1;
                }
            }
            if(smonth > 12) {
                sday = 1;
                smonth = 1;
            }
        }
        return dayDifference;
    }

    static boolean DateComparison(int startDay, int starthMonth, int startYear, int endDay, int endMonth, int endYear) {
        boolean b = false;
        if(endYear > startYear) {
            b = true;
        }
        else if(startYear == endYear && starthMonth < endMonth) {
            b = true;
        }
        else if(startYear == endYear && starthMonth == endMonth && startDay < endDay) {
            b = true;
        }
        return b;
    }
	

			
			
	//error check for number cannot be negative
			
	public static boolean checkPositive(int number) {
		if (number<0) {
			return false;
		}
		return true;
	}
			
	static void AddCustomer(String inname, String insurname, Customer[] allCustomers, int allCustomersCounter) {
        allCustomers[allCustomersCounter] = new Customer(inname, insurname);
    }
	static void AddOffice(long inphoneNumber, String inaddress, String incity, Office[] allOffices, int allOfficesCounter) {
        allOffices[allOfficesCounter] = new Office(inphoneNumber, inaddress, incity);       
	}		
	static void ListOffice(Office[] _allOffice, int allOfficesCounter) {
		System.out.println("---------------");
		for (int i = 0; i < allOfficesCounter; i++) {
			if(!_allOffice[i].isDelete()) {
				System.out.println((i+1)+".office");
				System.out.println("Phone number :"+_allOffice[i].getPhoneNumber());
				System.out.println("Address :"+_allOffice[i].getAddress());
				System.out.println("City :"+_allOffice[i].getCity());
				System.out.println("Office ID :"+_allOffice[i].getOfficeID());
			}
		}
		System.out.println("---------------");	
	}
	
	static void ListCustomer(Customer[] allCustomers, int allCustomersCounter)
    {

        for (int i = 0; i < allCustomersCounter; i++) {
            System.out.println((i+1)+".customer");
            System.out.println("Name :"+allCustomers[i].getName());
            System.out.println("Surname :"+allCustomers[i].getSurname());
        }
    }
	static void addContract(int officeID, int customerID, int employeeID, int carID, Date startDate, Date endDate, Contract[] allContracts, int allContractsCoutner) {
        allContracts[allContractsCoutner] = new Contract(officeID, customerID, employeeID, carID, startDate, endDate);
    }
	static void AddCarRequest(int office_id, int customer_id, String brand, String model, String c_class, Date startDate, Date endDate, CarRequest[] carRequests, int carRequestCounter) {
		carRequests[carRequestCounter] = new CarRequest(office_id, customer_id, brand, model, c_class, startDate, endDate);
	}
	static void listCarRequest(CarRequest[] carRequests, int carRequestCounter)
	{
		System.out.println("---------------");
		for (int i = 0; i < carRequestCounter; i++) {
			if(carRequests[i] != null) {
				System.out.println((i + 1) + ". Car Request");
				System.out.println("Car Request Office ID : " + carRequests[i].getOffice_id());
				System.out.println("Car Request Customer ID : " + carRequests[i].getCustomer_id());
				System.out.println("Car Request Brand : " + carRequests[i].getBrand());
				System.out.println("Car Request Model : " + carRequests[i].getModel());
				System.out.println("Car Request Class : " + carRequests[i].getC_class());
				System.out.println("Car Request Start Date : " + carRequests[i].getStartDate().getDay()+"/"+carRequests[i].getStartDate().getMonth()+"/"+carRequests[i].getStartDate().getYear());
				System.out.println("Car Request End Date : " +carRequests[i].getEndDate().getDay()+"/"+carRequests[i].getEndDate().getMonth()+"/"+carRequests[i].getEndDate().getYear());
			}
		}
		System.out.println("---------------");
	}
	static void check_contract(Contract[] allContracts,int num) {

		int index=0;
		Contract[] temp_carRequests = new Contract[allContracts.length];
		for (int j = 0; j < allContracts.length; j++) {
			if (j!=num) {
				temp_carRequests[index]=allContracts[j];
				index++;
			}
		}
		for (int j = 0; j < allContracts.length; j++) {
			
			allContracts[j]=temp_carRequests[j];
				
		}
		
		
	}
	static void listContract(Contract[] allContracts, int allContractsCoutner)
	{
		System.out.println("---------------");
		for (int i = 0; i < allContractsCoutner; i++) {
			if(allContracts[i] != null) {
				System.out.println((i + 1) + ". Contract");
				System.out.println("Contract Office ID : " + allContracts[i].getOfficeID());
				System.out.println("Contract Customer ID : " + allContracts[i].getCustomerID());
				System.out.println("Car ID : " + allContracts[i].getCarID());
				System.out.println("Contract Start Date : " + allContracts[i].getStartDate().getDay()+"/"+allContracts[i].getStartDate().getMonth()+"/"+allContracts[i].getStartDate().getYear());
				System.out.println("Contract End Date : " + allContracts[i].getEndDate().getDay()+"/"+allContracts[i].getEndDate().getMonth()+"/"+allContracts[i].getEndDate().getYear());//allContracts[i].getEndDate()
			}
		}
		System.out.println("---------------");
	}
	static int[] Command(String[] inputs, Office[] allOffices, int allOfficesCounter, Customer[] allCustomers, int allCustomersCounter, CarRequest[] carRequests, int carRequestsCounter, Contract[] allContracts, int allContractsCounter,Date currentDay) {
		Random rnd = new Random();
		int[] counters = new int[4];
		switch(inputs[0]) {
		case "addOffice":{
			AddOffice(Long.parseLong(inputs[1]), inputs[2], inputs[3], allOffices, allOfficesCounter);
			allOfficesCounter++;
			break;
		}
		case "addEmployee":{
			
			String[] date = inputs[4].split("\\.");
			// ERROR ////////////////////////////////////////////////////////////////////////////////
			Date d = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			Employee p = new Employee(inputs[1], inputs[2], inputs[3], d);
			allOffices[Integer.parseInt(inputs[5]) - 1].addEmployee(p);
			break;
		}
		case "addCar":{
			Car c = new Car(inputs[1], inputs[2], inputs[3], Integer.parseInt(inputs[4]));
			allOffices[Integer.parseInt(inputs[5]) - 1].addCar(c);
			break;
		}
		case"addCustomer":{
			AddCustomer(inputs[1], inputs[2], allCustomers, allCustomersCounter);
			allCustomersCounter++;
			break;
		}
		case "addCarRequest":{
			String[] startDate = inputs[6].split("\\.");
			
			String[] endDate = inputs[7].split("\\.");
			Date sd = new Date(Integer.parseInt(startDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[2]));
			Date ed = new Date(Integer.parseInt(endDate[0]), Integer.parseInt(endDate[1]), Integer.parseInt(endDate[2]));
			AddCarRequest(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), inputs[3], inputs[4], inputs[5], sd, ed, carRequests, carRequestsCounter);
			carRequestsCounter++;
			
			if(DateComparison(sd.getDay(), sd.getMonth(), sd.getYear(), ed.getDay(), ed.getMonth(), ed.getYear())) {
				int dayDifference = DateDifference(sd.getDay(), sd.getMonth(), sd.getYear(), ed.getDay(), ed.getMonth(), ed.getYear());
				if(dayDifference > 5 || dayDifference < 0) {
					System.out.println("Error: Car requests must be for 1-4 days.");
					break;
				}
			}
			else {
				System.out.println("Error: Start date must be smaller than end date.");
			}
			Car[] cars;
			int r;
			if(allCustomersCounter < Integer.parseInt(inputs[2])) {
				System.out.println("Error: There is no customer such that.");
				break;
			}
			if(allOffices.length > Integer.parseInt(inputs[1]) && !allOffices[Integer.parseInt(inputs[1]) - 1].isDelete()) {
				cars = allOffices[Integer.parseInt(inputs[1]) - 1].getCars();
			}
			else {
				System.out.println("Error: There is no Office such that.");
				break;
			}
			boolean isExist = false;
			if(inputs[3].equals("*") && inputs[4].equals("*")) {
				for(int i = 0; i < cars.length; i++) {
					if(cars[i].get_class().equals(inputs[5])) {
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					System.out.println("Error: There is no car that class such that");
					break;
				}
				while(true) {
					r = rnd.nextInt(cars.length);
					if(cars[r].get_class().equals(inputs[5])) {
						inputs[3] = cars[r].getBrand();
						inputs[4] = cars[r].getModel();
						break;
					}
				}
			}
			else if(inputs[4].equals("*") && inputs[5].equals("*")) {
				isExist = false;
				for(int i = 0; i < cars.length; i++) {
					if(cars[i].getBrand().equals(inputs[3])) {
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					System.out.println("Error: There is no avaible car with that brand");
					break;
				}
				while(true) {
					r = rnd.nextInt(cars.length);
					if(cars[r].getBrand().equals(inputs[3])) {
						inputs[4] = cars[r].getModel();
						inputs[5] = cars[r].get_class();
						break;
					}
				}
			}
			boolean avibleCar = false;
			for(int i = 0; i < cars.length; i++) {
				if(cars[i].getBrand().equals(inputs[3]) && cars[i].getModel().equals(inputs[4]) && cars[i].get_class().equals(inputs[5]) && cars[i].isAvailibity()) {
					avibleCar = true;
					cars[i].setAvailibity(false);
					allOffices[Integer.parseInt(inputs[1]) - 1].setCars(cars);
					Employee[] employees = allOffices[Integer.parseInt(inputs[1]) - 1].getEmployees();
					boolean b = false;
					for(int j = 0; j < employees.length; j++) {
						if(employees[j] != null && employees[j].isAvaibility()) {
							b = true;
							break;
						}
					}
					if(!b) {
						System.out.println("Error:No employee for the contract");
						break;
					}
					else {
						while(true) {
							r = rnd.nextInt(3);
							if(employees[r] != null && employees[r].isAvaibility()) {
								employees[r].setAvaibility(false);	
								addContract(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), employees[r].getEmployeeID(), cars[i].getCarID(), sd, ed, allContracts, allContractsCounter);
								System.out.println("Contract:Employee" + employees[r].getEmployeeID() + "Customer" + Integer.parseInt(inputs[2]) + "CarID" + cars[i].getCarID());
								allContractsCounter++;
								break;
							}
						}
						
						break;
					}
				}
			
			}
			if(!avibleCar) {
				System.out.println("Error:No avaible car for the contract");
			}
			break;
		}
		case"addCarRequestRandom":{//-------------------------------
			Car[] cars=null;
			Car car = null;
			int random=0;
			Employee[] employees=null;
			int officeId = 0;
			int employees_counter=0;
			if (inputs[1].equals("-1")&&!inputs[2].equals("*")) {
				boolean classFlag=false;
				int _office=rnd.nextInt(allOfficesCounter);
				employees = allOffices[_office].getEmployees();
				cars = allOffices[_office].getCars();
				officeId=allOffices[_office].getOfficeID();
				for (int j = 0; j < cars.length; j++) {
					if (cars[j].get_class().equals(inputs[2])&&cars[j].isAvailibity()) {
						classFlag=true;
						break;
					}
				}
				if (!classFlag) {
					System.out.println("!!! ERROR !!! there are no cars in this class");
					break;
				}
				while (true) {
					random=rnd.nextInt(cars.length);
					if (cars[random].get_class().equals(inputs[2])&&cars[random].isAvailibity()) {
						car=cars[random];
						cars[random].setAvailibity(false);
						break;
					}
				}
			}
			else if (!inputs[1].equals("-1")&&inputs[2].equals("*")) {
				officeId=Integer.parseInt(inputs[1]);
				cars = allOffices[Integer.parseInt(inputs[1])-1].getCars();
				employees = allOffices[Integer.parseInt(inputs[1]) - 1].getEmployees();
				while (true) {
					random=rnd.nextInt(cars.length);
					if (cars[random].isAvailibity()) {
						car=cars[random];
						cars[random].setAvailibity(false);
						break;
					}
				}

				
			}
			else if(!inputs[1].equals("-1")&&!inputs[2].equals("*")) {
				boolean classFlag=false;
				employees = allOffices[Integer.parseInt(inputs[1]) - 1].getEmployees();
				cars = allOffices[Integer.parseInt(inputs[1])-1].getCars();
				officeId=Integer.parseInt(inputs[1]);
				for (int j = 0; j < cars.length; j++) {
					if (cars[j].get_class().equals(inputs[2])&&cars[j].isAvailibity()) {
						classFlag=true;
						break;
					}
				}
				if (!classFlag) {
					System.out.println("!!! ERROR !!! there are no cars in this class");
					break;
				}
				while (true) {
					random=rnd.nextInt(cars.length);
					if (cars[random].get_class().equals(inputs[2])&&cars[random].isAvailibity()) {
						car=cars[random];
						cars[random].setAvailibity(false);
						break;
					}
				}
			}
			else if (inputs[1].equals("-1") && inputs[2].equals("*")) {
				int _office=rnd.nextInt(allOfficesCounter);
				cars = allOffices[_office].getCars();
				employees = allOffices[_office].getEmployees();
				officeId=allOffices[_office].getOfficeID();
				while (true) {
					random=rnd.nextInt(cars.length);
					if (cars[random].isAvailibity()) {
						car=cars[random];
						cars[random].setAvailibity(false);
						break;
					}
				}
			}
			int employeeId=0;
			boolean employeeFlag=false;
			for (int i = 0; i < employees.length; i++) {
				if (employees[i]!=null&&employees[i].isAvaibility()) {
					employeeFlag=true;
				}
			}
			if (!employeeFlag) {
				System.out.println("!!! ERROR !!! there is no employee to make a contract");
				cars[random].setAvailibity(true);
				break;
			}
			for (int j = 0; j < employees.length; j++) {
				if (employees[j]!=null) {
					employees_counter++;
				}
			}
			while (true) {
				int random2=rnd.nextInt(employees_counter);
				if (employees[random2].isAvaibility()) {
					employees[random2].setAvaibility(false);
					employeeId=employees[random2].getEmployeeID();
					break;
				}
				
			}
			int random_day=rnd.nextInt(4)+1;
			
			Date endDate = new Date(currentDay.getDay()+random_day, currentDay.getMonth(), currentDay.getYear());
			int random_customer=rnd.nextInt(allCustomersCounter);
			if (!DateComparison(currentDay.getDay(),currentDay.getMonth(),currentDay.getYear(), endDate.getDay(),endDate.getMonth(),endDate.getYear())) {//endDate
				System.out.println("!!! DATE ERROR !!! start date cannot be greater than end date. (add Car Request Random)");
				break;
			}
			
			addContract(officeId,random_customer, employeeId, car.getCarID(),currentDay,endDate,allContracts, allContractsCounter);
			AddCarRequest(officeId, random_customer, car.getBrand(),car.getModel(),car.get_class(), currentDay, endDate, carRequests, carRequestsCounter);
			allContractsCounter++;
			carRequestsCounter++;
			break;
		}
		case"addCarRequestNRandom":{//***********************
			Car[] cars;
			Car[] _cars;
			Car car;
			Employee[] _employees;
			int random;
			Employee[] employees=null;
			int requsetsNumber=rnd.nextInt(Integer.parseInt(inputs[2])-Integer.parseInt(inputs[1])+1)+Integer.parseInt(inputs[1]);//
			int car_count=0;
			int employee_count=0;
			int countNrandom=0;
			
			for (int i = 0; i < allOfficesCounter; i++) {
				_cars = allOffices[i].getCars();
				
				for (int j = 0; j < _cars.length; j++) {
					if (_cars[j].isAvailibity()==true) {
						car_count++;
					}
				}
			}
			if (car_count<Integer.parseInt(inputs[2])) {
				System.out.println("!!! ERROR !!! there are not enough cars");
				break;
			}
			for (int i = 0; i < allOfficesCounter; i++) {
				_employees = allOffices[i].getEmployees();
				
				for (int j = 0; j < _employees.length; j++) {
					if (_employees[j]!=null&&_employees[j].isAvaibility()==true) {//_employees[j]!=null&&
						employee_count++;
					}
				}
			}
			if (employee_count<Integer.parseInt(inputs[2])) {
				System.out.println("!!! ERROR !!! there are not enough employees");
				break;
			}
			
			
			while (countNrandom<requsetsNumber) {
				
				int employees_counter=0;
				int _office=rnd.nextInt(allOfficesCounter);
				employees = allOffices[_office].getEmployees();
				int officeId=allOffices[_office].getOfficeID();
				cars = allOffices[_office].getCars();
				boolean carFlag=false;
				for (int j = 0; j < cars.length; j++) {
					if (cars[j].isAvailibity()) {
						carFlag=true;
						break;
					}
				}
				boolean employeeFlag=false;
				for (int j = 0; j < employees.length; j++) {
					if (employees[j]!=null&&employees[j].isAvaibility()) {
						employeeFlag=true;
						break;
					}
				}
				if (carFlag&&employeeFlag) {
					while (true) {
						random=rnd.nextInt(cars.length);
						if (cars[random].isAvailibity()) {
							car=cars[random];
							cars[random].setAvailibity(false);
							break;
						}
					}
					for (int j = 0; j < employees.length; j++) {
						if (employees[j]!=null) {
							employees_counter++;
						}
					}
					int employeeId=0;
					while (true) {
						int random2=rnd.nextInt(employees_counter);
						if (employees[random2].isAvaibility()) {
							employees[random2].setAvaibility(false);
							employeeId=employees[random2].getEmployeeID();
							break;
						}
						
					}

					int random_day=rnd.nextInt(4)+1;
					int random_customer=rnd.nextInt(allCustomersCounter);
					
					
					Date endDate = new Date(currentDay.getDay()+random_day, currentDay.getMonth(), currentDay.getYear());
					if (!DateComparison(currentDay.getDay(),currentDay.getMonth(),currentDay.getYear(), endDate.getDay(),endDate.getMonth(),endDate.getYear())) {
						System.out.println("!!! DATE ERROR !!! start date cannot be greater than end date. (add Car Request NRandom)");
						break;
					}
					
					AddCarRequest(officeId, random_customer, car.getBrand(),car.getModel(),car.get_class(), currentDay, endDate, carRequests, carRequestsCounter);
					addContract(officeId,random_customer, employeeId, car.getCarID(),currentDay,endDate,allContracts, allContractsCounter);
					allContractsCounter++;
					carRequestsCounter++;
					countNrandom++;
					
				}
				
				
				
				
			}
			
			break;
		}
		case "listOffice":{
			ListOffice(allOffices, allOfficesCounter);
			break;
		}
		case "listEmployee":{
			allOffices[Integer.parseInt(inputs[1]) - 1].listEmployee();
			break;
		}
		case "listCar":{
			allOffices[Integer.parseInt(inputs[1]) - 1].listCar();
			break;
		}
		case "listCustomer":{
			ListCustomer(allCustomers, allCustomersCounter);
			break;
		}
		case "listCarRequest":{
			listCarRequest(carRequests, carRequestsCounter);
			break;
		}
		case "listContract":{
			listContract(allContracts, allContractsCounter);
			break;
		}
		case "deleteOffice":{
			allOffices[Integer.parseInt(inputs[1]) - 1].setDelete(true);
			break;
		}
		case "deleteEmployee":{
			allOffices[Integer.parseInt(inputs[1]) - 1].deleteEmployee(Integer.parseInt(inputs[2]));
			break;
		}
		case "nextday":{
			for (int i = 0; i < allOfficesCounter; i++) {
				Employee[] employees = allOffices[i].getEmployees();
				for (int j = 0; j < employees.length; j++) {
					if (employees[j]!=null) {//_employees[j]!=null&&
						employees[j].setAvaibility(true);
					}
				}
			}
			
			currentDay.setDay(currentDay.getDay()+1);
			if(currentDay.getMonth() < 8) {
                if(currentDay.getMonth() == 2 && currentDay.getDay() > 28) {
                    currentDay.setMonth(3);
                    currentDay.setDay(1);
                }
                else {
                    if(currentDay.getMonth() % 2 == 0 && currentDay.getDay() > 30) {
                        currentDay.setMonth(currentDay.getMonth() + 1);
                        currentDay.setDay(1);
                    }
                    else if(currentDay.getMonth() % 2 == 0 && currentDay.getDay() > 31) {
                        currentDay.setMonth(currentDay.getMonth() + 1);
                        currentDay.setDay(1);
                    }
                }
            }
            else {
                if(currentDay.getMonth() % 2 == 0 && currentDay.getDay() > 31) {
                    currentDay.setMonth(currentDay.getMonth() + 1);
                    currentDay.setDay(1);
                }
                else if(currentDay.getMonth() % 2 == 0 && currentDay.getDay() > 30) {
                    currentDay.setMonth(currentDay.getMonth() + 1);
                    currentDay.setDay(1);
                }
            }
            if(currentDay.getMonth() > 12) {
                currentDay.setMonth(1);
            }
            System.out.println("Current day: " + currentDay.getDay() + "." + currentDay.getMonth() + "." + currentDay.getYear());
			Employee[] _employees;
			System.out.println("--- Office Profits ----");
			for (int i = 0; i < allOfficesCounter; i++) {
				int incomes=0;
				int expenses=0;
				int office_rent=100;
				int salaries=0;
				int vehicle_maintenance=0;
				Car[] cars=allOffices[i].getCars();
				Car _car = null;
				for (int j = 0; j < allContractsCounter; j++) {
					if (allOffices[i].getOfficeID()==allContracts[j].getOfficeID()) {
						int car_travels= rnd.nextInt(3)+1;
						for (int k = 0; k < cars.length; k++) {
							if (cars[k].getCarID()==allContracts[j].getCarID()) {
								 _car=cars[k];
								 break;
							}
						}
						if (_car.get_class().equals("economy")) {//"economy"
							incomes+=100;
							salaries+=5;
							vehicle_maintenance=vehicle_maintenance+20+car_travels*5;
						}
						else if (_car.get_class().equals("sports")) {
							incomes+=200;
							salaries+=10;
							vehicle_maintenance=vehicle_maintenance+70+car_travels*10;
						}
						else if (_car.get_class().equals("luxury")) {
							incomes+=300;
							salaries+=15;
							vehicle_maintenance=vehicle_maintenance+120+car_travels*15;
						}
					}
				}
				int _employees_counter=0;
				_employees = allOffices[i].getEmployees();
				for (int j = 0; j < _employees.length; j++) {
					if (_employees[j]!=null) {
						_employees_counter++;
					}
				}
				for (int j = 0; j < _employees_counter; j++) {
					salaries+=30;
				}
				expenses=salaries+vehicle_maintenance+office_rent;
				System.out.println("Office"+(i+1)+" incomes: "+incomes);
				System.out.println("Office"+(i+1)+" expenses: "+expenses);
				System.out.println("       Office rent: "+office_rent);
				System.out.println("       Employee salaries: : "+salaries);
				System.out.println("       Vehicle_maintenance: : "+vehicle_maintenance);
				System.out.println("Office"+(i+1)+" profit: "+(incomes-expenses));
				System.out.println();
				
				
			}
			
			
			
			for (int i = 0; i < allContractsCounter; i++) {
				if (allContracts[i].getEndDate().getDay()==currentDay.getDay()&&allContracts[i].getEndDate().getMonth()==currentDay.getMonth()&&allContracts[i].getEndDate().getMonth()==currentDay.getMonth()) {
					Car[] cars=allOffices[allContracts[i].getOfficeID()-1].getCars();
					
					for (int k = 0; k < cars.length; k++) {
						if (cars[k].getCarID()==allContracts[i].getCarID()) {
							 cars[k].setAvailibity(true);
							 
						}
					}
//					
					
					check_contract(allContracts,i);
					i--;
					allContractsCounter--;
					
					
				}
			}
			
			int day = currentDay.getDay() - 10;
			int month = currentDay.getMonth();
			int year = currentDay.getYear();
			if(day <= 0) {
				day = 30 + day;
				month -= 1;
				if(month  == 0) {
					month = 12;
					year -= 1;
				}
			}
			for(int k = 0; k < allOfficesCounter; k++) {
				System.out.println("Office" +  (k + 1) + ":");
				int[] carFreq = new int[51];
				int[] classFreq = new int[3];
				int[] customerFreq = new int[51];
				int[] employeeFreq = new int[51];
				Arrays.fill(carFreq, 0);
				Arrays.fill(customerFreq, 0);
				Arrays.fill(employeeFreq, 0);
				Arrays.fill(classFreq, 0);
				int sumOfDayDifferences = 0;
				int counterOfDayDifference = 0;
				for(int i = 0; i < allContractsCounter; i++) {
					Date sd = allContracts[i].getStartDate();
					Date ed = allContracts[i].getEndDate();
					if(allContracts[i].getOfficeID() == k + 1 && DateComparison(day, month, year, sd.getDay(), sd.getMonth(), sd.getYear())) {
						sumOfDayDifferences += DateDifference(sd.getDay(), sd.getMonth(), sd.getYear(), ed.getDay(), ed.getMonth(), ed.getYear());
						counterOfDayDifference++;	
						carFreq[allContracts[i].getCarID() - 1]++; //
						Car[] c = allOffices[allContracts[i].getOfficeID() - 1].getCars();
						for(int j = 0; j < c.length; j++) { //
							if(c[j].getCarID() == allContracts[i].getCarID()) {
								if(c[j].get_class().equals("economy")) {
									classFreq[0]++;
								}
								else if(c[j].get_class().equals("sports")) {
									classFreq[1]++;
								}
								else if(c[j].get_class().equals("luxury")) {
									classFreq[2]++;
								}
								break;
							}
						}
						customerFreq[allContracts[i].getCustomerID() - 1]++;
						Employee[] e = allOffices[allContracts[i].getOfficeID() - 1].getEmployees();
						for(int j = 0; j < e.length; j++) { //
							if(e[j].getEmployeeID() == allContracts[i].getEmployeeID()) {							
								employeeFreq[e[j].getEmployeeID()]++;
								break;
							}
						}
					}
				}
				
				int id = 0;
				int maxFreq = 0;
				for(int i = 0; i < carFreq.length; i++) {
					if(carFreq[i] > maxFreq) {
						id = i + 1;
						maxFreq = carFreq[i];
					}
				}
				Car[] cars = allOffices[k].getCars();
				for(int i = 0; i < cars.length; i++) {
					if(cars[i].getCarID() == id) {
						System.out.println("The most rented car: Car" + id + ";" + cars[i].getBrand() + ";" + cars[i].getModel());
						break;
					}
				}
				
				int maxClass = 0;
				int maxClassFreq = 0;
				for(int i = 0; i < classFreq.length; i++) {
					if(maxClassFreq < classFreq[i]) {
						maxClassFreq = classFreq[i];
						maxClass = i;
					}
				}
				String carClass = "";
				if(maxClass == 0) {
					carClass = "economy";
				}
				else if(maxClass == 1) {
					carClass = "sports";
				}
				else if(maxClass == 2) {
					carClass = "luxury";
				}
				System.out.println("The most rented car Class: " + carClass);
				id = 1;
				maxFreq = 0;
				for(int i = 0; i < customerFreq.length; i++) {
					if(customerFreq[i] > maxFreq) {
						id = i + 1;
						maxFreq = customerFreq[i];
					}
				}
				if(counterOfDayDifference != 0) {
					System.out.println("The average number of days the cars are rented: " + (sumOfDayDifferences / counterOfDayDifference));
				}
				
				
				System.out.println("The customer who rented most: Customer" + id + ";" + allCustomers[id - 1].getName() + allCustomers[id - 1].getSurname());
				id = 0;
				maxFreq = 0;
				for(int i = 0; i < employeeFreq.length; i++) {
					if(employeeFreq[i] > maxFreq) {
						id = i + 1;
						maxFreq = employeeFreq[i];
					}
				}
				Employee[] employees = allOffices[k].getEmployees();
				for(int i = 0; i < employees.length; i++) {
					if(employees[i] != null && employees[i].getEmployeeID() == id) {
						System.out.println("The most rented car: Employee" + id + ";" + employees[i].getName() + ";" + employees[i].getSurname());
						break;
					}
				}
			}
			break;
		}
		}
		counters[0] = allOfficesCounter;
		counters[1] = allCustomersCounter;
		counters[2] = carRequestsCounter;
		counters[3] = allContractsCounter;
		return counters;
	}
	public static void main(String[] args) {
		Date currentDay=new Date(1,1,2021);
		CarRequest[] carRequests = new CarRequest[50];
		int carRequestsCounter = 0;
		Office[] allOffices = new Office[50];
		int allOfficesCounter = 0;
        Customer[] allCustomers = new Customer[50];
        int allCustomersCounter = 0;
        Contract[] allContracts = new Contract[50];
        int allContractsCounter = 0;
        Scanner scn = new Scanner(System.in);
        Random random=new Random();
        // main game loop
		while(true) {
			System.out.print(">>>");
			String input = scn.nextLine();
			String[] inputs = input.split(";");
			if(inputs[0].equals("load")) {
				try {
				      File myObj = new File(inputs[1]);
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        System.out.println(">" + data);
				        inputs = data.split(";");
				        int[] counters = Command(inputs, allOffices, allOfficesCounter, allCustomers, allCustomersCounter, carRequests, carRequestsCounter, allContracts, allContractsCounter,currentDay);
				        allOfficesCounter = counters[0];
				        allCustomersCounter =counters[1];
				        carRequestsCounter = counters[2];
				        allContractsCounter = counters[3];
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
			else {
				int[] counters = Command(inputs, allOffices, allOfficesCounter, allCustomers, allCustomersCounter, carRequests, carRequestsCounter, allContracts, allContractsCounter,currentDay);
		        allOfficesCounter = counters[0];
		        allCustomersCounter =counters[1];
		        carRequestsCounter = counters[2];
		        allContractsCounter = counters[3];
			}
		}
		
	}
}