package baekjun;

import java.util.Scanner;

public class _1904 {
    private static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[n+1];
        System.out.println(make(n)%15746);
    }

    public static int make(int n){
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(data[n]!=0){
            return data[n];
        }

        return data[n] = (make(n-1) + make(n-2))%15746;
    }
}
