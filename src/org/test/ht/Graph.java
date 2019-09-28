package org.test.ht;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final int value;
    private List<Graph> neighbours;

    public Graph(int value) {
        this.value = value;
        neighbours = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public List<Graph> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Graph graph) {
        neighbours.add(graph);
    }

    public void addNeighbours(List<Graph> graphs) {
        neighbours.addAll(graphs);
    }
}
