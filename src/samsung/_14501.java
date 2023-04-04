package samsung;

import java.util.Scanner;

public class _14501 {
    private static int[] schedule;
    private static int[] t;
    private static int[] p;
    private static int n, max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        t = new int[n];
        p = new int[n];
        schedule = new int[n];

        for(int i=0; i<n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        dfs(0,0);

        System.out.println(max);
        sc.close();
    }

    public static void dfs(int money, int cur){
        if(cur==n){
            if(max<money)
                max=money;
            return;
        }

        if(schedule[cur]==1){
            return;
        }

        for(int i=cur; i<n; i++){
            if(i+t[i]>n){
                dfs(money, n);
                continue;
            }
            for(int j=i; j<i+t[i]; j++){
                schedule[j]=1;
            }
            dfs(money+p[i], i+t[i]);
            for(int j=i; j<i+t[i]; j++){
                schedule[j]=0;
            }
        }
    }
}
