import java.util.Scanner;

public class _3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1=sc.nextInt(), y1=sc.nextInt(), x2=sc.nextInt(), y2=sc.nextInt(), x3=sc.nextInt(), y3=sc.nextInt();
        if(x1==x2) System.out.print(x3+" ");
        else if(x1==x3) System.out.print(x2+" ");
        else if(x2==x3) System.out.print(x1+" ");
        if(y1==y2) System.out.print(y3);
        else if(y1==y3) System.out.print(y2);
        else if(y2==y3) System.out.print(y1);
        sc.close();
    }
}
