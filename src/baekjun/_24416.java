package baekjun;

import java.util.Scanner;

public class _24416 {
    private static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
        System.out.print(count+" ");
        count = 0;
        fibonacci(n);
        System.out.println(count);
    }

    public static int fib(int n){
        if(n==1||n==2){
            count++;
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibonacci(int n){
        int[] f = new int[n+1];;
        f[1] = 1;
        f[2] = 2;
        for(int i=n; i>=3; i--){
            f[i] = f[i-1]+f[i-2];
            count++;
        }
        return f[n];
    }
}
