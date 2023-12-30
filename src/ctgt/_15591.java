package ctgt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15591 {
    static int N, Q;
    static List<Node>[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        node = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new LinkedList<>();
        }

        int p, q, r;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            node[p].add(new Node(q, r));
            node[q].add(new Node(p, r));
        }

        int k, v, x;
        int[] visited = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            Arrays.fill(visited, 0);
            queue.clear();

            visited[v]=1;
            int count = 0;
            queue.add(v);

            while(!queue.isEmpty()){
                x = queue.poll();

                for(Node n: node[x]){
                    if(n.cost>=k&&visited[n.node]!=1){
                        count++;
                        queue.add(n.node);
                        visited[n.node]=1;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static class Node{
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
