package silver;

import java.util.*;
import java.io.*;

public class _1012 {
    static int M, N, count;
    static int[][] map;
    static int[] m1 = {0,0,-1,1};
    static int[] m2 = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int K, X, Y;
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                map[X][Y] = 1;
            }

            count=1;

            for(int j=0; j<M; j++){
                for(int k=0; k<N; k++){
                    if(1==map[j][k]){
                        bfs(j,k);
                    }
                }
            }

            System.out.println(count-1);
        }
    }

    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        count++;

        Node node;
        int xx, yy;
        while(!queue.isEmpty()){
            node = queue.poll();

            for(int i=0; i<4; i++){
                xx = node.x + m1[i];
                yy = node.y + m2[i];

                if(xx<0||yy<0||xx>=M||yy>=N||map[xx][yy]==count||map[xx][yy]==0){
                    continue;
                }

                map[xx][yy] = count;
                queue.add(new Node(xx,yy));
            }
        }
    }

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
