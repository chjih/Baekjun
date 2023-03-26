package backtracking;

import java.util.*;

public class _1941 {

    private static int[] set = new int[7];
    private static char[][] map = new char[5][5];
    private static int[][] check = new int[5][5];
    private static int[] m1 = {1,0,-1,0};
    private static int[] m2 = {0,-1,0,1};
    private static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<5; i++){
            map[i] = sc.next().toCharArray();
        }

        dfs(0,0,0);
        System.out.println(count);
        sc.close();
    }

    private static void dfs(int cur, int total, int s){
        if(total-s>3){
            return;
        }

        if(total==7){
            if(check(set[0]/5, set[0]%5)){
                count++;
            }
            return;
        }

        for(int i=cur; i<25; i++){
            set[total] = i;
            check[i/5][i%5] = 7;
            dfs(i+1, total+1, map[i/5][i%5]=='S'?s+1:s);
            check[i/5][i%5] = 0;
        }
    }

    private static boolean check(int x, int y){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x,y));
        Pos pos;
        int x2, y2, count=0;
        int[][] move = new int[5][5];

        while(!queue.isEmpty()){
            pos = queue.poll();

            for(int i=0; i<4; i++){
                x2 = pos.x+m1[i];
                y2 = pos.y+m2[i];

                if(x2>=0&&y2>=0&&x2<5&&y2<5
                && check[x2][y2]==7&&move[x2][y2]==0){
                    move[x2][y2]=1;
                    queue.add(new Pos(x2,y2));
                    count++;
                }
            }
        }

        return count == 7;
    }

    static class Pos{
        int x,y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
