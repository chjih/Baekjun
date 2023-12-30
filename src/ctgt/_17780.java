package ctgt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17780 {
    static int[] m1 ={0,0,-1,1};
    static int[] m2 = {1, -1, 0, 0};
    static Horse[] horse = new Horse[10];
    static int[][] map = new int[12][12];
    static Horses[][] horses = new Horses[12][12];

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int n;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
            }
        }

        int x, y, d;
        Queue<Horses> queue = new PriorityQueue<>((o1,o2)->o1.bottom-o2.bottom);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            d = Integer.parseInt(st.nextToken())-1;

            horse[i]=new Horse(x, y, d);
            if(horses[x][y]!=null){
                horses[x][y].top = i;
                horses[x][y].count++;
            }else{
                horses[x][y] = new Horses(i, i, 1, x, y);
                queue.add(horses[x][y]);
                set.add(i);
            }
        }

        // 이동 시작
        Horses cur;
        Horse h;
        int count=0;
        boolean t=false;
        while(true){
            if(queue.isEmpty()){
                set.clear();
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(horses[i][j]!=null){
                            if(horses[i][j].count>=4){
                                t=true;
                            }
                            set.add(horses[i][j].bottom);
                            queue.add(horses[i][j]);
                        }
                    }
                }
                count++;
            }

            cur = queue.poll();

            if(t){
                System.out.println(count);
                break;
            }

            if(count>=1000){
                System.out.println(-1);
                break;
            }

            h = horse[cur.bottom];

            x = cur.x+m1[h.dir];
            y = cur.y + m2[h.dir];

            // 체스판 벗어날 때, 파란색일 때
            if(x<0||y<0||x>=N||y>=N||map[x][y]==2){
                switch(h.dir){
                    case 0:
                        h.dir=1;
                        break;
                    case 1:
                        h.dir=0;
                        break;
                    case 2:
                        h.dir=3;
                        break;
                    case 3:
                        h.dir=2;
                        break;
                }
                x = cur.x+m1[h.dir];
                y = cur.y + m2[h.dir];

                // 여전히 파란색이거나 밖으로 나갈 때
                if(x<0||y<0||x>=N||y>=N||map[x][y]==2){
                    continue;
                }
            }

            // 흰색일 때
            if(map[x][y]==0){
                if(horses[x][y]==null){
                    horses[x][y] = cur;
                }else{
                    horses[x][y].top = cur.top;
                    horses[x][y].count += cur.count;
                }
                horses[cur.x][cur.y]=null;
                cur.x = x;
                cur.y = y;
            }
            // 빨간색일 때
            else if(map[x][y]==1){
                if(horses[x][y]==null){
                    int tmp = cur.bottom;
                    cur.bottom = cur.top;
                    cur.top = tmp;
                    horses[x][y] = cur;
                    if(!set.contains(cur.bottom)&&cur.top<cur.bottom){
                        queue.add(horses[x][y]);
                        set.add(cur.bottom);
                    }
                }else{
                    horses[x][y].top = cur.bottom;
                    horses[x][y].count += cur.count;
                }
                horses[cur.x][cur.y]=null;
                cur.x = x;
                cur.y = y;
            }
        }

    }

    static class Horse{
        int x, y;
        int dir;

        public Horse(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static class Horses{
        int bottom;
        int top;
        int count;
        int x,y;

        public Horses(int bottom, int top, int count, int x, int y){
            this.bottom = bottom;
            this.top = top;
            this.count = count;
            this.x = x;
            this.y = y;
        }
    }
}
