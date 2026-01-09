package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DepthFirstSearch {

    public class Graph {
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

        public void DFSwithStack(int currentVertex) {
            boolean[] visited = new boolean[numVertices];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(currentVertex);

            while (!stack.isEmpty()) {
                int vertex = stack.pop();
                LinkedList<Integer> adjacentVertices = adjVertices[vertex];

                if (!visited[vertex]) {
                    visited[vertex] = true;
                }
                for (Integer adjVertex : adjacentVertices) {
                    if (!visited[adjVertex]) {
                        stack.push(adjVertex);
                    }
                }

            }

        }
    }

}
