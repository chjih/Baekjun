package baekjun;

import java.io.*;
import java.util.*;

public class _1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        Map<Integer, String> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        for(int i=1; i<=a; i++){
            String s = br.readLine().replace("\n", "");
            m1.put(i, s);
            m2.put(s, i);
        }
        for(int i=0; i<b; i++){
            String input = br.readLine().replace("\n", "");
            try{
                int n = Integer.parseInt(input);
                bw.write(m1.get(n)+"\n");
            }catch (NumberFormatException e){
                bw.write(m2.get(input)+"\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
