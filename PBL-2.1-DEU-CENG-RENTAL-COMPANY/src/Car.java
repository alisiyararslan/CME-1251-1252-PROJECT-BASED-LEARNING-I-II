
public class Car {
	private static int uniqueID = 1;
	private int carID;
	private String brand;
	private String model;
	private String _class;
	private int kilometer ;
	private boolean availibity;
	public Car(String brand, String model, String _class, int kilometer) {
		this.brand = brand;
		this.model = model;
		this._class = _class;
		this.kilometer = kilometer;
		availibity = true;
		carID = uniqueID;
		uniqueID++;
	}
	public static int getUniqueID() {
		return uniqueID;
	}

	public static void setUniqueID(int uniqueID) {
		Car.uniqueID = uniqueID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
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
	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	public int getKilometer() {
		return kilometer;
	}
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	public boolean isAvailibity() {
		return availibity;
	}
	public void setAvailibity(boolean availibity) {
		this.availibity = availibity;
	}
}
