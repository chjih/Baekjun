package baekjun;

import java.util.Scanner;

public class _4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt(), b= sc.nextInt(), c=sc.nextInt();
            int max = Math.max(Math.max(a, b),c);
            if(a==0) break;
            if(max==a&&(max*max==b*b+c*c)) System.out.println("right");
            else if(max==b&&(max*max==a*a+c*c)) System.out.println("right");
            else if(max==c&&(max*max==b*b+a*a)) System.out.println("right");
            else System.out.println("wrong");
        }
        sc.close();
    }
}
