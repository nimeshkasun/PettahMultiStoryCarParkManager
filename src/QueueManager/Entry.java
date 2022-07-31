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
import java.util.concurrent.ConcurrentLinkedDeque;
import vehicle.Vehicle;

public class Entry implements Runnable {

    private String name;
    private ConcurrentLinkedDeque queue;
    private final int SLEEP;
    private CarPark carPark;

    public Entry(String name, int sleep, ConcurrentLinkedDeque queue, CarPark carPark) {
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
        // Continuously get the first vehicle in the queue and add to the car park
        while (true) {
            Vehicle vehicleToEnter = (Vehicle) this.queue.poll();
            try {
                // Check if a vehicle is currently in front of the queue
                if (vehicleToEnter != null) {
                    this.carPark.addVehicle(vehicleToEnter);
                    System.out.println(vehicleToEnter + " entered the car park");
                }
            } catch (Exception e) {
                // This is when car park is full, i.e. all possible floors to accommodate the vehicle is full
                System.out.println("Cannot accommodate " + vehicleToEnter + " at the moment");
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
