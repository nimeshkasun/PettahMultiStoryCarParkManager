package QueueManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nimesh Kasun
 */
import CarParkData.CarPark;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import vehicle.Vehicle;

public class Exit implements Runnable {

    private String name;
    private ConcurrentLinkedDeque queue;
    private final int SLEEP;
    private CarPark carPark;

    public Exit(String name, int sleep, ConcurrentLinkedDeque queue, CarPark carPark) {
        this.queue = queue;
        this.SLEEP = sleep;
        this.name = name;
        this.carPark = carPark;
    }

    // Name of the current thread
    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        // Simulate random vehicles leaving this car park periodically
        while (true) {
            List<Vehicle> vehicleList = new ArrayList<>(this.carPark.getVehicleList());
            Collections.shuffle(vehicleList);
            if (vehicleList.size() != 0) {
                // Get a random vehicle that will be removed
                Vehicle vehicleToRemove = vehicleList.get(0);
                try {
                    // Remove the vehicle from teh car park
                    this.carPark.deleteVehicle(vehicleToRemove.getPlateId());
                    System.out.println(vehicleToRemove + " left the car park");
                } catch (Exception e) {
                    System.out.println(vehicleToRemove.getPlateId() + " already left the car park");
                }
            }
            try {
                // Sleep the thread giving other threads a chance to run
                Thread.sleep(SLEEP);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
