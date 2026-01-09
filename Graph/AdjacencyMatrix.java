package Graph;

public class AdjacencyMatrix {
    
    private boolean adjacencyMatrix[][];
    private int numVertices;

    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int v1, int v2) {
        adjacencyMatrix[v1][v2] = true;
        adjacencyMatrix[v2][v1] = true;
    }

    public void removeEdge(int v1, int v2) {
        
        adjacencyMatrix[v1][v2] = false;
        adjacencyMatrix[v2][v1] = false;
    }
}
