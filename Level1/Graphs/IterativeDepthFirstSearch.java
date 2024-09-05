package Level1.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDepthFirstSearch {
    public static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static class Pair {
        int vt;
        String psf;

        public Pair(int vt, String psf) {
            this.vt = vt;
            this.psf = psf;
        }
    }

    public static void iterativeDFS(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Pair> st) {
        st.push(new Pair(src, src + ""));
        while (st.size() > 0) {
            Pair rem = st.pop();
            if (visited[rem.vt]) {
                continue;
            }
            visited[rem.vt] = true;
            System.out.println(rem.vt + " " + "@" + " " + rem.psf);
            for (Edge e : graph[rem.vt]) {
                if (!visited[e.nbr]) {
                    st.push(new Pair(e.nbr, rem.psf + e.nbr));
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
        boolean[] visited = new boolean[vertices];
        Stack<Pair> st = new Stack<>();
        iterativeDFS(graph, 0, visited, st);

    }
}
