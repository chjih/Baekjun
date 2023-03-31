package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _13460 {
    private static char[][] map;
    private static int[] m1 = {1, -1, 0, 0};
    private static int[] m2 = {0, 0, 1, -1};
    private static int[][][][] visit;
    private static int RX, RY;
    private static int BX, BY;
    private static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visit = new int[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R') {
                    RX = i;
                    RY = j;
                }
                if (map[i][j] == 'B') {
                    BX = i;
                    BY = j;
                }
            }
        }

        bfs();
        sc.close();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(RX, RY, BX, BY, 1));
        visit[RX][RY][BX][BY]=1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.count>10)
                continue;

            int r, b;
            for (int i = 0; i < 4; i++) {
                RX = node.rx;
                RY = node.ry;
                BX = node.bx;
                BY = node.by;

                if ((i == 0 && node.rx + m1[i] <= node.bx && node.ry == node.by)
                        || (i == 1 && node.rx + m1[i] >= node.bx && node.ry == node.by)
                        || (i == 2 && node.rx == node.bx && node.ry + m2[i] <= node.by)
                        || (i == 3 && node.rx == node.bx && node.ry + m2[i] >= node.by)) {

                    b = goBMax(m1[i], m2[i], node.bx, node.by);
                    r = goRMax(m1[i], m2[i], node.rx, node.ry);
                } else {
                    r = goRMax(m1[i], m2[i], node.rx, node.ry);
                    b = goBMax(m1[i], m2[i], node.bx, node.by);
                }
                if (r == 1 && b != 1) {
                    System.out.println(node.count);
                    return;
                }
                if (RX>0&&RY>0&&BX>0&&BY>0&&visit[RX][RY][BX][BY]==0) {
                    visit[RX][RY][BX][BY]=1;
                    queue.add(new Node(RX, RY, BX, BY, node.count+1));
                }
            }
        }
        System.out.println("-1");
    }

    public static int goRMax(int m1, int m2, int x, int y) {
        while (map[x + m1][y + m2] != '#' && (x + m1 != BX || y + m2 != BY)) {
            x += m1;
            y += m2;
            if (map[x][y] == 'O'){
                RX=-1;
                RY=-1;
                return 1;
            }
        }
        RX = x;
        RY = y;
        return -1;
    }

    public static int goBMax(int m1, int m2, int x, int y) {
        while (map[x + m1][y + m2] != '#' && (x + m1 != RX || y + m2 != RY)) {
            x += m1;
            y += m2;
            if (map[x][y] == 'O'){
                BX=-1;
                BY=-1;
                return 1;
            }
        }
        BX = x;
        BY = y;
        return -1;
    }

    static class Node {
        int rx;
        int ry;
        int bx, by;
        int count;

        public Node(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}
