package baekjun;

import java.util.Scanner;

public class _1929_2 {
    //"에라토스테네스의 체" 사용한 방법
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c=0;
        int[] array = new int[b-a+1];
        if(a==1) array[0]=-1;
        for(int i=2; i<=b; i++){
            c=i;
            if(c-a>=0&&array[c-a]==-1) continue;
            while(c<=b){
                c+=i;
                if(c-a>=0&&b-c>=0){
                    //배수는 모두 -1로 처리시키면서 소수가 아닌걸 증명
                    array[c-a]=-1;
                }
            }
        }
        for(int i=0; i<b-a+1; i++){
            if(array[i]!=-1) System.out.println(i+a);
        }
        sc.close();
    }
}
