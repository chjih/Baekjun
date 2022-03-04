import java.util.Scanner;

public class _1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int aa = sc.nextInt();
            int bb = sc.nextInt();
            int a = Math.max(aa,bb);
            int b = Math.min(aa,bb);
            while(true){
                int q = a/b;
                int r = a - q*b;
                if(r==0){
                    System.out.println(aa*bb/b);
                    break;
                }
                a = b;
                b = r;
            }
        }
        sc.close();
    }
}
