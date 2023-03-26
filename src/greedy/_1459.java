package greedy;

import java.util.Scanner;

public class _1459 {
    static long w, s, x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        s = sc.nextInt();

        System.out.println(greedy());

        sc.close();
    }

    static Long greedy() {
        long time=0;
        long move = Math.min(x, y);
        if(w*2>s){
            time += move*s;
        }else{
            time+=move*w*2;
        }
        move = Math.max(x,y)-move;
        if(move>1){
            if(w*2>s*2){
                time += move/2*s*2;
            }
            else{
                time += move/2*w*2;
            }
        }
        if(move%2==1)
            time+=w;
        return time;
    }

}
