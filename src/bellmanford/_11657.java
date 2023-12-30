package bellmanford;

import java.util.*;
import java.io.*;

public class _11657 {
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Edge> list = new LinkedList<>();

        int a,b,c;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a,b,c));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, 60000001);
        dist[1]=0;

        for(int i=1; i<=N; i++){
            for(Edge edge: list){
                // start가 갱신되지 않은 곳이면 패스
                if(dist[edge.start]==60000001){
                    continue;
                }

                if(dist[edge.end]>dist[edge.start]+edge.cost){
                    dist[edge.end]=dist[edge.start]+edge.cost;

                    // 마지막 노드에서 값이 변경되면 음의 사이클 발생했다는 뜻
                    if(i==N){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for(int i=2; i<=N; i++){
            if(dist[i]==60000001){
                System.out.println(-1);
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    static class Edge{
        int start,end;
        int cost;

        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
