package samsung;

import java.util.*;
import java.io.*;

public class _14891 {
    static List<Gear> gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gears = new ArrayList<>();

        // 기어 입력
        for (int i = 0; i < 4; i++) {
            gears.add(new Gear(br.readLine(), 6, 2, 0));
        }

        // 이동 입력
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            move(a-1, b, true, true);

            for(int j=0; j<4; j++){
                gears.get(j).getM();
            }
        }

        int score=0;

        if(gears.get(0).getM()=='1'){
            score++;
        }
        if(gears.get(1).getM()=='1'){
            score+=2;
        }
        if(gears.get(2).getM()=='1'){
            score+=4;
        }
        if(gears.get(3).getM()=='1'){
            score+=8;
        }

        System.out.println(score);
    }

    private static void move(int g, int d, boolean ml, boolean mr){
        // 왼쪽 검사
        if(ml&&g>0&&gears.get(g-1).getR()!=gears.get(g).getL()){
            // 반대방향으로 이동
            move(g-1, d==1?-1:1, true, false);
        }

        // 오른쪽 검사
        if(mr&&g<3&&gears.get(g+1).getL()!=gears.get(g).getR()){
            // 반대방향으로 이동
            move(g+1, d==1?-1:1, false, true);
        }

        // 회전
        if(d==-1){
            gears.get(g).l=(gears.get(g).l+1)%8;
            gears.get(g).r=(gears.get(g).r+1)%8;
            gears.get(g).m=(gears.get(g).m+1)%8;
            return;
        }
        gears.get(g).l = (gears.get(g).l-1)<0?7:gears.get(g).l-1;
        gears.get(g).r = (gears.get(g).r-1)<0?7:gears.get(g).r-1;
        gears.get(g).m = (gears.get(g).m-1)<0?7:gears.get(g).m-1;
    }
}

class Gear{
    String gear;
    int l, r, m;

    public Gear(String gear, int l, int r, int m){
        this.gear = gear;
        this.l = l;
        this.r = r;
        this.m = m;
    }

    public char getL(){
        return gear.charAt(l);
    }

    public char getR(){
        return gear.charAt(r);
    }

    public char getM(){
        return gear.charAt(m);
    }
}