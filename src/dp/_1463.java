package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {

    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        dp = new int[number + 1];
        System.out.println(recur(number));

//        dp[0]=dp[1]=0;
//
//        for(int i=2; i<=n; i++){
//            dp[i] = dp[i-1]+1;
//            if(i%2==0){
//                dp[i] = Math.min(dp[i], dp[i/2]+1);
//            }
//            if(i%3==0){
//                dp[i] = Math.min(dp[i], dp[i/3]+1);
//            }
//        }
    }

    static int recur(int n) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = recur(n - 1) + 1;
        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], recur(n / 3) + 1);
        }
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], recur(n / 2) + 1);
        }
        return dp[n];
    }
}
