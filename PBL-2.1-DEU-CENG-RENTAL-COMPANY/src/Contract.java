public class Contract {
    private static int uniqueID = 1;
    private int officeID;
    private int contractID;
    private int customerID;
    private int carID;
    private int employeeID;
    private Date startDate;
    private Date endDate;
    public Contract(int officeID, int customerID, int employeeID, int carID, Date startDate, Date endDate) {
        this.officeID = officeID;
        this.customerID = customerID;
        this.carID = carID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeID = employeeID;
        contractID = uniqueID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getOfficeID() {
        return officeID;
    }

    public void setOfficeID(int officeID) {
        this.officeID = officeID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getContractID() {
        return contractID;
    }
    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public static int getUniqueID() {
        return uniqueID;
    }
    public static void setUniqueID(int uniqueID) {
        Contract.uniqueID = uniqueID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }
    public int getCarID() {
        return carID;
    }
    public void setCar(int carID) {
        this.carID = carID;
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