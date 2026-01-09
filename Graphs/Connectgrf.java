package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Connectgrf {
    
public class Bfs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
           this.src = s;
           this.dest = d;
           this.wt = w;
        }
    }
//bfs for connected nodes 
     public static void bfs(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
        if (!vis[i]) {
            bfsUtil(graph,vis);
        }
    }

     }
    public static void bfsUtil(ArrayList<Edge> []graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);  //0 se start krna ho !
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr+" ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); 
                }
            }
        }

    }

    //dfs arrange connected ! 
    public static void dfs(ArrayList<Edge>[] graph){
       boolean vis[] = new boolean[graph.length];
       for (int i = 0; i < graph.length; i++) {
        dfsUtil(graph, i, vis);
       }
    }
     public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]){
         System.out.print(curr + " ");
         vis[curr] = true;
         for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, curr, vis);
         }
      }
    public static void main(String[] args) {
        
    }
}
