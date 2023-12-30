package graph;

import java.util.*;
import java.io.*;

public class _5214 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x;
        List<Integer>[] graph = new List[101001];

        for(int i=1; i<101001; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                x = Integer.parseInt(st.nextToken());
                graph[i+100001].add(x);
                graph[x].add(i+100001);
            }
        }

        // bfs
        int[] visited = new int[101001];
        Queue<Node2> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        queue.add(new Node2(1,1));
        visited[1]=1;
        Node2 cur;
        while(!queue.isEmpty()){
            cur = queue.poll();

            if(cur.node==N){
                System.out.println(cur.cost);
                return;
            }
            for(int i: graph[cur.node]){
                if(visited[i]==1){
                    continue;
                }

                visited[i]=1;
                if(i>100000){
                    queue.add(new Node2(i, cur.cost));
                }else{
                    queue.add(new Node2(i, cur.cost+1));
                }
            }
        }

        System.out.println("-1");
    }

    static class Node2{
        int node;
        int cost;

        public Node2(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}
