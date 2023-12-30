package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16234 {
    static int N,L,R;
    static int[][] map;
    static int[][] visited;
    static int[] m1 = {0, 0, 1, -1};
    static int[] m2 = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int day=1, hap;
        while(day<=2000){
            hap=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]!=day){
                        hap+=bfs(i, j, day);
                    }
                }
            }

            if(hap==0){
                System.out.println(day-1);
                break;
            }
            day++;
        }
    }

    static int bfs(int x, int y, int num){
        Queue<Pos> queue = new LinkedList<>();
        Set<Pos> set = new HashSet<>();
        queue.add(new Pos(x, y));
        visited[x][y]=num;

        Pos p;
        int xx, yy, minus, hap=0;
        while(!queue.isEmpty()){
            p = queue.poll();
            hap+=map[p.x][p.y];
            set.add(p);

            for(int i=0; i<4; i++){
                xx = p.x+m1[i];
                yy = p.y+m2[i];

                // 범위 밖 패스
                if(xx<0||yy<0||xx>=N||yy>=N){
                    continue;
                }

                // 이미 방문했던것도 패스
                if(visited[xx][yy]==num){
                    continue;
                }

                minus = Math.abs(map[xx][yy]-map[p.x][p.y]);
                if(minus<=R&&minus>=L){
                    queue.add(new Pos(xx, yy));
                    visited[xx][yy]=num;
                }
            }
        }

        if(set.size()!=0){
            return change(set, hap/set.size());
        }

        return 0;
    }

    static int change(Set<Pos> set, int num){
        int count=0;
        for(Pos p: set){
            if(map[p.x][p.y]!=num){
                count++;
                map[p.x][p.y]=num;
            }
        }
        return count;
    }

    static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
