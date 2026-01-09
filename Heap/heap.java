package Heap;

import java.util.*;
import java.util.PriorityQueue;

public class heap {
   static class Student implements Comparable<Student>{
      String name;
      int rank;
      public Student(String name, int rank){
       this.name = name;
       this.rank= rank;
      }
      @Override
      public int compareTo(Student S2){
        return this.rank - S2.rank;
      }
        
    }
    public static void main(String[] args) {
       PriorityQueue<Student> pq = new PriorityQueue<>();

       pq.add(new Student("A", 4));
       pq.add(new Student("B", 6));
        pq.add(new Student("C", 1));
         pq.add(new Student("D", 3));
          pq.add(new Student("E", 9));

       while (!pq.isEmpty()) {
        System.out.println(pq.peek().name+" -> "+pq.peek().rank);
        pq.remove();
       }
    }
}
