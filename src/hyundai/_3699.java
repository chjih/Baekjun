package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3699 {
    private static int[][] building;
    private static int h,l;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            h = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            building = new int[h][l];

            // 빌딩 상태 입력
            for(int j=0; j<h; j++){
                st = new StringTokenizer(bf.readLine());
                for(int k=0; k<l; k++){
                    building[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 차 찾는데 걸리는 시간 계산
            System.out.println(getTime());
        }
    }

    private static int getTime(){
        int[] index = new int[h];
        int i, car=1, x, time=0;

        while(true){
            // 층별로 검사
            for(i=0; i<h; i++){
                x = find(i, index[i], car);
                // 자동차 찾았을 때
                if(x>0){
                    int move = Math.abs(index[i]-x)%l;
                    time+=Math.min(move, l-move)*5;
                    index[i]=x;
                    car++;
                    break;
                }
            }
            // 더이상 차를 못찾았을 때
            if(i==h){
                break;
            } else{
                time+=i*10*2;
            }
        }

        return time;
    }

    private static int find(int f, int index, int car){
        for(int i=0; i<l; i++){
            if(building[f][(i+index)%l]==car){
                return (i+index)%l;
            }
        }

        // 해당 층에 존재하지 않음
        return -1;
    }
}
