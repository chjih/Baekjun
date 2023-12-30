package samsungsds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1 {
    static int n, m;
    static char[][] map;
    static int[][] record;
    static int[][] backup;
    static int[] m1 = {-1,1,0,0};
    static int[] m2 = {0,0,1,-1};
    static Node r, b;
    static int MIN = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        for(int i=0; i<number; i++){
            n = sc.nextInt();
            m = sc.nextInt();

            map = new char[n][m];
            record = new int[n][m];
            backup = new int[n][m];
            MIN = 100000;

            for(int j=0; j<n; j++){
                String s = sc.next();
                for(int k=0; k<m; k++){
                    map[j][k]=s.charAt(k);
                    if(s.charAt(k)=='R'){
                        r = new Node(j,k);
                    }else if(s.charAt(k)=='B'){
                        b = new Node(j,k);
                    }
                }
            }

            fillEmpty();
            int rCount = bfs(0,0,r.x, r.y);
            if(rCount<0){
                System.out.println("#"+(i+1)+" -1");
                continue;
            }
            fillEmpty();
            int bCount = bfs(b.x, b.y, n-1, m-1);
            if(bCount<0){
                System.out.println("#"+(i+1)+" -1");
                continue;
            }

            int count = rCount+bCount;

            // 중간값 구하면 됨
            fillEmpty();
            findTrash(r.x, r.y);

            System.out.println("#"+(i+1)+" "+(MIN==-100000?-1:(count+MIN)));
        }
    }

    static void fillEmpty(){
        for(int i=0; i<n; i++){
            Arrays.fill(record[i], -1);
        }
    }

    static void backup(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                backup[i][j] = record[i][j];
            }
        }
    }

    static int findTrash(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        record[x][y]=0;

        while(!queue.isEmpty()){
            Node q = queue.poll();

            int x1 = q.x;
            int y1 = q.y;

            int x2,y2;
            for(int i=0; i<4; i++){
                x2 = x1+m1[i];
                y2 = y1+m2[i];

                if(x2<0||y2<0||x2>=n||y2>=m||map[x2][y2]=='X'){
                    continue;
                }

                if(x2==0||y2==0||x2==n-1||y2==m-1){
                    record[x2][y2]=record[x1][y1]+1;

                    backup();
                    fillEmpty();
                    // B 찾으러 가야함
                    int length = bfs(x2, y2, b.x, b.y);
                    if(length<0) {
                        continue;
                    }

                    for(int a=0; a<n; a++){
                        for(int j=0; j<m; j++){
                            record[a][j] = backup[a][j];
                        }
                    }

                    length += record[x2][y2];

                    if(length<MIN){
                        MIN = length;
                    }
                }

                if(record[x2][y2]==-1){
                    queue.add(new Node(x2,y2));
                    record[x2][y2]=record[x1][y1]+1;
                }
            }
        }

        return -1;
    }

    static int bfs(int x, int y, int targetX, int targetY){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        record[x][y]=0;

        while(!queue.isEmpty()){
            Node q = queue.poll();

            int x1 = q.x;
            int y1 = q.y;

            int x2,y2;
            for(int i=0; i<4; i++){
                x2 = x1+m1[i];
                y2 = y1+m2[i];

                if(x2<0||y2<0||x2>=n||y2>=m){
                    continue;
                }

                if(x2==targetX&&y2==targetY){
                    return record[x1][y1]+1;
                }
                else if(map[x2][y2]!='X'&&record[x2][y2]==-1){
                    queue.add(new Node(x2,y2));
                    record[x2][y2]=record[x1][y1]+1;
                }
            }
        }

        return -1;
    }
}

class Node{
    int x, y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
