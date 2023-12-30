package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684 {
    static int[][] map;
    static int n, m, MIN=Integer.MAX_VALUE, h;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1];
        int a, b;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b]=1;
        }

        dfs(1, 0);

        if(MIN>3){
            System.out.println(-1);
        }else{
            System.out.println(MIN);
        }
    }

    static void dfs(int preH, int c){
        if(c>3||MIN<c){
            return;
        }

        if(check()){
            MIN = c;
        }

        for(int j=1; j<n; j++){
            for(int i=preH; i<=h; i++){
                // 본인과 양 사이드에 선이 없을 때
                if(map[i][j]==0&&map[i][j-1]==0&&map[i][j+1]==0) {
                    map[i][j] = 1;
                    dfs(i, c+1);
                    map[i][j]=0;
                }
            }
        }
    }

    static boolean check(){
        int cur;
        for(int j=1; j<n; j++) {
            cur = j;
            for (int i = 1; i <= h; i++) {
                if (map[i][cur] == 1) {
                    cur++;
                }
                else if (map[i][cur - 1] == 1) {
                    cur--;
                }
            }
            if (cur != j) {
                return false;
            }
        }

        return true;
    }
}
