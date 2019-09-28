package org.test.ht;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Matrix {

    private static class Node {
        int row;
        int col;
        Set<Integer> apologies;

        public Node(int row, int col, Set<Integer> apologies) {
            this.row = row;
            this.col = col;
            this.apologies = apologies;
        }
    }

    public static int shortestPath(int n, Integer[][] matrix, int startRow, int startCol, int endRow, int endCol) {

        boolean[][] visited = new boolean[n][];
        for (int i=0;i<n;i++) {
            visited[i] = new boolean[n];
            for(int j=0;j<n;j++) {
                visited[i][j] = false;
            }
        }

        visited[startRow][startCol] = true;
        Deque<Node> queue = new ArrayDeque<>();
        queue.addFirst(new Node(startRow, startCol, Collections.singleton(matrix[startRow][startCol])));

        while(!queue.isEmpty()) {
            Node currNode = queue.pollFirst();

            if (currNode.row == endRow && currNode.col == endCol) {
                return currNode.apologies.size();
            }

            if (currNode.row - 1 >= 0 && !visited[currNode.row - 1][currNode.col]) {
                Set<Integer> tmpSet = new HashSet<>(currNode.apologies);
                tmpSet.add(matrix[currNode.row - 1][currNode.col]);
                if (tmpSet.equals(currNode.apologies)) {
                    queue.addFirst(new Node(currNode.row - 1, currNode.col, tmpSet));
                }
                else {
                    queue.addLast(new Node(currNode.row - 1, currNode.col, tmpSet));
                }
                visited[currNode.row - 1][currNode.col] = true;
            }

            if (currNode.row + 1 < n && !visited[currNode.row + 1][currNode.col]) {
                Set<Integer> tmpSet = new HashSet<>(currNode.apologies);
                tmpSet.add(matrix[currNode.row + 1][currNode.col]);
                if (tmpSet.equals(currNode.apologies)) {
                    queue.addFirst(new Node(currNode.row + 1, currNode.col, tmpSet));
                }
                else {
                    queue.addLast(new Node(currNode.row + 1, currNode.col, tmpSet));
                }
                visited[currNode.row + 1][currNode.col] = true;
            }

            if (currNode.col - 1 >= 0 && !visited[currNode.row][currNode.col - 1]) {
                Set<Integer> tmpSet = new HashSet<>(currNode.apologies);
                tmpSet.add(matrix[currNode.row][currNode.col - 1]);
                if (tmpSet.equals(currNode.apologies)) {
                    queue.addFirst(new Node(currNode.row, currNode.col - 1, tmpSet));
                }
                else {
                    queue.addLast(new Node(currNode.row, currNode.col - 1, tmpSet));
                }
                visited[currNode.row][currNode.col - 1] = true;

            }

            if (currNode.col + 1 < n && !visited[currNode.row][currNode.col + 1]) {
                Set<Integer> tmpSet = new HashSet<>(currNode.apologies);
                tmpSet.add(matrix[currNode.row][currNode.col + 1]);
                if (tmpSet.equals(currNode.apologies)) {
                    queue.addFirst(new Node(currNode.row, currNode.col + 1, tmpSet));
                }
                else {
                    queue.addLast(new Node(currNode.row, currNode.col + 1, tmpSet));
                }
                visited[currNode.row][currNode.col + 1] = true;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Integer[][] maxtrix = new Integer[5][5];

        maxtrix[0] = Arrays.asList(0, 1, 0, 8, 3).toArray(new Integer[5]);
        maxtrix[1] = Arrays.asList(0, 2, 0, 3, 1).toArray(new Integer[5]);
        maxtrix[2] = Arrays.asList(0, 5, 0, 0, 0).toArray(new Integer[5]);
        maxtrix[3] = Arrays.asList(0, 5, 7, 8, 0).toArray(new Integer[5]);
        maxtrix[4] = Arrays.asList(0, 0, 0, 0, 0).toArray(new Integer[5]);

        System.out.println(shortestPath(5, maxtrix, 0, 0, 0, 3));
    }
 }
