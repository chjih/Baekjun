package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576 {
    private static int n, m, day=0;
    private static int[][] map, tomato;
    private static Queue<Point> queue = new LinkedList<>();
    private static int[] m1 = {1,-1,0,0};
    private static int[] m2 = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];
        tomato = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                // 익은 토마토이면 queue에 저장
                if(map[i][j]==1){
                    queue.add(new Point(i, j, 0));
                }
            }
        }

        bfs();

        // 다 익었는 지 확인
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]!=1&&map[i][j]!=-1){
                    result=-1;
                    break;
                }
            }
            if(result==-1){
                break;
            }
        }

        if(result==-1){
            System.out.println(result);
        }
        else{
            System.out.println(day);
        }

        sc.close();
    }

    private static void bfs(){
        Point p;
        int x, y;
        while(!queue.isEmpty()){
            p = queue.poll();

            for(int i=0; i<4; i++){
                x = p.x+m1[i];
                y = p.y+m2[i];

                // 범위 밖 리턴
                if(x<0||y<0||x>=n||y>=m){
                    continue;
                }

                // 익은거 퍼져갈 수 있을 때
                if(map[x][y]==0){
                    map[x][y]=1;
                    queue.add(new Point(x,y, p.day+1));
                    if(day<p.day+1){
                        day = p.day+1;
                    }
                }
            }
        }
    }

    static class Point{
        int x, y, day;

        public Point(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
