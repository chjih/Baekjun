package baekjun;

import java.util.Scanner;

public class _15649 {
    private static int[] number;
    private static boolean[] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        number = new int[m];
        visited = new boolean[n];
        bt(0);
    }

    private static void bt(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print((number[i] + 1) + " ");
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
            bt(index + 1);
            // 자식 노드 방문이 끝나고 돌아오면 방문 노드를 방문하지 않은 상태로 변경함
            visited[i] = false;
        }
    }
}
