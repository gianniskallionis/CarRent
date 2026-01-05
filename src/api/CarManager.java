package api;

import api.Car;

import java.util.ArrayList;

public class CarManager {

    private ArrayList<Car> carsList;

    public CarManager() {
        carsList=new ArrayList<>();
    }

    public Car searchByPlate(String plate) {

        if (plate==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getPlate().trim().equals(plate.trim())) {
                return c;
            }
        }

        return null;
    }


    public Car searchByBrand(String brand) {

        if (brand==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getBrand().trim().equals(brand.trim())) {
                return c;
            }
        }

        return null;
    }

    public Car searchByModel(String model) {

        if (model==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getModel().trim().equals(model.trim())) {
                return c;
            }
        }

        return null;
    }

    public Car searchByColor(String color) {

        if (color==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getColor().trim().equals(color.trim())) {
                return c;
            }
        }

        return null;
    }

    public Car searchByStatus(String status) {

        if (status==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getStatus().trim().equals(status.trim())) {
                return c;
            }
        }

        return null;
    }

    public boolean addCar(Car car1) {

        if (car1==null || car1.getPlate()==null || searchByPlate(car1.getPlate())!=null ) {
            return false;
        }
        carsList.add(car1);
        return true;
    }

public ArrayList<Car> searchCombined(String plate, String brand, String model, String color, String status) {
    ArrayList<Car> results = new ArrayList<>();

    for (Car car : carsList) {
        boolean matches = true;

        if (plate != null && !car.getPlate().toLowerCase().contains(plate.toLowerCase())) {
            matches = false;
        }
        if (brand != null && !car.getBrand().toLowerCase().contains(brand.toLowerCase())) {
            matches = false;
        }
        if (model != null && !car.getModel().toLowerCase().contains(model.toLowerCase())) {
            matches = false;
        }
        if (color != null && !car.getColor().toLowerCase().contains(color.toLowerCase())) {
            matches = false;
        }
        if (status != null && !car.getStatus().toLowerCase().contains(status.toLowerCase())) {
            matches = false;
        }

        if (matches) {
            results.add(car);}}
    return results;}


    public ArrayList<Car> getAllCars() {
        return new ArrayList<>(carsList);
    }
    public boolean removeCar(String plate) {
        if (plate == null) return false;
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getPlate().trim().equalsIgnoreCase(plate.trim())) {
                carsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateCar(String oldPlate, Car updatedCar) {
        if (oldPlate == null || updatedCar == null) return false;

        if (!oldPlate.trim().equalsIgnoreCase(updatedCar.getPlate().trim())) {
            if (searchByPlate(updatedCar.getPlate()) != null) {
                return false;
            }
        }

        if (!removeCar(oldPlate)) {
            return false;
        }
        return addCar(updatedCar);
    }

}
