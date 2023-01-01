package baekjun;

import java.util.Scanner;

public class _14888 {
    private static int min = 1000000000;
    private static int max = -1000000000;
    private static int[] numbers;
    private static int[] operators = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){
            operators[i] = sc.nextInt();
        }
        calculate(n, numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void calculate(int n, int result, int index){
        if(index==n){
            if(min>result){
                min = result;
            }
            if(max<result){
                max = result;
            }
            return;
        }
        int current = result;
        for(int i=0; i<4; i++){
            if(operators[i]>0){
                operators[i]--;
                switch (i){
                    case 0:
                        result+=numbers[index];
                        break;
                    case 1:
                        result-=numbers[index];
                        break;
                    case 2:
                        result*=numbers[index];
                        break;
                    case 3:
                        result/=numbers[index];
                        break;
                }
                calculate(n, result, index+1);
                operators[i]++;
                result = current;
            }
        }
    }
}
