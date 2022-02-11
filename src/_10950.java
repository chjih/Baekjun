import java.util.Scanner;

public class _10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a+b);
        }
        sc.close();
    }
}
