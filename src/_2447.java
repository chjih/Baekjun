import java.util.Scanner;

public class _2447 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] ar = new String[n][n];
        star(0, 0, n, ar, true);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) System.out.print(ar[i][j]);
            System.out.println("");
        }
        sc.close();
    }

    public static void star(int x, int y, int n, String[][] ar, boolean b){
        if(n==1) {
            if(b) ar[x][y] = "*";
            else ar[x][y]=" ";
        }
        else{

        }
    }
}
