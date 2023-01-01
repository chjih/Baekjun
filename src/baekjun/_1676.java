package baekjun;

import java.util.Scanner;

public class _1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        for(int i=2; i<=n; i++){
            int k =i;
            while(k>=5){
                if(k%5==0) {
                    count++;
                    k/=5;
                }
                else break;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
