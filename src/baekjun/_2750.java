package baekjun;

import java.util.Scanner;

public class _2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i=0; i<n; i++){
            ar[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(ar[i]<ar[j]){
                    int a = ar[i];
                    ar[i] = ar[j];
                    ar[j] = a;
                }
            }
        }
        for(int i=0; i<n; i++) System.out.println(ar[i]);

        sc.close();
    }
}
