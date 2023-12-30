package greedy;

import java.util.Scanner;

public class _11047 {
    static int n, k;
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        coin = new int[n];

        // 내림차순으로 저장
        for(int i=n-1; i>=0; i--){
            coin[i] = sc.nextInt();
        }

        greedy();
        sc.close();
    }

    private static void greedy(){
        int total=k, i=0, count=0;

        while(i<n){
            if(total==0){
                System.out.println(count);
                return;
            }
            if(total-coin[i]>=0){
                total-=coin[i];
                count++;
            }
            else{
                i++;
            }
        }
    }
}
