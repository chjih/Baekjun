package baekjun;

import java.util.Scanner;

public class _11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result=1;
        int k = Math.min(b, a-b);
        for(int i=a; i>a-k; i--){
            result*=i;
        }
        for(int i=k; i>0; i--){
            result/=i;
        }
        System.out.println(result);
        sc.close();
    }
}
