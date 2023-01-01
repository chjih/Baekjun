package baekjun;

import java.util.Scanner;

public class _10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = scanner.nextInt();
        }
        int min=array[0], max=array[0];
        for(int i=1; i<n; i++){
            if(min>array[i]){
                min = array[i];
            }
            if(max<array[i]){
                max = array[i];
            }
        }
        System.out.print(min+" "+max);
        scanner.close();
    }
}
