import java.util.Scanner;

public class _1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] ar = new int[41][2];
        ar[0] = new int[]{1, 0};
        ar[1] = new int[]{0, 1};
        int k=2;
        for(int i=0; i<t; i++){
            int n =  sc.nextInt();
            for(int j=k; j<=n; j++){
                ar[j][0] = ar[j-1][0]+ar[j-2][0];
                ar[j][1] = ar[j-1][1]+ar[j-2][1];
            }
            System.out.println(ar[n][0]+" "+ar[n][1]);
        }
        sc.close();
    }
}
