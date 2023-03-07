package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2644 {
    private static int[][] relation;
    private static int[] person;
    private static int[][] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt(), y=sc.nextInt();
        int m = sc.nextInt();
        relation = new int[n+1][n+1];
        int a,b;

        for(int i=0; i<m; i++){
            a=sc.nextInt();
            b=sc.nextInt();

            relation[a][b]=1;
        }

        bfs(x,y);
    }

    private static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
    }
}
