package baekjun;

import java.util.Scanner;

public class _9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int size=0;
            int result =1;
            String[] ar = new String[31];
            int[] count = new int[31];
            for(int j=0; j<n; j++){
                sc.next();
                String s = sc.next();
                //이미 있는 종류인지 찾아봄
                int k;
                for(k=0; k<size; k++){
                    if(s.equals(ar[k])){
                        count[k]++;
                        break;
                    }
                }
                if(k==size){
                    ar[size]=s;
                    count[size]+=2;
                    size++;
                }
            }
            for(int j=0; j<size; j++){
                result*=count[j];
            }
            System.out.println(result-1);
        }
        sc.close();
    }
}