package silver;

import java.util.*;
import java.io.*;

public class _20413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] lank = new int[5];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<5; i++){
            lank[i] = Integer.parseInt(st.nextToken());
        }

        int total=0;
        String result = br.readLine();

        int[] arr = new int[n];
        int max;
        for(int i=0; i<result.length(); i++) {
            switch (result.charAt(i)) {
                case 'B':
                    max = lank[1] - 1;
                    break;
                case 'S':
                    max = lank[2] - 1;
                    break;
                case 'G':
                    max = lank[3] - 1;
                    break;
                case 'P':
                    max = lank[4] - 1;
                    break;
                case 'D':
                    max = lank[4];
                    break;
                default:
                    max = 0;
            }

            if (i == 0 || result.charAt(i) == 'D') {
                arr[i] = max;
            } else {
                arr[i] = max - arr[i - 1];
            }
            total += arr[i];
        }

        System.out.println(total);
    }
}
