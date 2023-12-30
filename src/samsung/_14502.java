package samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _14502 {
    private static int[][] map;
    private static int[][] visit;
    private static int[][] virus;
    private static Queue<Node> virusQueue = new LinkedList<>();
    private static Queue<Node> queue;
    private static int n, m, min=64, blank=0, virusCount=0;
    private static int[] m1 = {0,0,1,-1};
    private static int[] m2 = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visit = new int[n][m];
        virus = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]==0){
                    blank++;
                }
                else if(map[i][j]==2){
                    virus[i][j]=1;
                    virusCount++;
                    virusQueue.add(new Node(i, j));
                }
            }
        }

        choose(0, 0);

        System.out.println(blank-min-3);
        sc.close();
    }

    // dfs로 벽(3개) 경우의 수 구함
    private static void choose(int k, int count){
        if(count==3){
            queue = new LinkedList<>();
            init();
            bfs();
            return;
        }

        for(int i=k; i<n*m; i++){
            if(map[i/m][i%m]!=0){
                continue;
            }
            map[i/m][i%m]=3;
            choose(i+1, count+1);
            map[i/m][i%m]=0;
        }
    }

    private static void init() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = virus[i][j];
            }
        }

        virusQueue.forEach(x->queue.add(new Node(x.x, x.y)));
    }

    // 바이러스 퍼지는 거 확인
    private static void bfs(){
        int x,y, count=0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                x = node.x + m1[i];
                y = node.y + m2[i];

                if(x<0||y<0||x>=n||y>=m||map[x][y]!=0||visit[x][y]!=0){
                    continue;
                }

                queue.add(new Node(x,y));
                visit[x][y]=1;
                count++;

                // 이미 넘었으면 더 찾을 필요 없음
                if(count>min){
                    return;
                }
            }
        }

        min = count;
    }

    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
