package graph;

import java.io.*;
import java.util.*;

public class _1707 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int v, e, a, b, cur;
        List<Integer>[] connect;
        int[] check;
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            connect = new List[v+1];
            check = new int[v+1];
            for(int i=1; i<=v; i++){
                connect[i] = new LinkedList<>();
            }

            for(int i=0; i<e; i++){
                st  = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                connect[a].add(b);
                connect[b].add(a);
            }

            // 이분탐색인지 확인
            Queue<Integer> queue = new LinkedList<>();
            boolean binary=false;

            for(int i=1; i<=v; i++){
                if(check[i]==0){
                    queue.add(i);
                    check[i]=1;
                }

                binary=false;
                while(!queue.isEmpty()){
                    cur = queue.poll();

                    for(int node:connect[cur]){
                        if(check[node]==0){
                            check[node]=check[cur]==1?2:1;
                            queue.add(node);
                        }
                        else if(check[node]==check[cur]){
                            binary=true;
                            break;
                        }
                    }
                    if(binary){
                        break;
                    }
                }
                if(binary){
                    break;
                }
            }

            if(binary){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
