package Level1.Graphs;

import java.util.ArrayList;

public class GetConnectedComponents {
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

    public static void getConnectedComps(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                getConnectedComps(graph, e.nbr, comp, visited);
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
        graph[1].add(new Edge(1, 0, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[4].add(new Edge(4, 6, 10));
        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 4, 10));
        graph[6].add(new Edge(6, 5, 10));

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComps(graph, i, comp, visited);
                comps.add(comp);
            }
        }

        System.out.println(comps);
    }
}
