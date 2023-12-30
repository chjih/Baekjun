package samsungdx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _1 {
    static int n, m, min;
    static List<List<Node>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            adj = new LinkedList<>();
            min = Integer.MAX_VALUE;

            for (int j = 0; j <= n; j++) {
                adj.add(new LinkedList<>());
            }

            int x, y, c;
            // 마니또 관계 입력(인접 Node 저장)
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                adj.get(x).add(new Node(y, c));
            }

            for (int j = 0; j <= n; j++) {
                isCycle(j, j, new int[n + 1], 0);
            }

            System.out.println("#" + (i + 1) + " " + (min == Integer.MAX_VALUE ? -1 : min));
        }
    }

    static void isCycle(int start, int node, int[] visited, int cost) {
        // 이미 최소값 넘어가면 더 탐색x
        if (cost >= min) {
            return;
        }
        visited[node] = 1;

        for (Node n : adj.get(node)) {
            // 사이클 완성
            if (n.node == start) {
                // 최소값인지 확인
                if ((cost + n.cost) < min) {
                    min = cost + n.cost;
                }
                continue;
            }
            // 탐색
            if (visited[n.node] == 0) {
                isCycle(start, n.node, visited, cost + n.cost);
            }
        }
    }
}

class Node {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}