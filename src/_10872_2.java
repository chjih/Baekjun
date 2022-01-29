import java.util.Scanner;

public class _10872_2 {
    public static void main(String[] args) {
        //재귀함수 사용
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));
        sc.close();
    }
    public static int fac(int n){
        if(n<=1) return 1;
        else return n*fac(n-1);
    }
}
