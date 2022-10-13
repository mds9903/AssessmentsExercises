public class Interface implements IVehicle, IMachine, ITransportMedium{
    // assumption: this class, even though named "Interface", represents an Aeroplane
    @Override
    public boolean startMachine() {

        return false;
    }

    @Override
    public boolean stopMachine() {
        return false;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public double updateFare() {
        return 0;
    }

    @Override
    public boolean updateDailyRoute() {
        return false;
    }

    @Override
    public boolean keyIgnition() {
        return false;
    }

    @Override
    public boolean applyBrakes() {
        return false;
    }

    @Override
    public void repair() {

    }
    // "Provide couple of interfaces.
    // Let them define the concrete implementations of all interfaces on single class"
    // demo multiple interface implementation
    public static void main(String[] args) {
        Interface aeroplane = new Interface();
    }

}
