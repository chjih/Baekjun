package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _2110 {
    static int n;
    static int[] house;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int c = sc.nextInt();
        house = new int[n];

        for(int i=0; i<n; i++){
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int x;
        int min = 1;
        int max = house[n-1]-house[0];
        int mid=1;
        int ans=mid;

        while(min<=max){
            mid = (min+max)/2;

            x = canInstall(mid);

            // 설치 더 많이 할 수 있으면 거리 늘림
            if(x>=c){
                min = mid+1;
                ans = mid;
            }
            // 설치 할 수 있는 횟수가 더 적으면 거리 줄임
            else{
                max = mid-1;
            }
        }

        System.out.println(ans);
        sc.close();
    }

    private static int canInstall(int gap){
        int count=1;
        int pre = house[0];

        for(int i=1; i<n; i++){
            if(house[i]-pre>=gap){
                count++;
                pre = house[i];
            }
        }

        return count;
    }
}
