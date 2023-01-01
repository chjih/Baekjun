package baekjun;

import java.util.Scanner;

public class _1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a, b, N = n, count=0;
        while(true){
            if(N<10){
                a = 10;
                b = N;
            } else{
                a = N/10;
                b = N%10;
            }
            N =b*10+(a+b)%10;
            count++;
            if(n==N) break;
        }
        System.out.println(count);
        scanner.close();
    }
}
