package api;

/**
 * Api.Person
 * <p>
 * Σύντομη περιγραφή της κλάσης Api.Person. IT is a class created for Inheritance purposes. it has 3 string fields. name,
 * surname and email that both Employee and Customer classes Inherit.  it creates setters and getters for each and a basic constructor
 * giving the method the value of the parameter string .
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
     * returns the current  name
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }
    /**
     * sets the name from the string of the parameter
     * @param name , the name
     */
    public void setName(String name) {
        if (name==null) throw new IllegalArgumentException("null  name ");
        if (name.trim().isEmpty() ) throw new IllegalArgumentException(("name is empty") );

        this.name = name.trim();
    }
    /**
     * returns  the  current surname
     * @return the surname
     */
    public String getSurname() {return surname;}
    /**
     * sets the surname from the string of the parameter
     * @param surname is the surname
     */
    public void setSurname(String surname) {
        if (surname==null) throw new IllegalArgumentException("null  surname ");
        if (surname.trim().isEmpty() ) throw new IllegalArgumentException(("surname is empty") );
        this.surname = surname.trim();
    }
    /**
     * returns  the current  email
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * sets   the email from the string of the parameter
     * @param email the email
     */
    public void setEmail(String email) {
        if( email==null ) throw new IllegalArgumentException("null email");
        if (!email.trim().contains("@")  ) throw new IllegalArgumentException( ("email must contain @") );
        if (email.trim().length()<3 ) throw new IllegalArgumentException(("email must  contain at least  a character before and after @  "));

        this.email = email.trim();
    }

    /** Constructor that sets the fields of the class from the strings of the parameters
     * @param name  the name
     * @param surname the surname
     * @param email the email
     * @throws IllegalArgumentException the error if any input is invalid
     *
     *
     */
    @SuppressWarnings({"AssignmentToMethodParameter"})
    public Person(String name, String surname, String email) {
       setName((name));
       setSurname((surname));
       setEmail(email);
    }



}