package backtracking;

import java.util.*;
import java.io.*;

public class _16987 {
    static int N, MAX=0;
    static Egg[] egg;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        egg = new Egg[N];

        int s, w;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            egg[i] = new Egg(s,w);
        }

        dfs(0,0);
        System.out.println(MAX);
    }

    static void dfs(int cur, int count){
        if(MAX<count){
            MAX = count;
        }

        if(cur==N){
            return;
        }

        // 든 것이 깨져있으면 패스
        if(egg[cur].s<=0){
            dfs(cur+1, count);
            return;
        }

        // 다음거 깨봄
        for(int i=0; i<N; i++){
            // 들고있는 계란이면 패스
            // 이미 깨진 계란이면 패스
            if(i==cur||egg[i].s<=0){
                continue;
            }

            egg[cur].s -= egg[i].w;
            egg[i].s -= egg[cur].w;

            // 지금 들고있는거 깨짐
            if(egg[cur].s<=0){
                // 부딪힌것도 같이 깨짐
                if(egg[i].s<=0){
                    dfs(cur+1, count+2);
                }
                else{
                    dfs(cur+1, count+1);
                }
            }
            // 안깨짐
            else{
                // 부딪힌거 깨짐
                if(egg[i].s<=0){
                    dfs(cur+1, count+1);
                }else{
                    dfs(cur+1, count);
                }
            }

            egg[cur].s += egg[i].w;
            egg[i].s += egg[cur].w;
        }
    }

    static class Egg{
        int w;
        int s;

        public Egg(int s, int w){
            this.w = w;
            this.s = s;
        }
    }
}
