package samsung;

import java.util.Scanner;

public class _14499 {
    private static int[] dice;
    private static int[][] map;
    private static int[] m1 = {0, 0, 0, -1, 1};
    private static int[] m2 = {0, 1, -1, 0, 0};
    private static int n, m, x, y, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        count = sc.nextInt();
        dice = new int[7];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int a;
        for (int i = 0; i < count; i++) {
            a = sc.nextInt();

            // 이동가능 확인
            x += m1[a];
            y += m2[a];
            if (x < 0 || y < 0 || x >= n || y >= m) {
                x -= m1[a];
                y -= m2[a];
                continue;
            }

            // 이동
            move(a);

            if (map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
        sc.close();
    }

    private static void move(int n) {
        int a;
        switch (n) {
            case 1:
                a = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = a;
                break;
            case 2:
                a = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = a;
                break;
            case 3:
                a = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = a;
                break;
            case 4:
                a = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = a;
                break;
        }
    }
}
