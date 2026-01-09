package HashMap;
import java.util.*;
public class LinkedHm {
    public static void main(String[] args) {
        //Key are Insertion Ordered! 
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("india", 100);
        lhm.put("China", 120);
        lhm.put("US", 50);
     
     HashMap<String,Integer> hm = new HashMap<>();
     hm.put("india", 100);
     hm.put("China", 120);
     hm.put("US", 50);
     System.out.println(hm);
     System.out.println(lhm);
    }
}
