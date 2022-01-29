import java.util.Scanner;

public class _2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n/5;
        while(k>=0){
            if((n-k*5)%3==0) break;
            k--;
        }
        if(k<0) System.out.println(-1);
        else System.out.println(k+((n-5*k)/3));
        sc.close();
    }
}
