package org.test.ht;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void traverse(Graph graph) {
        Queue<Graph> nodeQueue = new LinkedList<>();

        nodeQueue.add(graph);
        Graph node;
        while ((node = nodeQueue.poll()) != null) {
            process(node.getValue());
            if (!node.getNeighbours().isEmpty()) {
                nodeQueue.addAll(node.getNeighbours());
            }
        }
    }

    public static void process(Integer value) {
        System.out.println(value);
    }
}
