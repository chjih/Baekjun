package baekjun;

import java.util.Scanner;

public class _2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int N = Integer.parseInt(n), d = (int)Math.pow(9, n.length()), hap;
        d = (N-d>0)?N-d:0;
        while(true){
            hap = d;
            int k = d;
            for(int i=n.length()-1; i>=0; i--){
                hap += k/(int)Math.pow(10, i)%10;
            }
            if(hap==N) break;
            if(d>=N) break;
            d++;
        }
        if(d!=N) System.out.println(d);
        else System.out.println(0);
        sc.close();
    }
}
