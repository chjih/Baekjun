package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15686 {
    private static Pos[] chickens = new Pos[13];
    private static Pos[] house = new Pos[100];
    private static Set<Integer> set = new HashSet<>();
    private static int chickenNum, houseNum, M, MIN=5000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int num;
        chickenNum=0;
        houseNum=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                num = Integer.parseInt(st.nextToken());
                if(num==1){
                   house[houseNum++]=new Pos(i, j);
                }else if(num==2){
                    chickens[chickenNum++]=new Pos(i, j);
                }
            }
        }

        dfs(0, 0);

        System.out.println(MIN);
    }

    private static void dfs(int cur, int count){
        if(count==M){
            check();
        }

        for(int i=cur; i<chickenNum; i++){
            set.add(i);
            dfs(i+1, count+1);
            set.remove(i);
        }
    }

    static void check(){
        int total=0;
        int min, tmp;
        for(int i=0; i<houseNum; i++){
            min=5000;
            for(int c: set){
                tmp = Math.abs(chickens[c].x-house[i].x)+Math.abs(chickens[c].y-house[i].y);
                if(min>tmp){
                    min=tmp;
                }
            }
            total+=min;
        }

        if(total<MIN){
            MIN=total;
        }
    }

    static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
