import java.util.Scanner;

public class _1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min=1000000, max=0;
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            if(a<min) min = a;
            if(a>max) max = a;
        }
        System.out.println(min*max);
        sc.close();
    }
}
