/*
 * Graphs.java
 *
 * This file contains Java implementations of various graph algorithms and operations
 * without using any built-in functions. Each section is thoroughly commented
 * to explain each step and logic behind the graph operations.
 *
 */

import java.util.*;

public class Graphs {
    
    // Graph class using adjacency list
    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer> adj[]; // Adjacency lists

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Add edge to graph
        void addEdge(int v, int w) {
            adj[v].add(w); // Add w to v's list
        }

        // Recursive helper function for DFS
        void DFSUtil(int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // DFS traversal of vertices reachable from v
        void DFS(int v) {
            // Mark all vertices as not visited (set as false by default)
            boolean visited[] = new boolean[V];

            // Call recursive helper
            DFSUtil(v, visited);
            System.out.println();
        }

        // BFS traversal from given source
        void BFS(int s) {
            // Mark all vertices as not visited (set as false by default)
            boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                // Dequeue a vertex and print it
                s = queue.poll();
                System.out.print(s + " ");

                // Get all adjacent vertices
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            System.out.println();
        }
    }

    // Main method to test graph operations
    public static void main(String args[]) {
        Graph g = new Graph(4);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2)");
        g.DFS(2);

        System.out.println("Breadth First Traversal (starting from vertex 2)");
        g.BFS(2);
    }
}
