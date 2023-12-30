package greedy;

import java.util.*;
import java.io.*;

public class _1439{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int one=0, zero=0;
        char cur;
        cur = s.charAt(0);
        if(s.charAt(0)=='0'){
            zero=1;
        }else{
            one=1;
        }
        for(int i=1; i<s.length(); i++){
            if(cur!=s.charAt(i)){
                if(s.charAt(i)=='0'){
                    zero++;
                }else{
                    one++;
                }
                cur = s.charAt(i);
            }
        }

        if(one+zero==1){
            System.out.println(0);
        }else{
            System.out.println(Math.min(one, zero));
        }
    }
}
