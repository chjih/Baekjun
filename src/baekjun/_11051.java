package baekjun;

import java.util.Scanner;

public class _11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] ar = new int[1001][1001];
        for(int i=1; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(i==1) ar[i][j]=1;
                else if(i==j||j==0) ar[i][j]=1;
                else{
                    ar[i][j]=(ar[i-1][j]+ar[i-1][j-1])%10007;
                }
            }
        }
        System.out.println(ar[n][k]);
        sc.close();
    }
}
