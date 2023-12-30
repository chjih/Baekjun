package cote;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class _11723 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        String command;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            command = st.nextToken();

            int x;
            if(command.equals("add")){
                x = Integer.parseInt(st.nextToken());
                arr[x]=1;
            }
            if(command.equals("remove")){
                x = Integer.parseInt(st.nextToken());
                arr[x]=0;
            }
            if(command.equals("check")){
                x = Integer.parseInt(st.nextToken());
                bw.write(arr[x]+"\n");
            }
            if(command.equals("toggle")){
                x = Integer.parseInt(st.nextToken());
                if(arr[x]==1){
                    arr[x]=0;
                }else{
                    arr[x]=1;
                }
            }
            if(command.equals("all")){
                Arrays.fill(arr, 1);
            }
            if(command.equals("empty")){
                Arrays.fill(arr, 0);
            }
        }

        bw.flush();
        bw.close();
    }
}
