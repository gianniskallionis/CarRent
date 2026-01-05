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

    public Car searchCombined(String plate,String brand,String model,String color,String status) {

        if (plate==null && brand==null && model==null && color==null && status==null) {
            return null;
        }

        Car car2=null;

        if (plate!=null)
        {
            car2=searchByPlate(plate);
        }
        else if (brand!=null)
        {
            car2=searchByBrand(brand);
        }
        else if (model!=null)
        {
            car2=searchByModel(model);
        }
        else if (color!=null)
        {
            car2=searchByColor(color);
        }
        else if (status!=null)
        {
            car2=searchByStatus(status);
        }

        if (car2==null)
        {
            return null;
        }


        if (brand != null && !car2.getBrand().trim().equals(brand.trim())) {
            return null;
        }

        if (model != null && !car2.getModel().trim().equals(model.trim())) {
            return null;
        }

        if (color != null && !car2.getColor().trim().equals(color.trim())) {
            return null;
        }

        if (status != null && !car2.getStatus().trim().equals(status.trim())) {
            return null;
        }

        return car2;
    }

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
