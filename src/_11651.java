import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class XY2{
    int X;
    int Y;
    public XY2(int x, int y){
        X = x;
        Y = y;
    }
    public void getXY(){
        System.out.println(X+" "+Y);
    }
}

public class _11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<XY2> ar = new ArrayList<>(N);
        for(int i=0;i<N; i++){
            ar.add(new XY2(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(ar, (o1, o2)->{
            if(o1.Y==o2.Y) return o1.X - o2.X;
            else return o1.Y - o2.Y;
        });
        for(int i=0; i<N; i++) ar.get(i).getXY();
        sc.close();
    }
}
