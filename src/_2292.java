import java.util.Scanner;

public class _2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), aa=1, count=1;
        while(n>1){
            aa+=6*count;
            count++;
            if(n<=aa) break;
        }
        System.out.println(count);
        sc.close();
    }
}
