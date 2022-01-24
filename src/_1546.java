import java.util.Scanner;

public class _1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] array = new double[n];
        double max = 0, average=0;
        for(int i=0; i<n; i++){
            array[i] = sc.nextDouble();
            if(max<array[i]) max = array[i];
        }
        for(int i=0; i<n; i++){
            average+=array[i]/max*100;
        }
        System.out.println(average/n);
    }
}
