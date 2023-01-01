package baekjun;

import java.io.*;
import java.util.*;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            ar[i]= Integer.parseInt(st.nextToken());
        }
        int[] s = ar.clone();
        Arrays.sort(s);
        int k=0;
        map.put(s[0], 0);
        for(int i=1; i<n; i++){
            if(s[i]!=s[i-1]){
                k++;
                map.put(s[i], k);
            }
        }
        for(int i=0; i<n; i++){
            bw.write(map.get(ar[i])+" ");
        }
        bw.flush();
        bw.close();
    }
}
