package HashMap;
//<-----Yeh impelent hashmap ka Company ne pucha ja skta hai es liye pdhna hai !    leet - 706
import java.util.LinkedList;
import java.util.*;

//this code of  map me linked list me nodes 
public class MapCode {
    static class Hashmap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
         this.key = key;
         this.value = value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[]; //N=backets.length
//eska use Esliye krte hai jisse hme linked list ka type define nhi kiya hai !  
        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

 //<----------------------------------------------------->
        private int hashFunction(K key){
          int hc = key.hashCode();
          return Math.abs(hc) % N;
        }

//linked ke under ka Node search 
  private int SearchInLL(K key, int bi){
    //esse linked list ka num nikal liya kon se num pe hai  
     LinkedList<Node> ll = buckets[bi];
     int di = 0;
     for (int i = 0; i < ll.size(); i++) {
        Node node = ll.get(i);              //samne node number niklna ! 
        if (node.key == key) {
            return di;
        }
        di++;
     }
     return -1;
  }


@SuppressWarnings("unchecked")
private void rehash(){
    LinkedList<Node> oldBuck[] = buckets;
    buckets = new LinkedList[N*2];
    N =2*N;
    for (int i = 0; i < oldBuck.length; i++) {
        buckets[i] = new LinkedList<>();
    }
    //nodes-> add in buckets
    for (int i = 0; i < oldBuck.length; i++) {
        LinkedList<Node> ll = oldBuck[i];
        for (int j = 0; j < ll.size(); j++) {
            Node node = ll.remove();
            put(node.key, node.value);
        }
    }
}

  //<------------------------------------------------------------------>
        public void put(K key,V value){
          int bi = hashFunction(key); //this is the backet indx
          int di = SearchInLL(key, bi);
          if (di != -1) {
            //node number nikala update ke liye 
            Node node = buckets[bi].get(di);
            node.value = value;
          }else{
            //new Add kr di agr nhi hai to 
            buckets[bi].add(new Node(key, value));
            n++;
          }
          double lambda = (double)n/N;
          if (lambda > 2.0) {
            rehash();
          } 
        }

        //condition check
        public boolean containsKey(K key){
           int bi = hashFunction(key);
           int di = SearchInLL(key, bi);
           if (di != -1) {
            return true;
           }else{
            return false;
           }
        }

        public V remove(K key){
           int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
             if(di != -1){
               Node node= buckets[bi].remove(di);
               n--;
               return node.value;
             }else{
                return null;
             }    
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
             if(di != -1){
               Node node= buckets[bi].get(di);
               return node.value;
             }else{
                return null;
             }    
        }
        //yeh Array print krane ke liye ! only key ayegi !
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
           for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> ll =buckets[i];
            for (Node node : ll) {
              keys.add(node.key);
            }
           }
           return keys;
        }

        public boolean isEmpty(){
          return n == 0;
        }
    }
    public static void main(String[] args) {
      Hashmap<String,Integer> hm = new Hashmap<>();
      hm.put("india", 100);
      hm.put("pak", 20);
      hm.put("US", 60); 
      hm.put("Nepal", 15);
      ArrayList<String> keys = hm.keySet();
      for (String key : keys) {
        System.out.println(key);
      }
      System.out.println(hm.get("india"));
      System.out.println(hm.remove("india"));
       System.out.println(hm.get("india"));
    }
}
