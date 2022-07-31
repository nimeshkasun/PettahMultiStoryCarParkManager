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
public class Minibus extends Vehicle {

    private int numDoors;
    private int seats;

    public Minibus(String plateID) {
        super(plateID);
        this.vehicleType = vehicleType.Minibus;
        this.slotsNeeded = 3.0;
    }

    // Return string version of the Minibus class along with its attributes
    @Override
    public String toString() {
        return "Minibus with plate id- " + this.plateId + ", entered at: " + this.entryTime.getDateTime();
    }

    public Minibus(String regNumber, String brand, String model, DateTime entryTime, int numDoors, int seats) {
        super(regNumber, brand, model, entryTime);
        this.numDoors = numDoors;
        this.seats = seats;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

}
