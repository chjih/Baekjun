package baekjun;

import java.util.Scanner;

public class _10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean exist = false;
        int[] answer = new int[26];
        for(int i=0; i<26; i++) answer[i]=-1;
        for(int i=0 ; i<s.length(); i++) {
            if (answer[(int) s.charAt(i) - 'a'] == -1) answer[(int) s.charAt(i) - 'a'] = i;
        }
        for(int a: answer) System.out.print(a+" ");
        sc.close();
    }
}
