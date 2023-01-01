package baekjun;

import java.util.Scanner;

public class _1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a, count=0;
        for(int i=0; i<n; i++){
            a=sc.nextInt();
            count+=(decimal(a)==false&&a!=1)?1:0;
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean decimal(int n){
        boolean check = false;
        for(int i=2; i<n; i++){
            if(n%i==0){
                check = true;
                break;
            }
        }
        return check;
    }
}
