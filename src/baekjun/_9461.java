package baekjun;

import java.io.*;

public class _9461 {
    private static long[] data;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            data = new long[a+1];
            bw.write(P(a)+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static long P(int n) {
        if (n <= 3) {
            return 1;
        }
        if (n <= 5) {
            return 2;
        }

        if (data[n] != 0) {
            return data[n];
        }

        return data[n] = P(n - 1) + P(n - 5);
    }
}
