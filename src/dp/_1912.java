package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] hap = new int[n];
        dp[0]=arr[0];
        hap[0]=arr[0];
        int min = 0;
        for(int i=1; i<n; i++){
            dp[i] = dp[i-1]+arr[i];
            if(min>dp[i-1]){
                min = dp[i-1];
            }
            hap[i] = dp[i]-min;
        }

        int max=-1000;
        for(int i=0; i<n; i++){
            if(hap[i]>max){
                max = hap[i];
            }
        }

        System.out.println(max);
    }
}
