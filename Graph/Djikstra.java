package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Stream;

public class Djikstra {
    public void calculateShortestPath(Node source) {
        // A list that will maintain a list of visited nodes
        // A list that will maintain the distance from one node to another
        // For each node we will check if its not visited we will visit it
        // Find distance from vertex under study to adjacent vertex
        source.distance = 0;
        Set<Node> settled = new HashSet<>();
        PriorityQueue<Node> unsettled = new PriorityQueue<>();

        unsettled.add(source);

        while (!unsettled.isEmpty()) {
            Node current = unsettled.poll();
            settled.add(current);
            current.adjacentNodes
                    .entrySet().stream()
                    .filter(it -> !settled.contains(it.getKey()))
                    .forEach(unsettledNode -> {
                        findMinDistance(unsettledNode.getKey(), unsettledNode.getValue(), current);
                        unsettled.add(unsettledNode.getKey());
                    }
                    );
        }

    }

    public void findMinDistance(Node adjacent, Integer edgeWeight, Node source) {
        Integer distance = source.distance + edgeWeight;

        if(distance < adjacent.distance) {
            adjacent.distance = distance;
            adjacent.shortestDistance.add(source);
        }
    }

    public class Node implements Comparable<Node> {
        public String name;
        public int distance = Integer.MAX_VALUE; // store its own distance from source
        public LinkedList<Node> shortestDistance = new LinkedList<>(); // store shortest distance from the adjacent
                                                                       // nodes
        public Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addAdjacentNode(Node node, Integer distance) {
            this.adjacentNodes.put(node, distance);
        }

        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }
    }
}
