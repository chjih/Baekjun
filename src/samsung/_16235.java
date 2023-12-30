package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Space[][] spaces = new Space[n+1][n+1];
        int[][] nut = new int[n+1][n+1];
        int[] m1 = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] m2 = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n;j++){
                spaces[i][j]=new Space();
                nut[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int x, y, z;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            spaces[x][y].add(z);
        }

        int c, xx, yy;
        for(int i=0; i<k; i++){
            // 봄
            for(int j=1; j<=n; j++){
                for(int l=1; l<=n; l++){
                    spaces[j][l].eat();
                }
            }

            // 여름
            for(int j=1; j<=n; j++){
                for(int l=1; l<=n; l++){
                    spaces[j][l].summer();
                }
            }

            // 가을 (번식)
            for(int j=1; j<=n; j++){
                for(int l=1; l<=n; l++){
                    c = spaces[j][l].age5;
                    if(c!=0){
                        for(int s=0; s<8; s++){
                            xx = j+m1[s];
                            yy = l+m2[s];

                            if(xx>n||yy>n||xx<1||yy<1){
                                continue;
                            }

                            for(int ii=0; ii<c; ii++){
                                spaces[xx][yy].add(1);
                            }
                        }
                    }
                }
            }

            // 겨울 (양분 추가)
            for(int j=1; j<=n; j++){
                for(int l=1; l<=n; l++){
                    spaces[j][l].nutrient+=nut[j][l];
                }
            }
        }

        int count=0;
        for(int i=1; i<=n; i++){
           for(int j=1; j<=n;j++){
                count+=spaces[i][j].trees.size();
            }
        }

        System.out.println(count);
    }

    static class Space{
        int nutrient=5;
        PriorityQueue<Integer> trees = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
        int age5=0;
        int death=0;

        public void add(int n){
            trees.add(n);
            if(n%5==0){
                age5++;
            }
        }

        public void eat(){
            int t;
            List<Integer> list = new LinkedList<>();
            while(!trees.isEmpty()){
                t = trees.poll();
                if(t%5==0){
                    age5--;
                }

                if(t<=nutrient){
                    nutrient-=t;
                    list.add(t+1);
                    if((t+1)%5==0){
                        age5++;
                    }
                }else{
                    death+=t/2;
                }
            }

            trees.addAll(list);
        }

        public void summer(){
            nutrient+=death;
            death=0;
        }
    }
}
