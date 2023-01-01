package baekjun;

import java.util.Scanner;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            int j;
            for(j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if(c=='('){
                    stack.add(c);
                }
                else{
                    if(stack.size()==0) break;
                    stack.pop();
                }
            }
            if(j==s.length()&&stack.size()==0) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
