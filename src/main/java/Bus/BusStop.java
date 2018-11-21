package Bus;

public class BusStop implements BusStopInterface {

    private String busName;

    public BusStop(String newBusName) {
        busName = newBusName;
    }

    public String getName() {
        return busName;
    }
}
