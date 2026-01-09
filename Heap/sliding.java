package Heap;

import java.util.PriorityQueue;

public class sliding {
    // make Pair static so main can use it
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // descending order for max-heap
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // window size
        int res[] = new int[arr.length - k + 1]; // corrected size

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for (int i = 0; i < k; i++) {
            //yeh add kiya shuru ke K tk ke liye 
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        // process remaining windows
        for (int i = k; i < arr.length; i++) {
            // remove out-of-window elements
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.poll(); // poll ya remove same hi hai ! 
            }

            //ye Sare ke liye ! 
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        // print result
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
