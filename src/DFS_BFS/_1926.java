package DFS_BFS;

import java.util.*;
import java.io.*;

public class _1926 {
    static int N, M, count=0, max=0;
    static int[][] map;
    static int[][] visited;
    static int[] m1 = {0,0,-1,1};
    static int[] m2 = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bfs(i,j);
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void bfs(int x, int y){
        if(map[x][y]==1&&visited[x][y]==0){
            count++;
        }else{
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y]=1;
        Node node;
        int xx, yy;
        int size=0;
        while(!queue.isEmpty()){
            node = queue.poll();
            size++;

            for(int i=0; i<4; i++){
                xx = node.x+m1[i];
                yy = node.y + m2[i];

                // 범위 나갈때
                if(xx<0||yy<0||xx>=N||yy>=M){
                    continue;
                }

                if(visited[xx][yy]==0&&map[xx][yy]==1){
                    visited[xx][yy]=1;
                    queue.add(new Node(xx,yy));
                }
            }
        }

        max = Math.max(size, max);
    }

    static class Node{
        int x,y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
