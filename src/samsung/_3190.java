package samsung;

import java.util.*;

public class _3190 {
    private static int[] m1={1,-1,0,0};
    private static int[] m2 = {0,0,-1,1};
    private static int[][] map;
    private static int[][] l;
    private static int lastX, lastY, head, headX, headY, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int x, y, i;
        map = new int[n+1][n+1];
        head = 1;

        for(i=0; i<a; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            map[x][y] = -1;
        }

        map[1][1]=1;
        lastX=1;
        lastY=1;
        headX=1;
        headY=1;

        // 이동
        int move = sc.nextInt();
        l = new int[move][2];
        for(i=0; i<move; i++){
            l[i][0] = sc.nextInt();
            l[i][1] = sc.next().charAt(0);
        }
        int recent=0;
        for(i=0; i<move; i++){
            if(!move(l[i][0]-recent))
                break;
            if(l[i][1]=='D'){
                head=(head+1)%4;
            }else{
                head=(head+3)%4;
            }
            recent=l[i][0];
        }
        if(i==move){
            for(i=0; i<n; i++){
                if(!move(1)) break;
            }
        }

        sc.close();
    }

    public static boolean move(int X){
        int x,y;
        for(int i=0; i<X; i++){
            x = headX;
            y = headY;
            switch(head){
                case 0:
                    headX-=1;
                    break;
                case 1:
                    headY+=1;
                    break;
                case 2:
                    headX+=1;
                    break;
                case 3:
                    headY-=1;
                    break;
            }
            // 벗어나거나 자기자신인지 확인
            if(headX>n||headY>n||headX<1||headY<1||map[headX][headY]>=1){
                System.out.println(map[x][y]);
                return false;
            }

            // 이동
            if(map[headX][headY]!=-1){
                map[headX][headY] = map[x][y]+1;
                deleteTail();
            }
            else map[headX][headY] = map[x][y]+1;
        }
        return true;
    }

    public static void deleteTail(){
        int x,y;
        int last = map[lastX][lastY];
        map[lastX][lastY]=0;
        for(int i=0; i<4; i++){
            x=lastX+m1[i];
            y=lastY+m2[i];

            if(x<1||y<1||x>n||y>n)
                continue;

            if(map[x][y]==last+1){
                lastX=x;
                lastY=y;
                break;
            }
        }
    }
}
