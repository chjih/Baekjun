import java.util.Scanner;

public class _11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            System.out.println("Case #"+(i+1)+": "+(sc.nextInt()+ sc.nextInt()));
        }
        sc.close();
    }
}
