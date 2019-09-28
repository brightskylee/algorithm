package org.test.ht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<Boolean> columnAllowed = new ArrayList<Boolean>(n);
        for(int i=0;i<n;i++) columnAllowed.add(true);

        List<Boolean> leftDiagAllowed = new ArrayList<>(2 * n - 1);
        for(int i=0;i< 2 * n - 1;i++) leftDiagAllowed.add(true);

        List<Boolean> rightDiagAllowed = new ArrayList<>(2 * n - 1);
        for(int i=0;i<2 * n - 1;i++) rightDiagAllowed.add(true);

        return layer(n, n, columnAllowed, leftDiagAllowed, rightDiagAllowed);
    }

//    private static Set<Integer> calculateNotAllowed(int total, int layer, List<Integer> occupiedColumn) {
//        Set<Integer> notAllowed = new HashSet<>(occupiedColumn);
//        for(int i=1;i<=occupiedColumn.size();i++) {
//            int rightDiag = occupiedColumn.get(i-1) + (total - layer + 1) - i;
//            if (rightDiag >= 0 && rightDiag < total) {
//                notAllowed.add(rightDiag);
//            }
//            int leftDiag = occupiedColumn.get(i-1) - (total - layer + 1) + i;
//            if (leftDiag >= 0 && leftDiag < total) {
//                notAllowed.add(leftDiag);
//            }
//        }
//        return notAllowed;
//    }

    private List<List<String>> layer(int total, int n, List<Boolean> columnAllowed, List<Boolean> leftDiagAllowed, List<Boolean> rightDiagAllowed) {

        List<List<String>> results = new ArrayList<>();


        if (n == 1) {
            for (int i = 0; i < total; i++) {
                if (columnAllowed.get(i) && leftDiagAllowed.get(total - n + i) && rightDiagAllowed.get(total - n + total - i - 1)) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < total; j++) {
                        if (j == i) {
                            sb.append('Q');
                        } else {
                            sb.append('.');
                        }
                    }
                    List<String> tmp = new ArrayList<>();
                    tmp.add(sb.toString());
                    results.add(tmp);
                }
            }
        } else {
            for (int i = 0; i < total; i++) {
                if (columnAllowed.get(i) && leftDiagAllowed.get(total - n + i) && rightDiagAllowed.get(total - n + total - i - 1)) {
                    List<Boolean> newColumnAllowed = new ArrayList<>(columnAllowed);
                    List<Boolean> newLeftDiagAllowed = new ArrayList<>(leftDiagAllowed);
                    List<Boolean> newRightDiagAllowed = new ArrayList<>(rightDiagAllowed);

                    newColumnAllowed.set(i, false);
                    newLeftDiagAllowed.set(total - n + i, false);
                    newRightDiagAllowed.set(total - n + total - i - 1, false);

                    List<List<String>> next = layer(total, n - 1, newColumnAllowed, newLeftDiagAllowed, newRightDiagAllowed);
                    if (next.isEmpty()) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < total; j++) {
                        if (j == i) {
                            sb.append('Q');
                        } else {
                            sb.append('.');
                        }
                    }

                    for (List<String> l : next) {
                        l.add(0, sb.toString());
                        results.add(l);
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        NQueens test = new NQueens();
        List<List<String>> ans = test.solveNQueens(4);
        return;
    }
}
