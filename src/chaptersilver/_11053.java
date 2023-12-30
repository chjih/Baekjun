package chaptersilver;

import java.util.Scanner;

public class _11053 {
    static int[] arr, number;
    static int n, max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        number = new int[1001];
        int x;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp로 풀이
        for(int i=0; i<n; i++){
            // 이전것 중 가장 횟수가 많으면서 현재 수보다는 작은 거 가져옴
            int m=0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]&&m<number[arr[j]]){
                    m = number[arr[j]];
                }
            }
            if(number[arr[i]]<(m+1)){
                number[arr[i]]=m+1;
            }
            if((m+1)>max){
                max = m+1;
            }
        }

        System.out.println(max);

        sc.close();
    }
}
