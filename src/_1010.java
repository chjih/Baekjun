import java.util.Scanner;

public class _1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] ar = new int[31][31];
            for(int k=1; k<=m; k++){
                for(int j=0; j<=k; j++){
                    if(k==1) ar[k][j]=1;
                    else if(j==0||j==k) ar[k][j]=1;
                    else{
                        ar[k][j]=ar[k-1][j]+ar[k-1][j-1];
                    }
                }
            }
            System.out.println(ar[m][n]);
        }
        sc.close();
    }
}
