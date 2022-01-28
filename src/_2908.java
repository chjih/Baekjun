import java.util.Scanner;

public class _2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i;
        for(i=0; i<3; i++){
            if(a%10!=b%10) {
                a = (a%10>b%10)? a:b;
                break;
            }
            else{
                System.out.print(a%10);
                a=(a-a%10)/10;
                b=(b-b%10)/10;
            }
        }
        for(int j=i; j<3; j++){
            System.out.print(a%10);
            a=(a-a%10)/10;
        }
        sc.close();
    }
}
