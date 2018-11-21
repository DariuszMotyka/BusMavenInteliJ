package Bus;

import java.util.ArrayList;
import java.util.List;

public class CityMap {

    private int numberOfBusStop;
    private List<Integer>[] connectionList;
    private final String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};


    public CityMap(int numberOfBusStop) {
        this.numberOfBusStop = numberOfBusStop;
        connectionList = (List<Integer>[]) new List[numberOfBusStop];
        for (int i = 0; i < numberOfBusStop; i++) {
            connectionList[i] = new ArrayList<Integer>();
        }
    }

    public int getIdOfBusStopTmp(BusStopInterface busStop) {
        int id = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == busStop.getName()) {
                id = i;
                break;
            }
        }
        return id;
    }

    public String getNameOfBusStopId(int number) {
        return names[number];
    }

    public void addConection(int idBusStopX, int idBusStopY) {
        connectionList[idBusStopX].add(idBusStopY);
        connectionList[idBusStopY].add(idBusStopX);
    }

    public int getNumberOfVertices() {
        return numberOfBusStop;
    }

    public Iterable<Integer> getConnectionList(int busStopNr) {
        return connectionList[busStopNr];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        s.append("Liczba przystanków: ").append(numberOfBusStop).append(";")
                .append(newLine);
        for (int i = 0; i < numberOfBusStop; i++) {
            s.append("Przystanek " + names[i]).append(" połączony z: ");
            for (int w : connectionList[i]) {
                s.append(names[w]).append(" ");
            }
            s.append(newLine);
        }
        return s.toString();
    }

}
