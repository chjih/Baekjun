package DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2468 {
    private static int[][] map;
    private static int[][] visit;
    private static int[] move1 = {1, 0, -1, 0};
    private static int[] move2 = {0, 1, 0, -1};
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        map = new int[n + 1][n + 1];
        visit = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            getNumbers(i, n);
        }
        int max = 0;
        for (int i = 0; i <= 100; i++) {
            for(int k=1; k<=n; k++){
                Arrays.fill(visit[k], 0);
            }
            int count = find(n, i);
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);
        sc.close();
    }

    public static void getNumbers(int index, int n) {
        for (int i = 1; i <= n; i++) {
            map[index][i] = sc.nextInt();
        }
    }

    public static int find(int n, int depth) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visit[i][j] == 0 && map[i][j] > depth) {
                    count++;
                    check(i, j, depth, n);
                }
            }
        }
        return count;
    }

    public static void check(int x, int y, int depth, int n) {
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = {x, y};
        queue.add(arr);
        visit[x][y]=1;

        while (!queue.isEmpty()) {
            arr = queue.poll();
            x = arr[0];
            y = arr[1];
            for (int i = 0; i < 4; i++) {
                int a = x + move1[i];
                int b = y + move2[i];

                if (a <= n && b <= n && a >= 1 && b >= 1 && map[a][b] > depth && visit[a][b] != 1) {
                    int[] arr1 = {a, b};
                    queue.add(arr1);
                    visit[a][b] = 1;
                }
            }
        }
    }

}
