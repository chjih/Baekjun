package DFS_BFS;

import java.util.*;
import java.io.*;

public class _7569 {
    static int N, M, H;
    static int[][][] box;
    static int[] m1 = {0,0,0,0,1,-1};
    static int[] m2 = {0,0,1,-1,0,0};
    static int[] m3 = {1,-1,0,0,0,0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    box[i][j][k]=Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1){
                        queue.add(new Node(i,j,k));
                    }
                }
            }
        }

        int a,b,c;
        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            for(int i=0; i<6; i++){
                a = node.x+m1[i];
                b = node.y+m2[i];
                c = node.z+m3[i];

                if(a<0||b<0||c<0||a>=H||b>=N||c>=M||box[a][b][c]==-1){
                    continue;
                }

                if(box[a][b][c]==0){
                    box[a][b][c]=box[node.x][node.y][node.z]+1;
                    queue.add(new Node(a,b,c));
                }
            }
        }

        int MAX=0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(box[i][j][k]==0){
                        System.out.println("-1");
                        return;
                    }
                    MAX = Math.max(MAX, box[i][j][k]);
                }
            }
        }

        System.out.println(MAX-1);
    }

    static class Node{
        int x, y, z;

        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
