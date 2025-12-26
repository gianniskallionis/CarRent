/**
 *
 */
public class Employees extends Person {


    private String username;
    private String  password;
// ftiakse to login me hashtable

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
        if(username==null) throw new IllegalArgumentException(("null username"));
        if (username.isEmpty() ) throw new IllegalArgumentException("username is empty;");
        this.username = username.trim();
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
        if(password==null) throw new IllegalArgumentException(("null password"));
        if (password.isEmpty() ) throw new IllegalArgumentException("password is empty;");
        this.password = password.trim();
    }


    /**
     * A constructor who trims the first spaces so that the entry is smooth, checks if the strings are null or empty to ensure correct entries then sets
     * the variables with the given inputs. firstly it calls the constructor of the Person class to initiate the common fields with  the Customer class
     * @param name the name of the employee
     * @param surname the surname of the employee
     * @param  username the username the employee uses to log in
     * @param  password the password the employee uses to log in
     * @param  email the email of the employee
     * @throws IllegalArgumentException the error if any input is invalid
     *
     *
     */
    @SuppressWarnings("ReassignedVariable")
    public Employee(String name, String surname , String username, String password , String email )
    {
       super(name,surname,email);
      setUsername((username));
       setPassword((password));
    }







































}
