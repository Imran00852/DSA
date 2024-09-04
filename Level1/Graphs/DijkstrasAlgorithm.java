package Level1.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
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
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void dijkstrasAlgo(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src, src + "", 0));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "via" + rem.psf + "@" + rem.wsf);
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 20));

        graph[1].add(new Edge(1, 0, 30));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 50));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 20));
        graph[3].add(new Edge(3, 2, 18));
        graph[3].add(new Edge(3, 4, 19));

        graph[4].add(new Edge(4, 3, 20));
        graph[4].add(new Edge(4, 5, 18));
        graph[4].add(new Edge(4, 6, 27));

        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));

        graph[6].add(new Edge(6, 4, 10));
        graph[6].add(new Edge(6, 5, 10));
        boolean[] visited = new boolean[vertices];
        dijkstrasAlgo(graph, 0, visited);
    }
}
