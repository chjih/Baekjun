package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {
    static int n, min=1000000000;
    static int[] length, cost;
    static long result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        length = new int[n-1];
        cost = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<n-1; i++){
            length[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        // 도시 이동
        for(int i=0; i<n-1; i++){
            if(min>cost[i]){
                min = cost[i];
            }
            result += (long)min * length[i];
        }

        System.out.println(result);
    }
}
