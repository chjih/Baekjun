package binarysearch;

import java.io.*;
import java.util.*;

public class _2295_treeset {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            tree.put(arr[i], i);
        }

        Arrays.sort(arr);
        int a, last, b;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if(tree.floorKey(arr[i]-arr[j])!=null){
                    a = tree.get(tree.floorKey(arr[i]-arr[j]));
                    a = Math.min(a, j);
                }else{
                    a=0;
                }
                for (int k = a; k >= 0; k--) {
                    last = arr[i] - arr[j] - arr[k];
                    //System.out.println(arr[i]+":"+arr[j]+"/"+arr[k]+"/"+last);
                    if (tree.containsKey(last)) {
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
    }
}
