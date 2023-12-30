package dp;

import java.util.*;
import java.io.*;

public class _13558 {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[] v = new long[30001];
        long[] u = new long[30001];
        long ans = 0;

        while (N-- > 0) {
            int x = scanner.nextInt();

            ans += u[x] + v[x] * (v[x] - 1) / 2;
            v[x]++;

            for (int i = 1; i < x; i++) {
                if (x + (x - i) <= 30000) {
                    u[x + (x - i)] += v[i];
                }
            }

            for (int i = 30000; i > x; i--) {
                if (x - (i - x) >= 1) {
                    u[x - (i - x)] += v[i];
                }
            }
        }

        System.out.println(ans);
    }
}
