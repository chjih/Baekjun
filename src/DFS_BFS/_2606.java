package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2606 {
    static int[] computer;
    static int[][] network;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a,b;
        network = new int[n][n];
        computer = new int[n];

        for(int i=0; i<m; i++){
            a=sc.nextInt();
            b=sc.nextInt();

            network[--a][--b]=network[b][a]=1;
        }

        bfs();

        int count=0;
        for(int i=0; i<n; i++){
            if(computer[i]==1) count++;
        }
        System.out.println(count-1);
        sc.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        computer[0]=1;

        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i=0; i<network[n].length; i++){
                if(network[n][i]==1&&computer[i]!=1){
                    computer[i]=1;
                    queue.add(i);
                }
            }
        }
    }

}
