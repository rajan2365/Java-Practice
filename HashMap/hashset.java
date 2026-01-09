package HashMap;

import java.util.HashSet;
import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // set.add(2);
        // set.add(1);
        // System.out.println(set);
        // if (set.contains(1)) {
        //     System.out.println("set contains ! ");
        // }
    
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Begaluru");

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        //   System.out.println(it.next());
        // }

        //loop method 
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
