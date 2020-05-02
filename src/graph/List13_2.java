package graph;

import java.util.Vector;

public class List13_2 {

    private static class Station {

        public String name;
        public Vector transitions;

        public Station(String name) {
            this.name = name;
            this.transitions = new Vector();
        }

        public void addStation(Station transition) {
            for (int i = 0; i < this.transitions.size(); i++) {
                if (((Station) this.transitions.get(i)).name.equals(transition.name)) {
                    return;
                }
            }
            this.transitions.add(transition);
        }

        public void printStation() {
            System.out.println(this.name + " : ");
            for (int i = 0; i < this.transitions.size(); i++) {
                System.out.println("=>" + ((Station) this.transitions.get(i)).name + "");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Station[] station = new Station[6];

        station[0] = new Station("鎌倉");
        station[1] = new Station("藤沢");
        station[2] = new Station("横浜");
        station[3] = new Station("横須賀");
        station[4] = new Station("茅ヶ崎");
        station[5] = new Station("東京");


        // 鎌倉
        station[0].addStation(station[3]);
        station[0].addStation(station[1]);

        // 藤沢
        station[1].addStation(station[4]);
        station[1].addStation(station[2]);
        // 横浜
        station[2].addStation(station[0]);
        station[2].addStation(station[5]);

        // 横須賀・茅ヶ崎・東京
        station[3].addStation(station[0]);
        station[4].addStation(station[1]);
        station[5].addStation(station[2]);

        for(int i = 0; i < 6; i++) {
            station[i].printStation();
        }
    }
}
