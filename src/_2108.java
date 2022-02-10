import java.io.*;
import java.util.*;

public class _2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max=0, first=0, second=0;
        boolean b = false;
        int hap=0;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            ar.add(a);
            hap+=a;
        }
        Collections.sort(ar);
        //최빈값
        int a =0;
        first=ar.get(0);
        for(int i=N-1; i>0; i--){
            a++;
            if(!ar.get(i).equals(ar.get(i - 1))){
                if(a==max){
                    int aa = first;
                    first = ar.get(i);
                    second = aa;
                    b = true;
                } else if(a>max) {
                    b=false;
                    max=a;
                    first = ar.get(i);
                }
                a=0;
            }
        }
        if(a!=0) a++;
        else a=1;
        if(a==max){
            b=true;
            second = first;
        } else if(a>max) {
            b=false;
            first = ar.get(0);
        }
        bw.write((int)Math.round((double) hap/N)+"\n");
        bw.write(ar.get(N/2)+"\n");
        bw.write(((b)?second:first)+"\n");
        bw.write(ar.get(ar.size()-1)-ar.get(0)+"\n");
        bw.flush();
        bw.close();
    }
}
