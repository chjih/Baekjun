package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11725 {
    private static int n;
    private static ArrayList<Integer> tree[];
    private static int[] parent;
    private static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n+1];
        visit = new int[n+1];
        visit[1]=1;
        tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        int a,b;
        for(int i=0; i<n-1; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            tree[a].add(b);
            tree[b].add(a);
        }

        bfs();

        for(int i=2; i<n+1; i++){
            System.out.println(parent[i]);
        }

        sc.close();
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while(!queue.isEmpty()){
            int n = queue.poll();

            for(int node: tree[n]){
                if(visit[node]==0){
                    parent[node]=n;
                    visit[node]=1;
                    queue.add(node);
                }
            }
        }
    }
}
