import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _2869_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int day = Integer.parseInt(st.nextToken()), night = Integer.parseInt(st.nextToken()), height = Integer.parseInt(st.nextToken());
        if(height==day) System.out.println(1);
        else System.out.println((height-day-1)/(day-night)+2);
    }
}
