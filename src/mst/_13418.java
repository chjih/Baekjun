package mst;

import java.io.*;
import java.util.*;

public class _13418 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        PriorityQueue<Node> worstQueue = new PriorityQueue<>((o1,o2)->o2.cost-o1.cost);
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i]=i;
        }

        int a,b,c;
        for(int i=0; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            queue.add(new Node(a,b, c==0?1:0));
            worstQueue.add(new Node(a,b, c==0?1:0));
        }

        // MST
        Node cur;
        int countA=0, countB=0;
        while(!queue.isEmpty()){
            cur = queue.poll();

            if(!union(cur.node1, cur.node2)){
                countA+=cur.cost;
            }
        }

        for(int i=0; i<=N; i++){
            parent[i]=i;
        }
        while(!worstQueue.isEmpty()){
            cur = worstQueue.poll();

            if(!union(cur.node1, cur.node2)){
                countB+=cur.cost;
            }
        }

        System.out.println(countB*countB-countA*countA);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        // 부모가 같을 때
        if(x==y){
            return true;
        }

        // 부모가 다를 때
        parent[x]=y;
        return false;
    }

    static int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x]=find(parent[x]);
    }

    static class Node{
        int node1, node2;
        int cost;

        public Node(int node1, int node2, int cost){
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }
    }
}
