package Bus;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();

        List<BusStopInterface> trasa100 = new LinkedList<BusStopInterface>();
        trasa100.add(new BusStop("A"));
        trasa100.add(new BusStop("B"));
        trasa100.add(new BusStop("C"));
        trasa100.add(new BusStop("D"));
        trasa100.add(new BusStop("F"));
        trasa100.add(new BusStop("G"));

        List<BusStopInterface> trasa200 = new LinkedList<BusStopInterface>();
        trasa200.add(new BusStop("H"));
        trasa200.add(new BusStop("I"));
        trasa200.add(new BusStop("C"));
        trasa200.add(new BusStop("J"));
        trasa200.add(new BusStop("K"));

        List<BusStopInterface> trasa300 = new LinkedList<BusStopInterface>();
        trasa300.add(new BusStop("L"));
        trasa300.add(new BusStop("E"));
        trasa300.add(new BusStop("M"));
        trasa300.add(new BusStop("N"));
        trasa300.add(new BusStop("O"));


        pathFinder.addLine(new BusLine(trasa100), new Bus(100));
        pathFinder.addLine(new BusLine(trasa200), new Bus(200));
        pathFinder.addLine(new BusLine(trasa300), new Bus(300));
    }
}
