package Bus;

public class Bus implements BusInterface {
    private int number;

    public Bus(int number) {
        this.number = number;
    }

    public int getBusNumber() {
        /**
         * Metoda zwraca numer autobusu
         * @return numer autobusu
         */
        return this.number;
    }
}
