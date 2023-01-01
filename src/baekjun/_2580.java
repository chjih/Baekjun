package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _2580 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[][] adr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            input(i, br.readLine());
        }
        sudoku(0, 0);
    }

    private static void sudoku(int depth, int column) throws IOException {
        if (depth == 9) {
            sudoku(0, column+1);
            return;
        }

        if (column == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(adr[i][j] + " ");
                }
                bw.newLine();
            }
            bw.flush();
            System.exit(0);
        }

        if (adr[depth][column] == 0) {
            for (int x = 1; x <= 9; x++) {
                if (isPossible(depth, column, x)) {
                    adr[depth][column] = x;
                    sudoku(depth+1, column);
                    adr[depth][column] = 0;
                }
            }
            return;
        }
        sudoku(depth+1, column);
    }

    private static boolean isPossible(int depth, int column, int value) {
        // 가로줄에 같은 수가 존재하는 지
        for (int i = 0; i < 9; i++) {
            if (value == adr[depth][i]) {
                return false;
            }
        }
        // 세로줄
        for (int i = 0; i < 9; i++) {
            if (value == adr[i][column]) {
                return false;
            }
        }
        //3*3
        int n = depth / 3 * 3;
        int m = column / 3 * 3;
        for (int i = n; i < n + 3; i++) {
            for (int j = m; j < m + 3; j++) {
                if (value == adr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void input(int index, String input) {
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < 9; i++) {
            adr[index][i] = Integer.parseInt(st.nextToken());
        }
    }
}
