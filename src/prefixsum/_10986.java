package prefixsum;

import java.util.Scanner;

public class _10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int[] sum = new int[n+1];
        int[] counts = new int[m];
        long count=0;

        for(int i=0; i<n; i++){
            num[i]=sc.nextInt()%m;
        }

        sum[0]=0;
        for(int i=0; i<n; i++){
            sum[i+1]=(sum[i]+num[i])%m;
        }

        // 같은 수의 각각 개수 구하기
        for(int i=0; i<=n; i++){
            counts[sum[i]]++;
        }

        long total;
        for(int i=0;i<m; i++){
            if(counts[i]!=0){
                total = (long)counts[i]*(counts[i]-1)/2;
                count+=total;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
