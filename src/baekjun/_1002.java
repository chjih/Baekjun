package baekjun;

import java.util.Scanner;

public class _1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x1=sc.nextInt(), y1= sc.nextInt(), r1=sc.nextInt(), x2=sc.nextInt(), y2= sc.nextInt(), r2=sc.nextInt();
            double distance = Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
            //일치(서로 겹칠 때)
            if(x1==x2&&y1==y2&&r1==r2) System.out.println("-1");
            //서로 엇갈릴 때
            else if((r1+r2)>distance&&Math.abs(r1-r2)<distance) System.out.println("2");
            //서로 맞물릴 때
            else if((r1+r2)==distance||Math.abs(r1-r2)==distance) System.out.println("1");
            //안에 들어가던가 외부에서 떨어져 있을 때
            else if((r1+r2)<distance||Math.abs(r1-r2)>distance) System.out.println("0");
        }
        sc.close();
    }
}
