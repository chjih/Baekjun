package baekjun;

import java.util.Scanner;

public class _2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r5 = num(n, 5) - num(n-m, 5) - num(m, 5);
        int r2 = num(n, 2) - num(n-m, 2) - num(m,2);
        System.out.println(Math.min(r5, r2)>=0?Math.min(r5, r2):0);
        sc.close();
    }

    public static int num(int x, int n){
        int count = 0;
        while(x >= n){
            count += x/n;
            x/=n;
        }
        return count;
    }
}
