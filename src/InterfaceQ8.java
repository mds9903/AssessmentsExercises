// "Provide couple of interfaces.
// Let them define the concrete implementations of all interfaces on single class"
// demo multiple interface implementation
public class InterfaceQ8 implements IVehicle, IMachine, ITransportMedium{
    private boolean running;
    private double fare;
    private String route;
    // assumption: this class represents an Aeroplane
    public static void main(String[] args) {
        InterfaceQ8 aeroplane = new InterfaceQ8();
        aeroplane.keyIgnition();
        System.out.println(aeroplane.isRunning());
        aeroplane.repair();
        aeroplane.startMachine();
        aeroplane.stopMachine();
        aeroplane.updateDailyRoute("from B to F to G");
        aeroplane.keyIgnition();
        aeroplane.startMachine();
        aeroplane.stopMachine();
    }

    @Override
    public void startMachine() {
        System.out.println("Starting machine...");
        this.running = true;
        System.out.println("Machine stared");
    }

    @Override
    public void stopMachine() {
        System.out.println("Stopping stopped...");
        this.running = false;
        System.out.println("Machine stopped");
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public double updateFare(double newFare) {
        this.fare = newFare;
        return this.fare;
    }

    @Override
    public String updateDailyRoute(String newRoute) {
        this.route = newRoute;
        return this.route;
    }

    @Override
    public void keyIgnition() {
        System.out.println("Pilot in cockpit... Ignition.. Flight is about to take off");
    }

    @Override
    public boolean applyBrakes() {
        System.out.println("Applying air breaks.........");
        this.running = false;
        System.out.println("Brakes applied... Aeroplane stopped");
        return this.running;
    }
    @Override
    public void repair() {
        System.out.println("This flight is being sent for repair.");
    }

}
