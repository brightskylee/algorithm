package org.test.ht;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DFS {

    private static class Graph {
        int val;
        List<Graph> children;

        public Graph(int val) {
            this.val = val;
        }
    }

    public static void dfs(Graph graph) {
        for (Graph g : graph.children) {
            process(g.val);
            dfs(g);
        }
    }

    public static void process(Integer value) {
        System.out.println(value);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(1);
        Graph graph1 = new Graph(2);
        Graph graph2 = new Graph(3);
        Graph graph3 = new Graph(4);
        Graph graph4 = new Graph(5);
        Graph graph5 = new Graph(6);
        Graph graph6 = new Graph(7);
        Graph graph7 = new Graph(8);
        Graph graph8 = new Graph(9);
        Graph graph9 = new Graph(10);
        Graph graph10 = new Graph(11);

        graph.children.addAll(Arrays.asList(graph1, graph2, graph3));
        graph1.children.addAll(Arrays.asList(graph4, graph5));
        graph2.children.addAll(Arrays.asList(graph6, graph7, graph8));
        graph4.children.addAll(Arrays.asList(graph9, graph10));

        dfs(graph);
    }
}
