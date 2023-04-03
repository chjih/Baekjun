package samsung;

import java.util.*;

public class _14500 {
    private static int n,m;
    private static int[][] map;
    private static int[][][] t1={{{1,1,1},{0,1,0}},
            {{0,1,0},{1,1,1}},
            {{1,1,1},{1,0,0}},
            {{0,0,1},{1,1,1}},
            {{1,0,0},{1,1,1}},
            {{1,1,1},{0,0,1}},
            {{1,1,0},{0,1,1}},
            {{0,1,1},{1,1,0}}};
    private static int[][][] t2 = {
            {{1,0},{1,0},{1,1}},
            {{1,1},{0,1},{0,1}},
            {{1,1},{1,0},{1,0}},
            {{0,1},{0,1},{1,1}},
            {{1,0},{1,1},{0,1}},
            {{0,1},{1,1},{1,0}},
            {{1,0},{1,1},{1,0}},
            {{0,1},{1,1},{0,1}}
    };
    private static int[][] t3={{1,1,1,1}};
    private static int[][] t4={{1},{1},{1},{1}};
    private static int[][] t5 = {{1,1},{1,1}};
    private static int max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        search();

        System.out.println(max);
        sc.close();
    }

    private static void search(){
        int sum;

        // 2x3 확인
        for(int i=0; i<=n-2; i++){
            for(int j=0; j<=m-3; j++){
                for (int k=0; k<t1.length; k++) {
                    sum = sum(i, j, t1[k]);
                    if(sum>max){
                        max=sum;
                    }
                }
            }
        }

        // 3*2 확인
        for(int i=0; i<=n-3; i++){
            for(int j=0; j<=m-2; j++){
                for(int[][] arr:t2){
                    sum=sum(i,j,arr);
                    if(sum>max){
                        max=sum;
                    }
                }
            }
        }

        // 1*4 확인
        for(int i=0; i<=n-1; i++){
            for(int j=0; j<=m-4; j++){
                sum=sum(i,j,t3);
                if(sum>max){
                    max=sum;
                }
            }
        }

        // 4*1 확인
        for(int i=0; i<=n-4; i++){
            for(int j=0; j<=m-1; j++){
                sum=sum(i,j,t4);
                if(sum>max){
                    max=sum;
                }
            }
        }

        // 2*2 확인
        for(int i=0; i<=n-2; i++){
            for(int j=0; j<=m-2; j++){
                sum=sum(i,j,t5);
                if(sum>max){
                    max=sum;
                }
            }
        }
    }

    private static int sum(int x, int y, int[][] arr){
        int total=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                total+=map[i+x][j+y]*arr[i][j];
            }
        }
        return total;
    }
}
