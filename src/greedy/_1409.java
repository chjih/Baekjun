package greedy;

import java.util.*;
import java.io.*;

public class _1409 {
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int six=1000, one=1000;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            six = Math.min(six, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }

        six = Math.min(six, one*6);

        int total=0;
        int count=0;
        total+= (N/6)*six;
        count = (N/6) * 6;

        total += Math.min((N - count) * one, six);

        System.out.println(total);
    }
}
