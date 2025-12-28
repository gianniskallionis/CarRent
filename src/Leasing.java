import java.util.Objects;


public class Leasing {

    private String code;
    private Car car;
    private Customer customer;
    private String startdate;
    private String enddate;
    private Employee employee;

    public String getCode() { return code; }

    public Car getCar() { return car; }

    public Customer getCustomer { return customer; }

    public String getStartdate() { return startdate; }

    public String getEnddate() { return enddate; }

    public Employee getEmployee() { return employee;  }

    public void setCode(String code) {
        if (code == null) throw new IllegalArgumentException(("null code"));
        if (code.isEmpty()) throw new IllegalArgumentException("code is empty;");
        this.code = code.trim();
    }

    public void setCar(Car car) {
        if (car == null) throw new IllegalArgumentException(("null car"));
        if (car.getId().isEmpty()) throw new IllegalArgumentException("car is empty;");
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException(("null customer"));
        if (customer.getAfm().isEmpty()) throw new IllegalArgumentException("customer is empty;");
        this.customer = customer;
    }

    public void setStartdate(String startdate) {
        if (startdate == null) throw new IllegalArgumentException(("null startdate"));
        if (startdate.isEmpty()) throw new IllegalArgumentException("startdate is empty;");
        this.startdate = startdate.trim();
    }

    public void setEnddate(String enddate) {
        if (enddate == null) throw new IllegalArgumentException(("null enddate"));
        if (enddate.isEmpty()) throw new IllegalArgumentException("enddate is empty;");
        this.enddate = enddate.trim();
    }

    public void setEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException(("null employee"));
        if (employee.getUsername().isEmpty()) throw new IllegalArgumentException("employee is empty;");
        this.employee = employee;
    }

    public Leasing(String code, Car car, Customer customer, String startdate, String enddate, Employee employee) {
        setCode(code);
        setCar(car);
        setCustomer(customer);
        setStartdate(startdate);
        setEnddate(enddate);
        setEmployee(employee);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj==null ) return false;
        if (this == obj) return true;     // if compared to oneself

        if (!(obj instanceof Leasing)) return false; // if it is not a leasing object it cant be equal

        Leasing leasingTemp = (Leasing) obj;
        if(this.code==null || leasingTemp.code==null) return false;
        return (Objects.equals(this.code.toLowerCase(), leasingTemp.code.toLowerCase()));
    }

    @Override
    public int hashCode() {
        if (code==null) return 0;
        return Objects.hash(code.toLowerCase());
    }

    public String toString() {
        return String.format("Leasing [ code= %s, car= %s,customer=  %s, startdate= %s, enddate= %s, employee= %s ]",
                getCode() ,getCar(),getCustomer(),getStartdate(),getEnddate(),getEmployee()     );
    }

}
