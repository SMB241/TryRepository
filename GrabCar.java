public class GrabCar extends GrabRide {
    public GrabCar(String pickuplocation, String dropofflocation, double distance) {
        super(pickuplocation, dropofflocation, distance, 25.0);
    }

    @Override
    public double calculatefare() {
       return basefare + (10.0 * distance);
    }

    @Override
    public String getRideType() {
        return "Grab Car";
    }

    @Override
    public int estimatedArrivalTime() {
        return (int)(5 + distance * 1.5);
    }
    
}
