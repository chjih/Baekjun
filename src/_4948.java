import java.util.Scanner;

public class _4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            int count=0;
            for(int i=n+1; i<=2*n; i++){
                count++;
                for(int j=2; j<=Math.sqrt(i); j++){
                    if(i%j==0){
                        count--;
                        break;
                    }
                }
            }
            if(n==1) System.out.println(1);
            else System.out.println(count);
            n=sc.nextInt();
        }
    }
}
