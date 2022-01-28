import java.util.Scanner;

public class _1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt(), y= sc.nextInt(), w=sc.nextInt(), h=sc.nextInt(), min1, min2;
        min1=((w-x)>x)?x:w-x;
        min2=((h-y)>y)?y:h-y;
        System.out.println(Math.min(min1, min2));
        sc.close();
    }
}
