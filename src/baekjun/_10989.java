package baekjun;

import java.io.*;
import java.util.Scanner;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        int[] result = new int[N];
        int[] count = new int[10001];
        for(int i=0; i<N; i++){
            ar[i] = Integer.parseInt(br.readLine());
            count[ar[i]]++;
        }
        //누적 합계로 만들어준다.
        for(int i=2; i<=10000; i++){
            count[i]+=count[i-1];
        }
        //count에 있는 인덱스로 차례대로 넣어줌
        for(int i=N-1; i>=0;i--){
            result[count[ar[i]]-1] = ar[i];
            count[ar[i]]--;
        }
        for(int i:result) bw.write(i+"\n");
        bw.flush();
        bw.close();
    }
}
