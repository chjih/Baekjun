package DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1260 {
    static int[][] arr;
    static int[] visit;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        int a, b;

        arr = new int[n + 1][n + 1];
        visit = new int[n + 1];

        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            arr[a][b] = arr[a][b] = 1;
        }
        dfs(v);
        System.out.println();
        Arrays.fill(visit, 0);
        bfs(v);
        System.out.println();
        sc.close();
    }

    public static void bfs(int v) {
        visit[v] = 1;
        System.out.print(v + " ");

        for (int i = 1; i < arr[v].length; i++) {
            if (arr[v][i] == 1 && visit[i] != 1)
                bfs(i);
        }
    }

    public static void dfs(int v) {
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            visit[v] = 1;
            System.out.print(v + " ");

            for (int i = 1; i < arr[v].length; i++) {
                if (arr[v][i] == 1 && visit[i] != 1)
                    queue.add(i);
            }
        }
    }
}
