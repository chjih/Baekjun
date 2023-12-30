package graph;

import java.io.*;
import java.util.*;

public class _2660 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] friend = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(friend[i], 51);
        }

        int a, b;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1){
                break;
            }

            friend[a][b]=1;
            friend[b][a]=1;
        }

        // 플로이드 와샬
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    friend[i][j] = Math.min(friend[i][j], friend[i][k]+friend[k][j]);
                }
            }
        }

        List<Integer> candidate = new LinkedList<>();
        int min=51;
        int max;

        for(int i=1; i<=N; i++){
            max=0;
            for(int j=1; j<=N; j++){
                if(i==j){
                    continue;
                }
                if(max<friend[i][j]){
                    max = friend[i][j];
                }
            }

            if(min==max){
                candidate.add(i);
            }
            else if(min>max){
                candidate.clear();
                candidate.add(i);
                min = max;
            }
        }

        System.out.printf("%d %d\n", min, candidate.size());
        Collections.sort(candidate);

        for(int i: candidate){
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
