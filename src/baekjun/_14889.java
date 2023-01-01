package baekjun;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _14889 {
    private static int[][] S;
    private static boolean[] people;
    private static int min = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        S = new int[n][n];
        people = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        run(n, 0, 0);
        System.out.println(min);
    }

    private static void run(int n, int index, int p) {
        if (index == n / 2) {
            int start = add(n, true);
            int link = add(n, false);
            if (Math.abs(start - link) < min) {
                min = Math.abs(start - link);
            }
            if(min==0){
                System.out.println(min);
                System.exit(0);
            }
            return;
        }

        for (int i = p+1; i < n; i++) {
            if (!people[i]) {
                people[i] = true;
                run(n, index + 1,  i);
                people[i] = false;
            }
        }
    }

    private static int add(int n, boolean bool) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j && people[i] == bool && people[j] == bool) {
                    result += S[i][j];
                }
            }
        }
        return result;
    }
}
