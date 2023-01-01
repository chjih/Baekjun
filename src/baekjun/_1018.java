package baekjun;

import java.util.Scanner;

public class _1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt();
        int min=M*N;
        char[][] ar = new char[N][M];
        char[][] white = {{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
        char[][] black = {{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},};
        //입력받음
        for(int i=0; i<N; i++){
            String s = sc.next();
            for(int j=0; j<M; j++){
                ar[i][j]=s.charAt(j);
            }
        }
        //최대한 비슷한 곳으로 찾음
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int acount=0;
                int bcount=0;
                for(int a=0; a<8; a++){
                    for(int b=0; b<8; b++){
                        if(ar[i+a][j+b]!=white[a][b]) acount++;
                        if(ar[i+a][j+b]!=black[a][b]) bcount++;
                    }
                }
                if(acount<min||bcount<min) min=Math.min(acount, bcount);
            }
        }
        System.out.println(min);
        sc.close();
    }
}
