package dp;

import java.util.*;
import java.io.*;

public class _20922 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] num = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int cur, start=0, max=0;
        for(int i=0; i<N; i++){
            cur = arr[i];
            num[cur]++;

            // 초과
            if(num[cur]>K){
                for(int j=start; j<=i; j++){
                    num[arr[j]]--;

                    if(arr[j]==cur){
                        start=j+1;
                        break;
                    }
                }
            }

            max = Math.max(max, i-start+1);
        }

        System.out.println(max);
    }
}
