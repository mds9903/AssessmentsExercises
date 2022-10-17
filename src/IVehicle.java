public interface IVehicle {
    // an interface that represents classes that are a kind of Vehicle
    public boolean keyIgnition();
    public boolean applyBrakes();
    public void repair();
    public default void displaySpecs(){
        System.out.println("Displaying details of this vehicle");
        System.out.println("Default details of specifications");
    }
}
