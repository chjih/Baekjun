package baekjun;

import java.util.Scanner;
import java.util.Stack;

public class _10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            if(k==0) stack.pop();
            else stack.add(k);
        }
        int hap=0;
        int s = stack.size();
        for(int i=0; i<s; i++){
            hap+=stack.pop();
        }
        System.out.println(hap);
        sc.close();
    }
}
