package baekjun;

import java.util.Scanner;

public class _1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int max=0, c=0, index=1000, j=100;
        boolean exist = false;
        int[] alphabet = new int[26];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>='a'){
                j=s.charAt(i)-'a';
                c= ++alphabet[s.charAt(i)-'a'];
            }
            else if(s.charAt(i)>='A') {
                j=s.charAt(i)-'A';
                c=++alphabet[s.charAt(i)-'A'];
            }
            if(max<c) {
                max=c;
                index=j;
            }
        }
        for(int i=0; i<26; i++){
            if((alphabet[i]==max)&&(i!=index)){
                exist = true;
            }
        }
        if(exist) System.out.println("?");
        else  System.out.println((char)('A'+index));

        sc.close();
    }
}
