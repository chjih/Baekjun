package baekjun;

import java.util.Scanner;

public class _4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s, count;
        double average;
        int[] array;
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            average=0.0;
            count=0;
            s = sc.nextInt();
            array = new int[s];
            for(int j=0; j<s; j++){
                array[j] = sc.nextInt();
                average += array[j];
            }
            average/=s;
            for(int a : array){
                if(average<a)
                    count++;
            }
            answer[i]=String.format("%.3f", ((double)count/s*100))+"%";
        }
        for(String a : answer)
            System.out.println(a);
        sc.close();
    }
}
