package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17144 {
    static int R, C, T, Y=-1;
    static int[][] map;
    static int[][] tmp;
    static int[] m1 = {0,0, -1, 1};
    static int[] m2 = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        tmp = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1&&Y==-1){
                    Y = i;
                }
            }
        }

        for(int i=0; i<T; i++){
            // 미세먼지 확산
            diffusion();

            // 공기청정기 작동
            airClean();
        }

        int count=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){
                    count+=map[i][j];
                }
            }
        }

        System.out.println(count);
    }

    public static void diffusion(){
        int x, y, count;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                tmp[i][j]=map[i][j];
            }
        }

        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                count=0;
                if (map[i][j]>=1) {
                    // 확산
                    for(int k=0; k<4; k++){
                        x=i+m1[k];
                        y=j+m2[k];

                        // 범위 밖
                        if(x<0||y<0||x>=R||y>=C||map[x][y]==-1){
                            continue;
                        }

                        tmp[x][y]+=map[i][j]/5;
                        count++;
                    }
                    tmp[i][j]-=(map[i][j]/5)*count;
                }
            }
        }

        int[][] t = map;
        map = tmp;
        tmp = t;
    }

    public static void airClean(){
        // 위에 반시계방향
        for(int i=Y-1; i>0; i--){
            map[i][0]=map[i-1][0];
        }
        for(int i=0; i<C-1; i++){
            map[0][i]=map[0][i+1];
        }
        for(int i=0; i<Y; i++){
            map[i][C-1]=map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[Y][i]=map[Y][i-1];
        }
        map[Y][1]=0;
        // 아래 시계방향
        for(int i=Y+2; i<R-1; i++){
            map[i][0]=map[i+1][0];
        }
        for(int i=0; i<C-1; i++){
            map[R-1][i]=map[R-1][i+1];
        }
        for(int i=R-1; i>Y+1; i--){
            map[i][C-1]=map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[Y+1][i]=map[Y+1][i-1];
        }
        map[Y+1][1]=0;
    }
}
