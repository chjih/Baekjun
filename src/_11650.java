import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class XY implements Comparable{
    int X;
    int Y;
    public XY(int x, int y){
        X = x;
        Y = y;
    }

    @Override
    public int compareTo(Object o) {
        XY O = (XY) o;
        if(this.X < O.X) return -1;
        else if(this.X == O.X){
            if(this.Y < O.Y) return -1;
            else if(this.Y==O.Y) return 0;
            else return 1;
        } else return 1;
    }

    public void getXY(){
        System.out.println(X+" "+Y);
    }
}
public class _11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<XY> ar = new ArrayList<>();
        for(int i=0; i<N; i++){
            ar.add(new XY(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(ar);
        for(int i=0;i<N; i++) ar.get(i).getXY();
        sc.close();
    }
}
