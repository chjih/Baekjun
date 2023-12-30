package samsung;

import java.util.*;
import java.io.*;

public class _17142 {
    static int N, M, count=0, all=0, MIN=2501, num=1;
    static int[][] map;
    static int[][] visited;
    static Node[] nodes = new Node[10];
    static int[] curNode;
    static int[] m1 = {0,0,-1,1};
    static int[] m2 = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        curNode = new int[M];

        for(int i=0 ;i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    nodes[count++] = new Node(i,j);
                }
                if(map[i][j]!=1){
                    all++;
                }
            }
        }

        all -= count;

        dfs(0,0);

        System.out.println(MIN==2501?-1:MIN);
    }

    static void dfs(int cur, int n){
        if(n==M){
            num++;
            bfs();
            return;
        }

        for(int i=cur; i<count; i++){
            curNode[n] = i;
            dfs(i+1, n+1);
        }
    }

    static void bfs(){
        Queue<Node2> queue = new LinkedList<>();
        Node node;
        for(int i=0; i<M; i++){
            node = nodes[curNode[i]];
            queue.add(new Node2(node.x, node.y, 0));
            visited[node.x][node.y]=num;
        }

        int x,y;
        int count=0, last=0;
        Node2 node2;
        while(!queue.isEmpty()){
            node2 = queue.poll();

            if(map[node2.x][node2.y]!=2){
                count++;
            }

            if(node2.time>=MIN){
                return;
            }

            last = node2.time;

            if(count==all){
                MIN = last;
                return;
            }

            for(int i=0; i<4; i++){
                x = node2.x + m1[i];
                y = node2.y + m2[i];

                // 범위 초과
                if(x<0||y<0||x>=N||y>=N){
                    continue;
                }

                if(map[x][y]!=1&&visited[x][y]!=num){
                    visited[x][y] = num;
                    queue.add(new Node2(x,y,node2.time+1));
                }
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

    static class Node2{
        int x, y, time;

        public Node2(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
