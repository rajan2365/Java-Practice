package Heap;

import java.util.PriorityQueue;

// nearest car (K closest points to origin)
public class Nearest {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // min-heap based on distance
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];  //s2 = x2 + y2;
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // nearest k points
        for (int i = 0; i < k; i++) {
            Point p = pq.remove();
            System.out.println("C" + p.idx + " -> (" + p.x + "," + p.y + ")");
        }
    }
}
