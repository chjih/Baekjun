package divideandconquer;

import java.util.Scanner;

public class _2630 {
    static int[][] map;
    static int n, countB = 0, countW=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int last =dc(0,0,n);
        if(last==0){
            countW++;
        }
        else if(last==1){
            countB++;
        }
        System.out.println(countW);
        System.out.println(countB);
        sc.close();
    }

    static int dc(int x, int y, int length) {
        int[] arr=new int[4];

        if (length == 1) {
            return map[x][y];
        }

        arr[0] = dc(x, y, length / 2);
        arr[1] = dc(x, y+length/2, length / 2);
        arr[2] = dc(x +length/2, y, length / 2);
        arr[3] = dc(x + length/2, y + length / 2, length / 2);

        if(arr[0]!=-1&&arr[0]==arr[1]&&arr[2]==arr[3]&&arr[1]==arr[3]){
            return arr[0];
        }
        else{
            for(int i=0; i<4; i++){
                if(arr[i]==1){
                    countB++;
                }
                else if(arr[i]==0){
                    countW++;
                }
            }
            return -1;
        }
    }
}
