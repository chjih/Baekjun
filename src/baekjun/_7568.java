package baekjun;

import java.util.Scanner;

public class _7568 {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][3];
        for(int i=0; i<n; i++){
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();
            for(int j=0; j<=i; j++){
                if(ar[j][0]<ar[i][0]&&ar[j][1]<ar[i][1]){
                    ar[j][2]++;
                }
                else if(ar[i][0]<ar[j][0]&&ar[i][1]<ar[j][1]){
                    ar[i][2]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            System.out.print((ar[i][2]+1)+" ");
        }
        sc.close();
    }
}
