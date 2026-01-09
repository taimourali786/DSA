package Graph;

import java.util.LinkedList;

public class AdjacencyList {
    public LinkedList<Integer> adjList[];

    public AdjacencyList(int numVertices) {
        adjList = new LinkedList[numVertices];
    }

    public void addEdge(int v1, int v2) {
        LinkedList<Integer> edges = adjList[v1];
        edges.add(v2);
    }

    public void removeEdge(int v1, int v2) {
        LinkedList<Integer> edges = adjList[v1];
        edges.remove(v2);
    }
}
