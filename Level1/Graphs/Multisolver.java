package Level1.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Multisolver {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    //smallest path
    static String Spath;

    //smallest weight
    static int Swt = Integer.MAX_VALUE;

    //highest path
    static String Hpath;

    //highest Weight
    static int Hwt = Integer.MIN_VALUE;

    //ceil-->smallest among biggest or just bigger
    static int ceil = Integer.MAX_VALUE;

    //ceil path
    static String ceilPath;

    //floor-->biggest among smallest or just smaller
    static int floor = Integer.MIN_VALUE;

    //floor path
    static String floorPath;

    //priority Queue to find kth largest weight
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, int k, boolean[] visited, int criteria, String psf, int wsf) {
        if (src == dest) {
            //smallest path with wt.
            if (wsf < Swt) {
                Swt = wsf;
                Spath = psf;
            }
            //highest wt. path
            if (wsf > Hwt) {
                Hwt = wsf;
                Hpath = psf;
            }

            //ceil
            if (wsf > criteria && wsf < ceil) {
                ceil = wsf;
                ceilPath = psf;
            }

            //floor
            if (wsf < criteria && wsf > floor) {
                floor = wsf;
                floorPath = psf;
            }
            //kth largest
            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                multisolver(graph, edge.nbr, dest, k, visited, criteria, psf + edge.nbr, wsf + edge.wt);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[vertices];
        multisolver(graph, 0, 6, 3, visited, 44, 0 + "", 0);
        System.out.println(Spath + "@" + Swt);
        System.out.println(Hpath + "@" + Hwt);
        System.out.println(ceilPath + "@" + ceil);
        System.out.println(floorPath + "@" + floor);

        System.out.println("Kth largest weight:" + " " + pq.peek().wsf);

    }
}
