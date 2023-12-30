package dp;

import java.util.Arrays;
import java.util.Scanner;

public class _10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[10];
        int[] rec;

        Arrays.fill(dp, 1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            rec = dp.clone();
            dp[0] = rec[1];
            dp[9] = rec[8];
            for (int j = 1; j < 9; j++) {
                dp[j] = (rec[j - 1] + rec[j + 1])%1000000000;
            }
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = (count + dp[i]) % 1000000000;
        }
        System.out.println(count);
        sc.close();
    }
}
