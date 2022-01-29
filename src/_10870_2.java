import java.util.Scanner;

public class _10870_2 {
    public static void main(String[] args) {
        //재귀함수 사용
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
        sc.close();
    }
    public static int fib(int n){
        if(n<=1) return n;
        else return fib(n-1)+fib(n-2);
    }
}
