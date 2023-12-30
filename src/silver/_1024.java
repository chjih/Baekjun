package silver;

import java.io.*;
import java.util.*;

public class _1024 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        for(int i=l; i<=100; i++){
            // 짝수
            if(i%2==0){
                if(n%i==i/2&&n/i-i/2+1>=0){
                    for(int j=n/i-i/2+1; j<=n/i+i/2; j++){
                        System.out.printf("%d ", j);
                    }
                    System.out.println();
                    return;
                }
            }
            // 홀수
            else{
                // 나눠떨어질때
                if(n%i==0&&n/i-i/2>=0){
                    for(int j=n/i-i/2; j<=n/i+i/2; j++){
                        System.out.printf("%d ", j);
                    }
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println("-1");
    }
}
