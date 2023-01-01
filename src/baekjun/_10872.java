package baekjun;

import java.util.Scanner;

public class _10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=n-1; i>=1; i--){
            n*=i;
        }
        if(n==0) System.out.println(1);
        else System.out.println(n);
        sc.close();
    }
}
