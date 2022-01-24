import java.util.Scanner;

public class _2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int r = a*b*c;
        int[] count = new int[10];
        while(r!=0){
            count[r%10]++;
            r/=10;
        }
        for(int i=0; i<10; i++){
            System.out.println(count[i]);
        }

        scanner.close();
    }
}
