package samsung;

import java.util.*;
import java.io.*;

public class _17143 {
    static int R,C,M;
    static Shark[][] map;
    static Set<Shark> shark = new HashSet<>();
    static int[] m1 = {0, -1, 1, 0, 0};
    static int[] m2 = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R+1][C+1];
        int r, c, s, d, z;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r,c,s,d,z);
        }

        int total=0;
        for(int i=1; i<=C; i++){
            total+=grep(i);
            move();
        }

        System.out.println(total);
    }

    static void move(){
        // 모두 null 처리
        shark.clear();
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(map[i][j]!=null){
                    shark.add(map[i][j]);
                    map[i][j]=null;
                }
            }
        }

        // 이동
        int left;
        for(Shark s: shark){
            left = s.speed;

            while(left>0){
                s.x += m1[s.dir];
                s.y += m2[s.dir];
                if(s.x<1||s.y<1||s.x>R||s.y>C){
                    s.x -= m1[s.dir];
                    s.y -= m2[s.dir];
                    s.dir = opp(s.dir);
                    continue;
                }
                left--;
            }

            check(s.x, s.y, s);
        }
    }

    static void check(int x, int y, Shark shark){
        if(map[x][y]!=null){
            if(map[x][y].size>shark.size){
                return;
            }
        }
        map[x][y] = shark;
    }

    static int opp(int n){
        if(n==1){
            return 2;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 4;
        }
        return 3;
    }

    static int grep(int cur){
        Shark target;
        for(int i=1; i<=R; i++){
            if(map[i][cur]!=null){
                target = map[i][cur];
                map[i][cur]=null;
                return target.size;
            }
        }
        return 0;
    }

    static class Shark{
        int x;
        int y;
        int size;
        int speed;
        int dir;

        public Shark(int x, int y, int speed, int dir, int size){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.size = size;
            this.dir = dir;
        }
    }
}
