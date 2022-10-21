package com.mdsujan.interfaces;

import java.time.LocalDate;

//"Define an interface with a default method implementation
//        Implement the interface and override the default implementation.
//
//        Ex. - getFormattedDisplayAmount(amount) - default with Indian currenct symbol and , separated
//        Specific Impl -
//        US format
//        UK Format
//        French Format"
public class InterfaceQ15 implements IVehicle {
    private String color;
    private int wheels;
    private LocalDate make;
    private boolean running;
    public InterfaceQ15(String color, int wheels, LocalDate make) {
        this.color = color;
        this.wheels = wheels;
        this.make = make;
        this.running = false;
    }

    public static void main(String[] args) {
        InterfaceQ15 vehicle = new InterfaceQ15("red", 4, LocalDate.of(2022, 11, 23));
        vehicle.keyIgnition();
        vehicle.applyBrakes();
        vehicle.displaySpecs();
    }

    @Override
    public boolean keyIgnition() {
        if (this.running) {
            System.out.println("Car is already running. No need for key ignition.");
            return false;
        }
        System.out.println("Key in... Ignition!. Car is ready to start moving");
        running = true;
        return true;
    }

    @Override
    public boolean applyBrakes() {
        if(this.running){
            System.out.println("Applying brakes....");
            this.running = false;
            System.out.println("Car stopped");
            return true;
        }
        System.out.println("Car is already stopped");
        return false;
    }

    @Override
    public void repair() {
        System.out.println("Car sent for repair... You can pick it up in a day.");
    }

    public void displaySpecs() {
        System.out.println("Car Specs");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "com.mdsujan.interfaces.q8.InterfaceQ15{" +
                "color=" + color +
                ", wheels=" + wheels +
                ", make=" + make +
                ", running=" + running +
                '}';
    }
}
