package cote;

import java.io.*;
import java.util.*;

public class _13549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, 100002);
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        queue.add(new Node(n, 0));

        Node node;
        int c;
        while(!queue.isEmpty()){
            node = queue.poll();

            // 도착했을 때
            if(node.cur==k){
                System.out.println(node.cost);
                break;
            }

            c = node.cur*2;
            if(c>=0&&c<=100000){
                if(visited[c]>node.cost){
                    visited[c]=node.cost;
                    queue.add(new Node(c, node.cost));
                }
            }
            c = node.cur-1;
            if(c>=0&&c<=100000){
                if(visited[c]> node.cost+1){
                    visited[c]=node.cost+1;
                    queue.add(new Node(c, node.cost+1));
                }
            }
            c = node.cur+1;
            if(c>=0&&c<=100000){
                if(visited[c]> node.cost+1){
                    visited[c]=node.cost+1;
                    queue.add(new Node(c, node.cost+1));
                }
            }
        }
    }

    static class Node{
        int cur;
        int cost;

        public Node(int cur, int cost){
            this.cur = cur;
            this.cost = cost;
        }
    }
}
