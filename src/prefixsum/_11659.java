package prefixsum;

import java.util.Scanner;

public class _11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n+1];
        int a,b, total;

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        sum[0]=0;
        for(int i=1; i<=n; i++){
            sum[i]=sum[i-1]+arr[i-1];
        }

        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(sum[b]-sum[a-1]);
        }

        sc.close();
    }
}
