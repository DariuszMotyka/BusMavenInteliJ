package Bus;

public class BusStop implements BusStopInterface {
    private String busStopName;

    public BusStop(String name){
        this.busStopName = name;
    }

    public String getName() {
        /**
         * Metoda zwraca nazwę przystanku.
         * @return nazwa przystanku
         */
        return this.busStopName;
    }
}
