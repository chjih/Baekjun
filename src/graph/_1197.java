package graph;

import java.io.*;
import java.util.*;

public class _1197 {
    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        int a, b, c;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            queue.add(new Node(a,b,c));
        }

        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i]=i;
        }

        Node node;
        long cost=0;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(!union(node.a, node.b)){
                cost += node.cost;
            }
        }
        System.out.println(cost);
    }

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b){
            return true;
        }

        if(a<b){
            parent[b]=a;
        }else{
            parent[a]=b;
        }
        return false;
    }

    static int find(int a){
        if(a==parent[a]){
            return a;
        }
        return parent[a]=find(parent[a]);
    }

    static class Node{
        int a, b;
        int cost;

        public Node(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
