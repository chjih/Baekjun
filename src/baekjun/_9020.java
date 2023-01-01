package baekjun;

import java.util.Scanner;

public class _9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b1=0, b2=0, gap, k, d;
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            gap=a;
            for(int j=2; j<a; j++){
                for(k=2; k<=Math.sqrt(j); k++){
                    if(j%k==0){
                        break;
                    }
                }
                if(k==(int)Math.sqrt(j)+1){
                    for(d=2; d<=Math.sqrt(a-j); d++){
                        if((a-j)%d==0){
                            break;
                        }
                    }
                    //if안에 check=false;와 같은 체크 표시 말고 소수인지를 확인하는 다른 방법
                    //위의 for문이 끝까지 돈게 맞으면 소수이다
                    //for문은 끝나고 마지막에 ++실행 => Math.sqrt(a-j)+1과 동일해야 for문을 다 돈걸로 확인할 수 있음
                    if(d==(int)Math.sqrt(a-j)+1){
                        if(gap>((a-2*j>0)?a-2*j:2*j-a)){
                            b1=j;
                            b2=a-j;
                            gap = (b1-b2>0)?b1-b2:b2-b1;
                        }
                    }
                }
            }
            System.out.println((b1-b2>0)?b2+" "+b1:b1+" "+b2);
        }
        sc.close();
    }
}
