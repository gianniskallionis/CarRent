package api;

import java.util.Objects;

/** a class that inherits from Person and adds 2 strings as fields. username and password . it has getters and setters
 * for each and a constructor giving each String a value from the given parameter. an Employee is also a user
 *
 */
public class Employee extends Person {


    private String username;
    private String  password;
// ftiakse to login me hashtable

    /**
     * returns  the current  username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * gives value  to the username from the parameter
     * @param username the username
     */
    public void setUsername(String username) {
        if(username==null) throw new IllegalArgumentException(("null username"));
        if (username.isEmpty() ) throw new IllegalArgumentException("username is empty;");
        this.username = username.trim();
    }


    /**
     * returns the  current password of the employee
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * gives value  to the password from the parameter
     * @param password the password
     */
    public void setPassword(String password) {
        if(password==null) throw new IllegalArgumentException(("null password"));
        if (password.isEmpty() ) throw new IllegalArgumentException("password is empty;");
        this.password = password.trim();
    }


    /**
     * A constructor who trims the first spaces so that the entry is smooth, checks if the strings are null or empty to ensure correct entries then sets
     * the variables with the given inputs. firstly it calls the constructor of the Api.Person class to initiate the common fields with  the Api.Customer class
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
    public Employee(String name, String surname , String username, String email , String password)
    {
       super(name,surname,email);
      setUsername((username));
       setPassword((password));
    }



    /**
     * Compares this employee with another object for equality.
     * Two employees are equal if they have the same username
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj==null ) return false;
        if (this == obj) return true;     // if compared to oneself

        if (!(obj instanceof Employee)) return false; // if it is not a customer object it cant be equal

        Employee employeeTemp = (Employee) obj;
        if(this.username==null ||employeeTemp.username==null) return false;
        return (Objects.equals(this.username.toLowerCase(), employeeTemp.username.toLowerCase()));
    }
    /**
     * Returns a hash code value for this employee.
     * The hash code is based on the username
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        if (username==null) return 0;
        return Objects.hash(username.toLowerCase());
    }
    /**
     * Returns a string representation of this employee.
     * Format: "Api.Employee [name=..., surname=..., username=..., email=...]"
     *
     * @return string representation of the employee
     */
    public String toString() {
        return String.format("Api.Employee [name= %s,surname=  %s,username= %s, email = %s ]"
                                     ,getName(),getSurname(),getUsername() ,getEmail()       );
    }



































}
