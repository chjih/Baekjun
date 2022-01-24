import java.util.Scanner;

public class _8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int o, score;
        int[] scores = new int[n];
        String answer;
        for(int i=0; i<n; i++){
            o=1;
            score = 0;
            answer = sc.next();
            for(int j=0; j<answer.length(); j++){
                if(answer.charAt(j)=='O'){
                    score+=o;
                    o++;
                }
                else{
                    o=1;
                }
            }
            scores[i]=score;
        }
        for(int i=0; i<n;i++){
            System.out.println(scores[i]);
        }
    }
}
