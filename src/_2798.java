import java.util.Scanner;

public class _2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), hap=0, i, j, k, max=0;
        int[] ar = new int[N];
        for(i=0; i<N; i++){
            ar[i] = sc.nextInt();
        }
        for(i=0; i<N; i++){
            for(j=i+1; j<N; j++){
                hap=ar[i]+ar[j];
                for(k=j+1; k<N; k++){
                    if((hap+ar[k])<=M&&(hap+ar[k])>max){
                        max=hap+ar[k];
                    }
                }
            }
        }
        if(max!=0) System.out.println(max);
        sc.close();
    }
}
