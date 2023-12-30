package silver;

import java.util.*;
import java.io.*;

public class _1254 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String tmp;
        boolean p;
        for(int i=0; i<s.length(); i++){
            tmp = s.substring(i);

            // 펠린드롬인지 확인
            p=true;
            for(int j=0; j<tmp.length()/2; j++){
                if(tmp.charAt(j)!=tmp.charAt(tmp.length()-j-1)){
                    p=false;
                    break;
                }
            }

            if(p){
                System.out.println(tmp.length()+2*i);
                return;
            }
        }
    }
}
