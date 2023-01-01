package baekjun;

import java.util.Scanner;

public class _1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k=0, a=1;
        while(true){
            //k는 1,2,3,,씩 증가된 대각선의 총 갯수
            //a는 그 더해지는 1, 2, 3,, = a+1이 해당 대각선의 분자+분모
            k+=a++;
            if(n<=k){
                k-=a-1;
                //분자+분모가 짝수이면 분자가 큰거부터 줄어듬 | 홀수이면 분자가 1붙 증가 됨
                System.out.println((a%2==0)?(a-n+k)+"/"+(n-k):(n-k)+"/"+(a-n+k));
                break;
            }
        }
        sc.close();
    }
}
