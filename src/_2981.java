import java.util.Scanner;

public class _2981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int min = 1000000000, min2 = 1000000000;

        //입력 받음(동시에 최소수가 뭔지 알아냄)
        for(int i=0; i<n; i++){
            ar[i]=sc.nextInt();
            if(ar[i]<min2) {
                if(ar[i]<min){
                    min2 = min;
                    min = ar[i];
                }
                else{
                    min2 = ar[i];
                }
            }
        }
        //최대 수까지 돌려봄
        for(int i=2; i<=min2-min; i++){
            int a = ar[0]%i;
            int j;
            for(j = 1; j<ar.length; j++){
                if(ar[j]%i!=a) break;
            }
            if(j==ar.length) System.out.print(i+" ");
        }

        sc.close();
    }
}
