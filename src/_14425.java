import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Set<String> s = new HashSet<>();
        int n=0;
        for(int i=0; i<a; i++){
            s.add(br.readLine().replace("\n", ""));
        }
        for(int i=0; i<b; i++){
            if(s.contains(br.readLine().replace("\n", ""))) n++;
        }
        bw.write(String.valueOf(n));
        bw.flush();
        bw.close();
        br.close();
    }
}
