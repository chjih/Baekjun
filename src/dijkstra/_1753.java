package dijkstra;

import java.util.*;

public class _1753 {
    static ArrayList<Node> list[];       // 인접리스트
    static int dist[];              // 최단거리 저장
    static int v, e, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();
        k = sc.nextInt();

        list = new ArrayList[v + 1];

        // 정점 개수만큼 ArrayList 할당해줌
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            list[u].add(new Node(v, w));
        }

        // start부터 dot으로 가는 최단거리 저장할 곳
        dist = new int[v + 1];
        // 최대값으로 초기화
        Arrays.fill(dist, 200000);

        // 시작점
        dist[k] = 0;

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == 200000) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        sc.close();
    }

    private static void dijkstra(int s) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        List<Node> l;
        queue.add(new Node(s, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : list[now.index]) {
                // 이동한게 더 가중치가 적을 때 갱신 후 해당 Node 다시 탐색
                if (dist[next.index] > next.cost + now.cost) {
                    dist[next.index] = next.cost + now.cost;
                    queue.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        // 가중치 값 비교
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
