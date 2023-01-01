package baekjun;

import java.util.Scanner;

public class _5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count=0;
        for(int i=0; i<s.length(); i++){
            int gap = s.charAt(i)-'A';
            if(gap<=2) count+=3;
            else if(gap<=5) count+=4;
            else if(gap<=8) count+=5;
            else if(gap<=11) count+=6;
            else if(gap<=14) count+=7;
            else if(gap<=18) count+=8;
            else if(gap<=21) count+=9;
            else if(gap<=25) count+=10;
        }
        System.out.println(count);
        sc.close();
    }
}
