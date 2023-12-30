package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1919 {
    static int[] aa = new int['z'-'a'+1];
    static int[] bb = new int['z'-'a'+1];
    static String a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        a = bf.readLine().replace("/n", "");
        b = bf.readLine().replace("/n", "");

        for(int i=0; i<a.length(); i++){
            aa[a.charAt(i)-'a']++;
        }
        for(int i=0; i<b.length(); i++){
            bb[b.charAt(i)-'a']++;
        }

        int count=0;
        for(int i=0; i<='z'-'a'; i++){
            if(aa[i]!=bb[i]){
                count+=Math.abs(aa[i]-bb[i]);
            }
        }

        System.out.println(count);
    }
}
