package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273 {
    static int n, x;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(bf.readLine());

        Arrays.sort(num);

        int count=0;
        for(int i=0; i<n;i++){
            if(num[i]>=x){
                break;
            }
            for(int j=i+1;j<n; j++){
                if(num[i]+num[j]==x){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
