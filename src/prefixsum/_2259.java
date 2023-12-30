package prefixsum;

import java.util.Scanner;

public class _2259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        int[] sum = new int[n+1];
        sum[0]=0;

        for(int i=0; i<n; i++){
            num[i]= sc.nextInt();
        }

        for(int i=0; i<n; i++){
            sum[i+1]=sum[i]+num[i];
        }

        int total, max=-10000000;
        // 최대값 가져오기
        for(int i=0; i<=n-k; i++){
            total = sum[i+k]-sum[i];
            if(total>max){
;                max = total;
            }
        }
        System.out.println(max);
        sc.close();
    }
}
