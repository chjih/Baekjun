package dp;

import java.util.*;
import java.io.*;

public class _1965 {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        int index;
        int count=0;
        for(int i=0; i<n; i++){
            index = binarySearch(count, arr[i]);
            if(count==index){
                count++;
            }
            dp[index]=arr[i];
        }

        System.out.println(count);
    }

    static int binarySearch(int end, int target){
        int start=0;
        int mid;
        while(start<end){
            mid = (start+end)/2;

            if(dp[mid]<target){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }

        return end;
    }
}
