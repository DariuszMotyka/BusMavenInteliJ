package Bus;

import java.util.ArrayList;
import java.util.List;

public class CityMap {

    // liczba krawedzi
    private int numberOfConnections;
    // liczba wierzcholkow
    private int numberOfBusStop;
    // tablica list sasiedztwa danego wierzcholka
    private List<Integer>[] connectionList;
    private final String[] names = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
    /**
     *
     * @param numberOfBusStop
     *            ilosc wierzcholkow w grafie
     */
    @SuppressWarnings("unchecked")
    public CityMap(int numberOfBusStop) {
        this.numberOfBusStop = numberOfBusStop;
        this.numberOfConnections = 0;
        connectionList = (List<Integer>[]) new List[numberOfBusStop];
        for (int i = 0; i < numberOfBusStop; i++) {
            connectionList[i] = new ArrayList<Integer>();
        }
    }

    public int getIdOfBusStopTmp(BusStopInterface busStop) {
        int id=0;
        for(int i=0;i<names.length;i++) {
            if(names[i]==busStop.getName()) {
                id = i;
                break;
            }
        }
        return id;
    }

    public String getNameOfBusTopId(int number){
        return names[number];
    }

    /**
     * Dodaje krawedz numberOfBusStop-w do grafu nieskierowanego.
     *
     * @param v
     *            jeden z wierzcholkow krawedzi
     * @param w
     *            drugi z wierzcholkow krawedzi
     */
    public void addConection(int v, int w) {
        connectionList[v].add(w);
        connectionList[w].add(v);
        numberOfConnections++;
    }

    /**
     *
     * @return liczbe krawedzi
     */
    public int getNumberOfEdges() {
        return numberOfConnections;
    }

    /**
     * @return liczbe wierzcholkow
     */
    public int getNumberOfVertices() {
        return numberOfBusStop;
    }

    /**
     * Zwraca liste sasiedztwa danego wierzcholka.
     *
     * @param v
     *            indeks wierzcholka skierowanego
     * @return zwraca iterowalna kolekcje wierzcholkow sasiadujacych
     */
    public Iterable<Integer> getConnectionList(int v) {
        return connectionList[v];
    }

    /**
     * @return opis grafu.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        s.append("wierzcholki: ").append(numberOfBusStop).append("; krawedzie: ").append(numberOfConnections)
                .append(newLine);
        for (int i = 0; i < numberOfBusStop; i++) {
            s.append(i).append(": ");
            for (int w : connectionList[i]) {
                s.append(w).append(" ");
            }
            s.append(newLine);
        }
        return s.toString();
    }

}
