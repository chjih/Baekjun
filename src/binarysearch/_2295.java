package binarysearch;

import java.util.*;
import java.io.*;

public class _2295 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result, a, last;
        for(int i=N-1; i>=0; i--){
            for(int j=i-1; j>=0; j--){
                a = binarySearch(j, arr[i]-arr[j]);
                for(int k=a; k>=0; k--){
                    last = arr[i]-arr[j]-arr[k];

                    result = binarySearch(k, last);
                    if(arr[result]==last){
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
    }

    public static int binarySearch(int end, int target){
        int start=0;
        int mid;

        while(start<=end){
            mid = (start+end)/2;

            if(arr[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return Math.max(end, 0);
    }
}
