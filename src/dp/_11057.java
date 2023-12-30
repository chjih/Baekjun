package dp;

import java.util.Arrays;
import java.util.Scanner;

public class _11057 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[10];

        Arrays.fill(dp, 1);

        for(int k=1; k<n; k++){
            for(int i=9; i>=0; i--){
                for(int j=0; j<i; j++){
                    dp[i]=(dp[i]+dp[j])%10007;
                }
            }
        }

        int count=0;
        for(int i=0; i<10; i++){
            count=(count+dp[i])%10007;
        }
        System.out.println(count);

        sc.close();
    }
}
