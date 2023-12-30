package samsung;

import java.util.*;
import java.io.*;

public class _17825 {
    static int MAX=0;
    static int[] dice = new int[10];
    static int[] order = new int[10];
    static Horse[] horse = new Horse[4];
    static int[][] map = new int[41][41];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++){
            dice[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<4; i++){
            horse[i] = new Horse(0, 0);
        }

        makeOrder(0);
        System.out.println(MAX);
    }

    // 조합 만들기
    static void makeOrder(int cur){
        if(cur==10){
            check();
            return;
        }

        for(int i=cur; i<10; i++){
            for(int j=0;j<4;j++){
                order[i]=j;
                makeOrder(i+1);
            }
        }
    }
    static void check(){
        int result=0;

        for(int i=0; i<4; i++){
            map[horse[i].node][horse[i].cur]=0;
            horse[i].cur=0;
            horse[i].node=0;
            horse[i].end=false;
        }

        Horse h;
        for(int i=0; i<10; i++){
            h = horse[order[i]];
            if(h.end){
                return;
            }

            map[h.node][h.cur]=0;
            h.checkMove(dice[i]);
            if(map[h.node][h.cur]==0){
                map[h.node][h.cur]=1;
                result+=horse[order[i]].cur;
            }
            else if(!h.end){
                return;
            }
        }
        if(result>MAX){
            MAX = result;
        }
    }

    static class Horse{
        int cur;
        int node;
        boolean end=false;

        public Horse(int cur, int node){
            this.cur = cur;
            this.node = node;
        }

        public void checkMove(int count){
            for(int i=0; i<count; i++){
                move();
                if(end){
                    return;
                }
            }

            if(node==0&&(cur==10||cur==20||cur==30)){
                node=cur;
            }
        }

        public void move(){
            if(node==0){
                if(cur==38){
                    cur=40;
                    node=40;
                }else{
                    cur+=2;
                }
                return;
            }
            if(node==10){
                if(cur==19){
                    cur=25;
                    node=25;
                }else{
                    cur+=3;
                }
                return;
            }
            if(node==20){
                if(cur==24){
                    node=25;
                    cur=25;
                }else{
                    cur+=2;
                }
                return;
            }
            if(node==30){
                if(cur==30){
                    cur=28;
                }
                else if(cur==26){
                    node=25;
                    cur=25;
                }else{
                    cur-=1;
                }
                return;
            }
            if(node==25){
                if(cur==35){
                    cur=40;
                    node=40;
                }
                else{
                    cur+=5;
                }
                return;
            }
            if(node==40){
                end=true;
                cur=0;
            }
        }
    }
}
