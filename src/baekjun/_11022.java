package baekjun;

import java.util.Scanner;

public class _11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
        }
        sc.close();
    }
}
