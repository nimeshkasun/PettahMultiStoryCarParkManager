package vehicle;

import datetime.DateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nimesh Kasun
 */
public abstract class Vehicle extends Object implements Comparable<Vehicle> {

    @Override
    public int compareTo(Vehicle vehicle) {
        Double veh1_timeParked = this.getTimeParked();
        Double veh2_timeParked = vehicle.getTimeParked();

        return veh1_timeParked.compareTo(veh2_timeParked);
    }

    // Vehicle Properties
    protected String plateId;
    protected String brand;
    protected String model;
    protected DateTime entryTime;
    protected double slotsNeeded;
    protected VehicleType vehicleType;

    public Vehicle(String plateId) {
        // Set plateID
        this.plateId = plateId;
        // Initialize entry time
        this.entryTime = new DateTime();
    }

    public Vehicle(String plateId, String brand, String model, DateTime entryTime) {
        this.plateId = plateId;
        this.brand = brand;
        this.model = model;
        this.entryTime = entryTime;
    }

    public String getPlateId() {
        return plateId;
    }

    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public DateTime getEntryDate() {
        return entryTime;
    }

    public void setEntryDate(DateTime entryTime) {
        this.entryTime = entryTime;
    }

    public double getSlotsNeeded() {
        return this.slotsNeeded;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public double getTimeParked() {
        DateTime currentTime = new DateTime();
        return currentTime.getDateTimeDiffHours(this.entryTime);
    }

    public DateTime getEntryTime() {
        return entryTime;
    }
}
