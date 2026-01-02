import java.util.HashMap;
import java.util.ArrayList;
/**
 * EmployeeManager
 * <p>
 * the log in and other stuff happen here
 *
 * @author giannis
 * @version 06-Dec-25
 * @since 2025
 */
public class EmployeeManager {
    HashMap<String,Employee> employeesByUsername;
Employee currentUser;



    public EmployeeManager() {
        employeesByUsername = new HashMap<>();
    }

    /**
     * first it checks if the argument is valid . then if calls search by email and search by username
     * to ensure no employee with these 2 already exists. if it doesn't exist , it gets added to the
     * hashmap logins . otherwise the method returns false indicating it could not add the user
     * @param emp1 the instance of the employee addUser is trying to add to the hashmap
     * @return if it returns true the attempt was fruitful otherwise it was futile.
     */
    public boolean  addUser(Employee emp1)
    {
        if ( emp1==null || emp1.getUsername()==null ||emp1.getUsername().trim().isEmpty())
        {return false;}

            if (  searchByEmail(emp1.getEmail() ) ==  null   && searchByUsername(emp1.getUsername()) ==null     ) // an ==null den yparxei to email ,username ara mporw add
            {
                employeesByUsername.put(emp1.getUsername().trim().toLowerCase(),emp1); // prosthetw ton emp1 sto hashmap
                return true;
            }
            else return false;
        }


    /** it has an instance of employees for argument. it calls searchBbyEmail and searchByUsername to Ensure
     * that the instance has both its email and username registered on the hashmap ,and then it removes the
     * key(username) thus the duet(username->employee) .
     *
     * @param emp1 the instance of Employees that is being given as an argument
     * @return if the method was successful it returns true. otherwise it returns false
     */
    public boolean deleteUser(Employee emp1) {
        if (emp1 == null || emp1.getUsername() == null) return false;
        if (employeesByUsername.containsKey(emp1.getUsername().trim().toLowerCase())) {
            employeesByUsername.remove(emp1.getUsername().trim().toLowerCase());
            return true;
        }
        return false;
    }

    /**an enumeration used to explain the reason if loginUser can not log in the user
     *
     *
     */
     public enum loginStatus{
        /** if the loginuser method is successful meanning the username exists and is the key to the password
         * in the logins hashmap then the user is now logged in
         */
     success,
        /** if the username is null then the loginuser method terminates with the wrong_username indication
         */
wrong_username,
        /**  if the password is not the value to the key username then it terminates with the
         * wrong password indication
         */
wrong_password;
     }

    /** checks if : the argument emp1 is null, if the username exists ( if it does not  it returns wrong username)
     * also checks if the instance of employee logins.get(key) is null , if it isnt it then checks if its method getpassword is null
     * if it isnt it checks if the argument's method getpassword is null. if NONE are it checks if the normalized passowrd is equal to the
     * normalized password of the argument . if they are, then it goes through and the CurrentUser in the application becomes the one we are
     * dealing with right now.if it doesnt go through then a wrong_password  return status occurs and  current user is set to null
     *   logins.get(emp1.getUsername()).trim().toLowerCase() is the key normalized
     * @param emp1 the argument , its an instance of employee used to try to Log him into the application
     * @return if the return is wrong username  then it means there is an error concerning the username. same with the wrong password
     * if the return status is success then  all went well
     */
    public loginStatus loginUser(Employee emp1) {
        if ( emp1==null || searchByUsername(emp1.getUsername()) == null)
        {currentUser=null;
return loginStatus.wrong_username;   }// failsafe gia an einai valid to username

        String key=emp1.getUsername().trim().toLowerCase();
if (  employeesByUsername.get(key)==null ||employeesByUsername.get(key).getPassword() ==null || emp1.getPassword()==null || ! employeesByUsername.get(key).getPassword().equals(emp1.getPassword())  )  // lathos kwdikos
{currentUser=null;
    return loginStatus.wrong_password;}
currentUser=employeesByUsername.get(key);
return loginStatus.success;
}


    /**
     *
     *
     * @return
     */
    public boolean logoutUser(){
if (currentUser!=null) // an egine me epityxia login tote currentuser=oxi null
{
currentUser=null;
return true;}// etsi kanw logout;
    return false;
}








    public Employee searchByEmail(String email1)
{
    if (email1==null || email1.isEmpty() ) return null;
    String t2= email1.trim().toLowerCase();
    for (Employee x:employeesByUsername.values()) // kanei iterate olo to hashmap logins<username,Employees>
    {
        if(x.getEmail()== null ) continue; // αν το email toy stoixeiou tou logins == null, proxwraei ston epomeno
        String t1=  x.getEmail().trim().toLowerCase();
        if (t1.equals(t2) )
        {return x;}
    }
    return null;  // an den vrei employee me auto to email returns null
}


 public Employee searchByUsername(String username1)
 {
     if(username1==null || username1.trim().isEmpty()){return null;}
     return employeesByUsername.get(username1.trim().toLowerCase());
 }

    public ArrayList<Employee> getAllEmployees() {

        return new ArrayList<>(employeesByUsername.values());
    }




}



































