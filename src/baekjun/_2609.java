package baekjun;

import java.util.Scanner;

public class _2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max=1;
        for(int i=2; i<=Math.min(a,b); i++){
            if(a%i==0&&b%i==0){
                max = i;
            }
        }
        System.out.println(max);
        for(int i=Math.max(a,b); i<=100000000; i++){
            if(i%a==0&&i%b==0){
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}
