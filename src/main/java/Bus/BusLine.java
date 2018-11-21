package Bus;

import java.util.List;

public class BusLine implements BusLineInterface {

    private List<BusStopInterface> busLine;

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
        if(number < 0 || number >= getNumberOfBusStops()){
            return null;
        }

        return busLine.get(number);
    }

    public BusInterface getBus() {
        return null;
    }

    @Override
    public String toString() {
        String tmp="";
        for(int i=0;i<busLine.size();i++) {
            tmp+=busLine.get(i).getName()+", ";
        }
        return "BusLine [busLine=" + tmp + "]";
    }
}
