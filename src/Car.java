public class Car {

    private String id;
    private String plate;
    private String brand;
    private String model;
    private String year;
    private String color;
    private String status;

    public String getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        if (id == null) throw new IllegalArgumentException(("null id"));
        if (id.isEmpty()) throw new IllegalArgumentException("id is empty;");
        this.id = id.trim();
    }


    public void setPlate(String plate) {
        if (plate == null) throw new IllegalArgumentException(("null plate"));
        if (plate.isEmpty()) throw new IllegalArgumentException("plate is empty;");
        this.plate = plate.trim();
    }

    public void setBrand(String brand) {
        if (brand == null) throw new IllegalArgumentException(("null brand"));
        if (brand.isEmpty()) throw new IllegalArgumentException("brand is empty;");
        this.brand = brand.trim();
    }

    public void setModel(String model) {
        if (model == null) throw new IllegalArgumentException(("null model"));
        if (model.isEmpty()) throw new IllegalArgumentException("model is empty;");
        this.model = model.trim();
    }

    public void setYear(String year) {
        if (year == null) throw new IllegalArgumentException(("null year"));
        if (year.isEmpty()) throw new IllegalArgumentException("year is empty;");
        this.year = year.trim();
    }

    public void setColor(String color) {
        if (color == null) throw new IllegalArgumentException(("null color"));
        if (color.isEmpty()) throw new IllegalArgumentException("color is empty;");
        this.color = color.trim();
    }

    public void setStatus(String status) {
        if (status == null) throw new IllegalArgumentException(("null status"));
        if (status.isEmpty()) throw new IllegalArgumentException("status is empty;");
        this.status = status.trim();
    }

    public Car(String id, String plate, String brand, String model, String year, String color, String status) {
        setId(id);
        setPlate(plate);
        setBrand(brand);
        setModel(model);
        setYear(year);
        setColor(color);
        setStatus(status);
    }
}

