package Bus;

import java.util.ArrayList;
import java.util.List;

public class PathFinder implements PathFinderInterface {
    private List<ArrayList<Object>> busLines = new ArrayList<ArrayList<Object>>();
    private CityMap cityMap = new CityMap(15);

    public PathFinder(){
        System.out.println();
        System.out.println();
        System.out.println("graphLine -------------------------------------------");
        //ab
        cityMap.addConection(0,1);
        //bc
        cityMap.addConection(1,2);
        //cd
        cityMap.addConection(2,3);
        //de
        cityMap.addConection(3,4);
        //ef
        cityMap.addConection(4,5);
        //fg
        cityMap.addConection(5,6);
        //hi
        cityMap.addConection(7,8);
        //ic
        cityMap.addConection(8,2);
        //cj
        cityMap.addConection(2,9);
        //jk
        cityMap.addConection(9,10);
        //le
        cityMap.addConection(11,4);
        //em
        cityMap.addConection(4,12);
        //mn
        cityMap.addConection(12,13);
        //no
        cityMap.addConection(13,14);

        /*
        cityMap.addConection(new BusStop("A"), new BusStop("B"));
        cityMap.addConection(new BusStop("B"), new BusStop("C"));
        cityMap.addConection(new BusStop("C"), new BusStop("D"));
        cityMap.addConection(new BusStop("D"), new BusStop("E"));
        cityMap.addConection(new BusStop("E"), new BusStop("F"));
        cityMap.addConection(new BusStop("F"), new BusStop("G"));
        cityMap.addConection(new BusStop("H"), new BusStop("I"));
        cityMap.addConection(new BusStop("I"), new BusStop("C"));
        cityMap.addConection(new BusStop("C"), new BusStop("J"));
        cityMap.addConection(new BusStop("J"), new BusStop("K"));
        cityMap.addConection(new BusStop("L"), new BusStop("E"));
        cityMap.addConection(new BusStop("E"), new BusStop("M"));
        cityMap.addConection(new BusStop("M"), new BusStop("N"));
        cityMap.addConection(new BusStop("N"), new BusStop("O"));
        */
        cityMap.toString();
    }

    public List<ArrayList<Object>> getBusLines() {
        return busLines;
    }

    public void addLine(BusLineInterface line, BusInterface bus) {
        busLines.add(new ArrayList<Object>());
        busLines.get(busLines.size()-1).add(bus);
        busLines.get(busLines.size()-1).add(line);

        //System.out.println(bus.getBusNumber());
        System.out.println("-----------------");
        System.out.println("Dodano nową linię autobusową:");
        System.out.println("Nr autobusu: "+bus.getBusNumber());
        //System.out.println("Nr autobusu: "+busLines.get(busLines.size()-1).get(0).toString()); // nie wiem czemu przestało działać
        System.out.println("Trasa: "+busLines.get(busLines.size()-1).get(1).toString());
        System.out.println("-----------------");
    }

    public void find(BusStopInterface from, BusStopInterface to, int transfers) {
        int fromId = cityMap.getIdOfBusStopTmp(from);
        int toId = cityMap.getIdOfBusStopTmp(to);
        int maxTransfer = transfers;
        Dfs dfs1 = new Dfs(cityMap, fromId);
        for (int it : dfs1.getPathTo(toId)) {
            System.out.print(cityMap.getNameOfBusTopId(it) + " ");
        }
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
