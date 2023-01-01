package baekjun;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class _4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if(s.equals(".")) break;
            int i;
            Stack<Character> stack = new Stack<>();
            try{
                for(i=0; i<s.length(); i++){
                    if(s.charAt(i)=='('||s.charAt(i)=='[') stack.add(s.charAt(i));
                    else if(s.charAt(i)==')'){
                        if(stack.peek()=='(') stack.pop();
                        else break;
                    }
                    else if(s.charAt(i)==']'){
                        if(stack.peek()=='[') stack.pop();
                        else break;
                    }
                }
                if(i==s.length()&&stack.size()==0) System.out.println("yes");
                else System.out.println("no");
            } catch(EmptyStackException e){
                System.out.println("no");
            }
        }
        sc.close();
    }
}
