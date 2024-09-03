package Level1.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstTraversal {
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

    public static void bfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + ""));

        while (!q.isEmpty()) {
            //r m* w a*
            Pair rem = q.remove();
            if (visited[rem.src]) {
                continue;
            }
            visited[rem.src] = true;
            System.out.println(rem.src + "@" + rem.psf);
            for (Edge e : graph[rem.src]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
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
        bfs(graph, 0, visited);
    }
}

