package Level1.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class FindSinglePathBetweenSrcAndDest {
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

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vistied) {
        if (src == dest) {
            return true;
        }
        vistied[src] = true;
        for (Edge edge : graph[src]) {
            if (!vistied[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, vistied);
                if (hasNbrPath) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        ArrayList<Edge>[] graphs = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graphs[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = sc.nextLine().split(" ");
            int src = Integer.parseInt((parts[0]));
            int nbr = Integer.parseInt((parts[1]));
            int wt = Integer.parseInt((parts[2]));
            graphs[src].add(new Edge(src, nbr, wt));
            graphs[nbr].add(new Edge(nbr, src, wt));
            
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[vertices];
        boolean path = hasPath(graphs, src, dest, visited);
        System.out.println(path);
    }
}
