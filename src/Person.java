/**
 * Person
 * <p>
 * Σύντομη περιγραφή της κλάσης Person.
 *
 * @author giannis
 * @version 05-Dec-25
 * @since 2025
 */
public abstract  class Person {

    private String name;
    private String surname;
    private String email;
    /**
     * gets the name
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }
    /**
     * sets the name
     * @param name , the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * gets the surname
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * sets the surname
     * @param surname is the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * gets the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * sets the email
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Constructor that sets the fields of the class
     * @param name  the name
     * @param surname the surname
     * @param email the email
     * @throws IllegalArgumentException the error if any input is invalid
     *
     *
     */
    @SuppressWarnings({"AssignmentToMethodParameter", "ReassignedVariable"})
    public Person(String name, String surname, String email) {
        if (name != null) name = name.trim();
        if (surname != null) surname = surname.trim();
        if (email != null) email = email.trim();

        if (name==null || name.isEmpty()) throw new IllegalArgumentException("invalid  name ");
        if(surname== null || surname.isEmpty())  throw new IllegalArgumentException(("invalid surname"));
        if( email==null || !(email.contains("@"))) throw new IllegalArgumentException("invalid email");

        this.name = name;
        this.surname = surname;
        this.email = email;
    }



}