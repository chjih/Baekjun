package baekjun;

import java.util.Scanner;

public class _2562 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[9];

        for(int i=0; i<9; i++){
            array[i] = scanner.nextInt();
        }
        int max = array[0], index=0;
        for(int i=1; i<9; i++){
            if(max<array[i]){
                index = i;
                max = array[i];
            }
        }

        System.out.println(max+"\n"+(index+1));
        scanner.close();
    }
}
