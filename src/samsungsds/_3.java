package samsungsds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3 {
    static int[] products;
    static int[] arr;
    static int n, m;
    static int min=1000000000, max=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            products = new int[m];
            arr = new int[n];
            min=1000000000;
            max=-1;


            for(int j=0; j<n; j++){
                arr[j]=Integer.parseInt(br.readLine());
            }

            for(int j=0; j<m; j++){
                products[j]=Integer.parseInt(br.readLine());
            }

            Arrays.sort(products);
            Arrays.sort(arr);

            /*
            if(n*m>=5000){
                System.out.println("#"+(i+1)+" -1");
                continue;
            }*/

            for(int j=0; j<m/2; j++){
                dfs(0, products[j], products[j], n-1);
                dfs(0, products[m-j-1], products[m-j-1], n-1);

                if(min!=1000000000&&max!=-1){
                    break;
                }
            }

            if(max==-1){
                System.out.println("#"+(i+1)+" -1");
            }else{
                System.out.println("#"+(i+1)+" "+min+" "+max);
            }
        }
    }

    static int dfs(int count, int number, int origin, int index){
        if(count==3){
            // 더한 값이 자판기에 있는 지 확인
            if(number==0){
                if(origin<min){
                    min=origin;
                }
                if(origin>max){
                    max = origin;
                }
                return 1;
            }
            return -1;
        }

        for(int i=index; i>=0; i--){
            if(number-arr[i]<0){
                continue;
            }
            if(number-arr[i]*(3-count)<0){
                dfs(count+1, number-arr[i], origin, i-1);
            }else if(dfs(count+1, number-arr[i], origin, i)==1){
                return 1;
            }
        }

        return -1;
    }
}
