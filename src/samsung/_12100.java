package samsung;

import java.util.*;

public class _12100 {
    private static int[][] map;
    private static int n, max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j]= sc.nextInt();
            }
        }

        dfs(map, 0);

        System.out.println(max);
        sc.close();
    }

    private static void dfs(int[][] map, int count){
        if(count==5){
            if(getMax(map)>max)
                max = getMax(map);
            return;
        }

        int[][] originMap = new int[n][n];
        for(int i=0; i<n; i++){
            originMap[i]=map[i].clone();
        }

        for(int i=0; i<4; i++){
            move(map, i);
            dfs(map, count+1);
            for(int j=0; j<n; j++){
                map[j] = originMap[j].clone();
            }
        }
    }

    private static void move(int[][] map, int i){
        int min;
        int number;
        // 아래
        if(i==0){
            for(int b=0; b<n; b++){
                min=n-1;
                number=0;
                for(int a=n-1; a>=0; a--){
                    int x = map[a][b];
                    if(x!=0){
                        if(number==x){
                            map[min+1][b]*=2;
                            map[a][b] = 0;
                            number=0;
                        }
                        else{
                            number = map[a][b];
                            map[a][b] = 0;
                            map[min][b]=number;
                            min--;
                        }
                    }
                }
            }
        }
        // 위
        else if(i==1){
            for(int b=0; b<n; b++){
                min=0;
                number = 0;
                for(int a=0; a<n; a++){
                    int x = map[a][b];
                    if(x!=0){
                        if(number==x){
                            map[min-1][b]*=2;
                            map[a][b]=0;
                            number=0;
                        }
                        else{
                            number=map[a][b];
                            map[a][b]=0;
                            map[min][b]=number;
                            min++;
                        }
                    }
                }
            }
        }
        // 왼
        else if(i==2){
            for(int a=0; a<n; a++){
                min=0;
                number=0;
                for(int b=0; b<n; b++){
                    int x = map[a][b];
                    if(x!=0){
                        if(x==number){
                            map[a][min-1]*=2;
                            map[a][b]=0;
                            number=0;
                        }
                        else{
                            number=map[a][b];
                            map[a][b]=0;
                            map[a][min]=number;
                            min++;
                        }
                    }
                }
            }
        }
        // 오
        else if(i==3){
            for(int a=0; a<n; a++){
                min=n-1;
                number=0;
                for(int b=n-1; b>=0; b--){
                    int x = map[a][b];
                    if(x!=0){
                        if(x==number){
                            map[a][min+1]*=2;
                            map[a][b] = 0;
                            number=0;
                        }
                        else{
                            number=map[a][b];
                            map[a][b]=0;
                            map[a][min]=number;
                            min--;
                        }
                    }
                }
            }
        }
    }

    private static int getMax(int[][] map){
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(max<map[i][j])
                    max=map[i][j];
            }
        }
        return max;
    }
}
