package DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

public class _2331 {

    private static int[] arr = new int[1000000];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Arrays.fill(arr, -1);

        arr[a] = count++;
        dfs(a, b);
    }

    public static void dfs(long n, int b) {
        int result = Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .map(x -> multiply(x, b)).sum();

        if (arr[result] != -1) {
            System.out.println(arr[result]);
            return;
        }

        arr[result]=count++;
        dfs(result, b);
    }

    public static int multiply(long n, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= n;
        }
        return result;
    }
}
