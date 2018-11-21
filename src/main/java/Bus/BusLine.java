package Bus;

import java.util.LinkedList;
import java.util.List;

public class BusLine implements BusLineInterface {
    private BusStopInterface busLine;

    public BusLine(BusStopInterface newBusLine){
        this.busLine = newBusLine;
    }


    public int getNumberOfBusStops() {
        /**
         * Metoda zwraca liczbę przystanków, które wchodzą w jej skład.
         *
         * @return liczba przystanków danej lini
         */
        return busLine.size();
    }

    public BusStopInterface getBusStop(int number) {
        /**
         * Metoda zwraca obiekt reprezentujący przystanek o podanym numerze. Prawidłowe
         * numery przystanów mieszczą się w przedziale od 0 do getNumberOfBusStops()-1.
         * Tylko podanie błednego numeru przystanku spowoduje zwrócenie null.
         *
         * @param number numer przystanku
         * @return obiekt reprezentujący przystanek o numerze number
         */
        return busLine.get(number);
    }

    public BusInterface getBus() {
        return null;
    }
}
