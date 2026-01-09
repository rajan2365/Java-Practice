package HashMap;

import java.util.HashMap;

public class Ticket {
    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);    // from ko to me reverce kr diya hain ! 
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {     //to ko key bna diya uske baad jo key 
                return key;
            }
        }
        return null;
    }
     public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();

    }
}

