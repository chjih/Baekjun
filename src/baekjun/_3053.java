package baekjun;

import java.util.Scanner;

public class _3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(String.format("%.6f", (double)n*n*Math.PI));
        System.out.println(String.format("%.6f", (double)n*n*2));
        sc.close();
    }
}
