package graph;

import java.io.*;
import java.util.*;

public class _2617 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] lower = new int[N+1][N+1];
        int[][] higher = new int[N+1][N+1];

        int INF = 100;
        for(int i=1; i<=N; i++){
            Arrays.fill(lower[i], INF);
            Arrays.fill(higher[i], INF);
        }

        int a,b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            higher[a][b]=1;
            lower[b][a]=1;
        }

        // 플로이드 와샬
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    higher[i][j]=Math.min(higher[i][j], higher[i][k]+higher[k][j]);
                    lower[i][j] = Math.min(lower[i][j], lower[i][k]+lower[k][j]);
                }
            }
        }

        int mid = N/2;

        int count=0;
        int maxH, maxL;
        for(int i=1; i<=N; i++){
            maxH = 0;
            maxL = 0;
            for(int j=1; j<=N; j++){
                if(higher[i][j]!=INF){
                    maxH++;
                }
                if(lower[i][j]!=INF){
                    maxL++;
                }
            }

            if(maxH>mid||maxL>mid){
                count++;
            }
        }

        System.out.println(count);
    }

    static void print(int[][] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr.length; j++){
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
