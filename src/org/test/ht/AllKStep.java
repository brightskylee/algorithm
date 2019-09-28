package org.test.ht;

public class AllKStep {

    public int allKStep(char[][] matrix, int si, int sj, int di, int dj, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return allKStep(matrix, si, sj, di, dj, k, visited);
    }

    private int allKStep(char[][] matrix, int si, int sj, int di, int dj, int k, boolean[][] visited) {
        if (si == di && sj == dj) {
            return 0;
        }

        if (k == 1) {
            return Math.abs(di - si) <= 1 && Math.abs(dj - sj) <= 1 ? 1 : 0;
        }

        int up;
        if (di - 1 < 0 || visited[di - 1][dj]) {
            up = 0;
        }
        else {
            visited[di][dj] = true;
            up = allKStep(matrix, si, sj, di - 1, dj, k - 1, visited);
            visited[di][dj] = false;
        }

        int down;
        if ((di + 1 >= matrix.length) || visited[di+1][dj]) {
            down = 0;
        }
        else {
            visited[di][dj] = true;
            down = allKStep(matrix, si, sj, di + 1, dj, k - 1, visited);
            visited[di][dj] = false;
        }

        int left;
        if (dj - 1 < 0 || visited[di][dj-1]) {
            left = 0;
        }
        else {
            visited[di][dj] = true;
            left = allKStep(matrix, si, sj, di, dj - 1, k - 1, visited);
            visited[di][dj] = false;
        }

        int right;
        if (dj + 1 >= matrix.length || visited[di][dj+1]) {
            right = 0;
        }
        else {
            visited[di][dj] = true;
            right = allKStep(matrix, si, sj, di, dj + 1, k - 1, visited);
            visited[di][dj] = false;
        }

        int leftUp;
        if (di - 1 < 0 || dj - 1 < 0 || visited[di-1][dj-1]) {
            leftUp = 0;
        }
        else {
            visited[di][dj] = true;
            leftUp = allKStep(matrix, si, sj, di - 1, dj - 1, k - 1, visited);
            visited[di][dj] = false;
        }

        int leftDown;
        if (di + 1 >= matrix.length || dj - 1 < 0 || visited[di+1][dj-1]) {
            leftDown = 0;
        }
        else {
            visited[di][dj] = true;
            leftDown = allKStep(matrix, si, sj, di + 1, dj - 1, k - 1, visited);
            visited[di][dj] = false;
        }

        int rightUp;
        if (di - 1 < 0 || dj + 1 >= matrix.length || visited[di-1][dj+1]) {
            rightUp = 0;
        }
        else {
            visited[di][dj] = true;
            rightUp = allKStep(matrix, si, sj, di - 1, dj + 1, k - 1, visited);
            visited[di][dj] = false;
        }

        int rightDown;
        if (di + 1 >= matrix.length || dj + 1 >= matrix.length ||
                visited[di+1][dj+1]) {
            rightDown = 0;
        }
        else {
            visited[di][dj] = true;
            rightDown = allKStep(matrix, si, sj, di + 1, dj + 1, k - 1, visited);
            visited[di][dj] = false;
        }
        
        return left + right + up + down + leftUp + leftDown + rightUp + rightDown;
    }
    
    public static void main(String[] args) {
        AllKStep allKStep = new AllKStep();
        
        char[][] matrix = new char[4][4];
        
        System.out.println(allKStep.allKStep(matrix, 3, 0, 2, 1, 4));
        
        
    }
}
