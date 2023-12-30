package binarysearch;

import java.util.*;
import java.io.*;

public class _18869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];

        Set<Integer> set = new HashSet<>();
        List<Integer>[] list = new ArrayList[M];
        int count=0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int n;
            set.clear();
            for(int j=0; j<N; j++){
                n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                set.add(n);
            }

            list[i] = new ArrayList<>(set);
            Collections.sort(list[i]);
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = Collections.binarySearch(list[i], arr[i][j]);
            }
        }

        for(int i=0; i<M-1; i++){
            for(int j=i+1; j<M; j++){
                if(Arrays.equals(arr[i], arr[j])){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}