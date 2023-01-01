package baekjun;

import java.util.Scanner;

public class _10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a, b;
        for(int i=0; i<n; i++){
            int H = sc.nextInt(), W = sc.nextInt(), N = sc.nextInt();
            a = N%H;
            b = (N-1)/H+1;
            System.out.println(((a==0)?H:a)+""+((b<10)?"0"+b:b));
        }
        sc.close();
    }
}
