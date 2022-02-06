import java.util.Scanner;

public class _1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i=666, count=1;
        while(N>1){
            i++;
            if(String.valueOf(i).contains("666")) count++;
            if(count==N) break;
        }
        System.out.println(i);
        sc.close();
    }
}
