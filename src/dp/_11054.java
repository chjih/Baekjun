package dp;

import java.util.Scanner;

public class _11054 {
    static int[] num, dpAsc, dpDesc;
    static int n, max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        dpAsc = new int[n];
        dpDesc = new int[n];

        for(int i=0; i<n; i++){
            num[i]=sc.nextInt();
        }

        dp();
        System.out.println(max-1);
        sc.close();
    }

    public static void dp() {
        int k;
        dpAsc[0] = 1;

        // 증가
        for (int i = 0; i < n; i++) {
            k = 0;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i] && k < dpAsc[j]) {
                    k = dpAsc[j];
                }
            }
            dpAsc[i] = k + 1;
        }

        // 감소
        dpDesc[n-1]=1;
        for (int i = n - 1; i >= 0; i--) {
            k = 0;
            for (int j = n-1; j > i; j--) {
                if (num[j] < num[i] && k < dpDesc[j]) {
                    k = dpDesc[j];
                }
            }
            dpDesc[i] = k + 1;
        }

        int total;
        for(int i=0; i<n; i++){
            total = dpDesc[i]+dpAsc[i];
            if(total>max){
                max=total;
            }
        }
    }
}
