package dp;

import java.util.*;
import java.io.*;

public class _2579 {
    static int[] score;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        score = new int[n];
        dp = new int[n][2];

        for(int i=0; i<n; i++){
            score[i]=Integer.parseInt(br.readLine());
        }

        dp[0][0]=dp[0][1]=score[0];
        if(n>1){
            dp[1][0]=score[1]+score[0];
            dp[1][1]=score[1];
        }

        for(int i=2; i<n; i++){
            // 바로 전칸
            if(dp[i-1][0]!=dp[i-2][0]+score[i-1]){
                dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+score[i]);
            }
            dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+score[i]);
            // 전전칸
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i-2][0], dp[i-2][1])+score[i]);
        }

        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
