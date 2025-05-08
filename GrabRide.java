public abstract class GrabRide {
    protected String pickuplocation;
    protected String dropofflocation;
    protected double distance;
    protected double basefare;

    public GrabRide(String pickuplocation, String dropofflocation, double distance, double basefare) {
        this.pickuplocation = pickuplocation;
        this.dropofflocation = dropofflocation;
        this.distance = distance;
        this.basefare = basefare;
    }
    public void showRoute(){
        System.out.println("From: " + pickuplocation + "To: " + dropofflocation);
    }

    public abstract double calculatefare();
    public abstract String getRideType();
    public abstract int estimatedArrivalTime();
}