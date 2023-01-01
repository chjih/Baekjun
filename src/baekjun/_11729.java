package baekjun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((int)Math.pow(2, n)-1);
        hinoy(n, 1, 2, 3);
        bw.flush();
        bw.close();
        sc.close();
    }
    public static void hinoy(int n, int s, int m, int e) throws IOException {
        if(n==1){
            bw.write(s+" "+e+"\n");
        }
        else{
            //n-1만큼 중간으로 옮김
            hinoy(n-1, s, e, m);
            //가장 큰 원판 맨 끝으로 옮김
            bw.write(s+" "+e+"\n");
            //중간의 그 n-1판을 가장 끝에있는 큰 원판에 올린다.
            hinoy(n-1, m, s, e);
        }
    }
}
