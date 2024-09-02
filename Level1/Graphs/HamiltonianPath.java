package Level1.Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPath {
    public static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int src, String psf, HashSet<Integer> visited, int orgSrc) {
        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean closingEdgeFound = false;
            for (Edge e : graph[src]) {
                if (e.nbr == orgSrc) {
                    closingEdgeFound = true;
                    break;
                }
            }
            if (closingEdgeFound) {
                System.out.println("*"); //* means hamiltonian cycle
            } else {
                System.out.println("."); //. means hamiltonian path
            }
            return;
        }
        visited.add(src);
        for (Edge e : graph[src]) {
            if (!visited.contains(e.nbr)) {
                hamiltonianPathAndCycle(graph, e.nbr, psf + e.nbr, visited, orgSrc);
            }
        }
        visited.remove(src);
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 5));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));

        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 4));

        HashSet<Integer> visited = new HashSet<>();
        hamiltonianPathAndCycle(graph, 0, 0 + "", visited, 0);
    }
}
