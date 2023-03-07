package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;

public class _2178 {
    private static int[][] map;
    private static int[][] count;
    private static final int[] move1 = {-1, 0, 1, 0};
    private static final int[] move2 = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        count = new int[n][m];
        count[0][0] = 1;

        for (int i = 0; i < n; i++) {
            map[i] = Stream.of(sc.next().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        bfs(n - 1, m - 1);
        System.out.println(count[n - 1][m - 1]);
    }

    public static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int[] arr = {0, 0};
        int a, b, a2, b2;
        queue.add(arr);
        map[0][0] = 0;

        while (!queue.isEmpty()) {
            arr = queue.poll();
            a = arr[0];
            b = arr[1];

            for (int i = 0; i < 4; i++) {
                a2 = a + move1[i];
                b2 = b + move2[i];
                if (a2 >= 0 && b2 >= 0 && a2 < map.length && b2 < map[0].length && map[a2][b2] == 1) {
                    int[] arr1 = {a2, b2};
                    queue.add(arr1);
                    map[a2][b2] = 0;
                    count[a2][b2] = count[a][b] + 1;
                }
            }
        }
    }
}
