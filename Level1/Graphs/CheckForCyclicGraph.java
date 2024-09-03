package Level1.Graphs;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CheckForCyclicGraph {
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

    public static class Pair {
        int src;
        String psf;

        public Pair(int src, String psf) {
            this.src = src;
            this.psf = psf;
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + ""));

        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.src]) {
                return true;
            }
            visited[rem.src] = true;
            for (Edge e : graph[rem.src]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));
        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 4, 10));
        graph[6].add(new Edge(6, 5, 10));

        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                boolean isCyclic = isCyclic(graph, i, visited);
                if (isCyclic) {
                    System.out.println(true);
                    return;
                }
            }
        }

        System.out.println(false);
    }
}
