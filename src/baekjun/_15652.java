package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _15652 {
    private static int[] number;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        number = new int[m];
        run(n, m, 0);
        bw.flush();
        bw.close();
    }

    private static void run(int n, int m, int index) throws IOException {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                bw.write((number[i] + 1) + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = ((index - 1 >= 0) ? number[index - 1] : 0); i < n; i++) {
            number[index] = i;
            run(n, m, index + 1);
        }
    }
}
