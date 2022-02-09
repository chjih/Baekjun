import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class _2751 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            ar.add(sc.nextInt());
        }
        //정렬
        Collections.sort(ar);
        for(int a:ar){
            bw.write(a+"\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}
