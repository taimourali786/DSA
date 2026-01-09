package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public int numVertices;
    public LinkedList<Integer> adjVertices[];

    public Graph(int numVertices) {
            this.numVertices = numVertices;
            this.adjVertices = new LinkedList[numVertices]; // creates an array of linkedList
            for (int i = 0; i < numVertices; i++) {
                this.adjVertices[i] = new LinkedList<>(); // sets each index in array to a new linkedList
            }
        }

    public void addEdge(int source, int destination) {
        LinkedList<Integer> currentEdges = this.adjVertices[source];
        currentEdges.add(destination);
    }

    public void DFS(int currentVertex, boolean[] visited) {
        LinkedList<Integer> adjacentVerticesForCurrentVertex = adjVertices[currentVertex];
        visited[currentVertex] = true;

        for (Integer adjacentVertex : adjacentVerticesForCurrentVertex) {
            if (!visited[adjacentVertex]) {
                DFS(adjacentVertex, visited);
            }
        }
    }

    public void BFS(int currentVertex, boolean[] visited) {
        
    }

    public void BFSWithQueue(int currentVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(currentVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            LinkedList<Integer> adjacentVertices = adjVertices[vertex];

            if (!visited[vertex]) {
                visited[vertex] = true;
            }
            for (Integer adjVertex : adjacentVertices) {
                if (!visited[adjVertex]) {
                    queue.add(adjVertex);
                }
            }

        }

    }
}
