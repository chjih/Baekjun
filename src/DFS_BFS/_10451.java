package DFS_BFS;

import java.util.Scanner;

public class _10451 {

    private static int[] arr;
    private static int target;
    private static int[] visit;
    private static int count;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            count = 0;
            int length = sc.nextInt();
            visit = new int[length+1];
            arr = new int[length+2];
            getNumbers(length);

            for (int k = 1; k <= length; k++) {
                target = k;
                visit[target] = 1;
                dfs(arr[k]);
            }

            System.out.println(count);
        }

        sc.close();
    }

    private static void getNumbers(int n){
        for(int i=1; i<=n; i++){
            arr[i]=sc.nextInt();
        }
    }

    private static void dfs(int n) {
        if (n == target) {
            count++;
            return;
        }
        if (visit[n] == 1) {
            return;
        }

        visit[n] = 1;
        dfs(arr[n]);
    }
}
