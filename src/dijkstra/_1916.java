package dijkstra;

import java.util.*;
import java.io.*;

public class _1916 {
    static int N, M, S, E;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new List[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new LinkedList<>();
        }

        int a, b, c;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        queue.add(new Node(S, 0));

        int[] visited = new int[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, 100000001);
        dist[S]=0;

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            if(visited[node.node]==1){
                continue;
            }

            if(node.node==E){
                System.out.println(node.cost);
                return;
            }
            visited[node.node]=1;

            for(Node next: list[node.node]){
                if(dist[next.node]>dist[node.node]+next.cost){
                    dist[next.node] = dist[node.node]+next.cost;
                    queue.add(new Node(next.node, dist[next.node]));
                }
            }
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
