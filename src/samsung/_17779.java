package samsung;

import java.util.*;
import java.io.*;

public class _17779 {
    static int N, total=0, MIN=400001;
    static int[][] map;
    static int[][] section;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        section = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for(int d1=1; d1<N; d1++){
            for(int d2=d1; d2<N; d2++){
                XY(d1,d2);
                XY(d2,d1);
            }
        }

        System.out.println(MIN);
    }

    static void XY(int d1, int d2){
        for(int x=1; x<=N-d1-d2; x++){
            for(int y=1+d1; y<=N-d2; y++){
                for(int i=1; i<=N; i++){
                    Arrays.fill(section[i], 0);
                }

                getSection(x,y,d1,d2);
            }
        }
    }

    static void getSection(int x, int y, int d1, int d2){
        //1
        for(int i=0; i<=d1; i++){
            section[x+i][y-i] = 5;
        }
        //2
        for(int i=0; i<=d2; i++){
            section[x+i][y+i]=5;
        }
        //3
        for(int i=0; i<=d2; i++){
            section[x+d1+i][y-d1+i]=5;
        }
        //4
        for(int i=0; i<=d1; i++){
            section[x+d2+i][y+d2-i]=5;
        }


        int[] p = new int[6];
        //1번 선거구
        for(int i=1; i<x+d1; i++){
            for(int j=1; j<=y; j++){
                if(section[i][j]==5){
                    break;
                }
                p[1]+=map[i][j];
                section[i][j]=1;
            }
        }
        // 2번 선거구
        for(int i=1; i<=x+d2; i++){
            for(int j=N; j>y; j--){
                if(section[i][j]==5){
                    break;
                }
                p[2]+=map[i][j];
                section[i][j]=2;
            }
        }
        // 3번 선거구
        for(int i=x+d1; i<=N; i++){
            for(int j=1; j<y-d1+d2; j++){
                if(section[i][j]==5){
                    break;
                }
                p[3]+=map[i][j];
                section[i][j]=3;
            }
        }
        // 4번 선거구
        for(int i=x+d2+1; i<=N; i++){
            for(int j=N; j>=y-d1+d2; j--){
                if(section[i][j]==5){
                    break;
                }
                p[4]+=map[i][j];
                section[i][j]=4;
            }
        }


        p[5] = total-p[1]-p[2]-p[3]-p[4];

        int min=40001, max=0;
        for(int i=1; i<=5; i++){
            min = Math.min(min, p[i]);
            max = Math.max(max,p[i]);
        }

        MIN = Math.min(MIN, max-min);
    }


}
