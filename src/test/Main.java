import java.util.*;
import java.util.stream.Collectors;

class Main {
    private static int[][] area;
    private static int[][] visit;
    private static int lines;
    private static int[] m1 = {-1, 1, 0, 0};
    private static int[] m2 = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        lines = sc.nextInt();
        area = new int[lines][lines];
        visit = new int[lines][lines];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lines; j++) {
                if (area[i][j] == 1 && visit[i][j] == 0) {
                    group.add(bfs(i, j));
                }
            }
        }

        System.out.println(group.size());

        if(group.size()>0){
            String s = group.stream().sorted()
                    .map(x->x.toString())
                    .collect(Collectors.joining(" "));
            System.out.println(s);
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        Point p;
        queue.add(new Point(x, y));
        int count = 0;
        while (!queue.isEmpty()) {
            p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x1 = p.x + m1[i];
                int y1 = p.y + m2[i];

                if (x1 < 0 || y1 < 0 || x1 >= lines || y1 >= lines) {
                    continue;
                }

                if (area[x1][y1] == 1 && visit[x1][y1] == 0) {
                    visit[x1][y1] = 1;
                    queue.add(new Point(x1,y1));
                    count++;
                }
            }
        }

        return count;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}