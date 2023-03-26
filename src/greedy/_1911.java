package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class _1911 {
    static int n, l;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        arr = new int[n][2];

        int cur=0, count = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            else return o1[0]-o2[0];
        });

        for (int i = 0; i < n; i++) {
            if(arr[i][0]>cur){
                cur = arr[i][0];
            }
            if(arr[i][1]>cur){
                int c=(arr[i][1]-cur+(l-1))/l;
                count+=c;
                cur+=c*l;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
