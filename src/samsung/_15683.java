package samsung;

import java.util.*;

public class _15683 {
    static int n,m, min;
    static int[][] map;
    static int[][] record;
    static List<Point> cctvs = new ArrayList<>();
    static int[] m1={1,-1,0,0};
    static int[] m2 = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        record = new int[n][m];
        min = 64;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j]=sc.nextInt();
                record[i][j]=map[i][j];
                if(map[i][j]!=0&&map[i][j]!=6){
                    cctvs.add(new Point(map[i][j], i, j));
                }
            }
        }

        search(0);

        System.out.println(min);
        sc.close();
    }

    static void search(int number){
        // 모두 탐색
        if(number== cctvs.size()){
            int a = count();
            if(a<min){
                min=a;
            }
            return;
        }

        int cctv = cctvs.get(number).cctv;
        int x = cctvs.get(number).x;
        int y = cctvs.get(number).y;

        int[][] backup = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                backup[i][j] = record[i][j];
            }
        }

        if(cctv==1){
            // 한방향
            for(int i=0; i<4; i++){
                go(x, y, m1[i], m2[i]);
                search(number+1);
                //리셋
                reset(backup);
            }
            return;
        }
        if(cctv==2){
            // 양방향
            for(int i=0; i<3; i+=2){
                go(x,y,m1[i], m2[i]);
                go(x,y,m1[i+1], m2[i+1]);
                search(number+1);

                reset(backup);
            }
            return;
        }
        if(cctv==3){
            for(int i=0; i<2; i++){
                for(int j=2; j<4; j++){
                    go(x,y,m1[i], m2[i]);
                    go(x,y,m1[j], m2[j]);
                    search(number+1);

                    reset(backup);
                }
            }
            return;
        }
        if(cctv==4){
            for(int i=0; i<4; i++){
                go(x,y,m1[i], m2[i]);
                go(x,y,m1[(i+1)%4], m2[(i+1)%4]);
                go(x,y,m1[(i+2)%4], m2[(i+2)%4]);
                search(number+1);

                reset(backup);
            }
            return;
        }
        if(cctv==5){
            go(x,y,m1[0], m2[0]);
            go(x,y,m1[1], m2[1]);
            go(x,y,m1[2], m2[2]);
            go(x,y,m1[3], m2[3]);
            search(number+1);

            reset(backup);
        }
    }

    static void reset(int[][] backup){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                record[i][j]=backup[i][j];
            }
        }
    }

    static void go(int x, int y, int mx, int my){
        x+=mx;
        y+=my;
        while(x<n&&y<m&&x>=0&&y>=0){
            if(record[x][y]==6){
                break;
            }
            if(record[x][y]==0){
                record[x][y]=-1;
            }
            x+=mx;
            y+=my;
        }
    }

    static int count(){
        int count=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(record[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}

class Point{
    int x, y;
    int cctv;

    public Point(int cctv, int x, int y){
        this.x = x;
        this.y = y;
        this.cctv = cctv;
    }
}