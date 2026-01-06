package api;

import java.util.Objects;


/**
 * an instance of car with all its fields being strings  it has setters and getters for each and every one.
 */
public class Car {

    private String id;
    private String plate;
    private String brand;
    private String type;
    private String model;
    private String year;
    private String color;
    private String status;


    /** gets id
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * gets the plate
     * @return plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * gets brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * gets the type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * gets model
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * gets year
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * gets color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * gets status
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * sets the id
     * @param id string
     */
    public void setId(String id) {
        if (id==null) throw new IllegalArgumentException(("null id"));
        if (id.isEmpty()) throw new IllegalArgumentException("id is empty;");
        this.id=id.trim();
    }

    /**
     * sets plate
     * @param plate string
     */
    public void setPlate(String plate) {
        if (plate==null) throw new IllegalArgumentException(("null plate"));
        if (plate.isEmpty()) throw new IllegalArgumentException("plate is empty;");
        this.plate=plate.trim();
    }

    /**
     * sets the brand
     * @param brand string
     */
    public void setBrand(String brand) {
        if (brand==null) throw new IllegalArgumentException(("null brand"));
        if (brand.isEmpty()) throw new IllegalArgumentException("brand is empty;");
        this.brand=brand.trim();
    }

    /**
     * sets the type
     * @param type string
     */
    public void setType(String type) {
        if (type==null) throw new IllegalArgumentException(("null type"));
        if (type.isEmpty()) throw new IllegalArgumentException("type is empty;");
        this.type=type.trim();
    }

    /**
     * sets the model
     * @param model string
     */
    public void setModel(String model) {
        if (model==null) throw new IllegalArgumentException(("null model"));
        if (model.isEmpty()) throw new IllegalArgumentException("model is empty;");
        this.model=model.trim();
    }

    /**
     * sets the year
     * @param year string
     */
    public void setYear(String year) {
        if (year==null) throw new IllegalArgumentException(("null year"));
        if (year.isEmpty()) throw new IllegalArgumentException("year is empty;");
        this.year=year.trim();
    }

    /**
     * sets the color
     * @param color string
     */
    public void setColor(String color) {
        if (color==null) throw new IllegalArgumentException(("null color"));
        if (color.isEmpty()) throw new IllegalArgumentException("color is empty;");
        this.color=color.trim();
    }

    /**
     * sets the status
     * @param status string
     */
    public void setStatus(String status) {
        if (status==null) throw new IllegalArgumentException(("null status"));
        if (status.isEmpty()) throw new IllegalArgumentException("status is empty;");
        this.status=status.trim();
    }

    /**
     * constructor giving value to all the fields from the arguments
     * @param id string
     * @param plate string
     * @param brand string
     * @param type string
     * @param model string
     * @param year string
     * @param color string
     * @param status string
     */
    public Car(String id, String plate, String brand, String type, String model, String year, String color, String status) {
        setId(id);
        setPlate(plate);
        setBrand(brand);
        setType(type);
        setModel(model);
        setYear(year);
        setColor(color);
        setStatus(status);
    }

    /**
     * allows us to use equal function on 2 objects
     * @param obj   the reference object with which to compare.
     * @return true if they are equal false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (obj==null) {
            return false;
        }

        if (this==obj) {
            return true;
        }

        if (!(obj instanceof Car)) {
            return false;
        }

        Car carTemp=(Car) obj;

        if (this.id==null || carTemp.id==null) {
            return false;
        }

        return (Objects.equals(this.id.toLowerCase(),carTemp.id.toLowerCase()));
    }

    /**
     * hashcode of every object,
     * @return the hashcode
     */
    @Override
    public int hashCode() {

        if (id==null) {
            return 0;
        }

        return Objects.hash(id.toLowerCase());
    }

    /**
     * presents all the fields of the class in 1  presentative form
     * @return the string
     */
    public String toString() {
        return String.format("Car [ id= %s, plate= %s, brand=  %s, type= %s, model= %s, year= %s, color= %s, status= %s ]",getId(),getPlate(),getBrand(),getType(),getModel(),getYear(),getColor(),getStatus());
    }

}

