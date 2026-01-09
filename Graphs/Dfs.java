package Graphs;

import java.util.ArrayList;

public class Dfs {
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

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }
    
      public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
         System.out.print(curr + " "); // node 0 -> start kiya jisse 

         vis[curr] = true; //vis me pehle se insert kr diya ! 

         for (int i = 0; i < graph[curr].size(); i++) {  //traverce the graph ! 
            Edge e = graph[curr].get(i); //e -> graph ke element ke data insert ! 

            if (!vis[e.dest]) { //agr deta destination me nhi hai to dfs call krna ! 
                dfs(graph,e.dest, vis); //reverce aana ! 
            }
         }
      }

    //Note - > first Insert krenege to <vis> true krna jaruri hai ! 

      //1 se 5 tk way check krna !
      public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest,boolean vis[]){
           if (src == dest) {  //starting point Agr or ending point same ho to ! 
            return true;
           }
           vis[src] = true; //
           for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
           }
           return false;
      }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dfs(graph, 0,new boolean[V]);
    }
}
