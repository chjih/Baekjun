package dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _2565 {
    private static int n;
    private static int[] line = new int[501];
    private static int[] dp;
    private static int[] B;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        n = sc.nextInt();
        dp = new int[n];
        B = new int[n];

        for(int i=0; i<n; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            line[a]=b;
        }

        int j=0;
        for(int i=1; i<501; i++){
            if(line[i]!=0){
                B[j++]=line[i];
            }
        }

        int k;
        dp[0]=1;
        max=1;
        // 오름차순 최대 개수 dp로 구하기
        for(int i=0; i<n; i++){
            // 작은것 중 가장 최대값 가져옴
            k=0;
            for(j=0; j<i; j++){
                if(B[j]<B[i]){
                    if(k<dp[j]){
                        k = dp[j];
                    }
                }
            }

            dp[i]=k+1;
            if(dp[i]>max){
                max = dp[i];
            }
        }

        System.out.println(n-max);
        sc.close();
    }
}
