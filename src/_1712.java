import java.util.Scanner;

public class _1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = -sc.nextInt()+sc.nextInt(), count=0, e=0;
        if(b<=0) System.out.println("-1");
        else{
            while(true){
                e+=b;
                count++;
                if(e>a) break;
            }
            System.out.println(count);
        }
        sc.close();
    }
}
