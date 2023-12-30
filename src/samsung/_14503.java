package samsung;

import java.util.*;

public class _14503 {
    static int n,m, count=0, r,c,direction;
    static int[][] map;
    static int[] m1 = {-1,0,1,0};
    static int[] m2 = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        r = sc.nextInt();
        c = sc.nextInt();
        direction = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j]=sc.nextInt();
            }
        }

        map[r][c]=2;
        clean();

        System.out.println(count+1);
        sc.close();
    }

    static void clean(){
        int x, y;

        while(true){
            // 찾았을 때 존재할 때
            if(!find()){
                x = r+m1[(direction+2)%4];
                y = c+m2[(direction+2)%4];
                // 존재하지 x -> 뒤로 후진
                if(map[x][y]!=1){
                    r = x;
                    c = y;
                }
                // 후진도 x
                else{
                    return;
                }
            }
        }
    }

    static boolean find(){
        int x,y, d;
        d = (direction+3)%4;
        for(int i=0; i<4; i++){
            x = m1[d]+r;
            y = m2[d]+c;

            if(map[x][y]==0){
                count++;
                map[x][y]=2;
                r = x;
                c = y;
                direction=d;
                return true;
            }
            d = (d+3)%4;
        }
        return false;
    }
}
