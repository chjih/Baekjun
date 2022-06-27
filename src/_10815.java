import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> a = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] aa = new int[n];
        for(int i=0; i<n; i++){
            aa[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            if(a.contains(aa[i])) bw.write("1 ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
