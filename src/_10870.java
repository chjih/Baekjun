import java.util.Scanner;

public class _10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k=1, count=1;
        int[] ar = {0,1};
        while(count<n){
            k=ar[0]+ar[1];
            ar[0]=ar[1];
            ar[1]=k;
            count++;
        }
        System.out.println((n==0)?0:k);
        sc.close();
    }
}
