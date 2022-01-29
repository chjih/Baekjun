import java.util.Scanner;

public class _2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0; i<n; i++){
            int k = sc.nextInt(), kk = sc.nextInt(), count=0;
            int[] ar = new int[kk];
            for(int j = 0; j<kk; j++) ar[j]=j+1;
            while(count<k){
                for(int j=1; j<kk; j++){
                    ar[j]+=ar[j-1];
                }
                count++;
            }
            System.out.println(ar[kk-1]);
        }
        sc.close();
    }
}
