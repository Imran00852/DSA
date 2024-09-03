package Level1.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CheckForBipartiteGraph {
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
        int v;
        String psf;
        int level;

        public Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + "", 0));

        while (!q.isEmpty()) {
            Pair rem = q.remove();
            if (visited[rem.v] != -1) {
                if (rem.level != visited[rem.level]) {
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 10));

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == -1) {
                boolean isBipartite = isBipartite(graph, i, visited);
                if (!isBipartite) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}

/* 
Bipartite Graph: A graph is said to be bipartite if it is possible to make 2 sets from it
that are mutually exclusive(intersection of 2 sets=0 or no common elements among the two)
and exhaustive(all vertices should be present in combined sets) such that all the edges are
across set.

examples are:
All acyclic graphs are bipartite
cyclic graph with even length is also bipartite

graph1:
1---2
|   |  --> its a cyclic graph with even edges so its a bipartite graph or i can make             
3---4       2 sets from it and all rules will be followed

graph2:
 1
 |\  --> its a cyclic graph with even length so its not a bipartite as i cant make 2 sets
 2--3    that are mutually exclusive
 
graph3:
 1
 | --> its an acyclic graph so its bipartite as i can make 2 sets that are mutually exclusive  
 2     and exhaustive
 
 Algorithm:
 using BFS
 rm*wa* --> remove,mark star,work,add children

 */