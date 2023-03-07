package DFS_BFS;

import java.awt.*;
import java.util.*;
import java.util.List;


public class _2667 {
    private static int[][] map;
    private static final int[] move1 = {-1, 0, 1, 0};
    private static final int[] move2 = {0, -1, 0, 1};
    private static final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.next().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1)
                    bfs(i, j);
            }
        }

        Collections.sort(numbers);
        System.out.println(numbers.size());
        numbers.forEach(System.out::println);
    }

    private static void bfs(int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        int a, b, count = 1;
        queue.add(new Point(n, m));
        map[n][m] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                a = p.x + move1[i];
                b = p.y + move2[i];

                if (a >= 0 && b >= 0 && a < map.length && b < map.length && map[a][b] == 1) {
                    map[a][b] = 0;
                    queue.add(new Point(a, b));
                    count++;
                }
            }
        }
        numbers.add(count);
    }
}
