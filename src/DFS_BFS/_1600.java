package DFS_BFS;

import java.util.*;

public class _1600 {
    private static Scanner sc = new Scanner(System.in);
    private static int[][] map;
    private static int[][][] visit;
    private static int[] move1 = {-2, -2, -1, -1, 1, 1, 2, 2, 1, -1, 0, 0};
    private static int[] move2 = {-1, 1, -2, 2, -2, 2, -1, 1, 0, 0, -1, 1};
    private static int a, b;

    public static void main(String[] args) {
        int k = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        map = new int[b][a];
        visit = new int[b][a][31];

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = bfs(k, 0, 0);
        System.out.println(result);
    }

    public static int bfs(int k, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visit[x][y][k] = 1;
        queue.add(new Node(x, y, k, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == b - 1 && node.y == a - 1)
                return node.c;

            for (int i = 0; i < 12; i++) {
                int x2 = node.x + move1[i];
                int y2 = node.y + move2[i];

                if (x2 >= 0 && y2 >= 0 && x2 < b && y2 < a && map[x2][y2] != 1) {
                    if (i < 8 && node.k - 1 >= 0 && visit[x2][y2][node.k - 1] != 1) {
                        queue.add(new Node(x2, y2, node.k - 1, node.c + 1));
                        visit[x2][y2][node.k - 1] = 1;
                    } else if (i >= 8 && visit[x2][y2][node.k] != 1) {
                        queue.add(new Node(x2, y2, node.k, node.c + 1));
                        visit[x2][y2][node.k] = 1;
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x, y, k, c;

        public Node(int x, int y, int k, int c) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.c = c;
        }
    }
}
