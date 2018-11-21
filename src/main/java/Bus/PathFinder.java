package Bus;

import java.util.ArrayList;
import java.util.List;

public class PathFinder implements PathFinderInterface {
    List<ArrayList<Object>> busLines = new ArrayList<ArrayList<Object>>();

    public PathFinder(){
        System.out.println();
        System.out.println();
        System.out.println("graphLine -------------------------------------------");
        CityMap graphLine = new CityMap(15);
        graphLine.addConection(new BusStop("A"), new BusStop("B"));
        graphLine.addConection(new BusStop("B"), new BusStop("C"));
        graphLine.addConection(new BusStop("C"), new BusStop("D"));
        graphLine.addConection(new BusStop("D"), new BusStop("E"));
        graphLine.addConection(new BusStop("E"), new BusStop("F"));
        graphLine.addConection(new BusStop("F"), new BusStop("G"));
        graphLine.addConection(new BusStop("H"), new BusStop("I"));
        graphLine.addConection(new BusStop("I"), new BusStop("C"));
        graphLine.addConection(new BusStop("C"), new BusStop("J"));
        graphLine.addConection(new BusStop("J"), new BusStop("K"));
        graphLine.addConection(new BusStop("L"), new BusStop("E"));
        graphLine.addConection(new BusStop("E"), new BusStop("M"));
        graphLine.addConection(new BusStop("M"), new BusStop("N"));
        graphLine.addConection(new BusStop("N"), new BusStop("O"));
        graphLine.printGraph();
    }


    public void addLine(BusLineInterface line, BusInterface bus) {
        busLines.get(busLines.size()-1).add(line);
        busLines.get(busLines.size()-1).add(bus);

        System.out.println("Dodano nową linię autobusową:");
        System.out.println("Nr autobusu: "+busLines.get(busLines.size()-1).get(1));
        System.out.println("Trasa: "+busLines.get(busLines.size()-1).get(0).toString());
    }

    public void find(BusStopInterface from, BusStopInterface to, int transfers) {

    }

    public int getNumerOfSolutions() {
        return 0;
    }

    public int getBusStops(int solution) {
        return 0;
    }

    public BusStopInterface getBusStop(int solution, int busStop) {
        return null;
    }

    public BusInterface getBus(int solution, int busStop) {
        return null;
    }
}
