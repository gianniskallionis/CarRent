package api;

/**
 * has fields to initiate a rental, it combines car, employee and customer methods and instances
 */
public class Rental {

    private String code;
    private Car car;
    private Customer customer;
    private String startDate;
    private String endDate;
    private Employee employee;

    /**
     * gets code
     * @return string code
     */
    public String getCode() { return code; }

    /**
     * gets car
     * @return instance of car
     */
    public Car getCar() { return car; }

    /**
     * gets the customer
     * @return instance of customer
     */
    public Customer getCustomer() { return customer; }

    /**
     * gets start date
     * @return string of start date
     */
    public String getStartDate() { return startDate; }

    /**
     * gets end date
     * @return string of end date
     */
    public String getEndDate() { return endDate; }

    /**
     * gets employee
     * @return instance of employee
     */
    public Employee getEmployee() { return employee;  }

    /**
     * sets the code
     * @param code string
     */
    public void setCode(String code) {
        if (code==null) throw new IllegalArgumentException(("null code"));
        if (code.isEmpty()) throw new IllegalArgumentException("code is empty;");
        this.code=code.trim();
    }

    /**
     * sets the car
     * @param car instance of car
     */
    public void setCar(Car car) {
        if (car==null) throw new IllegalArgumentException(("null car"));
        if (car.getId().isEmpty()) throw new IllegalArgumentException("car is empty;");
        this.car=car;
    }

    /**
     * sets customer if not null
     * @param customer the argument
     */
    public void setCustomer(Customer customer) {
        if (customer==null) throw new IllegalArgumentException(("null customer"));
        if (customer.getAfm().isEmpty()) throw new IllegalArgumentException("customer is empty;");
        this.customer=customer;
    }

    /**
     * sets start date
     * @param startdate string
     */
    public void setStartdate(String startdate) {
        if (startdate==null) throw new IllegalArgumentException(("null startdate"));
        if (startdate.isEmpty()) throw new IllegalArgumentException("startdate is empty;");
        this.startDate=startdate.trim();
    }

    /**
     * sets enddate
     * @param enddate string
     */
    public void setEnddate(String enddate) {
        if (enddate==null) throw new IllegalArgumentException(("null enddate"));
        if (enddate.isEmpty()) throw new IllegalArgumentException("enddate is empty;");
        this.endDate=enddate.trim();
    }

    /**
     * sets employee
     * @param employee string
     */
    public void setEmployee(Employee employee) {
        if (employee==null) throw new IllegalArgumentException(("null employee"));
        if (employee.getUsername().isEmpty()) throw new IllegalArgumentException("employee is empty;");
        this.employee=employee;
    }

    /**
     * creates a new  object of type rental
     * @param code string
     * @param car string
     * @param customer string
     * @param startdate string
     * @param enddate string
     * @param employee string
     */
    public Rental(String code, Car car, Customer customer, String startdate, String enddate, Employee employee) {
        setCode(code);
        setCar(car);
        setCustomer(customer);
        setStartdate(startdate);
        setEnddate(enddate);
        setEmployee(employee);
    }

}
