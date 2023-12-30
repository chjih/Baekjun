package silver;

import java.io.*;
import java.util.*;

public class _4889 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int t=1;
        while(true){
            String s = br.readLine();

            if(s.charAt(0)=='-'){
                break;
            }

            stack.add(s.charAt(0));
            for(int i=1; i<s.length(); i++){
                if(!stack.isEmpty()&&s.charAt(i)=='}'&&stack.peek()=='{'){
                    stack.pop();
                    continue;
                }

                stack.add(s.charAt(i));
            }

            char cur='}';
            int count=0;
            while(!stack.isEmpty()){
                if(cur != stack.pop()){
                    count++;
                }
                if(cur=='{'){
                    cur = '}';
                }else{
                    cur = '{';
                }
            }

            System.out.println(t+". "+count);
            t++;
        }
    }
}
