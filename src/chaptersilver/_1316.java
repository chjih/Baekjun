package chaptersilver;

import java.util.Arrays;
import java.util.Scanner;

public class _1316 {
    static private final int[] alphabets = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (checkString(sc.next()))
                count++;
        }

        System.out.println(count);
        sc.close();
    }

    private static boolean checkString(String s) {
        Arrays.fill(alphabets, 0);
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i - 1) != s.charAt(i))
                alphabets[s.charAt(i - 1) - 'a'] = 2;
            if (alphabets[s.charAt(i) - 'a'] == 0) {
                alphabets[s.charAt(i) - 'a'] = 1;
                continue;
            }
            if (alphabets[s.charAt(i) - 'a'] == 2)
                return false;
        }
        return true;
    }
}
