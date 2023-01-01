package baekjun;

import java.io.*;

public class _2447 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String[][] ar = new String[n][n];
        star(0, 0, n, ar, true);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) bw.write(ar[i][j]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    public static void star(int x, int y, int n, String[][] ar, boolean b){
        if(n==1) {
            if(b) ar[x][y] = "*";
            else ar[x][y]=" ";
        }
        else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==1&&j==1)star(x+i*(n/3), y+j*(n/3), n/3, ar, false);
                    else star(x+i*(n/3), y+j*(n/3), n/3, ar, b);
                }
            }
        }
    }
}
