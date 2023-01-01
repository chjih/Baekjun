package baekjun;

import java.util.Scanner;

public class _1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i=a; i<=b; i++){
            int k = i;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0){
                    k=1;
                    break;
                }
            }
            if(k!=1) System.out.println(k);
        }
        sc.close();
    }
}
