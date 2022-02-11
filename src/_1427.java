import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        Arrays.sort(s);
        for(int i=s.length-1; i>=0; i--) System.out.print(s[i]);
        sc.close();
    }
}
