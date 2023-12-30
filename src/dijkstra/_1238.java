package dijkstra;

import java.io.*;
import java.util.*;

public class _1238 {
    private static List<Node>[] list;
    private static List<Node>[] listBack;
    private static int N, M, X;
    private static int[] total;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        listBack = new List[N+1];
        total = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new LinkedList<>();
            listBack[i] = new LinkedList<>();
        }

        int a, b, c;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            listBack[b].add(new Node(a,c));
        }

        dijkstra();
        dijkstraBack();

        int max=0;
        for(int i=0; i<total.length; i++){
            max = Math.max(max, total[i]);
        }

        System.out.println(max);
    }

    static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        queue.add(new Node(X, 0));
        int[] visited = new int[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, 1000001);
        dist[X]=0;

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            if(visited[node.node]==1){
                continue;
            }

            visited[node.node]=1;
            total[node.node] += node.cost;

            for(Node next: list[node.node]){
                if(dist[next.node]>dist[node.node]+next.cost){
                    dist[next.node] = dist[node.node]+next.cost;
                    queue.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    static void dijkstraBack(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        queue.add(new Node(X, 0));
        int[] visited = new int[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, 1000001);
        dist[X]=0;

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            if(visited[node.node]==1){
                continue;
            }

            visited[node.node]=1;
            total[node.node] += node.cost;

            for(Node next: listBack[node.node]){
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
