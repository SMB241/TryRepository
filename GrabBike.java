public class GrabBike extends GrabRide {
    public GrabBike(String pickuplocation, String dropofflocation, double distance) {
        super(pickuplocation, dropofflocation, distance, 15.0);
}

    @Override
    public double calculatefare() {
        return basefare + (6.0 * distance);
    }

    @Override
    public String getRideType() {
        return "Grab Bike";
    }

    @Override
    public int estimatedArrivalTime() {
        return (int)(3 + distance);
    }
}