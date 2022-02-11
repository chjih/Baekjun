import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class XY implements Comparable<XY>{
    int X;
    int Y;
    public XY(int x, int y){
        X = x;
        Y = y;
    }
    public void getXY(){
        System.out.println(X+" "+Y);
    }

    @Override
    public int compareTo(XY o) {
        if(this.X==o.X) return this.Y-o.Y;
        else return this.X-o.X;
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
