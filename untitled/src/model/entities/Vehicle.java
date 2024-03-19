package model.entities;

public class Vehicle {
    private String carModel;

    public Vehicle() {

    }
    public Vehicle(String carModel) {
        this.carModel = carModel;
    }

    public String getModel() {
        return carModel;
    }

    public void setModel(String carModel) {
        this.carModel = carModel;
    }
}
