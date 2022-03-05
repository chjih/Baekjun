import java.util.Scanner;

public class _3036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = sc.nextInt();
        //값 입력받아서 최소공배수구함(최대공약수로)
        for(int i=1; i<n; i++){
            int a = sc.nextInt();
            int j=1;
            for(int k=1; k<=Math.min(a, first); k++){
                if(a%k==0&&first%k==0) j=k;
            }
            System.out.println((first/j)+"/"+(a/j));
        }
        sc.close();
    }
}
