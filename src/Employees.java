/**
 *
 */
public class Employees {

    private String employeeName ;
    private String employeeSurname;
    private String username;
    private String employeeEmail;
    private String  password;

    /**
     * returns the name of the employee
     * @return the name
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * sets the name of the employee
     * @param employeeName the name of the employee
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * gets the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets the email of the employee
     * @return the email
     */
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    /**
     * sets the email of the employee
     * @param employeeEmail the email
     */
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    /**
     * gets the password of the employee
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password of the employee
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * gets the surname of the employee
     * @return the surname
     */
 public String getEmployeeSurname(){
        return employeeSurname;
 }

    /**
     * sets the surname of the employee
     * @param employeeSurname the surname of the employee
     */
 public void setEmployeeSurname(String employeeSurname){
     this.employeeSurname=employeeSurname;
 }

    /**
     * A constructor who trims the first spaces so that the entry is smooth, checks if the strings are null or empty to ensure correct entries then sets
     * the variables with the given inputs.
     * @param employeeName the name of the employee
     * @param employeeSurname the surname of the employee
     * @param  username the username the employee uses to login
     * @param  password the password the employee uses to login
     * @param  employeeEmail the email of the employee
     * @throws IllegalArgumentException the error if any input is invalid
     *
     *
     */
    @SuppressWarnings("ReassignedVariable")
    public Employees(String employeeName, String employeeSurname , String username, String password , String employeeEmail )
    {
       if  (employeeName!= null) employeeName=employeeName.trim();
       if (employeeSurname !=null) employeeSurname=employeeSurname.trim();
       if (username!=null) username=username.trim();
       if (password !=null) password=password.trim();
       if (employeeEmail!=null)  employeeEmail=employeeEmail.trim();

       if (employeeName==null || employeeName.isEmpty()) throw new IllegalArgumentException("invalid employee name");
       if (employeeSurname==null ||employeeSurname.isEmpty()) throw new IllegalArgumentException("invalid employee surname");
       if (username==null || username.isEmpty()) throw new IllegalArgumentException("invalid username");
       if (password==null || password.isEmpty()) throw new IllegalArgumentException("invalid password ");
       if (employeeEmail == null || !employeeEmail.contains("@")) throw new IllegalArgumentException("invalid email");
    }







































}
