package Bus;

import java.util.ArrayList;
import java.util.List;

public class PathFinder implements PathFinderInterface {
    //private List<ArrayList<Object>> busLines = new ArrayList<ArrayList<Object>>();
    private List<BusLineInterface> busLines = new ArrayList<BusLineInterface>();
    private List<BusInterface> busNames = new ArrayList<BusInterface>();
    private CityMap cityMap = new CityMap(15);

    public PathFinder() {
        System.out.println();
        System.out.println();
        System.out.println("graphLine -------------------------------------------");
        //ab
        cityMap.addConection(0, 1);
        //bc
        cityMap.addConection(1, 2);
        //cd
        cityMap.addConection(2, 3);
        //de
        cityMap.addConection(3, 4);
        //ef
        cityMap.addConection(4, 5);
        //fg
        cityMap.addConection(5, 6);
        //hi
        cityMap.addConection(7, 8);
        //ic
        cityMap.addConection(8, 2);
        //cj
        cityMap.addConection(2, 9);
        //jk
        cityMap.addConection(9, 10);
        //le
        cityMap.addConection(11, 4);
        //em
        cityMap.addConection(4, 12);
        //mn
        cityMap.addConection(12, 13);
        //no
        cityMap.addConection(13, 14);

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

    /*
    public List<ArrayList<Object>> getBusLines() {
        return busLines;
    }
    */

    public void addLine(BusLineInterface line, BusInterface bus) {
        //busLines.add(new ArrayList<Object>());
        //busLines.get(busLines.size()-1).add(bus);
        //busLines.get(busLines.size()-1).add(line);
        busLines.add(line);
        busNames.add(bus);

        //System.out.println(bus.getBusNumber());
        System.out.println("-----------------");
        System.out.println("Dodano nową linię autobusową:");
        System.out.println("Nr autobusu: " + busNames.get(busNames.size() - 1).getBusNumber());
        //System.out.println("Nr autobusu: "+busLines.get(busLines.size()-1).get(0).toString()); // nie wiem czemu przestało działać
        System.out.println("Trasa: " + busLines.get(busLines.size() - 1).toString());
        System.out.println("-----------------");
    }

    public void find(BusStopInterface from, BusStopInterface to, int transfers) {
        int fromId = cityMap.getIdOfBusStopTmp(from);
        int toId = cityMap.getIdOfBusStopTmp(to);
        int maxTransfer = transfers;

        System.out.println("----------------");
        System.out.println("Rozwiązanie:");
        Dfs dfs1 = new Dfs(cityMap, fromId);
        for (int it : dfs1.getPathTo(toId)) {
            System.out.println();
            System.out.print(cityMap.getNameOfBusStopId(it) + " ");
            System.out.print(" Dostępne autobusy: ");
            getBus(it, it);
        }

        System.out.println();
        System.out.println("Liczba przystanków do celu: " + getBusStops(dfs1.getNumberOfSteps()));
    }

    public int getNumerOfSolutions() {
        /**
         * Liczba odnalezionych rozwiązań.
         * @return liczba rozwiązań. Przed wykonaniem metody find
         * metoda zwraca zawsze 0.
         */
        return 0;
    }

    public int getBusStops(int solution) {
        /**
         * Liczba przystanków autobusowych należących do rozwiązania
         * o podanym numerze. Przystanek o numerze 0 to przystanek, od
         * którego rozpoczynana jest podróż (from). Przystanek o numerze
         * getNumerOfSolutions()-1 to przystanek końcowy (to).
         * @param solution numer rozwiązania
         * @return liczba przystanków.
         */
        return solution;
    }

    public BusStopInterface getBusStop(int solution, int busStop) {
        /**
         * Metoda zwraca przystanek o numerze busStop w rozwiązaniu
         * o numerze solution.
         * @param solution numer rozwiązania
         * @param busStop numer przystanku w obrębie danego rozwiązania
         * @return przystanek o podanych numerach identyfikacyjnych
         */
        BusStopInterface tmpBusStop = null;
        for (int i = 0; i < busNames.size(); i++) {
            if (busNames.get(i).getBusNumber() == busStop) {
                tmpBusStop = busLines.get(i).getBusStop(solution);
                break;
            }
        }

        return tmpBusStop;
    }

    public BusInterface getBus(int solution, int busStop) {
        /**
         * Dla wszystkich przystanków poza ostatnim, metoda zwraca autobus, który
         * obsługuje połączenie z przystanku o numerze busStop do następnego.
         * Dla przystanku ostatniego, autobus, który obsługiwał przejazd
         * z przystanku busStop-2 do busStop-1 (czyli ostatniego).
         * @param solution numer rozwiązania
         * @param busStop numer przystanku w obrębie danego rozwiązania
         * @return autobus, którym pasażer odjeżdża z danego przystanku lub
         * w przypadku przystanku docelowego, autobus, z którego pasażer
         * na tym przystanku wysiadł.
         */
        BusInterface tmpBus = null;
        for (int i = 0; i < busLines.size(); i++) {
            for (int j = 0; j < busLines.get(i).getNumberOfBusStops(); j++) {
                if (busLines.get(i).getBusStop(j).getName() == cityMap.getNameOfBusStopId(busStop)) {
                    //System.out.println("Przystanek: "+cityMap.getNameOfBusStopId(busStop)+" Autobus:"+busNames.get(i).getBusNumber());
                    tmpBus = busNames.get(i);
                    //break;
                    System.out.print(tmpBus.getBusNumber() + "; ");
                }
            }

        }

        return tmpBus;
    }
}
