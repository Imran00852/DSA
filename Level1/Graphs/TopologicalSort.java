package Level1.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[4].add(new Edge(4, 6));
        graph[5].add(new Edge(5, 6));
        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                topologicalSort(graph, v, visited, st);
            }
        }

        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }
}

/*
Topological Sort: It is defined as the permutations of vertices of a directed Acyclic Graph
such that all the edges of nature u,v,  u appears before v.

Example:
0->3<-4
↓  ↑  ↓ ↘  -->directed acyclic graph(DAG)
1->2  5-> 6

its topological sorted order will be:
4
5
6
0
1
2   2 depends on 3 so it appears before 3 and so on...
3   3 doesnt depend on anyone

Algorithm:

we'll use DFS and stack. Stack will be filled with vertices on post order.

 */