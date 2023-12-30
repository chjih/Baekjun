package ctgt;

import java.util.*;
import java.io.*;

public class _18500 {
    static int[][] map;
    static int[][] visited;
    static int[] m1 = {-1,1,0,0};
    static int[] m2 = {0,0,1,-1};
    static int R,C;
    static int num=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new int[R][C];

        String s;
        for(int i=0; i<R; i++){
            s = br.readLine();
            for(int j=0; j<C; j++){
                if(s.charAt(j)=='.'){
                    map[i][j]=0;
                }else{
                    map[i][j]=1;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int index;
        int dir=1;
        for(int i=1; i<=n; i++){
            index = Integer.parseInt(st.nextToken());
            num+=2;
            throwRod(R-index, dir);
            dir*=-1;
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]==0){
                    System.out.print(".");
                }else{
                    System.out.print("x");
                }
            }
            System.out.println();
        }
    }

    static void throwRod(int index, int start){
        boolean collision=true;
        // 왼쪽에서 던짐
        if(start==1){
            for(int i=0; i<C; i++){
                if(map[index][i]==1){
                    map[index][i]=0;

                    for(int a=0; a<4; a++){
                        check(a, index, i);
                        collision=true;
                        for(int k=0; k<C; k++){
                            // 연결되어 있을 때
                            if(visited[R-1][k]==num){
                                collision = false;
                            }
                        }

                        if(collision){
                            collision();
                        }
                        num++;
                    }
                    break;
                }
            }
        }
        // 오른쪽에서 던짐
        else{
            for(int i=C-1; i>=0; i--){
                if(map[index][i]==1){
                    map[index][i]=0;
                    for(int a=0; a<4; a++){
                        check(a, index, i);
                        collision=true;
                        for(int k=0; k<C; k++){
                            // 연결되어 있을 때
                            if(visited[R-1][k]==num){
                                collision = false;
                            }
                        }

                        if(collision){
                            collision();
                        }
                        num++;
                    }
                    break;
                }
            }
        }
    }

    static void collision(){
        int a, b, last;
        int min=102;
        for(int i=0; i<C; i++){
            b=R;
            for(int j=R-1; j>=0; j--){
                if(visited[j][i]==num){
                    if(min>(b-j)){
                        min = b-j;
                    }
                }
                else if(map[j][i]==1){
                    b=j;
                }
            }
        }

        // 차이 제일 작은거를 기준으로 밑으로 붕괴
        min--;
        for(int i=R-min-1; i>=0; i--){
            for(int j=0; j<C; j++){
                if(visited[i][j]==num){
                    map[i][j]=0;
                    map[i+min][j]=1;
                }
            }
        }
    }

    static void check(int ii, int x, int y){
        Queue<Node> queue = new LinkedList<>();
        int xx, yy;
        xx = x + m1[ii];
        yy = y + m2[ii];

        // 범위 밖
        if(xx<0||yy<0||xx>=R||yy>=C){
            return;
        }

        if(map[xx][yy]==1){
            visited[xx][yy]=num;
            queue.add(new Node(xx,yy));
        }

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            for(int i=0; i<4; i++){
                xx = node.x + m1[i];
                yy = node.y + m2[i];

                // 범위 밖
                if(xx<0||yy<0||xx>=R||yy>=C){
                    continue;
                }

                if(visited[xx][yy]!=num&&map[xx][yy]==1){
                    visited[xx][yy]=num;
                    queue.add(new Node(xx,yy));
                }
            }
        }
    }

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
