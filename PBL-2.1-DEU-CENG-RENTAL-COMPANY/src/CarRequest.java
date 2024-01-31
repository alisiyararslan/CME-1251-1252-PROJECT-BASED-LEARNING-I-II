
public class CarRequest {
	private static int uniqueID = 1;
	private int office_id;
	private int customer_id;
	private String brand;
	private String model;
	private String c_class;
	private Date startDate;
	private Date endDate;
	
	public CarRequest(int office_id, int customer_id, String brand, String model, String c_class, Date startDate, Date endDate) {
		this.office_id = office_id;
		this.customer_id = customer_id;
		this.brand = brand;
		this.model = model;
		this.c_class = c_class;
		this.startDate = startDate;
		this.endDate = endDate;
		
		
	}
	
	
	
	public static void addContract() {
		
	}

	public static int getUniqueID() {
		return uniqueID;
	}

	public static void setUniqueID(int uniqueID) {
		CarRequest.uniqueID = uniqueID;
	}
	
	

	public int getOffice_id() {
		return office_id;
	}

	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getC_class() {
		return c_class;
	}

	public void setC_class(String c_class) {
		this.c_class = c_class;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
