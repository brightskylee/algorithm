package org.test.ht;

import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.INTERNAL;

public class ShortestBridge {

    private class Node {
        int row;
        int col;
        int depth;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
            this.depth = 0;
        }

        public Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }

    Queue<Node> waterQueue = new LinkedList<>();
    boolean[][] visisted;

    public int shortestPath(int[][] matrix) {
        visisted = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                visisted[i][j] = false;
            }
        }

        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == 1) {
                    populateWaterQueue(new Node(i, j), matrix);
                    i = Integer.MAX_VALUE - 1;
                    j = Integer.MAX_VALUE - 1;
                }
            }
        }

        return bfs(matrix);
    }

    int bfs(int[][] matrix) {
        while (!waterQueue.isEmpty()) {
            Node node = waterQueue.poll();
            if (matrix[node.row][node.col] == 1) {
                return node.depth;
            }

            if (node.row - 1 >= 0 && !visisted[node.row - 1][node.col]) {
                waterQueue.add(new Node(node.row - 1, node.col, node.depth + 1));
                visisted[node.row - 1][node.col] = true;
            }

            if (node.row + 1 < matrix.length && !visisted[node.row + 1][node.col]) {
                waterQueue.add(new Node(node.row + 1, node.col, node.depth + 1));
                visisted[node.row + 1][node.col] = true;
            }

            if (node.col - 1 >= 0 && !visisted[node.row][node.col - 1]) {
                    waterQueue.add(new Node(node.row, node.col - 1, node.depth + 1));
                    visisted[node.row][node.col - 1] = true;
            }


            if (node.col + 1 < matrix[0].length && !visisted[node.row][node.col + 1]) {
                    waterQueue.add(new Node(node.row, node.col + 1, node.depth + 1));
                    visisted[node.row][node.col + 1] = true;
            }
        }

        return -1;
    }

    void populateWaterQueue(Node node, int[][] matrix) {
        visisted[node.row][node.col] = true;
        if (node.row - 1 >= 0 && !visisted[node.row - 1][node.col]) {
            if (matrix[node.row - 1][node.col] == 1) {
                populateWaterQueue(new Node(node.row-1, node.col), matrix);
            }
            else{
                waterQueue.add(new Node(node.row - 1, node.col));
                visisted[node.row - 1][node.col] = true;
            }
        }

        if (node.row + 1 < matrix.length && !visisted[node.row + 1][node.col]) {
            if (matrix[node.row + 1][node.col] == 1) {
                populateWaterQueue(new Node(node.row+1, node.col), matrix);
            }
            else{
                waterQueue.add(new Node(node.row + 1, node.col));
                visisted[node.row + 1][node.col] = true;
            }
        }

        if (node.col - 1 >= 0 && !visisted[node.row][node.col - 1]) {
            if (matrix[node.row][node.col - 1] == 1) {
                populateWaterQueue(new Node(node.row, node.col - 1), matrix);
            }
            else{
                waterQueue.add(new Node(node.row, node.col - 1));
                visisted[node.row][node.col - 1] = true;
            }
        }


        if (node.col + 1 < matrix[0].length && !visisted[node.row][node.col + 1]) {
            if (matrix[node.row][node.col + 1] == 1) {
                populateWaterQueue(new Node(node.row, node.col + 1), matrix);
            }
            else{
                waterQueue.add(new Node(node.row, node.col + 1));
                visisted[node.row][node.col + 1] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
        ShortestBridge sb = new ShortestBridge();
        System.out.println(sb.shortestPath(matrix));
    }
}
