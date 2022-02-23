import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNumber = Integer.parseInt(st.nextToken());
            int[] scores = new int[studentNumber];
            int sum = 0;
            for (int j = 0; j < studentNumber; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }
            double average = (double)sum / studentNumber;
            int up = 0;
            for (int k = 0; k < studentNumber; k++) {
                if (scores[k] > average) up++;
            }
            System.out.println(String.format("%.3f", (double)up/studentNumber*100)+"%");
        }
    }
}

/*
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentNumber = Integer.parseInt(st.nextToken());
        int[] scores = new int[studentNumber];
        int sum = 0;
        for (int j = 0; j < studentNumber; j++) {
        scores[j] = Integer.parseInt(st.nextToken());
        sum += scores[j];
        }
        double average = (double)sum / studentNumber;
        int up = 0;
        for (int j = 0; j < studentNumber; j++) {
        if (scores[j] > average) up++;
        }
        System.out.println(Math.round((double)up/studentNumber * 100000) / 1000.0 + "%");
        }*/

