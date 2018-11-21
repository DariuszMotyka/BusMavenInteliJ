package Bus;

import java.util.ArrayList;
import java.util.List;

public class CityMap {

        private int numberOfConnections;
        private int numberOfBusStop;
        private List<Integer>[]  connectionList;
        //private List<List<BusStopInterface>> connectionList;
        private final String[] names = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

        public CityMap(int numberOfBusStop){
            this.numberOfBusStop = numberOfBusStop;
            this.numberOfConnections = 0;
            connectionList = (List<Integer>[]) new List[numberOfBusStop];
            //connectionList = new ArrayList<List<BusStopInterface>>();
            for (int i = 0; i < numberOfBusStop; i++) {
                connectionList[i]=new ArrayList<Integer>();
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

        public void addConection(BusStopInterface from, BusStopInterface to) {
            connectionList[getIdOfBusStopTmp(from)].add(getIdOfBusStopTmp(to));
            connectionList[getIdOfBusStopTmp(to)].add(getIdOfBusStopTmp(from));
            numberOfConnections++;
        }

        public int getNumberOfConnections() {
            return numberOfConnections;
        }


        public int getNumberOfBusStop() {
            return numberOfBusStop;
        }

        public List<Integer> getConnectionList(int busStopNumber) {
            return connectionList[busStopNumber];
        }

        public void printGraph() {
            String tmp;
            System.out.println("Ilość przystanków:"+numberOfBusStop);
            for (int i = 0; i < numberOfBusStop; i++) {
                tmp="";
                System.out.print("Przystanek "+i+": ");
                for(int j=0;j<connectionList[i].size();j++) {
                    //tmp+=(connectionList[i].get(j))+" ";
                    tmp+=names[j]+" ";
                }
                System.out.println(tmp);
            }
        }

}
