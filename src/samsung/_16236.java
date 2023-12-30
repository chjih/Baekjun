package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16236 {
    static int N, X, Y, SIZE;
    static int[] m1 = {0,0, 1, -1};
    static int[] m2 = {1, -1, 0, 0};
    static int[][] map;
    static int[][] visited;
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2)->{
        if(o1.cost!=o2.cost){
            return o1.cost-o2.cost;
        }
        if(o1.x!=o2.x){
            return o1.x-o2.x;
        }
        return o1.y-o2.y;
    });
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    X = i;
                    Y = j;
                    map[i][j]=0;
                    SIZE=2;
                    count=0;
                }
            }
        }

        int day=0,r;
        while(true){
            r = bfs(day+1);
            if(r==0){
                System.out.println(day);
                break;
            }
            day+=r;
        }
    }

    static int bfs(int num){
        queue.clear();
        queue.add(new Node(0, X, Y));
        visited[X][Y]=1;

        Node n;
        int x, y;
        while(!queue.isEmpty()){
            n = queue.poll();
            // 처음으로 먹게 된 물고기
            if(map[n.x][n.y]!=0&&map[n.x][n.y]<SIZE){
                count++;
                if(count==SIZE){
                    SIZE++;
                    count=0;
                }
                map[n.x][n.y]=0;
                X=n.x;
                Y=n.y;
                return n.cost;
            }

            for(int i=0; i<4; i++){
                x = n.x + m1[i];
                y = n.y + m2[i];

                // 범위 밖이거나 이미 본인 위치면 패스
                if(x<0||y<0||x>=N||y>=N||(x==X&&y==Y)){
                    continue;
                }

                // 방문한적 없던 곳이거나
                // 이동할 수 있는 곳일 때
                if(map[x][y]<=SIZE&&visited[x][y]!=num){
                    queue.add(new Node(n.cost+1, x, y));
                    visited[x][y]=num;
                }
            }
        }

        // 아무 물고기도 못먹음
        return 0;
    }

    static class Node{
        int cost, x, y;

        public Node(int cost, int x, int y){
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }
}
