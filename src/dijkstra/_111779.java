package dijkstra;

import java.util.*;
import java.io.*;

public class _111779 {
    static List<Bus>[] list;
    static int N, M, A, B;

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

            list[a].add(new Bus(b, c));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int[] visited = new int[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Node(A, 0, new LinkedList<>(List.of(A))));
        dist[A]=0;

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            if(visited[node.cur]==1){
                continue;
            }
            visited[node.cur]=1;

            if(node.cur==B){
                System.out.println(node.cost);
                System.out.println(node.list.size());
                for(int i: node.list){
                    System.out.printf("%d ", i);
                }
                System.out.println();
                return;
            }

            for(Bus bus: list[node.cur]){
                if(dist[bus.node] >dist[node.cur]+bus.cost ){
                    dist[bus.node] = dist[node.cur]+bus.cost;
                    List<Integer> newList = new LinkedList<>(node.list);
                    newList.add(bus.node);
                    queue.add(new Node(bus.node, dist[bus.node], newList));
                }
            }
        }
    }

    static class Node{
        List<Integer> list;
        int cost;
        int cur;

        public Node(int cur, int cost, List<Integer> list){
            this.cur = cur;
            this.cost = cost;
            this.list = list;
        }
    }

    static class Bus{
        int node;
        int cost;

        public Bus(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
