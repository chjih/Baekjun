package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _15685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];

        List<Integer> list = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            map[x][y]=1;
            list.clear();
            list.add(d);
            int l;
            for(int j=0; j<g; j++){
                  l = list.size();
                  for(int k=l-1; k>=0; k--){
                      list.add((list.get(k)+1)%4);
                  }
            }

            for(int dir: list){
                if(dir==0){
                    x++;
                    map[x][y]=1;
                }
                if(dir==1){
                    y--;
                    map[x][y]=1;
                }
                if(dir==2){
                    x--;
                    map[x][y]=1;
                }
                if(dir==3){
                    y++;
                    map[x][y]=1;
                }
            }
        }

        // 정사각형 체크
        int count=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
               if(map[i][j]==1&&map[i+1][j+1]==1&&map[i][j+1]==1&&map[i+1][j]==1){
                   count++;
               }
            }
        }
        System.out.println(count);
    }
}
