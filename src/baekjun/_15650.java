package baekjun;

import java.util.Scanner;

public class _15650 {
    private static int[] number;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        number = new int[m];
        visited = new boolean[n];

        bt(n, m, 0);
    }

    public static void bt(int n, int m, int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(number[i] + 1 + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            number[index] = i;
            visited[i] = true;
            bt(n, m, index + 1);
            for (int j = i + 1; j < n; j++) {
                visited[j] = false;
            }
        }
    }
}
