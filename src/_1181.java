import java.util.Arrays;
import java.util.Scanner;

class word{
    int length;
    String word;
    public word(String word, int length){
        this.word = word;
        this.length = length;
    }
}

public class _1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        word[] ar = new word[N];
        for(int i=0; i<N; i++){
            String s = sc.next();
            ar[i] = new word(s, s.length());
        }
        Arrays.sort(ar, (o1, o2)->{
            if(o1.length==o2.length) return o1.word.compareTo(o2.word);
            else return o1.length - o2.length;
        });
        System.out.println(ar[0].word);
        for(int i=1; i<N; i++){
            if(!ar[i].word.equals(ar[i-1].word)) System.out.println(ar[i].word);
        }
        sc.close();
    }
}
