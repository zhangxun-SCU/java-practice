package cw.learn.basic;

public class recursion {
    public static void main(String[] args) {
        RecursionFunction f = new RecursionFunction();
        System.out.println(f.factorial(5));
        System.out.println(f.fibonacci(7));
        System.out.println(f.monkeyPeach(1, 10));
        int[][] map = f.makeMap(8, 7);
        f.maze(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        f.hanoiTower(3, 'a', 'b', 'c');
    }
}

class RecursionFunction {
    public int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int monkeyPeach(int n, int totalDays) {
        if (n < 0) {
            return -1;
        }
        if (n == totalDays) {
            return 1;
        }
        return (monkeyPeach(n + 1, totalDays) + 1) * 2;
    }

    public int[][] makeMap(int row, int col) {
        int[][] map = new int[row][col];
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        map[2][5] = 1;
        map[4][5] = 1;
        map[5][2] = 1;
        map[5][4] = 1;
//        map[6][3] = 1;
        return map;
    }

    public boolean maze(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
//               假定能走通
            map[i][j] = 2;
//            找一下看是否能走通
            if (maze(map, i + 1, j)) {
                return true;
            } else if (maze(map, i, j + 1)) {
                return true;

            } else if (maze(map, i - 1, j)) {
                return true;

            } else if (maze(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    public void hanoiTower(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("move " + n + " from " + a + " to " + c);
        } else {
            hanoiTower(n - 1, a, c, b);
            System.out.println("move " + n + " from " + a + " to " + c);
            hanoiTower(n - 1, b, a, c);
        }
    }
}