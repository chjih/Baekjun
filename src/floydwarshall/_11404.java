package floydwarshall;

import java.util.*;
import java.io.*;

public class _11404 {
    static long INF = 10000000001L;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int a, b, c;
        long[][] dist = new long[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i]=0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            dist[a][b]=Math.min(dist[a][b], c);
        }

        for(int n=1; n<=N; n++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    dist[i][j]=Math.min(dist[i][j], dist[i][n]+dist[n][j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dist[i][j]==INF){
                    System.out.printf("%d ", 0);
                }
                else{
                    System.out.printf("%d ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }
}
