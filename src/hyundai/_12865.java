package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865 {
    static int[][] bag;
    static int[][] dp;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bag = new int[n][2];
        dp = new int[n+1][k+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                // 위에 행 가져옴
                dp[i][j] = dp[i-1][j];
                // 무게 남으면 더 큰 값으로 갱신
                if(j>=bag[i-1][0]){
                    dp[i][j] = Math.max(dp[i][j],bag[i-1][1]+dp[i-1][j-bag[i-1][0]]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
