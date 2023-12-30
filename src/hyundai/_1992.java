package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1992 {
    private static int n,m;
    private static int[][] video;
    private static String result="";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        video = new int[n][n];
        for(int i=0; i<n; i++){
            String s = bf.readLine();

            for(int j=0; j<n; j++){
                video[i][j] = s.charAt(j)-'0';
            }
        }

        // 분할 정복
        System.out.println(check(0,0,n));
    }

    private static String check(int x, int y, int length){
        if(length==1){
            return String.valueOf(video[x][y]);
        }

        // 4분할
        String a = check(x, y, length/2);
        String b = check(x, y+length/2, length/2);
        String c = check(x+length/2, y, length/2);
        String d = check(x+length/2, y+length/2, length/2);

        // 모두같을 때
        if(a.length()==1&& a.equals(b) && b.equals(c) && c.equals(d)){
            return a;
        }
        // 다를 때
        else{
            return "("+a+b+c+d+")";
        }
    }
}
