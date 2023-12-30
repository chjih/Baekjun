package graph;

import java.util.*;
import java.io.*;

public class _11403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샬 (단 가중치는 갈 수 있음:1, 갈 수 없음:0)
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                // i->j로 갈때
                // k를 거쳐간다.
                for(int j=0; j<n; j++){
                    if(arr[i][k]+arr[k][j]==2){
                        arr[i][j]=1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
