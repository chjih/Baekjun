package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1952 {
    static int[][] map;
    static int m, n;
    static int[] m1 = {0,1,0,-1};
    static int[] m2 = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        int t=0, x=0, y=0, count=0;
        while(true){
            if(map[x][y]==0){
                map[x][y]=1;
                x+=m1[t];
                y+=m2[t];
                if(x>=0&&y>=0&&x<m&&y<n&&map[x][y]==0){
                    continue;
                }
                // 범위 넘어가거나 1일때 방향 바꾸러감
                x-=m1[t];
                y-=m2[t];
            }
            // 방향 바꿈
            t=(t+1)%4;
            x+=m1[t];
            y+=m2[t];
            // 다 지남
            if(map[x][y]==1){
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
