package Level1.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SpreadInfection {
    public static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        int v;
        int time;

        public Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    public static void spreadInfection(ArrayList<Edge>[] graph, int src, int[] visited, int t) {
        Queue<Pair> q = new ArrayDeque<>();
        int count = 0;
        q.add(new Pair(src, 1));
        while (!q.isEmpty()) {
            //r m* w a*
            Pair rem = q.remove();
            if (visited[rem.v] > 0) {
                continue;
            }
            visited[rem.v] = rem.time;
            if (rem.time > t) {
                break;
            }
            count++;
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == 0) {
                    q.add(new Pair(e.nbr, rem.time + 1));
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));

        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 4));
        graph[6].add(new Edge(6, 5));
        int[] visited = new int[vertices];
        spreadInfection(graph, 6, visited, 3);
    }
}
