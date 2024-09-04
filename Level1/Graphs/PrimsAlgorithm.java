package Level1.Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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
        int av; //aquired vertex
        int wt;

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void primsAlgo(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src, -1, 0));
        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            if (rem.av != -1) {
                System.out.println("[" + rem.v + " " + rem.av + "@" + " " + rem.wt + "]");
            }
            for (Edge e : graph[rem.v]) {
                if (!visited[e.nbr]) {
                    q.add(new Pair(e.nbr, rem.v, e.wt));
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
        graph[0].add(new Edge(0, 3, 40));

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
        primsAlgo(graph, 0, visited);
    }
}

/*
Minimum Spanning Tree(MST):  An MST is a subgraph of a connected, undirected graph
that includes all the vertices (spanning) and is connected and acyclic (a tree).
Among all possible spanning trees, the MST is the one with the minimum possible
total edge weight.

some examples of spanning trees from the give tree below:
0--3--4
|  |  |\  -->give connected tree
1--2  5--6

  _||_
   \/

spanning trees

0--3--4            0--3--4
|  |  |            |  |   \      and so on...
1  2  5--6         1  2 6--5

we need to find MST for which we have 2 algorithms.

1) Prims algorithm
rm*wa*
2) Kruskals algorithm

*/
