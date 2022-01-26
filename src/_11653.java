import java.util.Scanner;

public class _11653 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int min=2;
        while(n>1){
            if(n%min==0){
                n/=min;
                System.out.println(min);
            }
            else min++;
        }
        sc.close();
    }
}
