package samsung;

import java.util.Scanner;

public class _14890 {
    private static int[][] map;
    private static int[] runway;
    private static int count, n, l;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();

        map = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j]=sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            checkX(i);
            checkY(i);
        }

        System.out.println(count);
        sc.close();
    }

    public static void checkX(int y){
        runway = new int[n];

        for(int i=1; i<n; i++){
            // 동일한 높이일 때
            if(map[y][i-1]==map[y][i]){
                continue;
            }
            // 하강일 때
            if(map[y][i-1]-1==map[y][i]){
                // 경사로 놓을 수 있는지 확인
                if(i+l<=n&&checkRunwayDesc(i)){
                    continue;
                }
            }
            // 상승일 때
            if(map[y][i-1]+1==map[y][i]){
                // 경사로 놓을 수 있는지 확인
                if(i-l>=0&&checkRunwayAsc(i)){
                    continue;
                }
            }
            // 다 아니면 불가능
            return;
        }
        count++;
    }

    public static void checkY(int x){
        runway = new int[n];

        for(int i=1; i<n; i++){
            // 동일한 높이일 때
            if(map[i-1][x]==map[i][x]){
                continue;
            }
            // 하강일 때
            if(map[i-1][x]-1==map[i][x]){
                // 경사로 놓을 수 있는지 확인
                if(i+l<=n&&checkRunwayDesc(i)){
                    continue;
                }
            }
            // 상승일 때
            if(map[i-1][x]+1==map[i][x]){
                // 경사로 놓을 수 있는지 확인
                if(i-l>=0&&checkRunwayAsc(i)){
                    continue;
                }
            }
            // 다 아니면 불가능
            return;
        }
        count++;
    }

    public static boolean checkRunwayDesc(int x){
        for(int i=x; i<x+l; i++){
            if(runway[i]==1){
                return false;
            }
        }
        for(int i=x; i<x+l; i++){
            runway[i]=1;
        }
        return true;
    }

    public static boolean checkRunwayAsc(int x){
        for(int i=x-l; i<x; i++){
            if(runway[i]==1){
                return false;
            }
        }
        for(int i=x-l; i<x; i++){
            runway[i]=1;
        }
        return true;
    }
}
